package project.ljy.kotlindemo.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_viewpager.*
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.adapter.ViewPagerAdapter
import kotlin.properties.Delegates

/**
 *@author eddyliu
 * viewpager 实现加载多个fragment
 *@date 2018/9/9
 */
class ViewPagerFragment:Fragment() {

    private var pagerAdapter: FragmentPagerAdapter by Delegates.notNull()

    private var tabString = mutableListOf<String>().apply {
        add("videoList")
        add("AView")
        add("BView")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragments = mutableListOf<Fragment>().apply {
            add(VideoListFragment())
            add(AViewFragment())
            add(BViewFragment())
        }
        pagerAdapter = ViewPagerAdapter(fragmentManager , fragments)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = pagerAdapter
        pagerAdapter.notifyDataSetChanged()
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        tabString.forEach {
            tabLayout.addTab(tabLayout.newTab().apply { text = it })
        }
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_viewpager, container , false)
    }
}