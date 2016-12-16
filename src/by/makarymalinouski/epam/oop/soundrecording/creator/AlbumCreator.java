package by.makarymalinouski.epam.oop.soundrecording.creator;

import java.util.Collection;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import by.makarymalinouski.epam.oop.soundrecording.entity.Album;
import by.makarymalinouski.epam.oop.soundrecording.entity.DigitalRecording;
import by.makarymalinouski.epam.oop.soundrecording.entity.Recording;
import by.makarymalinouski.epam.oop.soundrecording.factory.AnalogRecordingFactory;
import by.makarymalinouski.epam.oop.soundrecording.factory.DigitalRecordingFactory;
import by.makarymalinouski.epam.oop.soundrecording.factory.RecordingFactory;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.AnalogMedium;
import by.makarymalinouski.epam.oop.soundrecording.musicenum.Compression;

public class AlbumCreator {
    RecordingFactory factory;
    
    public AlbumCreator(Compression compression) {
        factory = new DigitalRecordingFactory(compression);
    }
    
    public AlbumCreator(AnalogMedium medium) {
        factory = new AnalogRecordingFactory(medium);
    }
    
    
    
    public Album createAlbumFromData(Collection<Map<String, String>> data) {
        Album album = new Album();
        album.setRecordings(makeRecordings(data));
        return album;
    }
    
    public SortedSet<Recording> makeRecordings(Collection<Map<String, String>> data) {
        
        SortedSet<Recording> recordings = new TreeSet<Recording>(/* TODO some recording comparator */ );
        for (Map<String, String> recordingInfo : data) {
            recordings.add(factory.createInstance(recordingInfo));
        }
        return recordings;
    }
}
