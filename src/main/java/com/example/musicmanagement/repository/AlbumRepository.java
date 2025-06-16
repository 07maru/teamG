package com.example.musicmanagement.repository;

 import com.example.musicmanagement.mapper.AlbumMapper;
 import com.example.musicmanagement.entity.Album;
 import org.springframework.stereotype.Repository;

 import java.util.List;

 @Repository
 public class AlbumRepository {
   private final AlbumMapper albumMapper;

   public AlbumRepository(AlbumMapper albumMapper) {
       this.albumMapper = albumMapper;
   }
   
   public List<Album> getAllAlbums() {
       return albumMapper.selectAllAlbums();
   }

    public void insertAlbum(Album album) {
       albumMapper.insertAlbum(album);
   }

     public Album getAlbumById(long albumId) {
        return albumMapper.selectAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumMapper.deleteAlbumById(albumId);
    }

    public void updateAlbum(Album album){
        albumMapper.updateAlbum(album);
    }

    public List<Album> searchAlbums(String keyword){
        return  albumMapper.searchAlbumsbyKeyword(keyword);
    }

    public List<Album> searchASCAlbums(String keyword){
        return  albumMapper.searchASCAlbumsbyKeyword(keyword);
    }

    public List<Album> searchDESCAlbums(String keyword){
        return  albumMapper.searchDESCAlbumsbyKeyword(keyword);
    }

    public List<Album> searchTitleASCAlbums(String keyword){
        return  albumMapper.searchTitleASCAlbumsbyKeyword(keyword);
    }

    public List<Album> searchTitleDESCAlbums(String keyword){
        return  albumMapper.searchTitleDESCAlbumsbyKeyword(keyword);
    }

    public List<Album> searchReleaseAllASCAlbums(){
        return  albumMapper.searchReleaseAllASCAlbums();
    }

    public List<Album> searchReleaseAllDESCAlbums(){
        return  albumMapper.searchReleaseAllDESCAlbums();
    }

    public List<Album> searchTitleAllASCAlbums(){
        return  albumMapper.searchTitleAllASCAlbums();
    }

    public List<Album> searchTitleAllDESCAlbums(){
        return  albumMapper.searchTitleAllDESCAlbums();
    }
 }

