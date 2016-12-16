package test.by.makarymalinouski.epam.oop.soundrecording.comparator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import by.makarymalinouski.epam.oop.soundrecording.comparator.RecordingDurationComparator;
import by.makarymalinouski.epam.oop.soundrecording.entity.Recording;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class RecordingIdComparatorTest {

    @Test
    public void compareTest() {
        Recording rec1 = new Recording("Hey", "St. Patrick", Style.ROCK, 310); // id 1
        Recording rec2 = new Recording("Lively shadows", "Gretta German", Style.JAZZ, 320); // id 2
        
        RecordingDurationComparator compar = new RecordingDurationComparator();
        assertTrue("must be negative", compar.compare(rec1, rec2) < 0);
        assertTrue("must be positive", compar.compare(rec2, rec1) > 0);

    }
}
