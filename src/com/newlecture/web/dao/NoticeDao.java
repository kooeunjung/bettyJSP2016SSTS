package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.view.NoticeView;


/**
 * Notice Controller
 * 무엇을 구현하는가(가이드라인)
 */
public interface NoticeDao {
   List<NoticeView> getList();
   List<NoticeView> getList(int page);
   List<NoticeView> getList(int page, String field, String query);
   
   
   //생성자니? 이건뭘까~
   int getSize();
   int getSize(String field, String query);
   
   int add(Notice notice);
   int add(String title, String content, String writer);
}