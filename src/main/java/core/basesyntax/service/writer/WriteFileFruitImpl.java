package core.basesyntax.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileFruitImpl implements WriteFileFruit {
    @Override
    public void writeAll(String string, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(string);
        } catch (IOException e) {
            System.out.println("error: file not found." + e);
        }
    }
}
