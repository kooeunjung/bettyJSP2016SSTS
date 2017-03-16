package com.newlecture.web.entity;

import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mysql.MySQLMemberDao;

/**
 * MySQL사용한 프로그램
 *
 */
public class Program {

   public static void main(String[] args) {
      // MVC

      MemberDao memberDao = new MySQLMemberDao();
      // id검색
      System.out.print("검색어 입력: ");
      Scanner scan = new Scanner(System.in);
      String uid = scan.nextLine();
      List<Member> list = memberDao.getList(uid);
      System.out.println("\n아이디\t비밀번호");
      for (Member m : list)
         System.out.println(m.getId() + "\t" + m.getPwd());
   }

}