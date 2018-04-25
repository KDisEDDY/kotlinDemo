package project.ljy.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mTest : Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mHelloWorldTxt = findViewById<TextView>(R.id.tv_helloWorld)
        mHelloWorldTxt.setOnClickListener {
            startActivity(Intent(MainActivity@this , toBeActivity::class.java))
        }
        mTest = 1
        TestFun(mTest)
        var singleInstance = SingleInstance.getInstance()
        singleInstance.showToast()
    }

    fun TestFun(param1: Int) {
        Toast.makeText(this, "The testFunction is used , param is $param1",Toast.LENGTH_SHORT).show()
    }
}
