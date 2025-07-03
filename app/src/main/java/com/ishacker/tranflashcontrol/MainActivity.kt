package com.ishacker.tranflashcontrol

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
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
    @SuppressLint("ServiceCast")
    private fun openFlashLight() {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        cameraManager.setTorchMode(cameraId, true)
    }
    private fun openSubFlashLight() {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[1]
        cameraManager.setTorchMode(cameraId, true)
    }

    fun TurnFlashlightOn() {
        val iIntValue = 1
        val fileOutputStream = FileOutputStream("/sys/class/torch/torch/torch_level")
        fileOutputStream.write(iIntValue.toString().toByteArray())
        fileOutputStream.close()
        openFlashLight()
    }

    @Throws(IOException::class)
    fun TurnFlashlightOff(p0: View?) {
        val iIntValue = 0
        val fileOutputStream = FileOutputStream("/sys/class/torch/torch/torch_level")
        fileOutputStream.write(iIntValue.toString().toByteArray())
        fileOutputStream.close()
    }

    @Throws(IOException::class)
    fun TurnSubFlashlightOn(p0: View?) {
        val iIntValue = 1
        val fileOutputStream =
            FileOutputStream("/sys/devices/virtual/sub_torch/sub_torch/sub_torch_level")
        fileOutputStream.write(iIntValue.toString().toByteArray())
        fileOutputStream.close()
        openSubFlashLight()
    }

    @Throws(IOException::class)
    fun TurnSubFlashlightOff(p0: View?) {
        val iIntValue = 0
        val fileOutputStream =
            FileOutputStream("/sys/devices/virtual/sub_torch/sub_torch/sub_torch_level")
        fileOutputStream.write(iIntValue.toString().toByteArray())
        fileOutputStream.close()
    }

    fun setPermissive(p0: View?) {
        Toast.makeText(this, "Please grant root", Toast.LENGTH_LONG).show();
        Runtime.getRuntime().exec("/debug_ramdisk/su -c /system/bin/setenforce 0")
    }

    override fun onClick(p0: View?) {
        TurnFlashlightOn()
    }


}