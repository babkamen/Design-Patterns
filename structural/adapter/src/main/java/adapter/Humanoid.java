package adapter;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Humanoid implements Warrior {
    private int atkBase = 70;
    private Random m = new Random();
    private  final String name;
    @Override
    public int attack() {
        return atkBase + m.nextInt(30);
    }

    @Override
    public String getName() {
        return name;
    }
}
