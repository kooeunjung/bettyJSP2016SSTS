package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.view.NoticeView;

public class MySQLNoticeDao implements NoticeDao{

	   @Override
	   public List<NoticeView> getList() {
	      return getList(1, "TITLE", "");
	   }

	   @Override
	   public List<NoticeView> getList(int page) {
	      return getList(page, "TITLE", "");
	   }

	   @Override
	   public List<NoticeView> getList(int page, String field, String query) {
	      
	      /*SELECT * FROM NOTICE_VIEW Where TITLE like '%%' limit 0,10;*/
	      String sql = "SELECT * FROM NOTICE_VIEW WHERE BINARY " + field + " like ? limit ?,10";
	      List<NoticeView> list = new ArrayList<>();

	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
	         PreparedStatement st = con.prepareStatement(sql);
	         
	         st.setString(1, "%"+query+"%");
	         st.setInt(2, 10*(page-1));
	         
	         ResultSet rs = st.executeQuery();
	         
	         NoticeView noticeView = null;

	         while (rs.next()) {
	            noticeView = new NoticeView();
	            noticeView.setCode(rs.getString("CODE"));
	            noticeView.setTitle(rs.getString("TITLE"));
	            noticeView.setWriter(rs.getString("WRITER"));
	            noticeView.setContent(rs.getString("CONTENT"));
	            noticeView.setRegdate(rs.getDate("REGDATE"));
	            
	            noticeView.setWriterName(rs.getString("WRITER_NAME"));
	            noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
	            
	      
	            list.add(noticeView);
	         }

	         rs.close();
	         st.close();
	         con.close();
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return list;
	   }

	   
		@Override
		public int getSize(String field, String query) {
	
		      /*SELECT * FROM NOTICE_VIEW Where TITLE like '%%' limit 0,10;*/
		      String sql = "SELECT COUNT(CODE) SIZE FROM NOTICE WHERE BINARY " + field + " LIKE ?";
		      int size=0;
		      List<NoticeView> list = new ArrayList<>();
	
		      try {
		         Class.forName("com.mysql.jdbc.Driver");
		         
		         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
		         Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
		         PreparedStatement st = con.prepareStatement(sql);
		         st.setString(1, "%"+query+"%");
		         
		         ResultSet rs = st.executeQuery();
		         //갯수보여주기
		         if(rs.next())
		         size = rs.getInt("SIZE");
		        		 
		         rs.close();
		         st.close();
		         con.close();
		         
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      
		      return size;
		   
		}
	
		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return getSize("TITLE","");
		}

		@Override
		public int add(Notice notice) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int add(String title, String content, String writer) {
			// TODO Auto-generated method stub
			return 0;
		}


	
		}