package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSongs = Integer.parseInt(reader.readLine());
        Playlist playlist = new Playlist();
        for (int i = 0; i < numberOfSongs; i++) {
            try {
                String[] inputTokens = reader.readLine().split("[;:]");
                Song song = new Song(inputTokens[0], inputTokens[1], inputTokens[2], inputTokens[3]);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }
        playlist.getTotalLength();
        System.out.println("Songs added: " + playlist.getSongsNumber());
        System.out.println(playlist.toString());
    }
}
