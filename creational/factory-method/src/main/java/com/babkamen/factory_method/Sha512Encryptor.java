package com.babkamen.factory_method;

public class Sha512Encryptor implements Encryptor {

    @Override
    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return new Sha512EncryptionAlgorithm();
    }
}
