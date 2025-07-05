package com.ishacker.tranflashcontrol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;

public class OtgReceiver extends BroadcastReceiver {
    String read() throws IOException {
        return Runtime.getRuntime().exec("getprop persist.sys.tran.otg.preference").toString();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if (read().equals("1")) {
                try {
                    Runtime.getRuntime().exec("su -c echo 1 > /sys/devices/platform/tran_charger/OTG_CTL");
                    Log.d("TranFlashControl","OTG enabled");
                    Log.d("TranFlashControlLog",read());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                Log.d("TranFlashControl","OTG disabled");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
