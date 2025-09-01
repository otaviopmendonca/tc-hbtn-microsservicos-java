package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhpasody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        for(Song so : list){
            if(so.getId().equals(s.getId())){
                list.set(s.getId(), s);
            }
        }
    }

    public void removeSong(Song s) {
        list.remove(s);
    }
}