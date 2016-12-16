package test.by.makarymalinouski.epam.oop.soundrecording.action;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import by.makarymalinouski.epam.oop.soundrecording.action.RecordingsFinder;
import by.makarymalinouski.epam.oop.soundrecording.entity.Album;
import by.makarymalinouski.epam.oop.soundrecording.entity.Recording;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class recordingsFinderTest {

    @Test
    public void byDurationRangeTest() {
        Album album = new Album();
        SortedSet<Recording> recordings = new TreeSet<>();
        
        Recording rec1 = new Recording("Made my day", "Jill Sorry", Style.BLUES, 155);          // id 1
        Recording rec2 = new Recording("Something new", "Billy Storm", Style.ROCK, 210);        // id 2
        Recording rec3 = new Recording("Die darling", "Jim Scarecrow", Style.METAL, 205);       // id 3
        Recording rec4 = new Recording("To see the world", "Manz Dritter", Style.JAZZ, 421);    // id 4
        Recording rec5 = new Recording("Love me twice", "Sa-Sha", Style.POP, 329);              // id 5
        Recording rec6 = new Recording("Procrustes' bed", "Z-us", Style.ELECTRONIC, 312);       // id 6
        Recording rec7 = new Recording("Autumn Elegy", "Serge Simonoff", Style.CLASSICAL, 164); // id 7
        
        recordings.addAll(Arrays.asList(rec1, rec2, rec3, rec4, rec5, rec6, rec7));
        
        album.setRecordings(recordings);
        
        RecordingsFinder recFinder = new RecordingsFinder();
        Set<Recording> foundRecs = recFinder.byDurationRange(210, 329);
        
        assertEquals("must be of size", 3, foundRecs.size());
        assertTrue("must contain recording", foundRecs.contains(rec2));
        assertTrue("must contain recording", foundRecs.contains(rec5));
        assertTrue("must contain recording", foundRecs.contains(rec6));
        
    }
    
    @Test
    public void byDurationRangeTestOne() {
        Album album = new Album();
        SortedSet<Recording> recordings = new TreeSet<>();
        
        Recording rec1 = new Recording("Made my day", "Jill Sorry", Style.BLUES, 155); // id 1
        recordings.add(rec1);
        album.setRecordings(recordings);
        
        RecordingsFinder recFinder = new RecordingsFinder();
        Set<Recording> foundRecs = recFinder.byDurationRange(155, 155);
        
        assertEquals("must be of size 1", 1, foundRecs.size());
        assertTrue("must contain rec", foundRecs.contains(rec1));
    }

    
    @Test
    public void byDurationRangeTestNone() {
        Album album = new Album();
        SortedSet<Recording> recordings = new TreeSet<>();
        
        Recording rec1 = new Recording("Made my day", "Jill Sorry", Style.BLUES, 155);          // id 1
        Recording rec2 = new Recording("Something new", "Billy Storm", Style.ROCK, 210);        // id 2
        Recording rec3 = new Recording("Die darling", "Jim Scarecrow", Style.METAL, 205);       // id 3
        
        recordings.addAll(Arrays.asList(rec1, rec2, rec3));
        album.setRecordings(recordings);
        
        RecordingsFinder recFinder = new RecordingsFinder();
        Set<Recording> foundRecs = recFinder.byDurationRange(220, 329);
        
        assertTrue("must be empty", foundRecs.isEmpty());
    }

}
