package bridge;

public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int volume);

    int getChannel();

    void setChannel(int channel);

    boolean isMuted();

    void mute();

    void unmute();
}
