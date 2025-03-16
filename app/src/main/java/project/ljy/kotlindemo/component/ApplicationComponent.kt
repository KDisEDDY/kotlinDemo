package project.ljy.kotlindemo.component

import dagger.Component
import project.ljy.kotlindemo.network.RetrofitManager
import project.ljy.kotlindemo.ui.VideoListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitManager::class])
interface ApplicationComponent {
    fun inject(fragment: VideoListFragment)
}