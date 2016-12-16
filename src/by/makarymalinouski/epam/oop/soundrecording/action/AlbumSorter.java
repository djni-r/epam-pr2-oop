package by.makarymalinouski.epam.oop.soundrecording.action;

import by.makarymalinouski.epam.oop.soundrecording.entity.Album;
import by.makarymalinouski.epam.oop.soundrecording.entity.Recording;

import java.util.SortedSet;
import java.util.TreeSet;

import by.makarymalinouski.epam.oop.soundrecording.comparator.CompositionComparator;


public class AlbumSorter {

    public AlbumSorter() {
        // TODO Auto-generated constructor stub
    }
    
    public void byStyle(Album album) {
        SortedSet<Recording> recordings = new TreeSet<>(new CompositionComparator());
    }

}
