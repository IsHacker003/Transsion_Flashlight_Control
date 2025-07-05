package com.ishacker.tranflashcontrol

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class OtgActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otgact)
    }
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
    fun enableOtg(p0: View?) {
        Runtime.getRuntime().exec("su -c setprop persist.sys.tran.otg.preference 1 && su -c echo 1 > /sys/devices/platform/tran_charger/OTG_CTL")
    }
    fun disableOtg(p0: View?) {
        Runtime.getRuntime().exec("su -c setprop persist.sys.tran.otg.preference 0 && su -c echo 0 > /sys/devices/platform/tran_charger/OTG_CTL")
    }
}