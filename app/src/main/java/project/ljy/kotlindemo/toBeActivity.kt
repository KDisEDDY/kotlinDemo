package project.ljy.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class toBeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_be)
        val singleInstance : SingleInstance = SingleInstance.getInstance()
        singleInstance.showToast()
    }
}
