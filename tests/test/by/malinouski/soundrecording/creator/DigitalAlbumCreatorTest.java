package test.by.malinouski.soundrecording.creator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.malinouski.soundrecording.creator.DigitalAlbumCreator;
import by.malinouski.soundrecording.entity.Album;
import by.malinouski.soundrecording.entity.DigitalRecording;
import by.malinouski.soundrecording.musicenum.Compression;
import by.malinouski.soundrecording.musicenum.Style;

public class DigitalAlbumCreatorTest {

    @Test
    public void createAlbumFromDataTestEmpty() {
        
        DigitalAlbumCreator creator = new DigitalAlbumCreator(Compression.AAC);
        Album<DigitalRecording> album = creator.createAlbumFromData(Collections.emptyList());
        
        assertTrue("must be empty", album.getRecordings().isEmpty());
        
    }
    
    @Test
    public void createAlbumFromDataTest() {
        DigitalRecording recording = new DigitalRecording(
                "Story of my life", "Stan Gray", Style.JAZZ, 235, 250, 1, Compression.AAC);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jazz");
        recInfo.put("id", "235");
        recInfo.put("duration", "250");
        recInfo.put("number", "1");
        recInfo.put("compression", "AAC");
        
        
        DigitalAlbumCreator creator = new DigitalAlbumCreator(Compression.AAC);
        Album<DigitalRecording> album = creator.createAlbumFromData(Arrays.asList(recInfo));
        
        assertTrue("must contain recording", album.getRecordings().contains(recording));
        
    }
    
    @Test
    public void createAlbumFromDataTestSkipRecording() {
        DigitalRecording recording = new DigitalRecording(
                "Story of my life", "Stan Gray", Style.JAZZ, 235, 250, 1, Compression.AAC);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jazz");
        recInfo.put("id", "235");
        recInfo.put("duration", "250");
        recInfo.put("number", "1");
        recInfo.put("compression", "AAC");
        
        Map<String, String> recInfo2 = new HashMap<>();
        recInfo2.put("name", "Something new");
        recInfo2.put("author", "Billy Storm");
        recInfo2.put("style", "ROCK");
        recInfo2.put("id", "234534");
        recInfo2.put("duration", "21asdf0"); // mistake here
        recInfo2.put("number", "2");
        recInfo2.put("compression", "aac");
        
        
        DigitalAlbumCreator creator = new DigitalAlbumCreator(Compression.AAC);
        Album<DigitalRecording> album = creator.createAlbumFromData(Arrays.asList(recInfo2, recInfo));
        
        assertEquals("must contain only 1 recording", album.getRecordings().size(), 1);
        assertTrue("must contain recording 1", album.getRecordings().contains(recording));
        
    }

}
