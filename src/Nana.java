import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.mysql.MySQLMemberDao;

public class Nana extends HttpServlet {

	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  
		  PrintWriter out = response.getWriter(); //OutputStream/InputStream : byte,
		  Writer/Reader:char
		  
		  MebmerDao memberDao = new MySQLMemberDao(); List <Member> list =
		  memberDao.getList(); for (Member m : list)
		  //out.printf("id는 '%s'이고 비밀번호는 <span style='color:red;'>'%s'</span>이다\n<br/>"
		  , m.getId(), m.getPwd()); out.print("id는 "+m.getId() + "이고 비밀번호는" +
		  "<span style='color:red;'>"+m.getPwd()+"</span>이다<br />"); } }
		
	}
}

/* 
 * public void service(HttpServletRequest request, HttpServletResponse response)
 * throws IOException, ServletException { response.setContentType("image/jpeg");
 * BufferedImage image = new BufferedImage(200, 200,
 * BufferedImage.TYPE_INT_RGB); Graphics2D g = image.createGraphics();
 * g.setColor(Color.pink); g.drawLine(0, 0, 200, 200);
 * 
 * OutputStream os = response.getOutputStream(); ImageIO.write(image, "jpg",
 * os);
 * 

 */