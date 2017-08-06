<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function ()
            {
                //region 初始化商品信息表
                $('#tb_goods').datagrid
                (
                        {
                            showHeader: true,
                            pagination: true,
                            singleSelect: false,
                            rownumbers: true,
                            url: '/tinyshop8/showAllGoods.com?username=' + $('#hidden_username').val()
                        }
                );
                //endregion
            }
    );
</script>