package test.by.malinouski.soundrecording.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import by.malinouski.soundrecording.action.AlbumSorter;
import by.malinouski.soundrecording.comparator.RecordingNumberComparator;
import by.malinouski.soundrecording.entity.Album;
import by.malinouski.soundrecording.entity.Recording;
import by.malinouski.soundrecording.musicenum.Style;

public class AlbumSorterTest {
    
    @Test
    public void byStyleTestEmpty() {
        Album<Recording> album = new Album<>();
        SortedSet<Recording> recordings = new TreeSet<>(new RecordingNumberComparator());
        album.setRecordings(recordings);
        AlbumSorter sorter = new AlbumSorter();
        sorter.byStyle(album);
        assertTrue(album.getRecordings().isEmpty());

    }

    @Test
    public void byStyleTest() {
        Album<Recording> album = new Album<Recording>();
        SortedSet<Recording> recordings = new TreeSet<>(new RecordingNumberComparator());
        recordings.addAll(Arrays.asList(
                    new Recording("Made my day", "Jill Sorry", Style.BLUES, 112340, 155, 1),           
                    new Recording("Something new", "Billy Storm", Style.ROCK, 234534, 210, 2),        
                    new Recording("Die darling", "Jim Scarecrow", Style.METAL, 345235, 205, 3),        
                    new Recording("To see the world", "Manz Dritter", Style.JAZZ, 436345, 421, 4),     
                    new Recording("Love me twice", "Sa-Sha", Style.POP, 34574537, 532900, 5),               
                    new Recording("Procrustes' bed", "Z-us", Style.ELECTRONIC, 645734, 312, 6),        
                    new Recording("Autumn Elegy", "Serge Simonoff", Style.CLASSICAL, 745645, 164, 7)
                ));
        album.setRecordings(recordings);
        
        // re-sort alphabetically by style 
        AlbumSorter sorter = new AlbumSorter();
        sorter.byStyle(album);
        Iterator<Recording> iter = album.getRecordings().iterator();
        
        // has to be in this order: BLUES, CLASSICAL, ELECTRONIC, JAZZ, METAL, POP, ROCK
        assertEquals("album's size", 7, album.getRecordings().size());
        assertEquals("album's first element id", 1, iter.next().getNumber());
        assertEquals("album's second element id", 7, iter.next().getNumber());
        assertEquals("album's third element id", 6, iter.next().getNumber());
        assertEquals("album's fourth element id", 4, iter.next().getNumber());
        assertEquals("album's fifth element id", 3, iter.next().getNumber());
        assertEquals("album's sixth element id", 5, iter.next().getNumber());
        assertEquals("album's seventh element id", 2, iter.next().getNumber());
    }
    
    @Test
    public void byStyleTestSameStyleCase() {
        Album<Recording> album = new Album<Recording>();
        SortedSet<Recording> recordings = new TreeSet<>(new RecordingNumberComparator());
        recordings.addAll(Arrays.asList(
                    new Recording("Die darling", "Jim Scarecrow", Style.METAL, 152463456, 205, 1),        
                    new Recording("To see the world", "Manz Dritter", Style.JAZZ, 234564599, 421, 2),     
                    new Recording("Dirty road", "Razor Blade", Style.METAL, 313451344, 329, 3),           
                    new Recording("I never lived", "Shadows", Style.METAL, 413634644, 164, 4)             
                ));
        album.setRecordings(recordings);
        AlbumSorter sorter = new AlbumSorter();
        sorter.byStyle(album);
        Iterator<Recording> iter = album.getRecordings().iterator();
        
        assertEquals("album's first element id", 2, iter.next().getNumber());
        assertEquals("album's second element id", 1, iter.next().getNumber());
        assertEquals("album's third element id", 3, iter.next().getNumber());
        assertEquals("album's fourth element id", 4, iter.next().getNumber());
    }

    
}