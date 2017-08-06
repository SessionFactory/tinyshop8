<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="qin.tinyshop8.domain8.jpa.GoodsType8JPA" %>
<%@ page import="qin.tinyshop8_page.dao.GoodsTypeDAO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="http://localhost/jsLib2017/jquery/v2.2.0.js"></script>
    <script type="text/javascript" src="http://localhost/bootstrap3/js/bootstrap.js"></script>
    <link rel="stylesheet" href="http://localhost/bootstrap3/css/bootstrap.css">
</head>

<script type="text/javascript">
    $(function ()
        {
            $('#doAdd').click(function ()
                {
                    var type_name = $('#type_name').val();
                    var type_alias = $('#type_alias').val();
                    var type_sort = $('#type_sort').val();
                    //var parent = $('#parent option:selected')[0].innerText;
                    var parent = 0;
                    var _select = $('#parent option:selected')[0];
                    if (_select != undefined)
                    {
                        parent = _select.innerText;
                    }

                    var url = "/tinyshop8_goodstype/add.com?type_name=" + type_name +
                        "       &&type_alias=" + type_alias +
                        "       &&type_sort=" + type_sort +
                        "       &&parent=" + parent;

                    $.ajax
                    (
                        {
                            url: url,
                            method: 'POST',
                            success: function (msg)
                            {
                                alert(msg);
                            }
                        }
                    )
                }
            );
        }
    );
</script>

<body style="margin-left: 10%;">

类型名称:
<input type="text" id="type_name" class="form-control"><br><br>
类型别名:
<input type="text" id="type_alias" class="form-control"><br><br>
排序:
<input type="text" id="type_sort" class="form-control"><br><br>
上级分类:
<select id="parent" style="width: 500px;">
    <%
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        GoodsTypeDAO goodsTypeDAO = (GoodsTypeDAO)
                applicationContext.getBean("goodsTypeDAOImpl");
        List<GoodsType8JPA> goodsType8JPAList =
                (List<GoodsType8JPA>) goodsTypeDAO.findAll().getSearchList();
        for (int i = 0; i < goodsType8JPAList.size(); i++)
        {
            GoodsType8JPA goodsType8JPA = goodsType8JPAList.get(i);
            out.println(new StringBuilder()
                                .append("<option value=\"")
                                .append(i)
                                .append("\">")
                                .append(goodsType8JPA.getTypeName())
                                .append("</option>").toString());
        }
    %>
</select>
<br><br>
<input type="button" class="btn btn-success" value="新增" id="doAdd">

</body>
</html>