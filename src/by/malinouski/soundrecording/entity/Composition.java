package by.malinouski.soundrecording.entity;

import by.malinouski.soundrecording.musicenum.Style;

public class Composition {
    private String name;
    private String author;
    private Style style;
    private long compositionId;
    
    public Composition(String name, String author, Style style, long compositionId) {
        this.name = name;
        this.author = author;
        this.style = style;
        this.compositionId = compositionId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Style getStyle() {
        return style;
    }
    
    public long getCompositionId() {
        return compositionId;
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
        
        Composition rec = (Composition) obj;
        if (name == rec.getName() &&
            author == rec.getAuthor() &&
            style == rec.getStyle()) {                
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + style.hashCode();
        result = 31 * result + (int) (compositionId ^ (compositionId >>> 32));
        
        return result;
    }
}
