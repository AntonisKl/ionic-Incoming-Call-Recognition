package io.gvox.phonecalltrap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
    if(stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
      Bundle bundle = intent.getExtras();
      String phoneNumber = bundle.getString("incoming_number");
      CallStateListener.setPhoneNumber(phoneNumber);
    }
  }
}
