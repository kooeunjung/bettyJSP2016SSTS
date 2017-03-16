package com.newlecture.web.view;

import com.newlecture.web.entity.Notice;

public class NoticeView extends Notice{
   private String writerName;
   private int commentCount;
   
   public String getWriterName() {
      return writerName;
   }
   public void setWriterName(String writerName) {
      this.writerName = writerName;
   }
   public int getCommentCount() {
      return commentCount;
   }
   public void setCommentCount(int commentCount) {
      this.commentCount = commentCount;
   }
}