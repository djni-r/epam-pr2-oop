package by.malinouski.soundrecording.action;

import by.malinouski.soundrecording.comparator.CompositionComparator;
import by.malinouski.soundrecording.entity.Album;
import by.malinouski.soundrecording.entity.Recording;

import java.util.SortedSet;
import java.util.TreeSet;


public class AlbumSorter {

    public void byStyle(Album<Recording> album) {
        SortedSet<Recording> recordings = new TreeSet<>(new CompositionComparator());
        recordings.addAll(album.getRecordings());
        album.setRecordings(recordings);
    }
    
}
