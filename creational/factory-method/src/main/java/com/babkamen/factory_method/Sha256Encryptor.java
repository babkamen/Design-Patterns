package com.babkamen.factory_method;

public class Sha256Encryptor implements Encryptor {

    @Override
    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return new Sha256EncryptionAlgorithm();
    }
}
