/**
 * Created by Kenny on 2017/2/15.
 */
/**
 * @requires JQuery, EasyUI
 * 扩展validatebox,添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
  eqPwd: {
    validator: function(value, param){
      return value == $(param[0]).val();
    },
    message: '两次输入的密码不一致！'
  }
});
