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
        val username = this.getUsername()
        val token = this.getToken()
        val id = this.getId()

        if(email != null && username != null && token != null && id != null){
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