package com.example.key.beekeepernote.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by key on 24.09.17.
 */

public class AlarmService {
	private Context context;
	private PendingIntent mAlarmSender;
	public AlarmService(Context context) {
		this.context = context;
		mAlarmSender = PendingIntent.getBroadcast(context, 0, new Intent(context, TimeNotification.class), 0);
	}

	public void startAlarm(){
		//Set the alarm to 10 seconds from now
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, 10 *24*60*60*1000);
		long firstTime = c.getTimeInMillis();
		// Schedule the alarm!
		AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, firstTime, mAlarmSender);
	}
}
