<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function ()
        {
            //region 初始化商品信息表
            ini_goods();
            //endregion
        }
    );

    //region 初始化商品信息表格
    /**
     * 初始化商品信息表格
     */
    function ini_goods()
    {
        $('#tb_goods').datagrid
        (
            {
                //工具栏
                toolbar: '#toolbar',
                showHeader: true,
                pagination: true,
                singleSelect: false,
                rownumbers: true,
                url: '/tinyshop8/showAllGoods.com?username=' + $('#hidden_username').val()
            }
        );
    }
    //endregion


</script>