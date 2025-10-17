package dev.lpa.albums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private SongList songs;
    private int trackNumber = 0;

    public Album(String albumName, String authorName) {
        this.name = albumName;
        this.artist = authorName;
        songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration, trackNumber++));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        if (songs.findSong(trackNumber) != null) {
            playList.add(songs.findSong(trackNumber));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {

        if (songs.findSong(title) != null) {
            playList.add(songs.findSong(title));
            return true;
        }
        return false;
    }


    private class SongList {

        private List<Song> songList;


        public SongList() {
            songList = new ArrayList<>();

        }


        private boolean add(Song song) {

            for (Song s : songList) {
                if (s.getTitle().equalsIgnoreCase(song.getTitle())) {
                    return false;
                }

            }
            songList.add(song);

            return true;
        }

        private Song findSong(String songName) {

            for (Song s : songList) {
                if (s.getTitle().equalsIgnoreCase(songName)) {
                    return s;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {

            for (Song s : songList) {
                if (s.getTrackNumber() == trackNumber) {
                    return s;
                }
            }
            return null;
        }
    }
}
