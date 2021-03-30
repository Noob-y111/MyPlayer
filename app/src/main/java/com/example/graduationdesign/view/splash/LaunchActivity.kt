package com.example.graduationdesign.view.splash

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import cn.leancloud.AVUser
import com.example.graduationdesign.view.login.LoginActivity
import com.example.graduationdesign.view.main.MainActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_launch)
        getPermissions()
    }

    private val r = Runnable {
//        val currentUser = AVUser.getCurrentUser()
//        if (currentUser == null){
//            startActivity(Intent(this, LoginActivity::class.java))
//            println("=========================当前没有用户登录")
//        }else{
//            println("================当前登录用户为: ${currentUser.username}")
//            startActivity(Intent(this, MainActivity::class.java))
//        }
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun getPermissions() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M
            && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                100
            )
        } else {
            Handler().postDelayed(r, 2000)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Handler().postDelayed(r, 2000)
            } else {
                finish()
            }
        }
    }
}