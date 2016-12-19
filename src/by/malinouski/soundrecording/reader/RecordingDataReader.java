package by.malinouski.soundrecording.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecordingDataReader {
    final static Logger LOGGER = LogManager.getLogger(RecordingDataReader.class);
    
    public Collection<Map<String, String>> readJsonData(String fileName) {
        
        Collection<Map<String, String>> result = new ArrayList<Map<String,String>>();
        
        try {
            JSONObject jsonRecData = new JSONObject(new String(
                    Files.readAllBytes(new File(fileName).toPath())));
            
            String compression = jsonRecData.getJSONObject("info").getString("compression");
            JSONArray tracks = jsonRecData.getJSONArray("tracks");
            
            for (int trackIndex = 0; trackIndex < tracks.length(); trackIndex++) {
                try {
                    Map<String, String> map = new HashMap<>();
                    map.put("name", tracks.getJSONObject(trackIndex).getString("name"));
                    map.put("author", tracks.getJSONObject(trackIndex).getString("author"));
                    map.put("style", tracks.getJSONObject(trackIndex).getString("style"));
                    map.put("id", tracks.getJSONObject(trackIndex).getString("id"));
                    map.put("duration", tracks.getJSONObject(trackIndex).getString("duration"));
                    map.put("number", tracks.getJSONObject(trackIndex).getString("number"));
                    map.put("compression", compression);
                    result.add(map);
                } catch (JSONException e) {
                    LOGGER.error("Could not parse track info. Skipping this track");
                }
            }
            
        } catch (JSONException e) {
            LOGGER.error("Could not parse json object from file. Returing empty collection");
        } catch (IOException e) {
            LOGGER.error("Could not open file. Returning empty collection");
        }
        return result;
    }

}
