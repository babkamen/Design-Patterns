package factory_method;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;

@AllArgsConstructor
public class PersistedFile {
    private final String path;
    private final String contents;
    private final Encryptor encryptor;
    
    public void persist() throws FileNotFoundException {
        encryptor.writeToDisk(contents, path);
    }

}
