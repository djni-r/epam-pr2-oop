package by.makarymalinouski.epam.oop.soundrecording.factory;

import java.util.Map;

import by.makarymalinouski.epam.oop.soundrecording.entity.Recording;

public abstract class RecordingFactory {

    public RecordingFactory() {
        // TODO Auto-generated constructor stub
    }
    
    public void record() {
        // TODO
    }
    
    public abstract Recording createInstance(Map<String, String> recordingMap);
}
