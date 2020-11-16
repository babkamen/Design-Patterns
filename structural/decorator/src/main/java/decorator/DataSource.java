package decorator;

public interface DataSource {
    void writeData(byte[] data);

    byte[] readData();
}
