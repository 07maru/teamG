//Mybatisを使ってデータベースとやり取りするクラス
package com.example.musicmanagement.mapper;

 import com.example.musicmanagement.entity.Album;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
 import org.apache.ibatis.annotations.Mapper;
 import org.apache.ibatis.annotations.Options;
 import org.apache.ibatis.annotations.Select;
 import org.apache.ibatis.annotations.Update;

 import java.util.List;

 //インターフェース宣言
 @Mapper
 public interface AlbumMapper {
 
    @Select("SELECT * FROM albums")
   List<Album> selectAllAlbums();

    @Insert("INSERT INTO albums (title, artist, release_date) VALUES (#{title}, #{artist}, #{releaseDate})")
   @Options(useGeneratedKeys = true, keyProperty = "albumId")
   void insertAlbum(Album album);

     @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
    Album selectAlbumById(long albumId);

     @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
    void deleteAlbumById(long albumId);

     @Update("UPDATE albums SET title = #{title}, artist = #{artist}, release_date = #{releaseDate} WHERE album_id = #{albumId}")
    void updateAlbum(Album album);

    //キーワードでタイトルまたはアーティスト名を検索
    @Select("SELECT * FROM albums WHERE title LIKE CONCAT('%', #{keyword}, '%') OR artist LIKE CONCAT('%',#{keyword}, '%') ORDER BY release_date ASC")
    List<Album> searchAlbumsbyKeyword(String keyword);

    @Select("SELECT * FROM albums WHERE title LIKE CONCAT('%', #{keyword}, '%') OR artist LIKE CONCAT('%',#{keyword}, '%') ORDER BY release_date ASC")
    List<Album> searchASCAlbumsbyKeyword(String keyword);

    @Select("SELECT * FROM albums WHERE title LIKE CONCAT('%', #{keyword}, '%') OR artist LIKE CONCAT('%',#{keyword}, '%') ORDER BY release_date DESC")
    List<Album> searchDESCAlbumsbyKeyword(String keyword);

    @Select("SELECT * FROM albums WHERE title LIKE CONCAT('%', #{keyword}, '%') OR artist LIKE CONCAT('%',#{keyword}, '%') ORDER BY title ASC")
    List<Album> searchTitleASCAlbumsbyKeyword(String keyword);

    @Select("SELECT * FROM albums WHERE title LIKE CONCAT('%', #{keyword}, '%') OR artist LIKE CONCAT('%',#{keyword}, '%') ORDER BY title DESC")
    List<Album> searchTitleDESCAlbumsbyKeyword(String keyword);

    @Select("SELECT * FROM albums ORDER BY release_date ASC")
   List<Album> searchReleaseAllASCAlbums();

   @Select("SELECT * FROM albums ORDER BY release_date DESC")
   List<Album> searchReleaseAllDESCAlbums();

   @Select("SELECT * FROM albums ORDER BY title ASC")
   List<Album> searchTitleAllASCAlbums();

   @Select("SELECT * FROM albums ORDER BY title DESC")
   List<Album> searchTitleAllDESCAlbums();
 }

   