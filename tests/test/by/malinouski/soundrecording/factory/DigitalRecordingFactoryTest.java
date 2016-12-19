package test.by.malinouski.soundrecording.factory;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.malinouski.soundrecording.entity.DigitalRecording;
import by.malinouski.soundrecording.exception.RecordingInitializationException;
import by.malinouski.soundrecording.factory.DigitalRecordingFactory;
import by.malinouski.soundrecording.musicenum.Compression;
import by.malinouski.soundrecording.musicenum.Style;

public class DigitalRecordingFactoryTest {

    @Test
    public void createInstanceTest() throws RecordingInitializationException {
        DigitalRecordingFactory factory = new DigitalRecordingFactory(Compression.WMA);
        DigitalRecording recording1 = new DigitalRecording("Story of my life", 
                "Stan Gray", Style.JAZZ, 2345, 250, 1, Compression.WMA);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jazz");
        recInfo.put("id", "2345");
        recInfo.put("duration", "250");
        recInfo.put("number", "1");
        recInfo.put("compression", "aac");

        DigitalRecording recording2 = factory.createInstance(recInfo);
        
        assertEquals("must be the same recording", recording1, recording2);
        
    }
    
    @Test (expected = RecordingInitializationException.class)
    public void createInstanceTestException() throws RecordingInitializationException {
        DigitalRecordingFactory factory = new DigitalRecordingFactory(Compression.WMA);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jazz");
        recInfo.put("id", "234af45");       // here 
        recInfo.put("duration", "250");
        recInfo.put("number", "1");
        recInfo.put("compression", "aac");

        factory.createInstance(recInfo);
    }

}
