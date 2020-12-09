package bridge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TV implements Device {

    private int channel = 0;
    private int volume = 100;
    private boolean enabled;
    private boolean muted;

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public boolean isMuted() {
        return this.muted;
    }

    @Override
    public void mute() {
        this.muted = true;
    }

    @Override
    public void unmute() {
        this.muted = false;
    }
}
