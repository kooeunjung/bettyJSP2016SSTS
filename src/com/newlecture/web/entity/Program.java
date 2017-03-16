package com.newlecture.web.entity;

import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mysql.MySQLMemberDao;

/**
 * MySQL����� ���α׷�
 *
 */
public class Program {

   public static void main(String[] args) {
      // MVC

      MemberDao memberDao = new MySQLMemberDao();
      // id�˻�
      System.out.print("�˻��� �Է�: ");
      Scanner scan = new Scanner(System.in);
      String uid = scan.nextLine();
      List<Member> list = memberDao.getList(uid);
      System.out.println("\n���̵�\t��й�ȣ");
      for (Member m : list)
         System.out.println(m.getId() + "\t" + m.getPwd());
   }

}