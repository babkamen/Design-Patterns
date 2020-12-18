package com.babkamen.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EncryptionDecoratorTest {

    @TempDir
    Path tempDir;

    @Test
    void testEncryptionDecorator() {
        String data = "Hello,world!";
        Charset charset = Charset.defaultCharset();
        byte[] s = data.getBytes(charset);
        String filePath = tempDir.toString() + "/test.txt";
        FileDataSource fileDataSource = new FileDataSource(filePath);
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(fileDataSource);

        encryptionDecorator.writeData(s);

        assertNotEquals(data, new String(fileDataSource.readData(), charset));
        assertEquals(data, new String(encryptionDecorator.readData(), charset));
    }


    @Test
    void testCompressionDecorator() {
        String data = "Hello,world!Hello,world!";
        Charset charset = StandardCharsets.UTF_8;
        byte[] s = data.getBytes(charset);
        String filePath = tempDir + "/test.txt";
        FileDataSource fileDataSource = new FileDataSource(filePath);
        CompressionDataSourceDecorator encryptionDecorator = new CompressionDataSourceDecorator(fileDataSource);

        encryptionDecorator.writeData(s);

        assertNotEquals(data, new String(fileDataSource.readData(), charset));
        assertEquals(data, new String(encryptionDecorator.readData()));
    }
}