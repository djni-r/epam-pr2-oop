package by.makarymalinouski.epam.oop.soundrecording.factory;

import java.util.Map;

import by.makarymalinouski.epam.oop.soundrecording.entity.AnalogRecording;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.AnalogMedium;

public class AnalogRecordingFactory extends RecordingFactory {

    public AnalogRecordingFactory(AnalogMedium medium) {
        
    }
    @Override
    public AnalogRecording createInstance(Map<String, String> recordingMap) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented");
    }

}
