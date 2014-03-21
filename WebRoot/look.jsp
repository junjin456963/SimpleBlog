<%@ page language="java" import="java.util.*;import java.text.*;" pageEncoding="gbk"%>
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
    <script type="text/javascript">
           function Check(){
			if (document.theform['user.account'].value=="")
			{
				alert("姓名不能为空！");

				return false;
			}
			else if (document.theform['user.content'].firstChild.nodeValue==0)
			{
				alert("内容不能为空！");

				return false;
			}
		
			else
			{
			return true;
			}
			 return true;
           }
	</script>
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
			<div class="clearer"><span></span></div>
		</div>

	<div class="main">		
		
		<div class="content">
	        <s:iterator value="Blog">
			<h1><s:property value="title"/></h1>
			<div class="descr"><s:property value="time"/></div>
			<pre><s:property value="content" /></pre>
			</s:iterator>
			
			<hr/><h4>评论内容</h4>
			
			<s:iterator value="list">
		    <h1><s:property value="account"/></h1>
			<div class="descr"><s:property value="time" /></div>
			<p><s:property value="content" /></p>
			<br/>
			</s:iterator>
		<form method="post" action="save" name="theform" onsubmit="return Check()">	
		    <fieldset>

				<h4>发表评论</h4>
				<p>姓名 </p><input type="text" name="user.account" size="18" maxlength="30"/><br/>
				<p>文章内容</p>
				<textarea name="user.content" rows="6" cols="60"> </textarea><br/><br/>
				<input type="hidden" name="user.time" value="<%= DateFormat.getDateTimeInstance(2,2,Locale.CHINESE).format(new java.util.Date())%>"/>
				<input type="hidden" name="user.blogid" value="<s:property value="id" />"/>
				<s:token/>  
				<div class="enter">
			    <input type="submit" value="发表评论" /> 
				</div>

			</fieldset>			
		</form>
			
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
