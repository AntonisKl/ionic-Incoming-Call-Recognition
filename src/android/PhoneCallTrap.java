package phonecalltrap;

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

  public static CallbackContext callbackContext;

  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    PhoneCallTrap.callbackContext = callbackContext;

    return true;
  }

  public static void setAndSendResult(String msg) {
    PluginResult result = new PluginResult(PluginResult.Status.OK, msg);
    result.setKeepCallback(true);
    callbackContext.sendPluginResult(result);
  }
}
