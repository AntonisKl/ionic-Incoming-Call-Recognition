// import PhoneCallTrap from 'plugins/io.gvox.plugin.phonecalltrap/www/PhoneCallTrap';

PhoneCallTrap.onCall(function(state) {
    console.log("CHANGE STATE: " + state);

    switch (state) {
        case "RINGING":
            console.log("Phone is ringing");
            break;
        case "OFFHOOK":
            console.log("Phone is off-hook");
            break;

        case "IDLE":
            console.log("Phone is idle");
            break;
    }
});
