<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
  function addTabs(opts) {
    var t = $('#layout_center_tabs');
    if (t.tabs('exists', opts.title)) {
      t.tabs('select', opts.title);
    } else {
      t.tabs('add', opts);
    }
  }
</script>
<div id="layout_center_tabs" class="easyui-tabs" data-options="fit:true,border:false" style="overflow:hidden;">
  <div title="首页" data-options="closable:true">
    tab1
  </div>
</div>
