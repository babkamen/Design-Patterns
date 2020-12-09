package decorator;

public class InMemoryDataSourceDecorator implements DataSource {

    private byte[] dataSource;

    @Override
    public void writeData(byte[] data) {
        dataSource = data;
    }

    @Override
    public byte[] readData() {
        return dataSource;
    }
}
