package crew8.project.nito

import android.app.Application
import android.content.Context

class Nito  : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //MultiDex.install(this)

    }

    override fun onTerminate() {
        super.onTerminate()
    }

}