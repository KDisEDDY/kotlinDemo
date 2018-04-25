package project.ljy.kotlindemo

import android.util.Log

/**
 * Title: SingleInstance
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/4/25
 * Version: 1.0
 */
class SingleInstance private constructor(){

    companion object {
        private var mSingleInstance : SingleInstance? = null
        fun getInstance() : SingleInstance{
            if(mSingleInstance == null){
                mSingleInstance = SingleInstance()
            }
            return mSingleInstance as SingleInstance
        }
    }

    fun showToast() : Unit{
        Log.i("Tag" , "the hashCode is " + this.hashCode())
    }
}