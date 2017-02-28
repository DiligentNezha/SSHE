<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
  $(function () {
    $('#admin_usermanager_datagrid').treegrid({
      url: '${pageContext.request.contextPath}/userAction!datagrid',
      border:false,
      fit:true,
      columns: [[
        {title: '编号', field: 'id', width: 80},
        {title: '名称', field: 'name', width: 150},
        {title: '密码', field: 'pwd', width: 150},
        {title: '创建时间', field: 'createTime', width: 150},
        {title: '修改时间', field: 'modifyTime', width: 150}
      ]]
    });
  });
</script>
<table id="admin_usermanager_datagrid"></table>
