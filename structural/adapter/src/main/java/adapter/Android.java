package adapter;

public class Android {
    public int punch() {
        return 10;
    }

    public int kick() {
        return (int) (Math.random() * this.punch() * this.punch());
    }
}
