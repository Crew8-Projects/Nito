package crew8.project.nito.viewModel.singup_profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import crew8.project.nito.service.api.APIInterface
import crew8.project.nito.service.api.ApiClient
import crew8.project.nito.service.network.NetworkErrorHandler

class SingupProfileViewModelRepo(application: Application) {

    var app: Application = application
    var networkErrorHandler: NetworkErrorHandler = NetworkErrorHandler()
    var apiInterface: APIInterface = ApiClient.client(application)






}