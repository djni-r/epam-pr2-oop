package by.malinouski.soundrecording.factory;

import java.util.Map;

import by.malinouski.soundrecording.entity.DigitalRecording;
import by.malinouski.soundrecording.exception.RecordingInitializationException;
import by.malinouski.soundrecording.musicenum.Compression;
import by.malinouski.soundrecording.musicenum.Style;

public class DigitalRecordingFactory extends RecordingFactory<DigitalRecording> {

    Compression compression;
    
    public DigitalRecordingFactory(Compression compression) {
        this.compression = compression;
    }

    @Override
    public DigitalRecording createInstance(Map<String, String> recordingInfo) 
            throws RecordingInitializationException {

        try {
            DigitalRecording recording = new DigitalRecording(
                    recordingInfo.get("name"),
                    recordingInfo.get("author"),
                    Style.valueOf(recordingInfo.get("style").toUpperCase()),
                    Long.parseLong(recordingInfo.get("id")),
                    Integer.parseInt(recordingInfo.get("duration")),
                    Integer.parseInt(recordingInfo.get("number")),
                    compression);
            
            return recording;
        } catch (IllegalArgumentException e) {
            throw new RecordingInitializationException("Could not parse initialization data");
        }
    }
}
