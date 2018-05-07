package project.ljy.kotlindemo.base

import java.io.File

/**
 * Title: BaseConstant
 * Description:静态常量类
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/14
 * Version: 1.0
 */
object BaseConstant {

    /*toolbar样式*/
    const val STYLE_MAIN_PAGE = 1
    const val STYLE_RETURN_BACK = 2

    val LOG_ACTIVITY_STATE = "activityState"

    val DIR_HTTP_CACHE = File.pathSeparator + "Cache"
}
