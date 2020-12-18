package com.babkamen.bridge;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Remote {

    private static final int VOLUME_STEP = 5;
    protected Device device;

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void channelDown() {
        int channel = device.getChannel();
        if (channel > 0) {
            device.setChannel(channel + 1);
        }
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    public void volumeUp() {
        int volume = device.getVolume();
        if (volume < 100) {
            device.setVolume(volume + VOLUME_STEP);
        }
    }

    public void volumeDown() {
        int volume = device.getVolume();
        if (volume > 0) {
            device.setVolume(volume - VOLUME_STEP);
        }
    }
}
