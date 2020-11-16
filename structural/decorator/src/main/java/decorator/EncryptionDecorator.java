package decorator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class EncryptionDecorator extends DelegationDataSourceDecorator {
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public EncryptionDecorator(DataSource delegate) {
        super(delegate);
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair pair = keyPairGen.generateKeyPair();
            this.encryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            this.encryptCipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
            this.decryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
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
        return null;
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
