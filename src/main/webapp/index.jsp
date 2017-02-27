<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>home</title>
  <%-- easyui 样式引入--%>
  <link rel="stylesheet" href="jslib/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css">
  <link rel="stylesheet" href="jslib/jquery-easyui-1.5.1/themes/icon.css" type="text/css">
  <%-- easyui js 引入--%>
  <script type="text/javascript" src="jslib/jquery-easyui-1.5.1/jquery.min.js"></script>
  <script type="text/javascript" src="jslib/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="jslib/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
  
  <%-- 自定义工具js库引入--%>
  <script type="text/javascript" src="jslib/myjsutils/myUtils.js"></script>
  
  <script type="text/javascript">
    $(function () {
      
    });
    
    function addTabs(opts) {
      var t = $('#index_centerTabs');
      if (t.tabs('exists', opts.title)) {
        t.tabs('select', opts.title);
      } else {
        t.tabs('add', opts);
      }
    }
  </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:60px;"></div>
<div data-options="region:'south'" style="height:20px;"></div>
<div data-options="region:'west',split:true" style="width:200px;">
  <div class="easyui-panel" data-options="title:'功能树',border:false,fit:true">
    <div class="easyui-accordion" data-options="fit:true,border:false">
      <div title="功能导航" data-options="iconCls:'icon-save'">
        <ul class="easyui-tree" data-options="
        url:'${pageContext.request.contextPath}/menuAction!getTree',
        lines:'true',
        onClick: function(node){
          if(node.attributes.url) {
            var url = '${pageContext.request.contextPath}' + node.attributes.url;
            addTabs({title:node.text,closable:true,href:url});
          }
        }"></ul>
      </div>
      <div title="系统菜单" data-options="iconCls:'icon-reload'">
      </div>
    </div>
  </div>
</div>
<div data-options="region:'east',title:'East'" style="width:200px;"></div>
<div data-options="region:'center',title:'欢迎浏览SSHE项目演示'">
  <div id="index_centerTabs" class="easyui-tabs" data-options="fit:true,border:false">
    <div title="首页" data-options="closable:true">
      tab1
    </div>
  </div>
</div>

<jsp:include page="user/login.jsp"></jsp:include>

<jsp:include page="user/reg.jsp"></jsp:include>

</body>
</html>
