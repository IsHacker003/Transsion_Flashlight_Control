package com.ishacker.tranflashcontrol

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream
import java.io.IOException
import android.widget.Toast;

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button)
    }
    private fun openFlashLight() {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        cameraManager.setTorchMode(cameraId, true)
    }
    fun openSubFlashLight(view: View) {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[1]
        cameraManager.setTorchMode(cameraId, true)
    }
    fun closeFlashLight(view: View) {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        cameraManager.setTorchMode(cameraId, false)
    }
    fun closeSubFlashLight(view: View) {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[1]
        cameraManager.setTorchMode(cameraId, false)
    }
    fun setPermissive(p0: View?) {
        Toast.makeText(this, "Please grant root", Toast.LENGTH_LONG).show();
        Runtime.getRuntime().exec("/debug_ramdisk/su -c /system/bin/setenforce 0")
    }

    override fun onClick(p0: View?) {
        openFlashLight()
    }
}