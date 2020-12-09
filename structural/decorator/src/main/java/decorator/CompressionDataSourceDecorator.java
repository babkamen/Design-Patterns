package decorator;

import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionDataSourceDecorator extends DelegationDataSourceDecorator {

    private final Deflater compresser = new Deflater();
    private final Inflater decompresser = new Inflater();
    private int dataLength;

    public CompressionDataSourceDecorator(final DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(byte[] data) {
        this.dataLength = data.length;
        byte[] output = new byte[data.length];
        compresser.setInput(data);
        compresser.finish();
        compresser.deflate(output);
        super.writeData(output);
    }

    @Override
    public byte[] readData() {
        byte[] bytes = super.readData();
        try {
            decompresser.setInput(bytes);
            byte[] buffer = new byte[dataLength];
            decompresser.inflate(buffer);
            decompresser.end();
            return buffer;
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
