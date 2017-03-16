package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.view.NoticeView;


/**
 * Notice Controller
 * ������ �����ϴ°�(���̵����)
 */
public interface NoticeDao {
   List<NoticeView> getList();
   List<NoticeView> getList(int page);
   List<NoticeView> getList(int page, String field, String query);
   
   
   //�����ڴ�? �̰ǹ���~
   int getSize();
   int getSize(String field, String query);
   
   int add(Notice notice);
   int add(String title, String content, String writer);
}