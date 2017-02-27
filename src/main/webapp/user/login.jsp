<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
  $(function () {
    
  });
</script>
<!-- 登录页 -->
<div id="user_login_loginDialog" class="easyui-dialog" title="登录" data-options="modal:true,closable:false,
				buttons: [{
					text:'注册',
					iconCls:'icon-edit',
					handler:function(){
					  $('#user_reg_regForm input').val('');
						$('#user_reg_regDialog').dialog('open');
					}
				},{
					text:'登录',
					iconCls:'icon-help',
					handler:function(){
						$('#user_login_loginForm').form('submit', {
              url: '${pageContext.request.contextPath}/userAction!login',
              success: function (data) {
                var obj = $.parseJSON(data);
                if (obj.success) {
                  $('#user_login_loginDialog').dialog('close');
                }
                $.messager.show({
                    title:'提示',
                    msg:obj.msg,
                    timeout:5000,
                    showType:'slide'
                });
              }
            });
					}
				}]
			">
  <form id="user_login_loginForm" method="post">
    <table>
      <tr>
        <th>登录名</th>
        <td><input autofocus="autofocus" name="name" value="root" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'用户名不能为空!'"/></td>
      </tr>
      <tr>
        <th>密码</th>
        <td><input name="pwd" type="password" value="root" class="easyui-validatebox" data-options="required:true,missingMessage:'密码不能为空!'"/></td>
      </tr>
    </table>
  </form>
</div>
