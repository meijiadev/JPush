package com.blackview.jpush

import android.app.Application
import android.util.Log
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.api.TagAliasCallback
import cn.jpush.android.ups.JPushUPSManager
import cn.jpush.android.ups.TokenResult
import cn.jpush.android.ups.UPSRegisterCallBack
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.api.HuaweiApiClient
import com.huawei.hms.common.HuaweiApiInterface
import com.huawei.hms.common.internal.HuaweiApiManager

/**
 *    author : MJ
 *    time   : 2022/06/22
 *    desc   : 程序入口
 */
class JPushApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initJGPush()
    }

    private fun initJGPush(){
        Log.e("com.blackview.jpush.JPushApp","初始化极光推送")
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
        JPushInterface.setTags(this, mutableSetOf("HUAWEI"),object : TagAliasCallback {
            override fun gotResult(p0: Int, p1: String?, p2: MutableSet<String>?) {

            }

        })

        JPushUPSManager.registerToken(this,"b3e811485f7fc092853c8563",null,"c802546373bf5d3270ab6392"
        ) {
            Log.e("com.blackview.jpush.JPushApp", "initJGPush: ${it.token},registerID:${JPushInterface.getRegistrationID(this)}")
        }


    }
}