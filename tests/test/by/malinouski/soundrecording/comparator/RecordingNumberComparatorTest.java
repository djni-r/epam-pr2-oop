package test.by.malinouski.soundrecording.comparator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import by.malinouski.soundrecording.comparator.RecordingDurationComparator;
import by.malinouski.soundrecording.entity.Recording;
import by.malinouski.soundrecording.musicenum.Style;

public class RecordingNumberComparatorTest {

    @Test
    public void compareTest() {
        Recording rec1 = new Recording("Hey", "St. Patrick", Style.ROCK, 345, 310, 1);
        Recording rec2 = new Recording("Lively shadows", "Gretta German", Style.JAZZ, 2345, 320, 2);
        
        RecordingDurationComparator compar = new RecordingDurationComparator();
        assertTrue("must be negative", compar.compare(rec1, rec2) < 0);
        assertTrue("must be positive", compar.compare(rec2, rec1) > 0);

    }
}
