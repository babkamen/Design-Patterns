package adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AndroidAdapter implements Warrior {

    public static final String ANDROID_NAME = "Terminator";
    private final Android android;
    private double chanceToKick = 0.5;

    @Override
    public int attack() {
        if (Math.random() >= chanceToKick) {
            return android.kick();
        }
        return android.punch();
    }

    @Override
    public String getName() {
        return ANDROID_NAME;
    }
}
