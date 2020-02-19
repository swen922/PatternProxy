package videoservice;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PornVideoService implements VideoService {

    private Map<Integer, Video> allVideos = new HashMap<>();

    @Override
    public Map<Integer, String> videoNames() {
        Map<Integer, String> result = new HashMap<>();
        for (Video video : allVideos.values()) {
            result.put(video.getId(), video.getName());
        }
        return result;
    }

    @Override
    public int videosQuantity() {
        return allVideos.size();
    }

    @Override
    public String getVideoInfo(int id) {
        if (allVideos.containsKey(id)) {
            return allVideos.get(id).getInfo();
        }
        return null;
    }

    @Override
    public Video downloadVideo(int id) {
        if (allVideos.containsKey(id)) {
            return allVideos.get(id);
        }
        return null;
    }

    public void populateVideos(int quantity) {
        if (quantity < 1) {
            return;
        }

        for (int i = 0; i < quantity; i++) {
            Video video = new Video(i, "Video-" + i, "Video Info number " + i, "Video file -" + i);
            allVideos.put(i, video);
        }
    }

}
