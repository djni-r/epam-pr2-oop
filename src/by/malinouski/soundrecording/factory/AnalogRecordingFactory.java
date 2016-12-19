package by.malinouski.soundrecording.factory;

import java.util.Map;

import by.malinouski.soundrecording.entity.AnalogRecording;
import by.malinouski.soundrecording.exception.RecordingInitializationException;
import by.malinouski.soundrecording.musicenum.AnalogMedium;
import by.malinouski.soundrecording.musicenum.Style;

public class AnalogRecordingFactory extends RecordingFactory<AnalogRecording> {

    public AnalogRecordingFactory(AnalogMedium medium) {
        
    }
    @Override
    public AnalogRecording createInstance(Map<String, String> recordingInfo) 
            throws RecordingInitializationException {
        try {   
            AnalogRecording recording = new AnalogRecording(
                    recordingInfo.get("name"),
                    recordingInfo.get("author"),
                    Style.valueOf(recordingInfo.get("style").toUpperCase()),
                    Long.parseLong(recordingInfo.get("id")),
                    Integer.parseInt(recordingInfo.get("duration")),
                    Integer.parseInt(recordingInfo.get("number")),
                    AnalogMedium.valueOf(recordingInfo.get("medium").toUpperCase()));
        
            return recording;
        } catch (IllegalArgumentException e) {
            throw new RecordingInitializationException("Could not parse initialization data");
        }
    }

}
