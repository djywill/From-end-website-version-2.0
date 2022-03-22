package webpro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(true);
		String log = request.getParameter("log");
		String pwd = request.getParameter("pwd");
		if(YH_check(log,pwd)) {
			response.sendRedirect("./admin/main.jsp");
			String YH_xm = YH_xm(log, pwd);
			session.setAttribute("YH_name", YH_xm);
		}
		else {
			response.sendRedirect("./admin/login.jsp");
		}
	}
	public boolean YH_check(String log,String pwd) {
		Connection conn = pub_fun.getConnection();
		String Sql_str = "Select * from yh_data where YH_log='"+log+"' and YH_pwd='"+pwd+"'";
		boolean Oboolean = false;
		try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet)pstat.executeQuery();
			while(rs.next()) {
				Oboolean = true;
			}
			pstat.close();
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(log);
		System.out.println(pwd);
		System.out.println(Oboolean);
		return Oboolean;
	}
	public String YH_xm(String log,String pwd) {
		Connection conn = pub_fun.getConnection();
		String Sql_str = "Select * from yh_data where YH_log='"+log+"' and YH_pwd='"+pwd+"'";
		String Ostr = "";
		try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet)pstat.executeQuery();
			while(rs.next()) {
				Ostr = rs.getString("YH_xingming");
			}
			pstat.close();
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Ostr;
	}
}
