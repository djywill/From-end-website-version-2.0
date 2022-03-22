package webpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class sp_list {
	public String sp_list_all(int PN) {
		int pageSize=5;   
	    int beginnum=0;
        beginnum=(PN-1)*pageSize;
		Connection  conn = pub_fun.getConnection();
		String sql = "select * from sp_data limit "+beginnum+","+pageSize;
		String Ostr="";
		String spid="";
		try {
				PreparedStatement pstat = conn.prepareStatement(sql);
		        ResultSet rs = (ResultSet) pstat.executeQuery();
	              //获得结果集指针 
		        while(rs.next( )){
	              //将指针从当前位置下移一行。
		        		spid=rs.getString("spid");
		        		Ostr=Ostr+"<tr>";
		        		Ostr=Ostr+"<td><input name='' type='checkbox' value='' /></td>";
			        	Ostr=Ostr+"<td>"+rs.getString("spid")+"</td>";    
			        	Ostr=Ostr+"<td>"+rs.getString("spmingcheng")+"</td>";
			        	Ostr=Ostr+"<td>"+rs.getString("spxiangqing")+"</td>";
			        	Ostr=Ostr+"<td>"+rs.getString("spjiage")+"</td>";
			        	Ostr=Ostr+"<td>"+rs.getString("spshuliang")+"</td>";
			        	Ostr=Ostr+"<td>2013-09-09 15:05</td>";
			        	Ostr=Ostr+"<td><a href=\"#\" class=\"tablelink\">详情</a> <a href=\"HT_sp_edit.jsp?spid="+spid+"\" class=\"tablelink\">修改</a><a href=\"../sp_delok?spid="+spid+"\" class=\"tablelink\"> 删除</a></td>";
			        	Ostr=Ostr+"</tr>";
	             	}  
		         pstat.close();
		         conn.close();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		return Ostr;
	}
	/*public String sp_list_all(int PN){
        int pageSize=5;   
	    int beginnum=0;
        beginnum=(PN-1)*pageSize;
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from sp_data order by sp_id   limit "+beginnum+","+pageSize;
    	String Ostr="";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
 
		                Ostr=Ostr+"<tr><td>"+rs.getString("SP_id")+"</td>";  
		                Ostr=Ostr+"<td>"+rs.getString("SP_mingcheng")+"</td>";  
		                Ostr=Ostr+"<td>"+rs.getString("SP_xiangqing")+"</td>";  
		                Ostr=Ostr+"<td>"+rs.getString("SP_jiage")+"</td>";  
		                Ostr=Ostr+"<td>"+rs.getString("SP_kuchun")+"</td></tr>";  

						}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	//System.out.println(Ostr);
		return Ostr;
	}*/
	/*public String sp_listallpage() {
		int pageSize=5;  
	    int pageNow=1;   
	    int pageCount=0; 
	    int beginnum=0;
        int Pprev=0;
        int Pnext=0;
        int rowCount=0;
        
        Connection  conn = pub_fun.getConnection();
    	String sql = "select  count(*) from sp_data ";
    	String Ostr="";
    	try {
    	         PreparedStatement pstat = conn.prepareStatement(sql);
    	         ResultSet rs = (ResultSet) pstat.executeQuery();
                   //获得结果集指针 
    	         rs.last(); //跳到最后一条数据 
    	         rowCount=rs.getInt(1);	         
                 pstat.close();
    	         conn.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    	
    	if(rowCount%pageSize==0)   //计算总页面数  
    	{  
    		  pageCount=rowCount/pageSize;  
    	} else {  
    		  pageCount=rowCount/pageSize+1;    
    	} 
    	Pprev=pageNow-1;
    	Pnext=pageNow+1;
    	if(Pprev<1)
    	{
    	           Pprev=1;
    	}
    	if(Pnext>pageCount)
    	{
    	Pnext=pageCount;
    	}
    	Ostr=Ostr+"<a href='HT_sp_list.jsp?PN="+Pprev+"'>上一页</a>";
    	Ostr=Ostr+"<a href='HT_sp_list.jsp?PN="+Pnext+"'>下一页</a>";
    	return Ostr;	  
	}*/
	public String  sp_listallpage(int PN){
        int pageSize=5;  
        int pageNow=1;   
        int pageCount=0; 
        int Pprev=0;
        int Pnext=0;
        int rowCount=0;
        pageNow=PN;
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str ="select  count(*) from sp_data ",Ostr="";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
	         rs.last(); //跳到最后一条数据?
	         rowCount=rs.getInt(1);	
	         if(rowCount%pageSize==0)   //计算总页面数  
	         {  
	         	  pageCount=rowCount/pageSize;  
	         } else {  
	         	  pageCount=rowCount/pageSize+1;    
	         } 
	         Pprev=pageNow-1;
	         Pnext=pageNow+1;
	         if(Pprev<1)
	         {
	             Pprev=1;
	         }
	         if(Pnext>pageCount)
	         {
	        	 Pnext=pageCount;
	         }

             pstat.close();
	         conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	//System.out.println(Ostr);
    	Ostr="<a href='HT_sp_list.jsp?PN="+Pprev+"'>上一页</a>";
    	Ostr+="&nbsp;&nbsp;&nbsp;&nbsp;<a href='HT_sp_list.jsp?PN="+Pnext+"'>下一页</a>";
		return Ostr;
	}  
}
