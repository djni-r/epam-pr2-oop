package test.by.malinouski.soundrecording.factory;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.malinouski.soundrecording.entity.AnalogRecording;
import by.malinouski.soundrecording.exception.RecordingInitializationException;
import by.malinouski.soundrecording.factory.AnalogRecordingFactory;
import by.malinouski.soundrecording.musicenum.AnalogMedium;
import by.malinouski.soundrecording.musicenum.Style;

public class AnalogRecordingFactoryTest {

    @Test
    public void createInstanceTest() throws RecordingInitializationException {
        AnalogRecordingFactory factory = new AnalogRecordingFactory(AnalogMedium.TAPE);
        AnalogRecording recording1 = new AnalogRecording(
                "Story of my life", "Stan Gray", Style.JAZZ, 2345, 250, 1, AnalogMedium.TAPE);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jazz");
        recInfo.put("id", "2345");
        recInfo.put("duration", "250");
        recInfo.put("number", "1");
        recInfo.put("medium", "tape");

        AnalogRecording recording2 = factory.createInstance(recInfo);
        
        assertEquals("must be the same recording", recording1, recording2);
        
    }
    
    @Test (expected = RecordingInitializationException.class)
    public void createInstanceTestException() throws RecordingInitializationException {
        AnalogRecordingFactory factory = new AnalogRecordingFactory(AnalogMedium.TAPE);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jaz"); // here
        recInfo.put("id", "2345");
        recInfo.put("duration", "250");
        recInfo.put("number", "1");
        recInfo.put("medium", "tape");

        factory.createInstance(recInfo);
        
    }
}
