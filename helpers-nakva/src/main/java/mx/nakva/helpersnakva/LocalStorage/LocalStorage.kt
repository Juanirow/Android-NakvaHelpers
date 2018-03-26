package mx.nakva.helpersnakva.LocalStorage

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by Juancho on 23/11/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LocalStorage(context: Context): ILocalStorage {

    val TAG = "LocalStorage"

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    init {
        this.sharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_KEYS.NAME,
                LOCAL_STORAGE_KEYS.MODE)
    }

    override fun getEmail(): String? {
        return this.sharedPreferences?.getString(LOCAL_STORAGE_KEYS.EMAIL, null)
    }

    override fun getToken(): String? {
        return  this.sharedPreferences?.getString(LOCAL_STORAGE_KEYS.TOKEN, null)
    }

    override fun getUsername(): String? {
        return this.sharedPreferences?.getString(LOCAL_STORAGE_KEYS.USERNAME, null)
    }

    override fun getId(): String? {
        return this.sharedPreferences?.getString(LOCAL_STORAGE_KEYS.ID, null)
    }

    override fun createSession(username: String?, email: String?, token: String?, id: String?) {
        this.destroySession()
        if(this.sharedPreferences != null) {
            this.editor = this.sharedPreferences?.edit()
            this.editor?.putString(LOCAL_STORAGE_KEYS.USERNAME, username)
            this.editor?.putString(LOCAL_STORAGE_KEYS.EMAIL, email)
            this.editor?.putString(LOCAL_STORAGE_KEYS.TOKEN, token)
            this.editor?.putString(LOCAL_STORAGE_KEYS.ID, id)
            this.editor?.commit()
            this.editor?.apply()
        }
    }

    override fun hasSession(): Boolean {
        val email = this.getEmail()
        val token = this.getToken()

        if(email != null && token != null){
            return true
        }
        return false
    }

    override fun destroySession() {
        if(this.sharedPreferences != null) {
            this.editor = this.sharedPreferences?.edit()
            this.editor?.clear()
            this.editor?.commit()
            this.editor?.apply()
        }
    }

    override fun setValue(key: String, value: Any) {
        if(value is Long) {
            this.setLongValue(key, value)
            return
        }
        if(value is String) {
            this.setStringValue(key, value)
        }
        if(value is Int) {
            this.setIntValue(key, value)
        }
        if(value is Boolean) {
            this.setBooleanValue(key, value)
        }
        if(value is Double) {
            this.setDoubleValue(key, value)
        }
    }

    override fun setLongValue(key: String, value: Long) {
        this.sharedPreferences?.edit()?.putLong(key, value)?.apply()
    }

    override fun getLongValue(key: String): Long? {
        val value = this.sharedPreferences?.getLong(key, -100)
        if(value == -100L) {
            return null
        }
        return value
    }

    override fun setStringValue(key: String, value: String) {
        this.sharedPreferences?.edit()?.putString(key, value)?.apply()
    }

    override fun getStringValue(key: String): String? {
        return sharedPreferences?.getString(key, "")
    }

    override fun setIntValue(key: String, value: Int) {
        this.sharedPreferences?.edit()?.putInt(key, value)?.apply()
    }

    override fun getIntValue(key: String): Int? {
        var value = sharedPreferences?.getInt(key, -1)
        value = if(value == -1) null else value
        return value
    }

    override fun setBooleanValue(key: String, value: Boolean) {
        this.sharedPreferences?.edit()?.putBoolean(key, value)?.apply()
    }

    override fun getBooleanValue(key: String): Boolean? {
        if(this.sharedPreferences?.contains(key)!!) {
            return this.sharedPreferences?.getBoolean(key, false)
        }
        return null
    }

    override fun setDoubleValue(key: String, value: Double) {
        this.sharedPreferences?.edit()?.putLong(key, value.toLong())?.apply()
    }

    override fun getDoubleValue(key: String): Double? {
        if(this.sharedPreferences?.contains(key)!!) {
            return this.sharedPreferences?.getLong(key, 0L)?.toDouble()
        }
        return null
    }

    abstract class LOCAL_STORAGE_KEYS {
        companion object {
            val EMAIL = "_email"
            val TOKEN = "_token"
            val USERNAME = "_username"
            val ID = "_id"
            val NAME = "_localStorageNakva"
            val MODE = 0
        }
    }
}