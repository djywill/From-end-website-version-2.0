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
 * Servlet implementation class sp_delok
 */
@WebServlet("/sp_delok")
public class sp_delok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sp_delok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String spid = request.getParameter("spid").trim();
    	Connection  conn = pub_fun.getConnection();
    	String del_sql = "delete from sp_data where spid='"+spid+"'";
    	try {
    		Statement stmt = conn.createStatement();
    		stmt.execute(del_sql);
    		stmt.close();
    		conn.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	response.sendRedirect("./admin/HT_sp_list.jsp");	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
