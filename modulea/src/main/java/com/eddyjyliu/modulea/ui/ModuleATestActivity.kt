package com.eddyjyliu.modulea.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eddyjyliu.modulea.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ModuleATestActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ModuleATestActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_a_test)
        val calculateFunction = CalculateFunction()
//        GlobalScope.launch {
//            val number = calculateFunction.calculateLogic(10.toDouble())
//            Log.d("ModuleATestActivity" , "the number is $number")
//        }

        GlobalScope.launch {
            val number = calculateFunction.calculateLogicWithScopeAsync(10.toDouble(), 20.toDouble())
            Log.d(TAG , "calculateLogicWithScopeAsync the number is $number")
        }
    }
}
