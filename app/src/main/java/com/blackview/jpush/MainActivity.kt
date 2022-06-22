package com.blackview.jpush

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.common.ApiException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getToken()
    }

    private fun getToken() {
        // 创建一个新线程
        object : Thread() {
            override fun run() {
                try {
                    // 从agconnect-service.json文件中读取appId
                    val appId = "106526715"

                    // 输入token标识"HCM"
                    val tokenScope = "HCM"
                    val token = HmsInstanceId.getInstance(this@MainActivity).getToken(appId, tokenScope)
                    Log.e("MainActivity", "get token:$token")

                } catch (e: ApiException) {
                    Log.e("MainActivity", "get token failed, $e")
                }
            }
        }.start()
    }
}