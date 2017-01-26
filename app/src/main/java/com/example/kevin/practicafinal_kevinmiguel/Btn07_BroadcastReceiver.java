package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Btn07_BroadcastReceiver extends AppCompatActivity {

    private TextView tvBateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn07__broadcast_receiver);

        tvBateria = (TextView) findViewById(R.id.tvBateria);

        tvBateria.setText(readBattery());
    }

    private String readBattery() {
        StringBuilder sb = new StringBuilder();
        int status;

        IntentFilter batteryIntentFilter = new IntentFilter((Intent.ACTION_BATTERY_CHANGED));
        Intent batteryIntent = registerReceiver(null, batteryIntentFilter);

        boolean present1 = batteryIntent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
        sb.append("PRESENT : " + present1 + "\n");

        status = batteryIntent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            sb.append("BATTERY_STATUS_CHARGING\n");
        }

        if (status == BatteryManager.BATTERY_STATUS_FULL) {
            sb.append("BATTERY_STATUS_FULL\n");
        }

        int plugged = batteryIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        if (plugged == BatteryManager.BATTERY_PLUGGED_USB) {
            sb.append("BATTERY_PLUGGED_USB\n");
        }

        if (plugged == BatteryManager.BATTERY_PLUGGED_AC) {
            sb.append("BATTERY_PLUGGED_AC\n");
        }

        return sb.toString();
    }
}
