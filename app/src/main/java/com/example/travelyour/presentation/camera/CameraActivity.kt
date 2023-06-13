package com.example.travelyour.presentation.camera

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.RectF
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.example.travelyour.R
import com.example.travelyour.ml.Model7
import com.example.travelyour.ml.TLmodelv2
import com.example.travelyour.presentation.camera.camerapage.CameraView

import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class CameraActivity : ComponentActivity() {

    private lateinit var outputDirectory: File
    private lateinit var  cameraExecutor: ExecutorService
    private lateinit var photoUri: Uri
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)
    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)
    private var predictedObject = mutableStateOf("")
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){ isGranted ->
        if (isGranted){
            Log.i("Ngetrip", "Permission granted")
            shouldShowCamera.value = true
        }else{
            Log.i("Tag","Permission denied")
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    setContent {

           Box(
               modifier = Modifier
                   .fillMaxSize()
                   .background(Color.White),
           ){
             if  (shouldShowCamera.value) {
                 CameraView(
                     outputDirectory = outputDirectory,
                     executor = cameraExecutor,
                     onImageCaptured = ::handleImageCapture,
                     onError = { Log.e("Ngetrip", "View Error:", it) },
                     modifier = Modifier.matchParentSize()

                 )
             }

               if (shouldShowPhoto.value){
                   Image(
                       painter = rememberImagePainter(photoUri),
                       contentDescription = null,
                       modifier = Modifier
                           .align(Alignment.TopCenter)
                           .fillMaxSize()
                           .padding(20.dp))
               }

               if (shouldShowPhoto.value && predictedObject.value.isNotBlank()){
                   Text(
                       text =predictedObject.value,
                       modifier = Modifier.padding(16.dp))
               }
               if (shouldShowPhoto.value) {
                   Button(
                       onClick = { resetCameraState() },
                       modifier = Modifier.align(Alignment.BottomCenter)
                   ) {
                       Text(text = "Kembali ke Kamera")
                   }
               }

           }

       }

        requestCameraPermission()
        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun resetCameraState() {
        shouldShowPhoto.value = false
        shouldShowCamera.value = true
    }

    private fun requestCameraPermission(){
        when{
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("Ngetrip","Permission previously granted")
                shouldShowCamera.value = true
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> Log.i("Tag", "Show Camera permission dialog")
            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleImageCapture(uri: Uri){
        Log.i("Ngetrip","Image capture: $uri")
        shouldShowCamera.value = false

        photoUri = uri
        shouldShowPhoto.value = true

        val imagePath = photoUri.path
        val bitmap = BitmapFactory.decodeFile(imagePath)
        processImage(bitmap)

    }

    private fun getOutputDirectory(): File{
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply {
                mkdirs() }

        }
        return  if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun processImage(bitmap: Bitmap){
        val model = TLmodelv2.newInstance(this)
        val preprocessedBitmap = preprocessImage(bitmap)
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 150, 150, 3), DataType.FLOAT32)

        val byteBuffer = ByteBuffer.allocateDirect(150 * 150 * 3 * 4) // Adjust buffer size according to image dimensions and data type
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(150 * 150)
        preprocessedBitmap.getPixels(intValues,0,preprocessedBitmap.width,0,0,preprocessedBitmap.width,preprocessedBitmap.height)
        var pixel = 0
        for (i in 0 until 150){
            for (j in 0 until 150){
                val value = intValues[pixel++]
                val red = (value shr 16 and 0xFF)/ 255.0f
                val green = (value shr 8 and 0xFF) / 255.0f
                val blue = (value and 0xFF)/255.0F

                inputFeature0.buffer.putFloat(red)
                inputFeature0.buffer.putFloat(green)
                inputFeature0.buffer.putFloat(blue)
            }
        }
        val outputs = model.process(inputFeature0)
        val outputFeatureO = outputs.outputFeature0AsTensorBuffer

        val predictedClassIndex = outputFeatureO.floatArray.indices.maxByOrNull{outputFeatureO.floatArray[it]} ?: -1
        val predictedClassLabel = getClassLabel(predictedClassIndex)
        model.close()
        predictedObject.value = predictedClassLabel
        //handlePredictedClass(getClassLabel(predictedClassIndex))

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun preprocessImage(bitmap: Bitmap):Bitmap{
        val transformedBitmap = applyAugmentation(bitmap)
        val scaledBitmap = Bitmap.createScaledBitmap(transformedBitmap,150,150,true)
        val normalizedBitmap = normalizeImage(scaledBitmap)
        return normalizedBitmap
    }

    private fun applyAugmentation(bitmap: Bitmap): Bitmap {
        val matrix = Matrix()
        val degrees = listOf(0f, 90f, 180f, 270f) // Rotate the image by 0, 90, 180, and 270 degrees
        val scaleX = listOf(1f, 0.8f, 1.2f) // Scale the image by 0.8, 1.0, and 1.2
        val scaleY = listOf(1f, 0.8f, 1.2f) // Scale the image by 0.8, 1.0, and 1.2

        matrix.setRectToRect(RectF(0f, 0f, bitmap.width.toFloat(), bitmap.height.toFloat()), RectF(0f, 0f, 150f, 150f), Matrix.ScaleToFit.FILL)

        val augmentedBitmaps = mutableListOf<Bitmap>()

        for (rotateDegree in degrees) {
            for (scaleXValue in scaleX) {
                for (scaleYValue in scaleY) {
                    matrix.reset()
                    matrix.postRotate(rotateDegree)
                    matrix.postScale(scaleXValue, scaleYValue)

                    val augmentedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
                    augmentedBitmaps.add(augmentedBitmap)
                }
            }
        }

        val randomIndex = (0 until augmentedBitmaps.size).random()
        return augmentedBitmaps[randomIndex]
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun normalizeImage(bitmap: Bitmap):Bitmap{
        val normalizedBitmap = bitmap.copy(bitmap.config, true)
        val pixels = IntArray(normalizedBitmap.width * normalizedBitmap.height)

        normalizedBitmap.getPixels(pixels, 0, normalizedBitmap.width, 0, 0, normalizedBitmap.width, normalizedBitmap.height)

        for (i in pixels.indices) {
            val pixel = pixels[i]
            val red = (pixel shr 16 and 0xFF) / 255.0f
            val green = (pixel shr 8 and 0xFF) / 255.0f
            val blue = (pixel and 0xFF) / 255.0f

            pixels[i] = android.graphics.Color.rgb(red, green, blue)
        }

        normalizedBitmap.setPixels(pixels, 0, normalizedBitmap.width, 0, 0, normalizedBitmap.width, normalizedBitmap.height)

        return normalizedBitmap
    }
    private fun getClassLabel(classIndex:Int):String{
        val classLabels = listOf("borobudur",
            "jendral_sudirman","martapura",
            "monas",
            "monumen_lobar",
            "monumen_mataram_metro",
            "monumen_selamat_datang",
            "monumen_surabaya",
            "museum_tsunami",
           "pantai_penyu",
            "prambanan",
            "pura_suranadi",
          "rumah_aceh",
            "sarinah_mall",
           "taman_sangkreang",
            "tugu_jogja")
        return  if (classIndex >= 0 && classIndex < classLabels.size){
            classLabels[classIndex]
        }else{
            "Unknown"
        }
    }

    private fun handlePredictedClass(predictedClassLabel: String){
        predictedObject.value = predictedClassLabel
    }
}