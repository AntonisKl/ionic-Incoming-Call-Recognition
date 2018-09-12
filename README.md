# ionic-Incoming-Call-Recognition
This is an ionic project that uses the PhoneCallTrap cordova plugin and a BroadcastReceiver to receive the incoming phone number when the phone is ringing.

# Compatibility
* Android
* ionic v1

# Documentation
* The project uses a <b>BroadcastReceiver</b> which has an onReceive method implemented. This method is called whenever the phone <b>changes call state</b>.
All the possible call states are: <b>IDLE, OFFHOOK, RINGING</b>.
* When the phone goes into RINGING state and thus the onReceive method is called, the onReceive method is sending the <b>incoming phone number</b> to the <b>CallStateListener</b>.
Simultaneously, the <b>CallStateListener</b> which is also triggered by the state change, sends the <b>incoming phone number</b> as PluginResult to the <b>PhoneCallTrap</b> cordova plugin.
* Eventually, <b>ionic</b> gets the call state of the phone as well as the <b>incoming phone number</b> (only if the state is RINGING) and prints them on the console.

# How-to integrate to any ionic v1 project
Run these commands inside the folder of your ionic project: <br>
<b>(if you already have cordova and android platform installed start from the 3rd command)</b>
* npm install -g cordova
* cordova platform add android

* cordova plugin add io.gvox.plugin.phonecalltrap

<br>Next:
* Replace the files in the folder "platforms\android\app\src\main\java\io\gvox\phonecalltrap" with the files that are in the phonecalltrap folder of this project
* Add the following code in "platforms\android\app\src\main\AndroidManifest.xml" inside the "application" xml section:
 ```
  <receiver android:enabled="true" android:exported="true" android:name="io.gvox.phonecalltrap.MyBroadcastReceiver">
            <intent-filter>
                <action android:name="android.intent.action.PHONE_STATE" />
            </intent-filter>
        </receiver>
  ```
 * Also add the following code in the same file as above inside the "manifest" xml section:
 ```
 <uses-permission android:name="android.permission.READ_PHONE_STATE" />
 <uses-permission android:name="android.permission.READ_CALL_LOG" />
 ```
