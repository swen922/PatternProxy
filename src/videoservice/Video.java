package videoservice;

import com.sun.istack.internal.NotNull;

import java.io.File;

public class Video {

    private int id;
    private String name;
    private String info;
    private String file;

    public Video(int idNumber, @NotNull String name, @NotNull String info, @NotNull String file) {
        this.id = idNumber;
        this.name = name;
        this.info = info;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
