package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;
    private int hours;
    private int minutes;
    private int seconds;

    Playlist() {
        this.songs = new ArrayList<>();
    }

    int getSongsNumber() {
        return this.songs.size();
    }

    void addSong(Song song) {
        this.songs.add(song);
    }

    void getTotalLength() {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        for (Song song : this.songs) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
            while (seconds > 59) {
                seconds -= 60;
                minutes++;
            }
            while (minutes > 59) {
                minutes -= 60;
                hours++;
            }
        }

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("Playlist length: %dh %dm %ds", this.hours, this.minutes, this.seconds);
    }
}
