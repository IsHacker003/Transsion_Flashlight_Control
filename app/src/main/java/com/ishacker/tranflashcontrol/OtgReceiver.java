package com.ishacker.tranflashcontrol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OtgReceiver extends BroadcastReceiver {
    private String getSystemProperty(String propertyName) {
        String propertyValue = "[UNKNOWN]";

        try {
            Process getPropProcess = Runtime.getRuntime().exec("getprop " + propertyName);

            BufferedReader osRes =
                    new BufferedReader(new InputStreamReader(getPropProcess.getInputStream()));

            propertyValue = osRes.readLine();

            osRes.close();
        } catch (Exception e) {
            // Do nothing - can't get property value
        }

        return propertyValue;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
            if (getSystemProperty("persist.sys.tran.otg.preference").equals("1")) {
                try {
                    Runtime.getRuntime().exec("su -c echo 1 > /sys/devices/platform/tran_charger/OTG_CTL");
                    Log.d("TranFlashControl", "OTG enabled");
                    Log.d("TranFlashControlLog", getSystemProperty("persist.sys.tran.otg.preference"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                Log.d("TranFlashControl","OTG disabled");
            }
        }
    }

