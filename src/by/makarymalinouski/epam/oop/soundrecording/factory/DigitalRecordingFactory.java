package by.makarymalinouski.epam.oop.soundrecording.factory;

import java.util.Map;

import by.makarymalinouski.epam.oop.soundrecording.entity.DigitalRecording;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Compression;

public class DigitalRecordingFactory extends RecordingFactory {

    Compression compression;
    
    public DigitalRecordingFactory(Compression compression) {
        this.compression = compression;
    }

    @Override
    public DigitalRecording createInstance(Map<String, String> rocordingInfo) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented");
    }

}
