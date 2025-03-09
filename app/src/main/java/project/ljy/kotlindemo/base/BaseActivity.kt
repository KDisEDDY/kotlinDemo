package project.ljy.kotlindemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import com.eddyjyliu.baseutil.utils.StatusBarUtil
import project.ljy.kotlindemo.R

/**
 * Title: BaseActivity
 * Description:
 * Author: 刘加彦
 * Date: 2018/4/27
 * Version: 1.0
 */
abstract class BaseActivity :AppCompatActivity() {

    private var mToolbar: Toolbar? = null

    abstract fun setSubContentView(): Int

    abstract fun initOnCreateOperation(savedInstanceState : Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setSubContentView() != 0) {
            setContentView(setSubContentView())
        }
        mToolbar = findViewById(R.id.toolbar)
        if (mToolbar != null) {
            setSupportActionBar(mToolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
        initOnCreateOperation(savedInstanceState)
    }

    /**
     * 初始化title
     * @param title
     * @param toolbarStyle
     */
    fun initTitle(title: String, toolbarStyle: Int) {
        setWindowTitle(title)
        if (toolbarStyle == BaseConstant.STYLE_MAIN_PAGE){
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        } else if (toolbarStyle == BaseConstant.STYLE_RETURN_BACK) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorPrimary))
    }

    fun setWindowTitle(title: String) {
        val titleTxt = findViewById<TextView>(R.id.tv_title)
        titleTxt.text = title
    }

    fun setWindowTitle(titleId: Int) {
        if (titleId != 0) {
            val titleTxt = findViewById<TextView>(R.id.tv_title)
            titleTxt.setText(titleId)
        }
    }
}