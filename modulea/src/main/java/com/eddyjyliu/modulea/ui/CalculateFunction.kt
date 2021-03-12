package com.eddyjyliu.modulea.ui

import android.util.Log
import kotlinx.coroutines.*

class CalculateFunction {

    companion object {
        private const val TAG = "CalculateFunction"
    }

    suspend fun calculateLogic(number: Double): Double{
        var finalNum = number
        withContext(Dispatchers.IO) {
            for (i in 1 until 10) {
                delay(10)
                finalNum *= i
            }
        }
        return finalNum
    }

    suspend fun calculateLogicWithScopeAsync(number1: Double, number2: Double): Double {
        val num1 = calculateLogicAction(number1).await()
        Log.d(TAG, "num1 $num1")
        delay(100)
        val num2 = calculateLogicAction(number2).await()
        Log.d(TAG, "num2 $num2")
        return num1 + num2
    }


    fun calculateLogicAction(num: Double) = GlobalScope.async {
        var finalNum = num
        for (i in 1 until 10) {
            delay(10)
            finalNum *= i
        }
        finalNum
    }
}