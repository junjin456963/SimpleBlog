<%@ page language="java" import="java.util.*;import java.text.*;" pageEncoding="GB18030"%>
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
<title>KimKun|金君的个人站</title>

    <script type="text/javascript">
		var xmlHttp;
		var title;
		
		function clearvalue(x){
		document.getElementById(x).value="";
		}
		
		function checkForm()
		{
		   var theForm=document.apLogin;
           title = document.forms[0].elements["blog.title"].value

			if (title=="")
			{
			alert("题目不能为空！");
			document.forms[0].elements["blog.title"].focus();
			return false;
			}
			else if (document.forms[0].elements["blog.content"].value=="")
			{
			alert("内容不能为空！");
			document.forms[0].elements["blog.content"].focus();
			return false;
			}
		
			else
			{
				var text = document.getElementById("textarea");
		        var textArray = text.value.split("\n"); //对文本进行分行处理
		        var html = "";
		        for (var i = 0; i < textArray.length; i++) {
		            html += textArray[i] + "\";
		        }
			    document.getElementById("textarea").value = html;
			return true;
			}
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
	
	 <form method="post" action="add" onsubmit="return checkForm();">
		<div class="content">
			<!-- 添加文章（题目，选择分类，内容） -->
			标题：<input type="text" name="blog.title" id="title"/>
			<br/><br/>
			内容：<textarea rows="20" cols="70" name="blog.content" id="textarea"></textarea>
			<input type="hidden" name="blog.time" value="<%= DateFormat.getDateTimeInstance(2,2,Locale.CHINESE).format(new java.util.Date())%>"/>
			<input type="hidden" name="blog.assortment" value="jj"/>
			<input type="submit" value="提交"/>             
             
		</div>
     </form>
     
		<div class="sidenav">

			<h1>分类目录</h1>
			<ul>
			<li><a href="error.html">没有开放</a></li>

			</ul>

			<h1>近期文章</h1>
			<ul>
			<li><a href="error.html">没有开放</a></li>

			</ul>

			<h1>友情链接</h1>
			<ul>
				<li><a href="http://www.baidu.com">小孟子</a></li>

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