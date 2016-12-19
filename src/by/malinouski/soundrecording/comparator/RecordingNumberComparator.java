package by.malinouski.soundrecording.comparator;

import java.util.Comparator;

import by.malinouski.soundrecording.entity.Recording;

public class RecordingNumberComparator implements Comparator<Recording> {

    @Override
    public int compare(Recording r1, Recording r2) {
        return Long.compare(r1.getNumber(), r2.getNumber());
    }

}
