<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>home</title>
  <%-- easyui 样式引入--%>
  <link rel="stylesheet" href="js/jquery-easyui-1.5.1/themes/bootstrap/easyui.css" type="text/css">
  <link rel="stylesheet" href="js/jquery-easyui-1.5.1/themes/icon.css" type="text/css">
  <%-- easyui js 引入--%>
  <script type="text/javascript" src="js/jquery-easyui-1.5.1/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
  <%-- 自定义工具js库引入--%>
  <script type="text/javascript" src="js/myjsutils/myUtils.js"></script>
  

</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:60px;"></div>
<div data-options="region:'south'" style="height:20px;"></div>

<div data-options="region:'west',split:true" style="width:200px;">
  <jsp:include page="layout/west.jsp"></jsp:include>
</div>
<div data-options="region:'east',title:'East'" style="width:200px;"></div>

<div data-options="region:'center',title:'欢迎浏览SSHE项目演示'" style="overflow: hidden;">
  <jsp:include page="layout/center.jsp"/>
</div>

<jsp:include page="user/login.jsp"/>

<jsp:include page="user/reg.jsp"/>

</body>
</html>
