package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Bem-vindo ao serviço de músicas!";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Integer id) {
        Optional<Song> song = Optional.ofNullable(songRepository.getSongById(id));
        if (song.isPresent()) {
            return ResponseEntity.ok(song.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        return ResponseEntity.status(HttpStatus.CREATED).body(song);
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Song> updateSong(@RequestBody Song song) {
        try {
            songRepository.updateSong(song);
            return ResponseEntity.ok(song);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> deleteSongById(@RequestBody Song song) {
        try {
            songRepository.removeSong(song);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}