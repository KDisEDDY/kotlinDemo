package project.ljy.kotlindemo.ui

import android.os.Bundle
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.base.BaseActivity
import project.ljy.kotlindemo.base.BaseConstant

class MainActivity : BaseActivity() {

    override fun setSubContentView(): Int {
       return R.layout.activity_main
    }

    override fun initOnCreateOperation(savedInstanceState: Bundle?) {
        initTitle(getString(R.string.tab_video_list) , BaseConstant.STYLE_MAIN_PAGE)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ll_frag_container, VideoListFragment())
        transaction.commitAllowingStateLoss()
    }
}
