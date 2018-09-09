package project.ljy.kotlindemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *@author eddyliu
 *@date 2018/9/9
 */
class ViewPagerAdapter(fragmentManager: FragmentManager, private val fragments: List<Fragment>) : FragmentPagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}