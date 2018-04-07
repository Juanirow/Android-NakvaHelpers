package mx.nakva.helpersnakva

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import android.widget.LinearLayout


/**
 * Created by Juancho on 04/11/17.
 * Nakva
 * linanjm90@gmail.com
 */
object DialogCreator {

    /**
     *
     * Display an alert in the current context
     *
     * - This dialog can be use as confirmation dialog
     *
     * @param context               Current context to show the alert
     * @param titleId               Title of the alert
     * @param iconId                Id of the drawable to show as icon
     * @param positiveBtnTextId     Id of the string to set in the positive button
     * @param messageId             Message to show in the alert
     * @param onCLickListener       Listener to detect the clicks in the buttons
     * @param onDismissListener     Listener to detect the dismiss action of the alert
     */
    fun showDialogMessage(context: Context,
                          titleId: Int,
                          iconId: Int? = null,
                          positiveBtnTextId: Int,
                          messageId: Int,
                          onCLickListener: DialogInterface.OnClickListener? = null,
                          onDismissListener: DialogInterface.OnDismissListener? = null) {
        val builder = AlertDialog.Builder(context)
        if(iconId != null) {
            builder.setIcon(iconId)
        }
        builder.setTitle(titleId)
        builder.setPositiveButton(positiveBtnTextId, onCLickListener)
        builder.setMessage(messageId)
        val alert = builder.create()
        alert.setOnDismissListener(onDismissListener)
        alert.show()
    }

    /**
     *
     * Show and Error Dialog to the user
     *
     * @param context               Current context to show the alert
     * @param messageId             Message to show in the alert
     * @param titleId               Title of the alert. [default value] "Error"
     * @param iconId                Id of the drawable to show as icon. [default value] = ic_delete
     * @param positiveBtnTextId     Id of the string to set in the positive button. [default value] "Ok"
     * @param onCLickListener       Listener to detect the clicks in the buttons
     * @param onDismissListener     Listener to detect the dismiss action of the alert
     */
    fun showError(context: Context,
                  messageId: Int,
                  titleId: Int? = R.string.nakva_error,
                  iconId: Int? = android.R.drawable.ic_delete,
                  positiveBtnTextId: Int? = R.string.nakva_ok,
                  onCLickListener: DialogInterface.OnClickListener? = null,
                  onDismissListener: DialogInterface.OnDismissListener? = null) {

        val tId = titleId ?: R.string.nakva_error
        val btnTextId = positiveBtnTextId ?: R.string.nakva_ok

        this.showDialogMessage(context,
                tId,
                iconId,
                btnTextId,
                messageId,
                onCLickListener,
                onDismissListener)
    }

    /**
     *
     * Show a warning error to the user
     *
     * @param context               Current context to show the alert
     * @param messageId             Message to show in the alert
     * @param titleId               Title of the alert. [default value] "Warning"
     * @param iconId                Id of the drawable to show as icon. [default value] = stat_sys_warning
     * @param positiveBtnTextId     Id of the string to set in the positive button. [default value] "Ok"
     * @param onCLickListener       Listener to detect the clicks in the buttons
     * @param onDismissListener     Listener to detect the dismiss action of the alert
     */
    fun showWarning(context: Context,
                    messageId: Int,
                    titleId: Int? = R.string.nakva_warning,
                    iconId: Int? = android.R.drawable.stat_sys_warning,
                    positiveBtnTextId: Int? = R.string.nakva_ok,
                    onCLickListener: DialogInterface.OnClickListener? = null,
                    onDismissListener: DialogInterface.OnDismissListener? = null) {

        val tId = titleId ?: R.string.nakva_error
        val btnTextId = positiveBtnTextId ?: R.string.nakva_ok

        this.showDialogMessage(context,
                tId,
                iconId,
                btnTextId,
                messageId,
                onCLickListener,
                onDismissListener)
    }

    /**
     *
     * Create an alert dialog with an input to ask information to the user
     *
     * @param context                   Current context of the app
     * @param titleId                   Id of the title resource to put in the alert dialog
     * @param descId                    Id of the resource to show as message in the dialog
     * @param editText                  Input to enter information to the user
     * @param inputType                 Type of input for the dialog
     * @param inputText                 Text to put in the edit text selected
     * @param hintInput                 Hint of the edit text
     * @param positiveBtnTextId         Hint of the edit text
     * @param negativeBtnTextId         Hint of the edit text
     * @param onClickPositiveListener   Listener for the onClick Positive Listener
     * @param onClickNegativeListener   Listener for the onClick Negative Listener
     * @param onDismissListener         Listener for the on dismiss action of the dialog
     * @return alert dialog
     */
    fun createInputDialog(context: Context,
                          titleId: Int,
                          descId: Int,
                          editText: EditText,
                          inputType: Int,
                          inputText: String?,
                          hintInput: Int,
                          positiveBtnTextId: Int? = R.string.nakva_ok,
                          negativeBtnTextId: Int? = R.string.nakva_cancel,
                          onClickPositiveListener: DialogInterface.OnClickListener? = null,
                          onClickNegativeListener: DialogInterface.OnClickListener? = null,
                          onDismissListener: DialogInterface.OnDismissListener? = null): AlertDialog {
        val layout = LinearLayout(context)
        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layout.setPadding(16, 0, 16, 0)
        layout.layoutParams = params

        editText.setHint(hintInput)
        editText.setSingleLine(true)
        editText.inputType = inputType
        editText.layoutParams = params
        if (inputText != null) {
            editText.setText(inputText)
            editText.setSelection(0, inputText.length)
        }
        layout.addView(editText)

        val builder = AlertDialog.Builder(context)
                .setMessage(descId)
                .setTitle(titleId)
                .setView(layout)
                .setPositiveButton(positiveBtnTextId!!, onClickPositiveListener)
                .setNegativeButton(negativeBtnTextId!!, onClickNegativeListener)
                .setOnDismissListener(onDismissListener)

        return builder.create()
    }
}