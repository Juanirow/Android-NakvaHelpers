package mx.nakva.helpersnakva

import android.content.Context
import android.support.design.widget.TextInputLayout


/**
 * Created by Juancho on 04/11/17.
 * Nakva
 * linanjm90@gmail.com
 */
object TextInputLayoutErrorsHandler {


    /**
     * Set the error and the focus on the TextInputLayout
     * @param error error to set in the layout input
     * @param label input to set the error
     */
    fun setTextInputLayoutError(error: String,
                                label: TextInputLayout) {
        label.error = error
        label.isErrorEnabled = true
        label.error = error
        label.requestFocus()
    }

    /**
     * Set the error and the focus on the TextInputLayout
     * @param errorId string id of the error resource
     * @param label input to set the error
     * @param context current context of the app
     */
    fun setTextInputLayoutError(errorId: Int,
                                label: TextInputLayout,
                                context: Context) {
        val error = context.getString(errorId)
        setTextInputLayoutError(error, label)
    }

    /**
     * Remove/Hide the error from the TextInputLayout
     */
    fun removeErrors(label: TextInputLayout) {
        label.error = null
        label.isErrorEnabled = false
    }
}