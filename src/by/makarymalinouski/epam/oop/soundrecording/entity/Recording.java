package by.makarymalinouski.epam.oop.soundrecording.entity;

import by.makarymalinouski.epam.oop.soundrecording.musicenum.Style;

public class Recording extends Composition {

    private int duration;
    private long recordingId;
    
    public Recording(String name, String author, Style style, int duration) {
        super(name, author, style);
        this.duration = duration;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public long getRecordingId() {
        return recordingId;
    }
    
    public void setRecordingId(long id) {
        recordingId = id;
    }
    
}
