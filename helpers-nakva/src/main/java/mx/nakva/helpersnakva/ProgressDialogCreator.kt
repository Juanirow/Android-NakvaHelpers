package mx.nakva.helpersnakva

import android.app.ProgressDialog
import android.content.Context


/**
 * Created by Juancho on 04/11/17.
 * Nakva
 * linanjm90@gmail.com
 */
object ProgressDialogCreator {

    /**
     * Create a Progress dialog with the title and message with the
     * cancelable attr as false
     * @param context   Current context to show the dialog
     * @param title     Title to display in the progress dialog
     * @param message   Message to display in the progress dialog
     * @return ProgressDialog instance
     */
    fun createProgressDialog(context: Context,
                             title: String,
                             message: String): ProgressDialog {
        val mProgressDialog = ProgressDialog(context)
        mProgressDialog.setTitle(title)
        mProgressDialog.setMessage(message)
        mProgressDialog.setCancelable(false)
        return mProgressDialog
    }


    /**
     * Create a Progress dialog with the title and message with the
     * cancelable attr as false
     * @param context       Current context to show the dialog
     * @param titleId       Id of the  title to display in the progress dialog
     * @param messageId     Id of the message to display in the progress dialog
     * @return ProgressDialog instance
     */
    fun createProgressDialog(context: Context,
                             titleId: Int,
                             messageId: Int): ProgressDialog {
        val title = context.resources.getString(titleId)
        val message = context.resources.getString(messageId)
        return createProgressDialog(context, title, message)
    }
}