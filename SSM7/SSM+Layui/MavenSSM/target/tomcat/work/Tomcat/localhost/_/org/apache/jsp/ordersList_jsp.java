/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-07 06:22:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ordersList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("  <title>订单管理</title>\r\n");
      out.write("  <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("  <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\"> \r\n");
      out.write("  <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("  <meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("  \r\n");
      out.write("  <link rel=\"stylesheet\" href=\"/layui/css/layui.css\"  media=\"all\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write(" \t<!-- 引用top -->\r\n");
      out.write(" \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "index_top.jsp", out, false);
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"layui-side layui-bg-black\">\r\n");
      out.write("   <!-- 引用left -->\r\n");
      out.write(" \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "index_left.jsp", out, false);
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"layui-body\">\r\n");
      out.write("    <!-- 内容主体区域 -->\r\n");
      out.write("    <div style=\"padding: 15px;\">\r\n");
      out.write("      \r\n");
      out.write("    \t<table class=\"layui-hide\" id=\"test\" lay-filter=\"test\"></table>\r\n");
      out.write("      \r\n");
      out.write("\t\t<!-- 向表格中引入操作全选按钮 -->\r\n");
      out.write("\t\t\t<script type=\"text/html\" id=\"toolbarDemo\">\r\n");
      out.write(" \t\t\t\t\t <div class=\"layui-btn-container\">\r\n");
      out.write("    \t\t\t\t\t<button class=\"layui-btn layui-btn-sm\" lay-event=\"getCheckData\">添加</button>\r\n");
      out.write("    \t\t\t\t\t<button class=\"layui-btn layui-btn-sm\" lay-event=\"getCheckLength\">获取选中数目</button>\r\n");
      out.write("    \t\t\t\t\t<button class=\"layui-btn layui-btn-sm\" lay-event=\"isAll\">验证是否全选</button>\r\n");
      out.write("  \t\t\t\t\t </div>\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t<!-- 向表格中引入 操作按钮 -->\r\n");
      out.write("\t \t\t<script type=\"text/html\" id=\"barDemo\">\r\n");
      out.write("  \t\t\t\t<a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("  \t\t\t\t<a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\r\n");
      out.write("       \r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"layui-footer\">\r\n");
      out.write("    <!-- 底部固定区域 -->\r\n");
      out.write("    © layui.com - 底部固定区域\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t<script src=\"/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//JavaScript代码区域\r\n");
      out.write("\t\tlayui.use('element', function(){\r\n");
      out.write("\t\t  var element = layui.element;\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar _hmt = _hmt || [];\r\n");
      out.write("\t\t(function() {\r\n");
      out.write("\t\t  var hm = document.createElement(\"script\");\r\n");
      out.write("\t\t  hm.src = \"https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc\";\r\n");
      out.write("\t\t  var s = document.getElementsByTagName(\"script\")[0]; \r\n");
      out.write("\t\t  s.parentNode.insertBefore(hm, s);\r\n");
      out.write("\t\t})();\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\tlayui.use(['form','table','jquery'], function(){\r\n");
      out.write("\t\t\t\t\t  var form = layui.form;\r\n");
      out.write("\t\t\t\t\t  var jquery = layui.jquery;\r\n");
      out.write("\t\t\t\t\t  var table = layui.table;\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  table.render({\r\n");
      out.write("\t\t\t\t\t\t    elem: '#test'\t\t\t//获取table id值\r\n");
      out.write("\t\t\t\t\t\t    ,url:'/orders/findPage'\t\t\t//ajax 异步请求路径\r\n");
      out.write("\t\t\t\t\t\t    ,toolbar: '#toolbarDemo'\t//向表格头部中引入操作全选按钮 \r\n");
      out.write("\t\t\t\t\t\t    ,title: '用户数据表'\t\t\t//设置导出数据时的表名\r\n");
      out.write("\t\t\t\t\t\t    ,width: 1000\t\t\t\t\t//设置整个表格的宽度\r\n");
      out.write("\t\t\t\t\t\t    ,cols: [[\t\r\n");
      out.write("\t\t\t\t\t\t    \t{type:\"checkbox\"},  //开启全选操作\r\n");
      out.write("\t\t\t\t\t\t       {field:'oid', width:100, title: 'ID', sort: true}  //sort: true;  可排序\r\n");
      out.write("\t\t\t\t\t\t      ,{field:'oname', width:120, title: '名称'}\r\n");
      out.write("\t\t\t\t\t\t      ,{field:'person', width:100, title: '下单人'}\r\n");
      out.write("\t\t\t\t\t\t      ,{field:'address', width:150, title: '地址'}\r\n");
      out.write("\t\t\t\t\t\t      ,{field:'odesc', width:150, title: '描述'}\r\n");
      out.write("\t\t\t\t\t\t      ,{field:'date', width:150, title: '时间', sort: false,fixed:false, templet: '<div>{{ layui.laytpl.toDateString(d.createdTime) }}</div>'}\r\n");
      out.write("\t\t\t\t\t\t      ,{width:220, title:\"操作\", toolbar: '#barDemo'}    //toolbar: 向表格中引入 操作按钮 \r\n");
      out.write("\t\t\t\t\t\t    ]]\r\n");
      out.write("\t\t\t\t\t\t    ,page: true\t\t\t//开启分页\r\n");
      out.write("\t\t\t\t\t\t    ,response: {\r\n");
      out.write("\t\t\t\t\t\t      statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0\r\n");
      out.write("\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t    ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据\r\n");
      out.write("\t\t\t\t\t\t      return {\r\n");
      out.write("\t\t\t\t\t\t    \t  \"code\": res.status, //解析接口状态   在编写json 是一定要注意这些命名不可改变！否则解析失败！\r\n");
      out.write("\t\t\t\t\t\t          \"msg\": res.message, //解析提示文本\r\n");
      out.write("\t\t\t\t\t\t          \"count\": res.total, //解析数据长度\r\n");
      out.write("\t\t\t\t\t\t          \"data\": res.rows.item //解析数据列表\r\n");
      out.write("\t\t\t\t\t\t      };\r\n");
      out.write("\t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t  });\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  //头工具栏事件\r\n");
      out.write("\t\t\t\t  table.on('toolbar(test)', function(obj){\r\n");
      out.write("\t\t\t\t    var checkStatus = table.checkStatus(obj.config.id);\r\n");
      out.write("\t\t\t\t    switch(obj.event){\r\n");
      out.write("\t\t\t\t      case 'getCheckData':\t\t\t\t// ---> 获取选中复选框中的数据：\r\n");
      out.write("\t\t\t\t       // var data = checkStatus.data;\r\n");
      out.write("\t\t\t\t        //layer.alert(JSON.stringify(data));\r\n");
      out.write("\t\t\t\t        //用于添加 //弹出表单对话框\r\n");
      out.write("\t\t\t\t        layer.open({\r\n");
      out.write("\t\t\t\t\t\t\ttype:\"1\",\t\t\t\t//0  就是指  提示框！\r\n");
      out.write("\t\t\t\t\t\t\ttitle:\"弹出表单\",\t\t\t//标题\r\n");
      out.write("\t\t\t\t\t\t\tskin:\"layui-layer-lan\",\t//标题的背景色\r\n");
      out.write("\t\t\t\t\t\t\tarea:[\"500px\", \"390px\"],\t//设置宽，高！\r\n");
      out.write("\t\t\t\t\t\t\t//offset:\"auto\",   默认页面居中显示！\r\n");
      out.write("\t\t\t\t\t\t\tshade:[0.8, '#2F4056'],\t\t//遮皁\r\n");
      out.write("\t\t\t\t\t\t\tshadeClose:true,\t\t\t//点击遮皁 关闭\r\n");
      out.write("\t\t\t\t\t\t\t//time:5000,\t\t\t\t//表示5秒后关闭！\r\n");
      out.write("\t\t\t\t\t\t\tanim:0,\t\t\t\t\t\t//弹出动画 0~6！\r\n");
      out.write("\t\t\t\t\t\t\tcontent:$(\"#add\")  //content:\"提示！\" 也可写入标签\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t        //表单初始赋值\r\n");
      out.write("\t\t\t\t    \t  form.val('example', {\r\n");
      out.write("\t\t\t\t    \t\t\"oid\": \"\"\r\n");
      out.write("\t\t\t\t    \t    ,\"oname\": \"\" // \"name\": \"value\"\r\n");
      out.write("\t\t\t\t    \t    ,\"person\": \"\"\r\n");
      out.write("\t\t\t\t    \t    ,\"address\": \"\"\r\n");
      out.write("\t\t\t\t    \t    ,\"odesc\": \"\"\r\n");
      out.write("\t\t\t\t    \t  })\r\n");
      out.write("\t\t\t\t      break;\r\n");
      out.write("\t\t\t\t      case 'getCheckLength':\t\t\t// ---> 全选功能的控制：\r\n");
      out.write("\t\t\t\t        var data = checkStatus.data;\r\n");
      out.write("\t\t\t\t        //循环出全选的id 编号值\r\n");
      out.write("\t\t\t\t         //定义一个数组  来承接 全选的值！\r\n");
      out.write("\t\t\t\t         var arr = new Array();\r\n");
      out.write("\t\t\t\t        for(var i=0; i<data.length; i++){\r\n");
      out.write("\t\t\t\t        \tarr[i] = data[i].uid;\r\n");
      out.write("\t\t\t\t        \t//alert(data[i].uid);\r\n");
      out.write("\t\t\t\t        }\r\n");
      out.write("\t\t\t\t        alert(arr);\r\n");
      out.write("\t\t\t\t        layer.msg('选中了：'+ data.length + ' 个');\r\n");
      out.write("\t\t\t\t      break;\r\n");
      out.write("\t\t\t\t      case 'isAll':\t\t\t\t\t\t// ---> 判断全选功能是否选中：\r\n");
      out.write("\t\t\t\t        layer.msg(checkStatus.isAll ? '全选': '未全选');\r\n");
      out.write("\t\t\t\t      break;\r\n");
      out.write("\t\t\t\t    };\r\n");
      out.write("\t\t\t\t  });\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  //监听行工具事件\r\n");
      out.write("\t\t\t\t  table.on('tool(test)', function(obj){\r\n");
      out.write("\t\t\t\t    var data = obj.data;\r\n");
      out.write("\t\t\t\t    //console.log(obj)\r\n");
      out.write("\t\t\t\t    if(obj.event === 'del'){\t\t//监听删除操作\r\n");
      out.write("\t\t\t\t      layer.confirm('真的删除行么', function(index){\r\n");
      out.write("\t\t\t\t    \t  layer.msg('ID：'+ data.uid + ' 的删除操作');\r\n");
      out.write("\t\t\t\t    \t  //使用jquery ajax进行异步删除！\r\n");
      out.write("\t\t\t\t    \t  jquery.ajax({\r\n");
      out.write("\t\t\t\t\t    \t\t url:\"/orders/delete\",\r\n");
      out.write("\t\t\t\t\t    \t\t data:\"oid=\"+data.oid,\r\n");
      out.write("\t\t\t\t\t    \t\t dataType:\"text\",\r\n");
      out.write("\t\t\t\t\t    \t\t type:\"GET\",\r\n");
      out.write("\t\t\t\t\t    \t\t success: function(data){\r\n");
      out.write("\t\t\t\t\t    \t\t\t// layer.msg('访问成功！'+data);\r\n");
      out.write("\t\t\t\t\t    \t\t\t if(data == \"1\"){\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t obj.del();\t\t\t//删除当前tr 行\r\n");
      out.write("\t\t\t\t\t    \t\t\t\t layer.msg('删除成功！');\r\n");
      out.write("\t\t\t\t\t    \t\t\t }\r\n");
      out.write("\t\t\t\t\t    \t\t },\r\n");
      out.write("\t\t\t\t\t    \t\t error: function(){\r\n");
      out.write("\t\t\t\t\t    \t\t\t layer.msg('访问失败！');\r\n");
      out.write("\t\t\t\t\t    \t\t }\r\n");
      out.write("\t\t\t\t\t    \t  })\r\n");
      out.write("\t\t\t\t        //obj.del();\t\t表示删除当前tr 行\r\n");
      out.write("\t\t\t\t        layer.close(index);\r\n");
      out.write("\t\t\t\t      });\r\n");
      out.write("\t\t\t\t    } else if(obj.event === 'edit'){\t//修改操作\r\n");
      out.write("\t\t\t\t    \t//layer.alert('编辑行：<br>'+ JSON.stringify(data));\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t    \t //弹出表单对话框\r\n");
      out.write("\t\t\t\t    \tlayer.open({\r\n");
      out.write("\t\t\t\t\t\t\ttype:\"1\",\t\t\t\t//0  就是指  提示框！\r\n");
      out.write("\t\t\t\t\t\t\ttitle:\"弹出表单\",\t\t\t//标题\r\n");
      out.write("\t\t\t\t\t\t\tskin:\"layui-layer-lan\",\t//标题的背景色\r\n");
      out.write("\t\t\t\t\t\t\tarea:[\"500px\", \"390px\"],\t//设置宽，高！\r\n");
      out.write("\t\t\t\t\t\t\t//offset:\"auto\",   默认页面居中显示！\r\n");
      out.write("\t\t\t\t\t\t\tshade:[0.8, '#2F4056'],\t\t//遮皁\r\n");
      out.write("\t\t\t\t\t\t\tshadeClose:true,\t\t\t//点击遮皁 关闭\r\n");
      out.write("\t\t\t\t\t\t\t//time:5000,\t\t\t\t//表示5秒后关闭！\r\n");
      out.write("\t\t\t\t\t\t\tanim:0,\t\t\t\t\t\t//弹出动画 0~6！\r\n");
      out.write("\t\t\t\t\t\t\tcontent:$(\"#context\")  //content:\"提示！\" 也可写入标签\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t    \t  //表单初始赋值\r\n");
      out.write("\t\t\t\t    \t  form.val('example', {\r\n");
      out.write("\t\t\t\t    \t\t\"oid\": data.oid\r\n");
      out.write("\t\t\t\t    \t    ,\"oname\": data.oname // \"name\": \"value\"\r\n");
      out.write("\t\t\t\t    \t    ,\"person\": data.person\r\n");
      out.write("\t\t\t\t    \t    ,\"address\": data.address\r\n");
      out.write("\t\t\t\t    \t    ,\"odesc\": data.odesc\r\n");
      out.write("\t\t\t\t    \t  })\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t  });\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t // <!-- 当点击编辑是不弹框， 就将如下代码加上！  -->\r\n");
      out.write("\t\t\t\t  var $ = layui.$, active = {\r\n");
      out.write("\t\t\t\t  };\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  //Layui中对时间戳的处理方式：\r\n");
      out.write("\t\t\t\t\tlayui.laytpl.toDateString = function(d, format){\r\n");
      out.write("\t\t\t\t\t  var date = new Date(d || new Date())\r\n");
      out.write("\t\t\t\t\t  ,ymd = [\r\n");
      out.write("\t\t\t\t\t\tthis.digit(date.getFullYear(), 4)\r\n");
      out.write("\t\t\t\t\t\t,this.digit(date.getMonth() + 1)\r\n");
      out.write("\t\t\t\t\t\t,this.digit(date.getDate())\r\n");
      out.write("\t\t\t\t\t  ]\r\n");
      out.write("\t\t\t\t\t  ,hms = [\r\n");
      out.write("\t\t\t\t\t\tthis.digit(date.getHours())\r\n");
      out.write("\t\t\t\t\t\t,this.digit(date.getMinutes())\r\n");
      out.write("\t\t\t\t\t\t,this.digit(date.getSeconds())\r\n");
      out.write("\t\t\t\t\t  ];\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t\t\t // format = format || 'yyyy-MM-dd HH:mm:ss';\r\n");
      out.write("\t\t\t\t\t\t format = format || 'yyyy.MM.dd';\r\n");
      out.write("\t\t\t\t\t  return format.replace(/yyyy/g, ymd[0])\r\n");
      out.write("\t\t\t\t\t  .replace(/MM/g, ymd[1])\r\n");
      out.write("\t\t\t\t\t  .replace(/dd/g, ymd[2])\r\n");
      out.write("\t\t\t\t\t  .replace(/HH/g, hms[0]);\r\n");
      out.write("\t\t\t\t\t  //.replace(/mm/g, hms[1])\r\n");
      out.write("\t\t\t\t\t  //.replace(/ss/g, hms[2]);\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t\t\t//数字前置补零\r\n");
      out.write("\t\t\t\t\tlayui.laytpl.digit = function(num, length, end){\r\n");
      out.write("\t\t\t\t\t  var str = '';\r\n");
      out.write("\t\t\t\t\t  num = String(num);\r\n");
      out.write("\t\t\t\t\t  length = length || 2;\r\n");
      out.write("\t\t\t\t\t  for(var i = num.length; i < length; i++){\r\n");
      out.write("\t\t\t\t\t\tstr += '0';\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  return num < Math.pow(10, length) ? str + (num|0) : num;\r\n");
      out.write("\t\t\t\t\t};  \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<!-- 修改 -->\r\n");
      out.write("<div id=\"context\" style=\"display: none;\">\r\n");
      out.write("\t\t<div style=\"padding-right: 30px;\">\r\n");
      out.write("\t\t\t\t<form class=\"layui-form\" action=\"/orders/update\" method=\"post\"  lay-filter=\"example\">\t\t<!-- layui-form 表单  -->\r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t  <br/>\r\n");
      out.write("\t\t\t\t\t  <input type=\"hidden\" name=\"oid\" />\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">名称</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"oname\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t <div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">下单人</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"person\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">地址</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"address\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">描述</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"odesc\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\">立即提交</button>\r\n");
      out.write("\t\t\t\t\t      <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 添加 -->\r\n");
      out.write("\t<div id=\"add\" style=\"display: none;\">\r\n");
      out.write("\t\t<div style=\"padding-right: 30px;\">\r\n");
      out.write("\t\t\t\t<form class=\"layui-form\" id=\"addform\" action=\"/orders/add\" method=\"post\"  lay-filter=\"example\">\t\t<!-- layui-form 表单  -->\r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t  <br/>\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">名称</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"oname\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t <div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">下单人</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"person\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">地址</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"address\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item\">   <!-- layui-form-item 表示一行 -->\r\n");
      out.write("\t\t\t\t\t    <label class=\"layui-form-label\">描述</label>\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <input type=\"text\" name=\"odesc\" required  lay-verify=\"required\" placeholder=\"请输入标题\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  <div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t    <div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t      <button class=\"layui-btn\" lay-submit lay-filter=\"formDemo\">立即提交</button>\r\n");
      out.write("\t\t\t\t\t      <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}