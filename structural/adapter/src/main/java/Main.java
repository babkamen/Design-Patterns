import adapter.*;

public class Main {
    public static void main(String[] args) {
        Humanoid humanoid = new Humanoid("Sky Walker");
        Pokemon pokemon=new Pokemon("Squirtle");
        Android android=new Android();
        Tournament tournament=new Tournament();
        tournament.add(humanoid);
        tournament.add(pokemon);
        tournament.add(new AndroidAdapter(android));
        for (int i = 0; i < 5; i++) {
            tournament.fight();
        }
    }
}
