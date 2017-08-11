<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function ()
        {
            //region 初始化商品信息表
            ini_goods();
            //endregion

            //region 初始化对话框
            $('#addGoods_dialog').dialog
            (
                {
                    title: '新增商品对话框',
                    width: 700,
                    height: 800,
                    closed: true,
                    modal: true
                }
            );

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

    //region 点击新增时弹出新增对话框
    /**
     * 点击新增时弹出新增对话框
     */
    function openAddDialog()
    {
        $('#addGoods_dialog').dialog('open');
    }
    //endregion

    //region 新增实现

    //region 定义访问基本路径
    /** 定义访问基本路径*/
    var basePath = "/tinyshop8/";
    //endregion

    //region 在对商品进行新增或更新之前做判断
    /**
     * 在对商品进行新增或更新之前做判断(传递参数的时候必须有值)
     *
     * @param goodsName 商品名称(nullable, 400)
     * @param goodsAddDate 商品新增日期(nullable)
     * @param goodsCostPrice 商品成本价(nullable)
     * @param goodsMarketPrice 商品市场价(nullable)
     * @param goodsProNo 商品编号(nullable, 50)
     * @param goodsSellPrice 商品销售价格(nullable)
     * @param goodsStoreNums 商品库存(nullable)
     * @param goodsSubTitle 商品副标题(800)
     * @param goodsType 商品类型(nullable)
     * @returns {boolean}
     * 如果符合条件返回true 否则返回false
     * 并且报出提示信息
     */
    function checkGoods(goodsName, goodsAddDate,
                        goodsCostPrice, goodsMarketPrice, goodsProNo,
                        goodsSellPrice, goodsStoreNums, goodsSubTitle,
                        goodsType)
    {
        //逐个判, 最后将所有的条件&上, 如果为真就返回true
        //判断失败就返回false

        // @param goodsName 商品名称(nullable, 400)
        var check_goodsName = (goodsName.length > 0) &&
            (goodsName.length < 400);
        if (!check_goodsName)
        {
            msgAlert("商品名称不能为空");
            return false;
        }
        // @param goodsAddDate 商品新增日期(nullable)
        var check_goodsAddDate = goodsAddDate.length > 0;
        if (!check_goodsAddDate)
        {
            msgAlert("商品新增日期不能为空!");
            return false;
        }
        // @param goodsCostPrice 商品成本价(nullable)
        var check_goodsCostPrice = goodsCostPrice.length > 0;
        if (!check_goodsCostPrice)
        {
            msgAlert("商品成本价不能为空!");
            return false;
        }
        // @param goodsMarketPrice 商品市场价(nullable)
        var check_goodsMarketPrice = goodsMarketPrice.length > 0;
        if (!check_goodsMarketPrice)
        {
            msgAlert("商品市场价不能为空!");
            return false;
        }
        // @param goodsProNo 商品编号(nullable, 50)
        var check_goodsProNo = (goodsProNo.length > 0) &&
            (goodsProNo.length < 50);
        if (!check_goodsProNo)
        {
            msgAlert("商品编号不能为空并且只能在50个字符之内!")
            return false;
        }
        // @param goodsSellPrice 商品销售价格(nullable)
        var check_goodsSellPrice = goodsSellPrice.length > 0;
        if (!check_goodsSellPrice)
        {
            msgAlert("商品销售价格必须不为空!");
            return false;
        }
        // @param goodsStoreNums 商品库存(nullable)
        var check_goodsStoreNums = goodsStoreNums.length > 0;
        if (!check_goodsStoreNums)
        {
            msgAlert("商品库存不能为空!");
            return false;
        }
        // @param goodsSubTitle 商品副标题(800)
        var check_goodsSubTitle = goodsSubTitle.length < 800;
        if (!check_goodsSubTitle)
        {
            msgAlert("商品副标题不能超过800个字符!");
            return false;
        }
        // @param goodsType 商品类型(nullable)
        var check_goodsType = goodsType.length > 0;
        if (!check_goodsType)
        {
            msgAlert("商品类型不能为空!");
            return false;
        }

        //总体判断并返回
        return check_goodsName && check_goodsAddDate &&
            check_goodsCostPrice && check_goodsMarketPrice &&
            check_goodsProNo && check_goodsSellPrice &&
            check_goodsStoreNums && check_goodsSubTitle &&
            check_goodsType;
    }
    //endregion

    //region 将消息提示封装
    /**
     * 将消息提示封装
     *
     * @param msg 需要输出的信息
     */
    function msgAlert(msg)
    {
        $.messager.alert('警告!', msg, 'error');
    }
    //endregion

    //region 新增商品信息
    /**
     * 新增商品信息
     */
    function addGoods()
    {
        //region 接收界面的数据

        //商品名称
        var goodsName = $('#goodsName').val();
        //商品新增日期
        var goodsAddDate = $('#goodsAddDate').datetimebox('getValue');
        //商品成本价
        var goodsCostPrice = $('#goodsCostPrice').val();
        //商品市场价
        var goodsMarketPrice = $('#goodsMarketPrice').val();
        //商品编号
        var goodsProNo = $('#goodsProNo').val();
        //商品销售价格
        var goodsSellPrice = $('#goodsSellPrice').val();
        //商品库存
        var goodsStoreNums = $('#goodsStoreNums').val();
        //商品编码
        var goodsNo = $('#goodsNo').val();
        //商品重量
        var goodsWeight = $('#goodsWeight').val();
        //商品副标题
        var goodsSubTitle = $('#goodsSubTitle').val();
        //商品类型
        var goodsType = $('#goodsType').combobox('getText');
        //商品图片
        var goodsImgs1 = $('#goodsImgs1').val();
        var goodsImgs2 = $('#goodsImgs2').val();
        var goodsImgs3 = $('#goodsImgs3').val();
        var goodsImgs4 = $('#goodsImgs4').val();
        var goodsImgs5 = $('#goodsImgs5').val();
        //商品关键词
        var goodsKeyWords = $('#goodsKeyWords').val();

        //检查
        var flag = checkGoods(goodsName, goodsAddDate,
            goodsCostPrice, goodsMarketPrice, goodsProNo,
            goodsSellPrice, goodsStoreNums, goodsSubTitle,
            goodsType);

        if (!flag)
        {
            msgAlert("不满足要求, 不能新增!");
            return;
        }

        //拼接图片
        var goodsImage = [];

        doPush(goodsImgs1, goodsImage);
        doPush(goodsImgs2, goodsImage);
        doPush(goodsImgs3, goodsImage);
        doPush(goodsImgs4, goodsImage);
        doPush(goodsImgs5, goodsImage);

        //endregion

        //指定新增链接
        var addURL = basePath + "addGoods.com?goodsName=" + goodsName +
            "       &&goodsAddDate=" + goodsAddDate +
            "       &&goodsCostPrice=" + goodsCostPrice +
            "       &&goodsMarketPrice=" + goodsMarketPrice +
            "       &&goodsProNo=" + goodsProNo +
            "       &&goodsSellPrice=" + goodsSellPrice +
            "       &&goodsStoreNums=" + goodsStoreNums +
            "       &&goodsNo=" + goodsNo +
            "       &&goodsWeight=" + goodsWeight +
            "       &&goodsSubTitle=" + goodsSubTitle +
            "       &&goodsType=" + goodsType +
            "       &&goodsImages=" + goodsImage.toString() +
            "       &&goodsKeyWords=" + goodsKeyWords;

        console.log(addURL);

        //$('#goodsAddDate').datetimebox('getValue');
        //$('#goodsType').combobox('getText')
    }

    //endregion

    //region 封装图片方法
    /**
     * 封装图片方法<br>
     *     将图片放进数组里然后转成字符串
     *
     * @param goodsImage 图片控件
     * @param array 数组
     */
    function doPush(goodsImage, array)
    {
        if (goodsImage.length > 0) array.push(goodsImage + ",");
    }
    //endregion

    //endregion

</script>