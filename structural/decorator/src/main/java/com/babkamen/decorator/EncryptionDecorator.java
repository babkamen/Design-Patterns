package com.babkamen.decorator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class EncryptionDecorator extends DelegationDataSourceDecorator {

    public static final String RSA_TYPE = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public EncryptionDecorator(DataSource delegate) {
        super(delegate);
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair pair = keyPairGen.generateKeyPair();
            this.encryptCipher = Cipher.getInstance(RSA_TYPE);
            this.encryptCipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
            this.decryptCipher = Cipher.getInstance(RSA_TYPE);
            this.decryptCipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeData(byte[] data) {
        try {
            super.writeData(encrypt(data));
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] readData() {
        byte[] data = super.readData();
        try {
            return decrypt(data);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    private byte[] decrypt(byte[] data) throws BadPaddingException, IllegalBlockSizeException {
        return process(decryptCipher, data);
    }

    private byte[] encrypt(byte[] data) throws BadPaddingException, IllegalBlockSizeException {
        return process(encryptCipher, data);
    }

    private byte[] process(Cipher cipher, byte[] data) throws BadPaddingException, IllegalBlockSizeException {
        cipher.update(data);
        return cipher.doFinal();
    }
}
