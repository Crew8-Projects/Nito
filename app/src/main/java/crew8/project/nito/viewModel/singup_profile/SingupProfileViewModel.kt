package crew8.project.nito.viewModel.singup_profile


import android.app.Application
import android.os.Handler
import android.view.View

import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import android.widget.AdapterView




class SingupProfileViewModel (application: Application) : AndroidViewModel(application) {


    var singupProfileViewModelRepo: SingupProfileViewModelRepo = SingupProfileViewModelRepo(application)

    var textUsername = ObservableField<String>()
    var textUseremail = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()
    val isSingupButtonVisible = ObservableField<Boolean>()

    var image_url = String()
    var app = application



    var userBdayDate=String()
    var userBdayMonth=String()
    var userBdayYear=String()

    var singupRespons = MutableLiveData<Boolean>()



    fun setUserData(account: GoogleSignInAccount){
        isSingupButtonVisible.set(true)


        image_url = if(account.photoUrl==null){
            "https://firebasestorage.googleapis.com/v0/b/nito-70ff2.appspot.com/o/ic_profile_users.png?alt=media&token=862d3a79-dd59-4fb9-a8d1-6b1ac8e61b10"
        }else{
            account.photoUrl.toString()
        }
        textUsername.set(account.displayName)
        textUseremail.set(account.email)
    }


    fun setBdayYearsToSpinner(): MutableLiveData<ArrayList<String>> {
        val array = ArrayList<String>()
        val arrayRespond = MutableLiveData<ArrayList<String>>()
        val year = Calendar.getInstance().get(Calendar.YEAR)

        var maxYear = (year-14)
        var minYear = (maxYear-30)

        for (i in maxYear downTo minYear) {
            array.add(i.toString())
        }

        arrayRespond.postValue(array)
        return arrayRespond
    }

    fun onSelectBirthdayDateItem(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        userBdayDate=parent.getItemAtPosition(pos).toString()
    }
    fun onSelectBirthdayMonthItem(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        userBdayMonth= parent.getItemAtPosition(pos).toString()
    }
    fun onSelectBirthdayYearItem(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        userBdayYear= parent.getItemAtPosition(pos).toString()
    }


    fun singup() {

        isLoading.set(true)
        isSingupButtonVisible.set(false)


        Handler().postDelayed(Runnable {
            isLoading.set(false)
            isSingupButtonVisible.set(true)
            singupRespons?.value =true
        }, 4000)

    }

}