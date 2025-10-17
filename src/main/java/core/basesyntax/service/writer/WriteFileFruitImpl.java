package core.basesyntax.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileFruitImpl implements WriteFileFruit {
    @Override
    public void writeAll(String string, String path) {
        if (string == null || string.isBlank()) {
            throw new RuntimeException("Output content must not be null");
        }
        if (path == null || path.isBlank()) {
            throw new RuntimeException("Path file must not be null");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(string);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + path, e);
        }
    }
}
