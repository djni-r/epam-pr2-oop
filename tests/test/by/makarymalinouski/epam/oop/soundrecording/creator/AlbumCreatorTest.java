package test.by.makarymalinouski.epam.oop.soundrecording.creator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.makarymalinouski.epam.oop.soundrecording.creator.AlbumCreator;
import by.makarymalinouski.epam.oop.soundrecording.entity.Album;
import by.makarymalinouski.epam.oop.soundrecording.entity.DigitalRecording;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Compression;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class AlbumCreatorTest {

    @Test
    public void createAlbumFromDataTest() {
        DigitalRecording recording = new DigitalRecording("Story of my life", "Stan Gray", Style.JAZZ, 250, Compression.AAC);
        
        Map<String, String> recInfo = new HashMap<>();
        recInfo.put("name", "Story of my life");
        recInfo.put("author", "Stan Gray");
        recInfo.put("style", "jazz");
        recInfo.put("duration", "250");
        recInfo.put("compression", "aac");
        
        AlbumCreator creator = new AlbumCreator(Compression.AAC);
        Album album = creator.createAlbumFromData(Arrays.asList(recInfo));
        
        album.getRecordings().contains(recording);
        
        
    }

}
