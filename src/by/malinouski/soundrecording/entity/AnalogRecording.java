package by.malinouski.soundrecording.entity;

import by.malinouski.soundrecording.musicenum.AnalogMedium;
import by.malinouski.soundrecording.musicenum.Style;

public class AnalogRecording extends Recording {

    private AnalogMedium medium;
    
    public AnalogRecording(String name, String author, Style style, 
            long id, int duration, int number, AnalogMedium medium) {
        super(name, author, style, id, duration, number);
        this.medium = medium;
    }

    public AnalogMedium getMedium() {
        return medium;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (!obj.getClass().equals(this.getClass())) {
            return false;
        } 
        
        AnalogRecording rec = (AnalogRecording) obj;
        if (this.getName() == rec.getName() &&
            this.getAuthor() == rec.getAuthor() &&
            this.getStyle() == rec.getStyle() &&
            this.getCompositionId() == rec.getCompositionId() &&
            this.getNumber() == rec.getNumber() &&
            this.getDuration() == rec.getDuration() &&
            this.getMedium() == rec.getMedium()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + medium.hashCode();
        
        return result;
    }
        
}
