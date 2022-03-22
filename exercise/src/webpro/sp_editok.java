package webpro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sp_editok
 */
@WebServlet("/sp_editok")
public class sp_editok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sp_editok() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String spid = request.getParameter("spid").trim();
		String spmingcheng = request.getParameter("spmingcheng").trim();
		String spxiangqing = request.getParameter("spxiangqing").trim();
		String spjiage = request.getParameter("spjiage").trim();
		String spshuliang = request.getParameter("spshuliang").trim();
		Connection conn = pub_fun.getConnection();
		String update_sql = "update sp_data set spmingcheng='" + spmingcheng + "',spxiangqing='" + spxiangqing
				+ "',spjiage='" + spjiage + "',spshuliang='" + spshuliang + "' where spid='" + spid + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(update_sql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("./admin/HT_sp_list.jsp");
	}

}
