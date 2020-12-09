package factory_method;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Encryptor {

    void writeToDisk(final String plaintext, final String filePath) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.write(getEncryptionAlgorithm().encrypt(plaintext));
        }
    }

    abstract EncryptionAlgorithm getEncryptionAlgorithm();
}