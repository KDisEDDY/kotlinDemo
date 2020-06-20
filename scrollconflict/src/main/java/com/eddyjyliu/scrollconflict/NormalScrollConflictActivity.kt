package com.eddyjyliu.scrollconflict

import android.app.Activity
import android.os.Bundle

/**
 * 验证处理滑动冲突的activity
 */
class NormalScrollConflictActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
}