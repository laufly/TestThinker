package com.aifudao.testthinker

import android.app.Application.ActivityLifecycleCallbacks
import android.os.Build
import android.annotation.TargetApi
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.tencent.bugly.Bugly
import android.content.Intent
import com.tencent.bugly.beta.Beta
import com.tencent.tinker.entry.DefaultApplicationLike



/**
 * Created by dongxiaofei on 2019/4/8.
 */
class TestThinkerApplicationLike(
    application: Application, tinkerFlags: Int,
    tinkerLoadVerifyFlag: Boolean, applicationStartElapsedTime: Long,
    applicationStartMillisTime: Long, tinkerResultIntent: Intent
) : DefaultApplicationLike(
    application,
    tinkerFlags,
    tinkerLoadVerifyFlag,
    applicationStartElapsedTime,
    applicationStartMillisTime,
    tinkerResultIntent
) {


    override fun onCreate() {
        super.onCreate()
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(application, "73535fdec4", false)
    }


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    override fun onBaseContextAttached(base: Context) {
        super.onBaseContextAttached(base)
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base)

        // 安装tinker
        // TinkerManager.installTinker(this); 替换成下面Bugly提供的方法
        Beta.installTinker(this)
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    fun registerActivityLifecycleCallback(callbacks: Application.ActivityLifecycleCallbacks) {
        application.registerActivityLifecycleCallbacks(callbacks)
    }

    companion object {
        val TAG = "Tinker.SampleApplicationLike"
    }

}