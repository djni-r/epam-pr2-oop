package test.by.makarymalinouski.epam.oop.soundrecording.reader;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.makarymalinouski.epam.oop.soundrecording.reader.RecordingDataReader;

public class RecordingDataReaderTest {

    @Test
    public void readDataTest() {
        String fileName = "files/data.txt";
        
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "Made my day");
        map1.put("author", "Jill Sorry");
        map1.put("style", "blues");
        map1.put("duration", "155");
        
        Collection<Map<String, String>> maps = Arrays.asList(map1);
        
        RecordingDataReader reader = new RecordingDataReader();
        Collection<Map<String, String>> recordingsInfo = reader.readData(fileName);
        
        assertEquals("collections must be equal", maps, recordingsInfo);
    }

}
