package webpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sp_show_bean {
	String spid="";       //定义类的属性
	String spmingcheng="";
	String spxiangqing="";
	String spjiage="";
	String spshuliang="";

	public String get_spid() {    //定义类的方法
		return spid;
	}
	public String get_spmingcheng() {
		return spmingcheng;
	}
	public String get_spxiangqing() {
		return spxiangqing;
	}
	public String get_spjiage() {
		return spjiage;
	}
	public String get_spshuliang() {
		return spshuliang;
	}
	public void setSpid(String spid) {   //取得网页传来的sp_id
		this.spid=spid;
		sp_info();         //调用函数为各个属性付值
		//System.out.print(this.sz_sid);
	}
	public void sp_info()
	{
		Connection  conn = pub_fun.getConnection();
		String list_sql = "select * from sp_data where spid='"+this.spid+"'";
		//System.out.print(sql);
		try {
			PreparedStatement pstat = conn.prepareStatement(list_sql);
			ResultSet rs = (ResultSet) pstat.executeQuery();
		   	while(rs.next())  
            		{  
		   		spid=rs.getString("spid");
		   		spmingcheng=rs.getString("spmingcheng");
		   		spxiangqing=rs.getString("spxiangqing");
		   		spjiage=rs.getString("spjiage");
		   		spshuliang=rs.getString("spshuliang");
            		}
			pstat.close();
		        conn.close();
		        //System.out.print(sz_author);
	
		      } catch (SQLException e) {
		          e.printStackTrace();
		      }	
	}
}
