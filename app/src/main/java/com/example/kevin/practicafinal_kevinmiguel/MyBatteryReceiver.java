package com.example.kevin.practicafinal_kevinmiguel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by kevin on 11/01/17.
 */

public class MyBatteryReceiver extends BroadcastReceiver {
    @Override
    public  void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        String strAction;

        if (action == Intent.ACTION_BATTERY_LOW) {
            strAction = "ACTION_BATTERY_LOW";
        } else if (action == Intent.ACTION_BATTERY_OKAY) {
            strAction = "ACTION_BATTERY_OKAY";
        } else if (action == Intent.ACTION_POWER_CONNECTED) {
            strAction = "ACTION_POWER_CONNECTED";
        } else if (action == Intent.ACTION_POWER_DISCONNECTED) {
            strAction = "ACTION_POWER_DISCONNECTED";
        } else {
            strAction = "unknown!";
        }

        Log.i("Bateria", strAction);
    }
}
