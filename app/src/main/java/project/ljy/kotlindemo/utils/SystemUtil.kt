package project.ljy.kotlindemo.utils

/**
 * Title: SystemUtil
 * Description:
 * Author: 刘加彦
 * Date: 2018/4/27
 * Version: 1.0
 */

import java.util.Locale

/**
 * 系统工具类
 * Created by zhuwentao on 2016-07-18.
 */
object SystemUtil {

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    val systemLanguage: String
        get() = Locale.getDefault().language

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return  语言列表
     */
    val systemLanguageList: Array<Locale>
        get() = Locale.getAvailableLocales()

    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    val systemVersion: String
        get() = android.os.Build.VERSION.RELEASE

    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    val systemModel: String
        get() = android.os.Build.MODEL

    /**
     * 获取手机厂商
     *
     * @return  手机厂商
     */
    val deviceBrand: String
        get() = android.os.Build.BRAND

    //    /**
    //     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
    //     *
    //     * @return  手机IMEI
    //     */
    //    public static String getIMEI(Context ctx) {
    //        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
    //        if (tm != null) {
    //            return tm.getDeviceId();
    //        }
    //        return null;
    //    }
}