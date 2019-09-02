package crew8.project.nito.view.singupprofile

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import crew8.project.nito.R
import crew8.project.nito.databinding.ActivitySingupProfileBinding
import crew8.project.nito.viewModel.singup_profile.SingupProfileViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import crew8.project.nito.view.home.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_singup_profile.*


class SingupProfileActivity : AppCompatActivity() {

       lateinit var userModel : SingupProfileViewModel
      lateinit var binding: ActivitySingupProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         userModel = ViewModelProviders.of(this).get(SingupProfileViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_singup_profile)
        binding.singupprofile = userModel




    }

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account != null){
            userModel.setUserData(account)
        }else{

        }
        setDataToDateOfBirthSpinner()


        binding.singupprofile?.singupRespons?.observe(this, Observer<Boolean> {
            it?.let { result ->
                val intent = Intent(this, HomeActivity::class.java)
                val bndlanimation = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
                startActivity(intent, bndlanimation)
                this.finish()

            }
        })



    }


    private fun setDataToDateOfBirthSpinner(){

        val dateArray = arrayOf("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31")
        spinner_bday_date.adapter = ArrayAdapter(this, R.layout.list_bg_spinner, dateArray)


        val monthArray = arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
        spinner_bday_month.adapter = ArrayAdapter(this, R.layout.list_bg_spinner, monthArray)


        userModel.setBdayYearsToSpinner().observe(this, Observer<ArrayList<String>> {
            it?.let { result ->
                spinner_bday_year.adapter = ArrayAdapter(this, R.layout.list_bg_spinner, result)
            }
        })

    }
}
