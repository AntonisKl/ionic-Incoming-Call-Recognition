cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
  {
    "id": "io.gvox.plugin.phonecalltrap.PhoneCallTrap",
    "file": "plugins/io.gvox.plugin.phonecalltrap/www/PhoneCallTrap.js",
    "pluginId": "io.gvox.plugin.phonecalltrap",
    "clobbers": [
      "window.PhoneCallTrap"
    ]
  },
  {
    "id": "cordova-plugin-statusbar.statusbar",
    "file": "plugins/cordova-plugin-statusbar/www/statusbar.js",
    "pluginId": "cordova-plugin-statusbar",
    "clobbers": [
      "window.StatusBar"
    ]
  },
  {
    "id": "cordova-plugin-device.device",
    "file": "plugins/cordova-plugin-device/www/device.js",
    "pluginId": "cordova-plugin-device",
    "clobbers": [
      "device"
    ]
  },
  {
    "id": "cordova-plugin-splashscreen.SplashScreen",
    "file": "plugins/cordova-plugin-splashscreen/www/splashscreen.js",
    "pluginId": "cordova-plugin-splashscreen",
    "clobbers": [
      "navigator.splashscreen"
    ]
  },
  {
    "id": "cordova-plugin-ionic-webview.IonicWebView",
    "file": "plugins/cordova-plugin-ionic-webview/src/www/util.js",
    "pluginId": "cordova-plugin-ionic-webview",
    "clobbers": [
      "Ionic.WebView"
    ]
  },
  {
    "id": "cordova-plugin-ionic-keyboard.keyboard",
    "file": "plugins/cordova-plugin-ionic-keyboard/www/android/keyboard.js",
    "pluginId": "cordova-plugin-ionic-keyboard",
    "clobbers": [
      "window.Keyboard"
    ]
  }
];
module.exports.metadata = 
// TOP OF METADATA
{
  "io.gvox.plugin.phonecalltrap": "0.1.2",
  "cordova-plugin-whitelist": "1.3.3",
  "cordova-plugin-statusbar": "2.4.2",
  "cordova-plugin-device": "2.0.2",
  "cordova-plugin-splashscreen": "5.0.2",
  "cordova-plugin-ionic-webview": "2.1.3",
  "cordova-plugin-ionic-keyboard": "2.1.2"
};
// BOTTOM OF METADATA
});