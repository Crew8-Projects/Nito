package crew8.project.nito.viewModel.home

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import crew8.project.nito.model.datamodel.Paper
import crew8.project.nito.model.datamodel.Teacher


class HomeViewModel (application: Application) : AndroidViewModel(application) {



    var homeRepository: HomeRepo = HomeRepo(application)

    var app = application
    var textTitleOne = ObservableField<String>()

    fun init() {
        val account = GoogleSignIn.getLastSignedInAccount(app)
        textTitleOne.set(account?.givenName.toString()+","+"Select you'r teacher")
    }


    fun getTeachersFromServer(): MutableLiveData<ArrayList<Teacher>> {
        return homeRepository.getTeachers()
    }

    fun getPapersFromServer(): MutableLiveData<ArrayList<Paper>> {
        return homeRepository.getPapers()
    }

}