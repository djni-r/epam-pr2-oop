package by.makarymalinouski.epam.oop.soundrecording.entity;

import by.makarymalinouski.epam.oop.soundrecording.musicenum.AnalogMedium;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class AnalogRecording extends Recording {

    private AnalogMedium medium;
    
    public AnalogRecording(String name, String author, Style style, int duration, AnalogMedium medium) {
        super(name, author, style, duration);
        this.medium = medium;
    }

    public AnalogMedium getMedium() {
        return medium;
    }
    
}
