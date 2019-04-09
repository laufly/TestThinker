package com.aifudao.testthinker

import com.tencent.tinker.loader.app.TinkerApplication
import com.tencent.tinker.loader.shareutil.ShareConstants



/**
 * Created by dongxiaofei on 2019/4/8.
 */

class TestThinkerApplication : TinkerApplication(
    ShareConstants.TINKER_ENABLE_ALL, //tinkerFlags 表示Tinker支持的类型 dex only、library only or all suuport，default: TINKER_ENABLE_ALL
    "com.aifudao.testthinker.TestThinkerApplicationLike",//delegateClassName Application代理类 这里填写你自定义的ApplicationLike
    "com.tencent.tinker.loader.TinkerLoader",//loaderClassName Tinker的加载器，使用默认即可
    false //tinkerLoadVerifyFlag 加载dex或者lib是否验证md5，默认为false
)