//albumsテーブルから取得した値を保持するためのクラス
package com.example.musicmanagement.entity;
 
 import lombok.Data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Indexed;
import jakarta.*;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
 
 //Lombokを使ったGetterやSetterを自動生成するためのアノテーション
 @Data
 public class Album {
  
   private long albumId;
   private String title;
   private String artist;

   //日付型のフォーマットを指定
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate releaseDate;
   private LocalDateTime createdAt;


 }