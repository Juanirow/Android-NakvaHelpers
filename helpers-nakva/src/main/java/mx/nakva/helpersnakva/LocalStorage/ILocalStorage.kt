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

}
