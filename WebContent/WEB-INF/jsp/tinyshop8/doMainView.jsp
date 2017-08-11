<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="qin.tinyshop8_page.controller.TinyShop8Controller" %>
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
        <a id="btn_add" class="easyui-linkbutton c1" data-options="iconCls:'icon-add'"
           onclick="openAddDialog()">
            新增商品信息
        </a>
        　
        <a id="btn_delete" class="easyui-linkbutton c2" data-options="iconCls:'icon-cut'">
            删除商品信息
        </a>
        　
        <a id="btn_search" class="easyui-linkbutton c3" data-options="iconCls:'icon-search'">
            查找商品信息
        </a>
    </div>

    <%-- 新增对话框 --%>
    <div id="addGoods_dialog">
        <style type="text/css">
            input
            {
                font-family: 微软雅黑;
            }

            .textbox
            {
                border: 1px solid brown;
            }

            .textbox textarea.textbox-text
            {
                white-space: pre-wrap;
                font-family: 微软雅黑;
            }

        </style>

        <body style="font-family: 微软雅黑; font-size: 16px;">
        <div class="easyui-panel" title="新增商品" style="width:100%;padding:30px 60px">
            <div style="margin-bottom:20px">
                <div>商品名称(nullable, 400)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsName">
            </div>
            <div style="margin-bottom:20px">
                <div>商品新增日期(nullable)</div>
                <input class="easyui-datetimebox" style="width:50%;height: 32px;" \
                       id="goodsAddDate">
            </div>
            <div style="margin-bottom:20px">
                <div>商品成本价(nullable)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsCostPrice">
            </div>
            <div style="margin-bottom:20px">
                <div>商品市场价(nullable)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsMarketPrice">
            </div>
            <div style="margin-bottom:20px">
                <div>商品编号(nullable, 50)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsProNo">
            </div>
            <div style="margin-bottom:20px">
                <div>商品销售价格(nullable)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsSellPrice">
            </div>
            <div style="margin-bottom:20px">
                <div>商品库存(nullable)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsStoreNums">
            </div>
            <div style="margin-bottom:20px">
                <div>商品编码</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsNo">
            </div>
            <div style="margin-bottom:20px">
                <div>商品重量</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsWeight">
            </div>
            <div style="margin-bottom:20px">
                <div>商品副标题(800)</div>
                <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                       id="goodsSubTitle">
            </div>
            <div style="margin-bottom:20px">
                <div>商品类型(nullable)</div>
                <div id="div_goodsType">
                    <select class="easyui-combobox" id="goodsType" style="width:500px;">
                        <%
                            ApplicationContext applicationContext = new
                                    ClassPathXmlApplicationContext("applicationContext.xml");
                            TinyShop8Controller tinyShop8Controller =
                                    (TinyShop8Controller) applicationContext
                                            .getBean("_TinyShop8Controller");
                            out.println(tinyShop8Controller.showGoodsTypeCombobox());
                        %>
                    </select>
                </div>
            </div>
            <div style="margin-bottom:20px">
                <div>商品图片</div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                           id="goodsImgs1">
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                           id="goodsImgs2">
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                           id="goodsImgs3">
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                           id="goodsImgs4">
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" style="width:100%;height:32px" type="text"
                           id="goodsImgs5">
                </div>
            </div>
            <div style="margin-bottom:20px">
                <div>商品关键词</div>
                <input class="easyui-textbox" data-options="multiline:true"
                       style="width:100%;height:100px;" id="goodsKeyWords" type="text">
            </div>
            <div>
                <a href="#" class="easyui-linkbutton c4" iconCls="icon-add"
                   style="width:100%;height:32px" onclick="addGoods()">新增</a>
            </div>
        </div>
        </body>
    </div>
    <%-- 新增对话框 --%>

</div>
</body>

<%--
空格
[　]
--%>

</html>