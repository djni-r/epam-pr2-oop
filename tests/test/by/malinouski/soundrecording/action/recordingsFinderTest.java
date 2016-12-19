package test.by.malinouski.soundrecording.action;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import by.malinouski.soundrecording.action.RecordingsFinder;
import by.malinouski.soundrecording.comparator.RecordingNumberComparator;
import by.malinouski.soundrecording.entity.Album;
import by.malinouski.soundrecording.entity.Recording;
import by.malinouski.soundrecording.musicenum.Style;

public class recordingsFinderTest {

    @Test
    public void byDurationRangeTest() {
        Album<Recording> album = new Album<>();
        SortedSet<Recording> recordings = new TreeSet<>(new RecordingNumberComparator());
        
        Recording rec1 = new Recording("Made my day", "Jill Sorry", Style.BLUES, 1345324, 155, 1);          // id 1
        Recording rec2 = new Recording("Something new", "Billy Storm", Style.ROCK, 234523, 210, 2);        // id 2
        Recording rec3 = new Recording("Die darling", "Jim Scarecrow", Style.METAL, 34353, 205, 3);       // id 3
        Recording rec4 = new Recording("To see the world", "Manz Dritter", Style.JAZZ, 45435346, 421, 4);    // id 4
        Recording rec5 = new Recording("Love me twice", "Sa-Sha", Style.POP, 523453245, 329, 5);              // id 5
        Recording rec6 = new Recording("Procrustes' bed", "Z-us", Style.ELECTRONIC, 62345234, 312, 6);       // id 6
        Recording rec7 = new Recording("Autumn Elegy", "Serge Simonoff", Style.CLASSICAL, 72345345, 164, 7); // id 7
        
        recordings.addAll(Arrays.asList(rec1, rec2, rec3, rec4, rec5, rec6, rec7));
        
        album.setRecordings(recordings);
        
        RecordingsFinder recFinder = new RecordingsFinder();
        Set<Recording> foundRecs = recFinder.byDurationRange(album, 210, 329);
        
        assertEquals("must be of size", 3, foundRecs.size());
        assertTrue("must contain rec2", foundRecs.contains(rec2));
        assertTrue("must contain rec5", foundRecs.contains(rec5));
        assertTrue("must contain rec6", foundRecs.contains(rec6));
        
    }
    
    @Test
    public void byDurationRangeTestOne() {
        Album<Recording> album = new Album<>();
        SortedSet<Recording> recordings = new TreeSet<>(new RecordingNumberComparator());
        
        Recording rec1 = new Recording("Made my day", "Jill Sorry", Style.BLUES, 1351345, 155, 1); // id 1
        recordings.add(rec1);
        album.setRecordings(recordings);
        
        RecordingsFinder recFinder = new RecordingsFinder();
        Set<Recording> foundRecs = recFinder.byDurationRange(album, 155, 155);
        
        assertEquals("must be of size 1", 1, foundRecs.size());
        assertTrue("must contain rec", foundRecs.contains(rec1));
    }

    
    @Test
    public void byDurationRangeTestNone() {
        Album<Recording> album = new Album<>();
        SortedSet<Recording> recordings = new TreeSet<>(new RecordingNumberComparator());
        
        Recording rec1 = new Recording("Made my day", "Jill Sorry", Style.BLUES, 134531, 155, 1);          // id 1
        Recording rec2 = new Recording("Something new", "Billy Storm", Style.ROCK, 2345, 210, 2);        // id 2
        Recording rec3 = new Recording("Die darling", "Jim Scarecrow", Style.METAL, 324532, 205, 3);       // id 3
        
        recordings.addAll(Arrays.asList(rec1, rec2, rec3));
        album.setRecordings(recordings);
        
        RecordingsFinder recFinder = new RecordingsFinder();
        Set<Recording> foundRecs = recFinder.byDurationRange(album, 220, 329);
        
        assertTrue("must be empty", foundRecs.isEmpty());
    }

}
