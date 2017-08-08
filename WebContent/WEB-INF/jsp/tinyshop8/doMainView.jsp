<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>tinyshop8主页</title>
    <jsp:include page="/WEB-INF/include_easyui.jsp"></jsp:include>
    <jsp:include page="js/doMainViewJS.jsp"></jsp:include>
</head>

<%--
     顶部工具栏

        增删改查


     新增商品信息:
     1.根据已登录的用户来实现新增功能
     2.弹出新增对话框
        {
            goodsName, nullable(400)
            goodsAddDate, nullable
            goodsCostPrice, nullable
            godosMarketPrice, nullable
            goodsProNo, nullable(50)
            goodsSellPrice, nullable
            goodsStoreNums, nullable
            goodsNo, 300
            goodsWeight, nullable(10)
            goodsSubTitle, 800
            goodsType
            goodsImgsList 多个文本框(提供5个)
            goodsKeyWords 根据逗号分隔
        }

     3.实现新增
--%>

<body class="easyui-layout" style="width:100%;height:100%;font-family: 微软雅黑;">
<div data-options="region:'east',split:true" title="消息框" style="width:100px;"></div>
<div data-options="region:'west',split:true" title="导航" style="width:100px;"></div>
<div data-options="region:'center',title:'首页',iconCls:'icon-ok'">

    <%-- 获取密码 --%>
    <%
        if (request.getSession().getAttribute("password") == null)
        {
            //language=html
            out.println("<font style='font-size: 200px; " +
                                "color: red; font-weight: bold;'>请先登录!</font><br>");
        }
    %>
    <%-- 获取密码 --%>

    <%
        String username = request.getParameter("username");
    %>
    <input type="hidden" id="hidden_username" value="<%=username%>">

    <table class="easyui-datagrid" title="商品信息表" id="tb_goods">
        <thead>
        <tr>
            <th data-options="field:'goodsId',width:80, align:'center' ">商品编号</th>
            <th data-options="field:'goodsName',width:500, align:'center' ">商品名称</th>
            <th data-options="field:'goodsProNo',width:80, align:'center' ">商品编号</th>
            <th data-options="field:'goodsAddDate',width:200, align:'center' ">商品添加日期</th>
            <th data-options="field:'goodsMarketPrice',width:250, align:'center' ">商品市场价</th>
            <th data-options="field:'goodsType',width:200,align:'center'">商品类型</th>
            <th data-options="field:'goodsBrand',width:200,align:'center'">商品品牌</th>
        </tr>
        </thead>
    </table>

    <%-- 工具栏 --%>
    <div id="toolbar">
        <a id="btn_add" class="easyui-linkbutton c1" data-options="iconCls:'icon-add'">
            新增商品信息
        </a>
        　
        <a id="btn_delete" class="easyui-linkbutton c2" data-options="iconCls:'icon-cut'">
            删除商品信息
        </a>
        　
        <a id="btn_search" class="easyui-linkbutton c3" data-options="iconCls:'icon-search'">
            查找商品信息
        </a>
    </div>

</div>
</body>

<%--
空格
[　]
--%>

</html>