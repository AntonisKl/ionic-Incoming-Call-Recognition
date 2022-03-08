# ionic-Incoming-Call-Recognition
This is an ionic project that uses the PhoneCallTrap cordova plugin and a BroadcastReceiver to receive the incoming phone number when the phone is ringing.

# Compatibility
* Android
* ionic v1
* ionic v3

# Documentation
The project uses a <b>BroadcastReceiver</b> which has an onReceive method implemented. This method is called whenever the phone <b>changes call state</b>. All the possible call states are: `IDLE`, `OFFHOOK` and `RINGING`.

## Pipeline
Phone goes into `RINGING` state &rarr; the `onReceive` method gets called and sends the incoming phone number to the `CallStateListener` &rarr; The `CallStateListener`, also triggered by the state change, sends the phone number as `PluginResult` to the PhoneCallTrap cordova plugin &rarr; ionic gets the call state as well as the phone number and prints them on the console.

# How to integrate into any ionic project
Run these commands inside the folder of your ionic project: <br>
<b>(if you already have cordova and android platform installed start from the 3rd command)</b>
1. `npm install -g cordova`
2. `cordova platform add android`
3. `cordova plugin add antonis.phonecalltrap`

# Important Notes
Phone permissions must be given to the app for the plugin to work properly.
