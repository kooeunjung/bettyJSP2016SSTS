package com.newlecture.web.servlet;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.entity.Member;

@WebServlet("/memberlist")
public class MemberList {

		public void service(HttpServletRequest request, 
				HttpServletResponse response) throws IOException, ServletException {
			
			  String query = request.getParameter("query");
			  System.out.println(query);
			  response.setCharacterEncoding("UTF-8");
			  response.setContentType("text/html;charset=UTF-8");
			  
			  PrintWriter out = response.getWriter(); 
						  
			  MySQLMemberDao memberDao = new MySQLMemberDao(); 
			  List <Member> list = memberDao.getList(query);
			  for (Member m : list)
			  
			  out.printf("id=는"+ m.getId() + "이고 비밀번호는"+ m.getPwd());
	}
}
