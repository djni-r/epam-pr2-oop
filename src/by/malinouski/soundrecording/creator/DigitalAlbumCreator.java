package by.malinouski.soundrecording.creator;

import by.malinouski.soundrecording.entity.DigitalRecording;
import by.malinouski.soundrecording.factory.DigitalRecordingFactory;
import by.malinouski.soundrecording.musicenum.Compression;

public class DigitalAlbumCreator extends AlbumCreator<DigitalRecording> {

    public DigitalAlbumCreator(Compression compression) {
        super(new DigitalRecordingFactory(compression));
    }

}
