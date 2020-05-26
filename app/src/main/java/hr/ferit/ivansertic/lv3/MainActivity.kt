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

        btnGreyBird.setOnClickListener{
            saveColor(Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.gray)))
            saveCounter()
        }

        btnRedBird.setOnClickListener{
            saveColor(Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.red)))
            saveCounter()
        }

        btnBlueBird.setOnClickListener{
            saveColor(Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.blue)))
            saveCounter()
        }

        btnReset.setOnClickListener{
            resetCounter()
        }
    }

    override fun onResume() {
        super.onResume()
        displayBirdCounter()
    }

    private fun saveCounter() {
        var counter: Int = Integer.parseInt(twNumber.text.toString())
        counter += 1
        val preferenceManager = PreferenceManager()
        preferenceManager.saveCounter(counter.toString())
        displayBirdCounter()
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
        }else{
            twNumber.text = counter
            twNumber.setBackgroundColor((Color.parseColor(color)))
            twNumber.setTextColor(Color.parseColor("#"+Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.black))))
        }
    }

    private fun resetCounter(){
        twNumber.text = "0";
        twNumber.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.white))))
        twNumber.setTextColor(Color.parseColor("#"+Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.black))))

        val preferenceManager = PreferenceManager()
        preferenceManager.saveColor("#"+Integer.toHexString(ContextCompat.getColor(applicationContext,R.color.white)))
        preferenceManager.saveCounter("0");
    }
}
