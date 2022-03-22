<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String V_spid=(String)request.getParameter("spid");
%>
<jsp:useBean id="sp_edit" scope="page" class="webpro.sp_show_bean"></jsp:useBean>  
<jsp:setProperty  name="sp_edit" property="spid" value="<%=V_spid %>"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>商品信息</span></div>
    <form action="../sp_editok" method="post">
    <ul class="forminfo">
    <li><label>商品ID</label><input name="spid" type="text" class="dfinput" value="<%=sp_edit.get_spid() %>" /><i>只能包含字母和数字</i></li>
    <li><label>商品名称</label><input name="spmingcheng" type="text" class="dfinput" value="<%=sp_edit.get_spmingcheng() %>" /><i>名称不能超过30个字符</i></li>
    <li><label>商品详情</label><textarea name="spxiangqing" cols="" rows="" class="textinput"><%=sp_edit.get_spxiangqing() %></textarea></li>
    <li><label>商品价格</label><input name="spjiage" type="text" class="dfinput" value="<%=sp_edit.get_spjiage() %>" /></li>
    <li><label>商品库存</label><input name="spshuliang" type="text" class="dfinput" value="<%=sp_edit.get_spshuliang() %>" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>
</body>
</html>
