<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>home</title>
    <%-- easyui js 引入--%>
    <script type="text/javascript" src="jslib/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
    <%-- easyui 样式引入--%>
    <link rel="stylesheet" href="jslib/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="jslib/jquery-easyui-1.5.1/themes/icon.css" type="text/css">
  </head>
  <body class="easyui-layout">
	  <div data-options="region:'north'" style="height:60px;"></div>
	  <div data-options="region:'south'" style="height:20px;"></div>
	  <div data-options="region:'west',split:true" style="width:200px;">
		  <div class="easyui-panel" data-options="title:'ssss',border:false,fit:true"></div>
	  </div>
	  <div data-options="region:'east',title:'East'" style="width:200px;"></div>
	  <div data-options="region:'center',title:'Center'"></div>
  </body>
</html>
