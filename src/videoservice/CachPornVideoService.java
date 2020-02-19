package videoservice;

import java.util.*;

public class CachPornVideoService implements VideoService {

    private VideoService videoService;
    private Map<Integer, String> cachedNames = new HashMap<>();
    private List<Video> cachedVideos = new ArrayList<>();
    private final int MAX_CACHE_SIZE = 3;

    public CachPornVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    public Map<Integer, String> videoNames() {
        if (!cacheNamesUpdated()) {
            updateCacheNames();
        }
        return cachedNames;
    }

    @Override
    public int videosQuantity() {
        if (!cacheNamesUpdated()) {
            updateCacheNames();
        }
        return cachedNames.size();
    }

    @Override
    public String getVideoInfo(int id) {
        if (videoCached(id)) {
            return getCachedVideo(id).getInfo();
        }
        return videoService.getVideoInfo(id);
    }

    @Override
    public Video downloadVideo(int id) {
        if (videoCached(id)) {
            return getCachedVideo(id);
        }
        Video video = videoService.downloadVideo(id);
        if (video != null) {
            putVideoToCache(video);
            return video;
        }
        return videoService.downloadVideo(id);
    }


    private boolean cacheNamesUpdated() {
        return this.cachedNames.size() == videoService.videosQuantity();
    }

    private void updateCacheNames() {
        cachedNames.clear();
        cachedNames.putAll(videoService.videoNames());
    }

    private void putVideoToCache(Video video) {
        cachedVideos.add(video);
        while (cachedVideos.size() > MAX_CACHE_SIZE) {
            cachedVideos.remove(0);
        }
    }

    private boolean videoCached(int id) {
        for (Video video : cachedVideos) {
            if (video.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private Video getCachedVideo(int id) {
        for (Video video : cachedVideos) {
            if (video.getId() == id) {
                return video;
            }
        }
        return null;
    }

    public int getCachedNamesSize() {
        return cachedNames.size();
    }

    public int getCachedVideoSize() {
        return cachedVideos.size();
    }

    public List<Video> getCachedVideos() {
        return cachedVideos;
    }

}
