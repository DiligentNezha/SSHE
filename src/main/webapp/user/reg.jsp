<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 注册页 -->
<script type="text/javascript">
  $(function(){
    
  });
</script>
<div id="user_reg_regDialog" class="easyui-dialog" title="注册" data-options="modal:true,closed:true,
				buttons: [{
					text:'注册',
					iconCls:'icon-edit',
					handler:function(){
					  $('#user_reg_regForm').form('submit', {
              url: '${pageContext.request.contextPath}/userAction!reg',
              success: function (data) {
                var obj = $.parseJSON(data);
                if (obj.success) {
                  $('#user_reg_regDialog').dialog('close');
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
				}]">
  <form id="user_reg_regForm" method="post">
    <table>
      <tr>
        <th>登录名</th>
        <td><input autofocus="autofocus" id="name" name="name" type="text" class="easyui-validatebox" data-options="required:true"/></td>
      </tr>
      <tr>
        <th>密码</th>
        <td><input id="pwd" name="pwd" type="password" class="easyui-validatebox" data-options="required:true"/></td>
      </tr>
      <tr>
        <th>重复密码</th>
        <td><input id="rePwd" name="rePwd" type="password" class="easyui-validatebox" data-options="required:true"
                   validType="eqPwd['#pwd']"/></td>
      </tr>
    </table>
  </form>
</div>
