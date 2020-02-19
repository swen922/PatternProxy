package videoservice;

import java.util.List;
import java.util.Map;

public interface VideoService {
    public Map<Integer, String> videoNames();
    public int videosQuantity();
    public String getVideoInfo(int id);
    public Video downloadVideo(int id);
}
