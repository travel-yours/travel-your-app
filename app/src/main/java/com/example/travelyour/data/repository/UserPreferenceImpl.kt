package com.example.travelyour.data.repository


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.travelyour.domain.UserPreferenceRepository
import com.example.travelyour.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.travelyour.utils.Constant.PREF_ID
import com.example.travelyour.utils.Constant.PREF_NAME
import com.example.travelyour.utils.Constant.PREF_TOKEN
import kotlinx.coroutines.flow.distinctUntilChanged




class UserPreferenceImpl(
    private val dataStore: DataStore<Preferences>
    ):UserPreferenceRepository {

    private object  Keys{
        val loginStatus = booleanPreferencesKey(PREF_LOGIN_STATUS)
        val id = stringPreferencesKey(PREF_ID)
        val name = stringPreferencesKey(PREF_NAME)
        val token = stringPreferencesKey(PREF_TOKEN)
    }

   private inline  val Preferences.id
   get() = this[Keys.id] ?: ""
    private inline val Preferences.name
    get() = this[Keys.name] ?: ""
    private inline val Preferences.token
    get() = this[Keys.token] ?: ""
    override val userData: Flow<UserEntity> = dataStore.data.map {
        UserEntity(
            id = it.id,
            name = it.name,
            token = it.token
        )
    }.distinctUntilChanged()

    override val isLoggedIn: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[Keys.loginStatus] ?: false
    }
    override suspend fun saveUser(userEntity: UserEntity) {
       dataStore.edit{preferences ->
           preferences[Keys.loginStatus] = true
           preferences[Keys.id] = userEntity.id
           preferences[Keys.name] = userEntity.name
           preferences[Keys.token] = userEntity.token
       }
    }

    override suspend fun clearUser() {
        dataStore.edit { preferences ->
            preferences[Keys.loginStatus] = false
            preferences.remove(Keys.id)
            preferences.remove(Keys.name)
            preferences.remove(Keys.token)
        }
    }
    companion object {
        private const val PREF_LOGIN_STATUS = "pref_login_status"
    }

}
