package by.malinouski.soundrecording.entity;

import by.malinouski.soundrecording.musicenum.Style;

public class Recording extends Composition {

    private int duration;
    private int number;
    
    public Recording(String name, String author, Style style, 
                     long id, int duration, int number) {
        super(name, author, style, id);
        this.duration = duration;
        this.number = number;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public long getNumber() {
        return number;
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
        
        Recording rec = (Recording) obj;
        if (this.getName() == rec.getName() &&
            this.getAuthor() == rec.getAuthor() &&
            this.getStyle() == rec.getStyle() && 
            this.duration == rec.duration && 
            this.number == rec.number) {
            
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + duration;
        result = 31 * result + number;
        
        return result;
    }
    
}
