package com.eddyjyliu.modulea.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import com.eddyjyliu.modulea.R

class ModuleATestActivity : AppCompatActivity() {


    val viewModel: AViewModel by lazy { val vm = ViewModelProvider
        .AndroidViewModelFactory.getInstance(this.application).create(AViewModel::class.java)
        vm.attachContext(this)
        vm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_a_test)
        viewModel.setImageBitmap(findViewById<AppCompatImageView>(R.id.img))
    }
}
