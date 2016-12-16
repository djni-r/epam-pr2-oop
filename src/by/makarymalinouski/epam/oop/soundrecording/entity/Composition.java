package by.makarymalinouski.epam.oop.soundrecording.entity;

import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class Composition {
    private String name;
    private String author;
    private Style style;
    
    public Composition(String name, String author, Style style) {
        this.name = name;
        this.author = author;
        this.style = style;
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
}
