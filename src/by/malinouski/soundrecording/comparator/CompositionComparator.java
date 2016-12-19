package by.malinouski.soundrecording.comparator;

import java.util.Comparator;

import by.malinouski.soundrecording.entity.Composition;

public class CompositionComparator implements Comparator<Composition> {

    @Override
    public int compare(Composition c1, Composition c2) {
        
        int result = String.valueOf(c1.getStyle()).compareToIgnoreCase(String.valueOf(c2.getStyle()));
        
        if (result == 0) {
            result = Long.compare(c1.getCompositionId(), c2.getCompositionId());
        }
        
        return result;
    }

}
