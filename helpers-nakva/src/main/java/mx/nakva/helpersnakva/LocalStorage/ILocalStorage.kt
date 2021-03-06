package mx.nakva.helpersnakva.LocalStorage


/**
 * Created by Juancho on 23/11/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ILocalStorage {

    fun getEmail(): String?
    fun getToken(): String?
    fun getUsername(): String?
    fun getId(): String?
    fun createSession(username: String?, email: String?, token: String?, id: String?)
    fun hasSession(): Boolean
    fun destroySession()
    fun setValue(key: String, value: Any)
    fun setLongValue(key: String, value: Long)
    fun getLongValue(key: String): Long?
    fun setStringValue(key: String, value: String)
    fun getStringValue(key: String): String?
    fun setIntValue(key: String, value: Int)
    fun getIntValue(key: String): Int?
    fun setBooleanValue(key: String, value: Boolean)
    fun getBooleanValue(key: String): Boolean?
    fun setDoubleValue(key: String, value: Double)
    fun getDoubleValue(key: String): Double?
}

