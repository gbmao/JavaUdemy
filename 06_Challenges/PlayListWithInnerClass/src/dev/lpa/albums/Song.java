package dev.lpa.albums;

public class Song {
    private String title;
    private double duration;
    private int trackNumber;

    protected Song(String title, double duration, int trackNumber) {
        this.title = title;
        this.duration = duration;
        this.trackNumber = trackNumber;

    }

    protected String getTitle() {
        return title;
    }

    protected double getDuration() {
        return duration;
    }

    protected int getTrackNumber() {
        return trackNumber;
    }
}
