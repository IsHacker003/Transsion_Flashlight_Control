package com.ishacker.tranflashcontrol

import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

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
    fun goToOtg(p0: View?) {
        val intent = Intent(this, OtgActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        openFlashLight()
    }
}
