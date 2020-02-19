package videoservice;

public class VideoManager {

    private VideoService videoService;

    public VideoManager(VideoService videoService) {
        this.videoService = videoService;
    }

    public void showVideoNames() {
        System.out.println("\nALL VIDEO NAMES:");
        for (String string : videoService.videoNames().values()) {
            System.out.println(string);
        }
    }

    public void showVideoInfo(int id) {
        System.out.println("\nVIDEO INFO:");
        System.out.println(videoService.getVideoInfo(id));
    }

    public void showVideo(int id) {
        System.out.println("\nVIDEO SHOW:");
        Video video = videoService.downloadVideo(id);
        System.out.println(video);
    }

}
