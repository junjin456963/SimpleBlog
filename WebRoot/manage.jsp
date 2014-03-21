<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=gbk"/>
<meta name="description" content="description"/>
<meta name="keywords" content="keywords"/> 
<meta name="author" content="author"/> 
<link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="page.css" media="screen"/>
<title>KimKun|金君的个人站</title>
</head>

<body>

<div class="container">

	<div class="header">
				
		<div class="title">
			<h1>Enjoy life</h1>
		</div>

	</div>

	<div class="navigation">
			<a href="myblog">我的博客</a>
			<a href="LibraryPlanning.html">图书规划</a>
			<a href="aboutme.html">关于我</a>
			<a href="http://blog.csdn.net/junjin456963">csdn</a>
			<input type="text" name="search" id="search" size="8" maxlength="10"/>
			<input type="button" value="搜索" onclick="Search();"/>
			<div class="clearer"><span></span></div>
		</div>

	<div class="main">		
		
		<div class="content">

            <s:iterator value="list">
            <table>
            <tr>
            <td>
                <h1><s:a href="look?id=%{id}"><s:property value="title"/></s:a>&nbsp;<s:a href="delete?id=%{id}">删除文章</s:a>
                &nbsp;<s:a href="modify?id=%{id}">编辑文章</s:a>
                </h1>
            </td>
            </tr>
            </table>
		  
			<div class="descr"><s:property value="time" /></div>
			<div class="partcontent"><pre><s:property value="content" /></pre></div>
			<div class="readmore"><h1><s:a href="look?id=%{id}">>>阅读全文...</s:a></h1> </div>
			</s:iterator>
			
            <h1><a href="AddArticle.jsp">添加文章</a> </h1>
           
            <% 
            int sumPage = Integer.parseInt((request.getParameter("sumpage")));
            int currentPage = Integer.parseInt(request.getParameter("currentPage")); 
            System.out.println(request.getParameter("sumpage"));
            System.out.println(request.getParameter("currentPage"));
           %>
            <div id="Page">
			<a href="manage_myblog?currentPage=<%=(currentPage-1)%>"><</a>
           <% 
            for (int i=1; i<=sumPage; i++){
	            if(i == currentPage){%>
	            <span><%=i%></span>
	           <%  }
	            else{%>
	            <a href="manage_myblog?currentPage=<%=i%>"><%=i%></a>
	          <%}
            }
             %>
			<a href="manage_myblog?currentPage=<%=(currentPage+1)%>">></a>
			</div>
			 
		</div>

		<div class="sidenav">

			<h1>分类目录</h1>
			<ul>
				<li><a href="error.html">没有开放</a></li>

			</ul>

			<h1>近期文章</h1>
			<ul>
			<s:iterator value="latestcontent">
		    <li><s:a href="look?id=%{id}"><s:property value="title"/></s:a></li>
			</s:iterator>

			</ul>

			<h1>友情链接</h1>
			<ul>
				<li><a href="http://www.jonear.com">余成海</a></li>
               <li><a href="http://upupxjg.com">肖建刚</a></li>
               <li><a href="http://lisuyong.com">李素颙</a></li>
               <li><a href="http://ifind.cc">江长舜</a></li>
               <li><a href="http://lrqblog.sinaapp.com">李日强</a></li>
			</ul>

		</div>

		<div class="clearer"><span></span></div>

	</div>

	<div class="footer">
       金君个人博客
	</div>

</div>

</body>

</html>