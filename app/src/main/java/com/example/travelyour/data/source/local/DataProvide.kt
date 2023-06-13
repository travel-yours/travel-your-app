package com.example.travelyour.data.source.local

import com.example.travelyour.R
import com.example.travelyour.data.response.Artikel
import com.example.travelyour.model.ArikelList

object ArtikelDataSource {

    val dummyArtikel = listOf(
        Artikel(1,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(2,"Stay cation","Liburan Stay cation",R.drawable.gunung,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(3,"Stay cation","Liburan Stay cation",R.drawable.pantai,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(4,"Stay cation","Liburan Stay cation",R.drawable.gunung,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(5,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(6,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(7,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(8,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(9,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian"),
        Artikel(10,"Stay cation","Liburan Stay cation",R.drawable.stay,
            "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian")

    )

    val articel =
        ArikelList(
            id = 1,
            title = "Staycation",
            headline = "Libuaran Staycation",
            desc = "berlibur dalam kesendirian untuk menikmati ketenangan dan kedamaian  kesendirian untuk menikmati ketenangan dan kedamaian",
            imageId = R.drawable.stay
        )

}