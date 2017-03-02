<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="admin_useredit_editForm" method="post">
  <table>
    <tr>
      <td><input type="hidden" name="id" class="easyui-validatebox" data-options="readonly:true"></td>
    </tr>
    <tr>
      <th>登录名称</th>
      <td><input type="text" class="easyui-validatebox" data-options="required:true" name="name"></td>
    </tr>
    <tr>
      <th>密码</th>
      <td><input type="password" class="easyui-validatebox" data-options="required:true" name="pwd"></td>
    </tr>
    <tr>
      <th>创建时间</th>
      <td><input type="datetime" class="easyui-validatebox" data-options="required:true,readonly:true" name="createTime"></td>
    </tr>
  </table>
</form>
