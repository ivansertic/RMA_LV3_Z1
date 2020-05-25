package hr.ferit.ivansertic.lv3

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
    }

    private fun setUpUi() {
        btnBlackBird.setOnClickListener{
            saveColor(Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.black)))
            saveCounter()
        }
    }

    private fun saveCounter() {
        var counter: Int = Integer.parseInt(twNumber.text.toString())
        counter += 1
        val preferenceManager = PreferenceManager()
        preferenceManager.saveCounter(counter.toString())
    }

    private fun saveColor(color:String) {
        val preferenceManager = PreferenceManager()
        preferenceManager.saveColor("#"+color)
        displayBirdCounter()
    }

    private fun displayBirdCounter(){
        val counter = PreferenceManager().retrieveCounter()
        val color = PreferenceManager().retrieveColor()
        println(color)

        if(color == "#"+Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.black))){
            twNumber.text = counter
            twNumber.setBackgroundColor(Color.parseColor(color))
            twNumber.setTextColor(Color.parseColor("#"+Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.white))))
        }/*else{
            twNumber.setTextColor(Color.parseColor(R.color.black.toString()))
            twNumber.setBackgroundColor((Color.parseColor(color)))
            twNumber.text = counter
        }*/
    }
}
