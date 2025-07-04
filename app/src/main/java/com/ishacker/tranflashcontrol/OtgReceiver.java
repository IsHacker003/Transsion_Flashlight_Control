package com.ishacker.tranflashcontrol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.preference.Preference;
import android.provider.Settings;

public class OtgReceiver extends BroadcastReceiver {
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        final String KEY_OTG_PREFERENCE = "persist.sys.tran.otg.preference";
        final String OTG_MODE = "otg_mode";
        Settings.Global.putInt(this.mContext.getContentResolver(), KEY_OTG_PREFERENCE, 1);
        Settings.Global.putInt(this.mContext.getContentResolver(), OTG_MODE, 1);
    }
}
