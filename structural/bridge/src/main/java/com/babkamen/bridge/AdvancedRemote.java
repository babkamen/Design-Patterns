package com.babkamen.bridge;

public class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void toggleMute() {
        if (device.isMuted()) {
            device.unmute();
        } else {
            device.mute();
        }
    }

}
