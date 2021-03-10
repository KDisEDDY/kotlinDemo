package com.eddyjyliu.modulea.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eddyjyliu.modulea.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ModuleATestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_a_test)
        GlobalScope.launch {
            val number = CalculateFunction().calculateLogic(10.toDouble())
            Log.d("ModuleATestActivity" , "the number is $number")
        }
    }
}
