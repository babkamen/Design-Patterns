package abstract_factory;

public class ModernSofa implements Sofa {

    @Override
    public boolean hasLegs() {
        return false;
    }

    @Override
    public void lieOn() {
        System.out.println("Lying on modern sofa");
    }
}
