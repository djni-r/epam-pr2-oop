package by.malinouski.soundrecording.creator;

import java.util.Collection;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.malinouski.soundrecording.comparator.RecordingNumberComparator;
import by.malinouski.soundrecording.entity.Album;
import by.malinouski.soundrecording.entity.Recording;
import by.malinouski.soundrecording.exception.RecordingInitializationException;
import by.malinouski.soundrecording.factory.RecordingFactory;

public class AlbumCreator<T extends Recording> {
    
    final static Logger LOGGER = LogManager.getLogger(AlbumCreator.class); 
    private RecordingFactory<T> factory;
    
    public AlbumCreator(RecordingFactory<T> factory) {
        this.factory = factory;
    }
    
    public Album<T> createAlbumFromData(Collection<Map<String, String>> data) {
        Album<T> album = new Album<>();
        album.setRecordings(makeRecordings(data));
        return album;
    }
    
    public SortedSet<T> makeRecordings(Collection<Map<String, String>> data) {
        
        SortedSet<T> recordings = new TreeSet<>(new RecordingNumberComparator());
        
        for (Map<String, String> recordingInfo : data) {
            try {
                recordings.add(factory.createInstance(recordingInfo));
            } catch (RecordingInitializationException e) {
                LOGGER.error("Could not create recording. Skipping to the next one");
            }
        }
        return recordings;
    }
}
