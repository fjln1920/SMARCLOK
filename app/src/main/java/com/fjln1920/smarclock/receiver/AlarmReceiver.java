package com.fjln1920.smarclock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//import com.example.leanh.service.AlarmService;
//import com.example.leanh.ultil.Constants;
import com.fjln1920.smarclock.Utils.Constants;
import com.fjln1920.smarclock.service.AlarmService;

import static android.widget.Toast.*;

public class AlarmReceiver extends BroadcastReceiver {
    // this hold pendingIntend id if one pendingIntend trigger. The PendingIntent'id is alarm'id
    public static int pendingId;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.e("on broad", "broad");
        if (intent != null) {
            // this hold information to service
            Intent intentToService = new Intent(context, AlarmService.class);
            try {
                // getting intent key "intentType"
                String intentType = intent.getExtras().getString("intentType");
                switch (intentType) {
                    case Constants.ADD_INTENT:
                        // assign pendingId
                        pendingId = intent.getExtras().getInt("PendingId");
                        intentToService.putExtra("ON_OFF", Constants.ADD_INTENT);
                        context.startService(intentToService);

                        break;
                    case Constants.OFF_INTENT:
                        // get alarm'id from extras
                        int alarmId = intent.getExtras().getInt("AlarmId");
                        // sending to AlarmService
                        intentToService.putExtra("ON_OFF", Constants.OFF_INTENT);
                        intentToService.putExtra("AlarmId", alarmId);
                        context.startService(intentToService);

                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}