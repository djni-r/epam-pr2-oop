package by.malinouski.soundrecording.comparator;

import java.util.Comparator;

import by.malinouski.soundrecording.entity.Recording;

public class RecordingDurationComparator implements Comparator<Recording> {

    @Override
    public int compare(Recording r1, Recording r2) {
        return Integer.compare(r1.getDuration(), r2.getDuration());
    }

}
