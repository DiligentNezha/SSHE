<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
  $(function () {
    $('#admin_usermanager_datagrid').datagrid({
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
      ]],
      toolbar: '#admin_usermanager_tb'
    });
  });

  function searchFun() {
    var val = $('#admin_usermanager_layout input[name=name]').val();
    $('#admin_usermanager_datagrid').datagrid('load', {
      name: val
    });
  }

  function clearFun() {
    var val = $('#admin_usermanager_layout input[name=name]').val('');
    $('#admin_usermanager_datagrid').datagrid('load', {});
  }
</script>

<div id="admin_usermanager_layout" class="easyui-layout" data-options="fit:true,border:false">
  <div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
    <input name="name" type="text"/>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun()">查询</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear',plain:true" onclick="clearFun()">清除</a>
  </div>
  <div data-options="region:'center'">
    <table id="admin_usermanager_datagrid"></table>
  </div>
</div>

<div id="admin_usermanager_tb">
  <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="float: left;">编辑</a>
  <div class="datagrid-btn-separator"></div>
  <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">帮助</a>
</div>