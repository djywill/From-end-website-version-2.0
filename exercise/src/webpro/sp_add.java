package webpro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sp_add
 */
@WebServlet("/sp_add")
public class sp_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sp_add() {
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
		//HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String spid = request.getParameter("spid").trim();
		String spmingcheng = request.getParameter("spmingcheng").trim();
		String spxiangqing = request.getParameter("spxiangqing").trim();
		String spjiage = request.getParameter("spjiage").trim();
		String spshuliang = request.getParameter("spshuliang").trim();
		SP_add(spid,spmingcheng,spxiangqing, spjiage, spshuliang);
		response.sendRedirect("./admin/HT_sp_list.jsp");
	}
	public void SP_add(String spid,String spmingcheng,String spxiangqing,String spjiage,String spshuliang) {
		Connection conn = pub_fun.getConnection();
		Statement stmt;
		String insert_sql = "insert into sp_data values('"+spid+"','"+spmingcheng+"','"+spxiangqing+"','"+spjiage+"','"+spshuliang+"')";
		try {
			stmt = conn.createStatement();
			stmt.execute(insert_sql);
			stmt.close();
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
