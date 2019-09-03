package crew8.project.nito.viewModel.home

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import crew8.project.nito.model.datamodel.Paper
import crew8.project.nito.model.datamodel.Teacher
import crew8.project.nito.service.api.APIInterface
import crew8.project.nito.service.api.ApiClient
import crew8.project.nito.service.network.NetworkErrorHandler
import java.util.ArrayList

class HomeRepo (application: Application) {



    var app: Application = application
    var networkErrorHandler: NetworkErrorHandler = NetworkErrorHandler()

    var apiInterface: APIInterface = ApiClient.client(application)



    fun getTeachers(): MutableLiveData<ArrayList<Teacher>> {

        val mutableTeacherData = MutableLiveData<ArrayList<Teacher>>()
        var teacherData = ArrayList<Teacher>()

        teacherData.add(Teacher(1,"Amith Pussella","Physics","AL","https://firebasestorage.googleapis.com/v0/b/nito-70ff2.appspot.com/o/2.png?alt=media&token=9f3f2dc9-0c54-41d4-bfbc-015f4bcf7d15"))
        teacherData.add(Teacher(1,"Dushyantha Mahabaduge","Combined Maths","AL","https://firebasestorage.googleapis.com/v0/b/nito-70ff2.appspot.com/o/2.png?alt=media&token=9f3f2dc9-0c54-41d4-bfbc-015f4bcf7d15"))
        teacherData.add(Teacher(1,"Nadun Rajakaruna","Chemistry","AL","https://firebasestorage.googleapis.com/v0/b/nito-70ff2.appspot.com/o/2.png?alt=media&token=9f3f2dc9-0c54-41d4-bfbc-015f4bcf7d15"))
        teacherData.add(Teacher(1,"Samitha Rathnayake","Physics","AL","https://firebasestorage.googleapis.com/v0/b/nito-70ff2.appspot.com/o/4.png?alt=media&token=65aaef51-36ce-4a0f-975a-303c8299e438"))
        teacherData.add(Teacher(1,"Thissa Jananayake","Biology","AL","http://marisstellaoba.com/wp-content/uploads/2019/05/DSC_2832-copy-copy.jpg"))

        mutableTeacherData.postValue(teacherData)


        return mutableTeacherData
    }


    fun getPapers(): MutableLiveData<ArrayList<Paper>> {

        val mutablePaperData = MutableLiveData<ArrayList<Paper>>()
        var paperData = ArrayList<Paper>()

        paperData.add(Paper(1,"Physics","MCQ","60Min"))
        paperData.add(Paper(1,"Combined Maths","MCQ","60Min"))
        paperData.add(Paper(1,"Chemistry","MCQ","60Min"))
        paperData.add(Paper(1,"Physics","MCQ","60Min"))
        paperData.add(Paper(1,"Biology","MCQ","60Min"))

        mutablePaperData.postValue(paperData)


        return mutablePaperData
    }


}