package by.makarymalinouski.epam.oop.soundrecording.entity;

import by.makarymalinouski.epam.oop.soundrecording.musicenum.Compression;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class DigitalRecording extends Recording {

    private Compression compression;

    public DigitalRecording(String name, String author, Style style, int duration, Compression compression) {
        super(name, author, style, duration);
        this.compression = compression;
    }
    
    public Compression getCompression() {
        return compression;
    }
}
