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
      toolbar: [{
        text: '增加',
        iconCls: 'icon-add',
        handler: function () {
          append()
        }
      }, '-', {
        text: '删除',
        iconCls: 'icon-remove',
        handler: function () {

        }
      }, '-', {
        text: '修改',
        iconCls: 'icon-edit',
        handler: function () {

        }
      }, '-', {
        text: '清除',
        iconCls: 'icon-clear',
        handler: function () {

        }
      }]
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

  function append() {
    $('#admin_usermanager_addDialog').dialog('open');
  }
</script>

<div id="admin_usermanager_layout" class="easyui-layout" data-options="fit:true,border:false">
  <div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
    <form id="admin_usermanager_searchForm">
      <input name="name" type="text"/>
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun()">查询</a>
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear',plain:true" onclick="clearFun()">清除</a>
    </form>
  </div>
  <div data-options="region:'center'">
    <table id="admin_usermanager_datagrid"></table>
  </div>
</div>

<div id="admin_usermanager_addDialog" class="easyui-dialog"
     data-options="closed:true,modal:true,title:'添加用户',buttons:[{
        text:'添加',
        iconCls:'icon-add',
        handler:function(){
          $('#admin_usermanager_addForm').form('submit', {
            url: '${pageContext.request.contextPath}/userAction!add',
            success: function (data) {
              var obj = $.parseJSON(data);
              if (obj.success) {
                $('#admin_usermanager_datagrid').datagrid('load');
                $('#admin_usermanager_addDialog').dialog('close');
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
     }]" style="width: 300px; height: 300px;" align="center">
  <form id="admin_usermanager_addForm">
    <table>
      <tr>
        <th>编号</th>
        <td><input type="text" name="id" class="easyui-validatebox" data-options="readonly:true"></td>
      </tr>
      <tr>
        <th>登录名称</th>
        <td><input type="text" class="easyui-validatebox" data-options="required:true" name="name"></td>
      </tr>
      <tr>
        <th>密码</th>
        <td><input type="password" class="easyui-validatebox" data-options="required:true" name="pwd"></td>
      </tr>
    </table>
  </form>
</div>