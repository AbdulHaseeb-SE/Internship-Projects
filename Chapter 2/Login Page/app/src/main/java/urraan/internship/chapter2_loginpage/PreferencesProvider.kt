package urraan.internship.chapter2_loginpage

import android.content.Context

class PreferencesProvider(context: Context){
    private val preferenceName = "User_Registration"
    val sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    val sharedPreferencesEditor = sharedPreferences.edit()

    fun insertValue(key: String, value: String) {
        sharedPreferencesEditor.apply {
            putString(key, value)
            apply()
        }
    }

    fun getValue ( key: String) : String? {
        return sharedPreferences.getString(key,null)
    }
}