package hr.ferit.ivansertic.lv3

import android.app.Application
import android.content.Context

class BirdWatcher: Application() {
    companion object{
        lateinit var ApplicationContext: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}