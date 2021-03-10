package com.eddyjyliu.modulea.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CalculateFunction {

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
}