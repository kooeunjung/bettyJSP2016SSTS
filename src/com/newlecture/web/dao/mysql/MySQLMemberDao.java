package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class MySQLMemberDao implements MemberDao{
   
   public List<Member> getList() {
      return getList("");
   }

   public List<Member> getList(String query) {
      String sql = "SELECT * FROM MEMEBER";
      List<Member> list = new ArrayList<>();
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         Member member =null;
         
         while (rs.next()) {
            member = new Member();
            member.setId(rs.getString("ID"));
            member.setPwd(rs.getString("PWD"));
            
            list.add(member);
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
   
   //나중에 구현
   public int add(Member member) {

      /*String sql = "INSERT INTO MEMBER(MID, PWD, NAME, PHONE, REGDATE) VALUES(?,?,?,?,SYSDATE)";

      
       try {
          Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
          PreparedStatement st = con.prepareStatement(sql);
          st.setString(1, member.getMid());
          st.setString(2, member.getPwd());
          st.setString(3, member.getName());
          st.setString(4, member.getPhone());
          
          //결과가 있는 쿼리 executeQuery()
          //SELCT
          
          //결과가 없는 쿼리 executeUpdate()
          //INSERT / UPDATE / DELETE
          int result = st.executeUpdate();
          
          st.close();
          con.close();
          
          return result;
          
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }*/
               
       return 0;
   }
}