package zeusro.specialalarmclock.service;

import android.app.IntentService;
import android.content.Intent;

import zeusro.specialalarmclock.Alarm;
import zeusro.specialalarmclock.activity.AlarmAlertActivity;
import zeusro.specialalarmclock.receiver.AlarmServiceBroadcastReciever;

public class SchedulingService extends IntentService {
    public SchedulingService() {
        super("SchedulingService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final Alarm alarm = (Alarm) intent.getExtras().getSerializable("alarm");
        Intent alarmAlertActivityIntent = new Intent(getApplicationContext(), AlarmAlertActivity.class);
        alarmAlertActivityIntent.putExtra("alarm", alarm);
        alarmAlertActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(alarmAlertActivityIntent);
        AlarmServiceBroadcastReciever.completeWakefulIntent(intent);
    }

}
