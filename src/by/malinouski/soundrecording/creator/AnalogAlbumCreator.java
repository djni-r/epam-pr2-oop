package by.malinouski.soundrecording.creator;

import by.malinouski.soundrecording.entity.AnalogRecording;
import by.malinouski.soundrecording.factory.AnalogRecordingFactory;
import by.malinouski.soundrecording.musicenum.AnalogMedium;

public class AnalogAlbumCreator extends AlbumCreator<AnalogRecording> {
    
    public AnalogAlbumCreator(AnalogMedium medium) {
        super(new AnalogRecordingFactory(medium));
    }

}
