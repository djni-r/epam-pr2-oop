package by.malinouski.soundrecording.entity;

import java.util.Collections;
import java.util.SortedSet;

public class Album<T extends Recording> {

    private SortedSet<T> recordings;
    
    public SortedSet<T> getRecordings() {
        return Collections.unmodifiableSortedSet(recordings);
    }
    
    public void setRecordings(SortedSet<T> recordings) {
        this.recordings = recordings;
    }
}
