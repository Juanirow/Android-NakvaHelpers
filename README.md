# Android-NakvaHelpers
Dependencies with helpers for android projects

### Installing
1.- Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2.- Add Dependency

```
dependencies {
    compile 'com.github.Juanirow:Android-NakvaHelpers:0.2.0'
}
```

## Example
1.- Show Alert Dialogs 
```
DialogCreator.showDialogMessage(this,
        R.string.dialog_title,
        null,
        R.string.ok,
        R.string.message,
        null)
```

2.- Create Progress Dialog 
```
val mPDialog = ProgressDialogCreator.createProgressDialog(this,
        R.string.dialog_title,
        R.string.message)

mPDialog.show()
.
.
.
mPDialog.dismiss()
```

3.- Email Validator
```
EmailValidator.isValid("nailah@nakva.mx")
```

4.- Erros Handler in Text Input Layout

4.1.- Set Error
```
TextInputLayoutErrorsHandler.setTextInputLayoutError(R.string.error, label, this.context)
-- or --
TextInputLayoutErrorsHandler.setTextInputLayoutError("Error To set", label)
```

4.2.- Remove Error
```
 TextInputLayoutErrorsHandler.removeErrors(label)
```

## License 
This project is licensed under the MIT License - se the [LICENSE] file for details.


