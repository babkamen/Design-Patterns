package factory_method;

public class Sha512Encryptor extends Encryptor{

    @Override
    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return new Sha512EncryptionAlgorithm();
    }
}
