<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
