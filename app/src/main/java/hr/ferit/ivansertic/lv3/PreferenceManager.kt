package hr.ferit.ivansertic.lv3

import android.content.Context

class PreferenceManager {

    companion object{
        const val PREFS_FILE_COLOR = "Color"
        const val PREFS_KEY_COLOR = R.color.white.toString()

        const val PREFS_FILE_COUNTER = "Counter"
        const val PREFS_KEY_COUNTER = R.string.starting_count.toString()
    }

    fun saveColor(color: String){
        val sharedPreferences = BirdWatcher.ApplicationContext.getSharedPreferences(
            PREFS_FILE_COLOR, Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COLOR,color)
        editor.apply()
    }

    fun retrieveColor():String?{
        val sharedPreferences = BirdWatcher.ApplicationContext.getSharedPreferences(
            PREFS_FILE_COLOR, Context.MODE_PRIVATE
        )

        return sharedPreferences.getString(PREFS_KEY_COLOR, "#ffff")
    }

    fun saveCounter(counter: String) {
        val sharedPreferences = BirdWatcher.ApplicationContext.getSharedPreferences(
            PREFS_FILE_COUNTER, Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COUNTER,counter)
        editor.apply()
    }

    fun retrieveCounter():String? {
        val sharedPreferences = BirdWatcher.ApplicationContext.getSharedPreferences(
            PREFS_FILE_COUNTER, Context.MODE_PRIVATE
        )

        return sharedPreferences.getString(PREFS_KEY_COUNTER,"0")
    }
}