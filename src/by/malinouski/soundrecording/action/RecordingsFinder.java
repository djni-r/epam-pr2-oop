package by.malinouski.soundrecording.action;

import java.util.Set;
import java.util.TreeSet;

import by.malinouski.soundrecording.comparator.RecordingDurationComparator;
import by.malinouski.soundrecording.entity.Album;
import by.malinouski.soundrecording.entity.Recording;

public class RecordingsFinder {

    public Set<Recording> byDurationRange(Album<Recording> album, int from, int to) {
        
        Set<Recording> result = new TreeSet<>(new RecordingDurationComparator()); 
        for (Recording rec : album.getRecordings()) {
            if (from <= rec.getDuration() && rec.getDuration() <= to) {
                result.add(rec);
            }
        }
        return result;
    }

}
