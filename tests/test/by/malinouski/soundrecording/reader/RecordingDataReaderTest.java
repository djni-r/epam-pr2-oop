package test.by.malinouski.soundrecording.reader;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.malinouski.soundrecording.reader.RecordingDataReader;

public class RecordingDataReaderTest {

    @Test
    public void readJsonDataTest() {
        // file contains track that must be skipped
        String fileName = "files/data.txt";
        
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "Made my day");
        map1.put("author", "Jill Sorry");
        map1.put("style", "BLUES");
        map1.put("id", "112340");
        map1.put("duration", "155");
        map1.put("number", "1");
        map1.put("compression", "aac");

        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "Something new");
        map2.put("author", "Billy Storm");
        map2.put("style", "ROCK");
        map2.put("id", "234534");
        map2.put("duration", "210");
        map2.put("number", "2");
        map2.put("compression", "aac");

        
        Collection<Map<String, String>> maps = Arrays.asList(map1, map2);
        
        RecordingDataReader reader = new RecordingDataReader();
        Collection<Map<String, String>> recordingsInfo = reader.readJsonData(fileName);
        
        assertEquals("collections must be equal", maps, recordingsInfo);
    }

    @Test
    public void readJsonDataTestEmpty() throws IOException {

        RecordingDataReader reader = new RecordingDataReader();
        Collection<Map<String, String>> recordingsInfo = reader.readJsonData(Files.createTempFile("file", ".tmp").toString());
        
        assertTrue("must be empty", recordingsInfo.isEmpty());
        
    }
}
