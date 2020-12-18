package com.babkamen.factory_method;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PersistedFileTest {

    @TempDir
    File tempDir;

    @Test
    void testPersistWithSha256() throws IOException {
        String filePath = tempDir.toPath() + "/test.txt";
        String content = "Hey!";

        PersistedFile persistedFile =
                new PersistedFile(filePath, content, new Sha256Encryptor());
        persistedFile.persist();

        String s = Files.readString(Path.of(filePath));
        assertEquals(DigestUtils.sha256Hex(content), s);
    }

    @Test
    void testPersistWithSha512() throws IOException {
        String filePath = tempDir.toPath() + "/test.txt";
        String content = "Hey!";

        PersistedFile persistedFile =
                new PersistedFile(filePath, content, new Sha512Encryptor());
        persistedFile.persist();

        String s = Files.readString(Path.of(filePath));
        assertEquals(DigestUtils.sha512Hex(content), s);
    }
}