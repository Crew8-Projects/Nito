package crew8.project.nito.view.splash

import android.app.ActivityOptions
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.gms.auth.api.signin.GoogleSignIn
import crew8.project.nito.R
import crew8.project.nito.view.home.activity.HomeActivity

import crew8.project.nito.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onStart() {
        super.onStart()
        textView_appversion.text=getAppVersionRepo()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        Handler().postDelayed(Runnable {

            val intent = Intent(this, HomeActivity::class.java)
            val bndlanimation = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
            startActivity(intent, bndlanimation)
            this.finish()



            /*if(account==null){
                val intent = Intent(this, LoginActivity::class.java)
                val bndlanimation = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
                startActivity(intent, bndlanimation)
                this.finish()
            }else{
                val intent = Intent(this, HomeActivity::class.java)
                val bndlanimation = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
                startActivity(intent, bndlanimation)
                this.finish()
            }*/

        }, 3000)

    }

    fun getAppVersionRepo() : String{
        var appVersion ="1.0.00"
        try {
            appVersion = packageManager.getPackageInfo(packageName, 0).versionName
        } catch (e: PackageManager.NameNotFoundException) { }
        return appVersion
    }
}
