package by.malinouski.soundrecording.entity;

import by.malinouski.soundrecording.musicenum.Compression;
import by.malinouski.soundrecording.musicenum.Style;

public class DigitalRecording extends Recording {

    private Compression compression;

    public DigitalRecording(String name, String author, Style style, 
            long id, int duration, int number, Compression compression) {
        super(name, author, style, id, duration, number);
        this.compression = compression;
    }
    
    public Compression getCompression() {
        return compression;
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
        
        DigitalRecording rec = (DigitalRecording) obj;
        if (this.getName() == rec.getName() &&
            this.getAuthor() == rec.getAuthor() &&
            this.getStyle() == rec.getStyle() &&
            this.getCompositionId() == rec.getCompositionId() &&
            this.getDuration() == rec.getDuration() &&
            this.getNumber() == rec.getNumber() &&
            this.getCompression() == rec.getCompression()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + compression.hashCode();
        
        return result;
    }
}
