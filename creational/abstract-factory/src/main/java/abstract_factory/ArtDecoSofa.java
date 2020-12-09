package abstract_factory;

public class ArtDecoSofa implements Sofa {

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void lieOn() {
        System.out.println("Lying on art deco sofa");
    }
}
