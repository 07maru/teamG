package com.example.musicmanagement.service;

 import com.example.musicmanagement.repository.AlbumRepository;
 import com.example.musicmanagement.entity.Album;
 import org.springframework.stereotype.Service;
 import com.example.musicmanagement.form.AlbumForm;

 import java.util.List;

 @Service
 public class AlbumService {
   private final AlbumRepository albumRepository;

   public AlbumService(AlbumRepository albumRepository) {
       this.albumRepository = albumRepository;
   }
   
   public List<Album> getAllAlbums(String sortBy, String sortOrder) {
    if (sortBy.equals("release_date")) {
        if (sortOrder.equals("asc")) {
            return albumRepository.searchReleaseAllASCAlbums();
        } else {
            return albumRepository.searchReleaseAllDESCAlbums();
        }
    } else if (sortBy.equals("title")) {
        if (sortOrder.equals("asc")) {
            return albumRepository.searchTitleAllASCAlbums();
        } else {
            return albumRepository.searchTitleAllDESCAlbums();
        }
    }
       return albumRepository.getAllAlbums();
   }

   public  List<Album> searchAlbums(String keyword){
        return albumRepository.searchAlbums(keyword);
   }

    public void createAlbum(AlbumForm albumForm) {
       Album album = new Album();
       album.setTitle(albumForm.getTitle());
       album.setArtist(albumForm.getArtist());
       album.setReleaseDate(albumForm.getReleaseDate());
       albumRepository.insertAlbum(album);
   }

    public Album getAlbumById(long albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumRepository.deleteAlbum(albumId);
    }

     public void updateAlbum(long albumId, Album album) {
        if (albumId != album.getAlbumId()) {
            throw new IllegalArgumentException("Album ID does not match");
        }
        albumRepository.updateAlbum(album);
    }

    
 }