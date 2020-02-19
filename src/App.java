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

        manager.showVideoInfo(15);
        manager.showVideo(15);

        manager.showVideoInfo(22);
        manager.showVideo(22);

        System.out.println("");
        for (Video video : ((CachPornVideoService) cach).getCachedVideos()) {
            System.out.println(video);
        }

        manager.showVideoInfo(99);
        manager.showVideo(99);

        System.out.println("cach.getCachedNamesSize() = " + ((CachPornVideoService) cach).getCachedNamesSize());
        System.out.println("cach.getCachedVideoSize() = " + ((CachPornVideoService) cach).getCachedVideoSize());

        System.out.println("");
        for (Video video : ((CachPornVideoService) cach).getCachedVideos()) {
            System.out.println(video);
        }
    }
}
