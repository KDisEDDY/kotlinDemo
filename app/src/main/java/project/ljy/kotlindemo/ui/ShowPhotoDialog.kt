package project.ljy.kotlindemo.ui

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import project.ljy.kotlindemo.R

/**
 * ClassName: ShowPhotoDialog
 * function:
 * Created by EDDY
 * CreateTime:2018/5/7
 */
class ShowPhotoDialog(context: Context?) : Dialog(context) {

    inner class Builder(context: Context?) {

        var dialog:ShowPhotoDialog? = null

        var photoList: List<String>? = null

        init {
            dialog = ShowPhotoDialog(context)
            val view : View = LayoutInflater.from(context).inflate(R.layout.dialog_show_photo , null)
            dialog!!.setContentView(view)
        }

        fun build(){
            
        }

    }
}