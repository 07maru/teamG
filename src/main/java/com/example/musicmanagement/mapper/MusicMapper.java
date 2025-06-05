package com.example.musicmanagement.mapper;

import com.example.musicmanagement.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.example.musicmanagement.viewmodel.MusicViewModel;

import java.util.List;

@Mapper
public interface MusicMapper {

    @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
        List<Music> selectMusicsById(long album_id);

    @Insert("INSERT INTO musics (title, duration, album_id) VALUES (#{title}, #{duration}, #{albumId})")
    @Options(useGeneratedKeys = true, keyProperty = "musicId")
    void insertMusic(Music music);

     @Select("""
            SELECT
                musics.music_id,
                title,
                duration,
                favorites.user_id IS NOT NULL AS is_favorite
            FROM musics
            LEFT JOIN favorites ON musics.music_id = favorites.music_id AND favorites.user_id = #{userId}
            WHERE album_id = #{albumId}
            """)
    List<MusicViewModel> selectMusicsWithFavorite(long albumId, long userId);
 }

