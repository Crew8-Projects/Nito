package crew8.project.nito.viewModel.login

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

open class LoginViewModel(application: Application) : AndroidViewModel(application) {


    var textDialogUsergmail = ObservableField<String>()
    var editTextDialogUserName = ObservableField<String>()






   /* fun setUserData(): MutableLiveData<Boolean> {




        return visitsRepository.geVisits(isLoading)
    }*/


    fun setUserData(account: GoogleSignInAccount){

        textDialogUsergmail.set("gMail : "+account.email)
        editTextDialogUserName.set(account.givenName)



    }

}