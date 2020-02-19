import videoservice.*;

public class App {

    public static void main(String[] args) {
        VideoService pornVideoService = new PornVideoService();
        ((PornVideoService) pornVideoService).populateVideos(100);
        VideoService cach = new CachPornVideoService(pornVideoService);
        VideoManager manager = new VideoManager(cach);
        manager.showVideoNames();
        manager.showVideoInfo(5);
        manager.showVideo(5);
    }
}
