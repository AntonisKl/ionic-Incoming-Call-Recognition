package phonecalltrap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import org.apache.cordova.CallbackContext;

public class MyBroadcastReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {

    if (PhoneCallTrap.callbackContext == null) return;

    String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
    String msg = "";

    if (stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE))
      msg = "IDLE";
    else if(stateStr.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
      msg = "OFFHOOK";
    else if (stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
      Bundle bundle = intent.getExtras();
      String phoneNumber = bundle.getString("incoming_number");
      msg = "RINGING&" + phoneNumber;
    }
    
    PhoneCallTrap.setAndSendResult(msg);
  }
}
