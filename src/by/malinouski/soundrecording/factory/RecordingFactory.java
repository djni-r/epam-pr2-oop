package by.malinouski.soundrecording.factory;

import java.util.Map;

import by.malinouski.soundrecording.entity.Recording;
import by.malinouski.soundrecording.exception.RecordingInitializationException;

public abstract class RecordingFactory<T extends Recording> {

    
    public abstract T createInstance(Map<String, String> recordingMap) 
            throws RecordingInitializationException;
}
