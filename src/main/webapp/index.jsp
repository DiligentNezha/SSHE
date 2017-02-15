<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
          $('#index_regForm').form({
              url:'',
              success:function(data){
              }
        });
      });
    </script>
    
  </head>
  <body class="easyui-layout">
	  <div data-options="region:'north'" style="height:60px;"></div>
	  <div data-options="region:'south'" style="height:20px;"></div>
	  <div data-options="region:'west',split:true" style="width:200px;">
		  <div class="easyui-panel" data-options="title:'west',border:false,fit:true"></div>
	  </div>
	  <div data-options="region:'east',title:'East'" style="width:200px;"></div>
	  <div data-options="region:'center',title:'Center'"></div>
	  
	  <div class="easyui-dialog" title="登录" data-options="modal:true,closable:false,
				buttons: [{
					text:'注册',
					iconCls:'icon-edit',
					handler:function(){
						$('#index_regDialog').dialog('open');
					}
				},{
					text:'登录',
					iconCls:'icon-help',
					handler:function(){
						alert('cancel');;
					}
				}]
			">
			  <table>
				  <tr>
					  <th>登录名</th>
					  <td><input type="text"/></td>
				  </tr>
				  <tr>
					  <th>密码</th>
					  <td><input type="password"/></td>
				  </tr>
			  </table>
	  </div>
	
	  
	  <div id="index_regDialog" class="easyui-dialog" title="注册" data-options="modal:true,closed:true,
				buttons: [{
					text:'注册',
					iconCls:'icon-edit',
					handler:function(){
					  $('#index_regForm').submit();
					}
				}]
			">
		  <form id="index_regForm" method="post">
			  <table>
				  <tr>
					  <th>登录名</th>
					  <td><input id="name" name="name" type="text" class="easyui-validatebox" data-options="required:true"/></td>
				  </tr>
				  <tr>
					  <th>密码</th>
					  <td><input id="pwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true"/></td>
				  </tr>
				  <tr>
					  <th>重复密码</th>
					  <td><input id="rePwd" name="rePwd" type="password" class="easyui-validatebox" data-options="required:true" validType="eqPwd['#pwd']"/></td>
				  </tr>
			  </table>
		  </form>
	  </div>
  
  </body>
</html>
