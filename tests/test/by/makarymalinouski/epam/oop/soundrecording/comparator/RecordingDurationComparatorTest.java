package test.by.makarymalinouski.epam.oop.soundrecording.comparator;

import static org.junit.Assert.*;

import org.junit.Test;

import by.makarymalinouski.epam.oop.soundrecording.comparator.RecordingDurationComparator;
import by.makarymalinouski.epam.oop.soundrecording.entity.Recording;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class RecordingDurationComparatorTest {

    @Test
    public void compareTest() {
        Recording rec1 = new Recording("Hey", "St. Patrick", Style.ROCK, 310);
        Recording rec2 = new Recording("Lively shadows", "Gretta German", Style.JAZZ, 120);
        
        RecordingDurationComparator compar = new RecordingDurationComparator();
        assertTrue("must be positive", compar.compare(rec1, rec2) > 0);
        assertTrue("must be negative", compar.compare(rec2, rec1) < 0);

    }
    
    @Test
    public void compareTestEquals() {
        Recording rec1 = new Recording("Hey", "St. Patrick", Style.ROCK, 310);
        Recording rec2 = new Recording("Hey", "St. Patrick", Style.ROCK, 310);

        RecordingDurationComparator compar = new RecordingDurationComparator();
        assertEquals("must be zero", 0, compar.compare(rec1, rec2));
        assertEquals("must be zero", 0, compar.compare(rec2, rec1));
    }

}
