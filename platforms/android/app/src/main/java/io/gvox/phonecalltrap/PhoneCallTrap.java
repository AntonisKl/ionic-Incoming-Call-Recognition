package io.gvox.phonecalltrap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONArray;


public class PhoneCallTrap extends CordovaPlugin {

  public static CallStateListener listener;


  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    prepareListener();
    listener.setCallbackContext(callbackContext);

    return true;
  }

  private void prepareListener() {
    if (listener == null) {
      listener = new CallStateListener();
      TelephonyManager TelephonyMgr = (TelephonyManager) cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
      TelephonyMgr.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    } else
      CallStateListener.setPhoneNumber("empty"); // reset phone number string
  }
}

class CallStateListener extends PhoneStateListener {

  private CallbackContext callbackContext;
  private static String phoneNumber = "empty";

  public void setCallbackContext(CallbackContext callbackContext) {
    this.callbackContext = callbackContext;
  }

  public void onCallStateChanged(int state, String incomingNumber) {
    super.onCallStateChanged(state, incomingNumber);

    if (callbackContext == null) return;

    String msg = ""; // needs to be an array because it is assigned inside the Runnable function of Handler

    switch (state) {
      case TelephonyManager.CALL_STATE_IDLE:
        msg = "IDLE";
        break;

      case TelephonyManager.CALL_STATE_OFFHOOK:
        msg = "OFFHOOK";
        break;

      case TelephonyManager.CALL_STATE_RINGING:
        msg = "RINGING&" + phoneNumber;
        break;
    }

    if (!msg.equals("RINGING&empty")) /* not yet got number */ {
      setAndSendResult(msg);
    } else {
      // wait a bit to get phone number from the Broadcast Receiver
      final Handler handler = new Handler();
      handler.postDelayed(() -> {
        //Do something after 100ms
        setAndSendResult("RINGING&" + phoneNumber);
      }, 100);
    }
  }

  private void setAndSendResult(String msg) {
    PluginResult result = new PluginResult(PluginResult.Status.OK, msg);
    result.setKeepCallback(true);
    callbackContext.sendPluginResult(result);
    phoneNumber = "empty"; // reset phone number to get a new one next time
  }

  public static String getPhoneNumber() {
    return phoneNumber;
  }

  public static void setPhoneNumber(String phoneNum) {
    phoneNumber = phoneNum;
  }
}
