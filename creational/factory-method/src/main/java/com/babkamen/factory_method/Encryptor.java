package com.babkamen.factory_method;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface Encryptor {

    default void writeToDisk(final String plaintext, final String filePath) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.write(getEncryptionAlgorithm().encrypt(plaintext));
        }
    }

    EncryptionAlgorithm getEncryptionAlgorithm();
}