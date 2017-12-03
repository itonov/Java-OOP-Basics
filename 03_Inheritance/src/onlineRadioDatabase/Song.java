package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, String minutes, String seconds) throws InvalidSongException {
        setArtistName(artistName);
        setSongName(songName);
        checkLength(minutes, seconds);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setMinutes(String minutes) throws InvalidSongMinutesException {
        int mins = Integer.parseInt(minutes);
        if (mins < 0 || mins > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = mins;
    }

    private void setSeconds(String seconds) throws InvalidSongSecondsException {
        int secs = Integer.parseInt(seconds);
        if (secs < 0 || secs > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = secs;
    }

    private void checkLength(String minutes, String seconds) throws InvalidSongLengthException {
        try {
            int mins = Integer.parseInt(minutes);
            int secs = Integer.parseInt(seconds);
        } catch (NumberFormatException nfe) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }


}
