<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
  $(function () {
    $('#admin_usermanager_datagrid').treegrid({
      url: '${pageContext.request.contextPath}/userAction!datagrid',
      fit: true,
      border: false,
      pagination: true,
      fitColumns: true,
      rownumbers: true,
      idField: 'id',
      sortName: 'name',
      sortOrder: 'asc',
      frozenColumns: [[
        {title: '编号', field: 'id', width: 150, hidden: true},
        {title: '名称', field: 'name', width: 150, sortable: true}
      ]],
      columns: [[
        {title: '密码', field: 'pwd', width: 150},
        {title: '创建时间', field: 'createTime', width: 150, sortable: true},
        {title: '修改时间', field: 'modifyTime', width: 150, sortable: true}
      ]]
    });
  });
</script>
<table id="admin_usermanager_datagrid"></table>