package by.makarymalinouski.epam.oop.soundrecording.entity;

import java.util.Collections;
import java.util.SortedSet;

public class Album {

    private SortedSet<Recording> recordings;
    
    public Album() {
        // TODO Auto-generated constructor stub
    }
    
    public SortedSet<Recording> getRecordings() {
        return Collections.unmodifiableSortedSet(recordings);
    }
    
    public void setRecordings(SortedSet<Recording> recordings) {
        this.recordings = recordings;
    }

}
