package qin.tinyshop8_page.controller._abstract;

import org.springframework.web.servlet.ModelAndView;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8_page.controller.TinyShop8Controller;
import qin.tinyshop8_page.service.GoodsBrandService;
import qin.tinyshop8_page.service.GoodsService;
import qin.tinyshop8_page.service.GoodsTypeService;
import qin.tinyshop8_page.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 抽象的tinyshop商城控制层系统
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
@SuppressWarnings("all")
public abstract class TinyShop8ControllerImpl
          implements TinyShop8Controller
{
    private static final long serialVersionUID = 1460315797915409433L;

    //region 注入服务层

    //region 注入用户服务层
    protected UserService userService;

    @Resource
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
    //endregion

    //region 商品类型服务层
    /**
     * 商品类型服务层
     */
    protected GoodsTypeService goodsTypeService;

    @Resource
    public void setGoodsTypeService(GoodsTypeService goodsTypeService)
    {
        this.goodsTypeService = goodsTypeService;
    }
    //endregion

    //region 商品品牌服务层
    /**
     * 商品品牌服务层
     */
    protected GoodsBrandService goodsBrandService;

    //@Resource
    public void setGoodsBrandService(GoodsBrandService goodsBrandService)
    {
        this.goodsBrandService = goodsBrandService;
    }
    //endregion

    //region 商品服务层
    /**
     * 商品服务层
     */
    protected GoodsService goodsService;

    @Resource
    public void setGoodsService(GoodsService goodsService)
    {
        this.goodsService = goodsService;
    }
    //endregion

    //endregion

    //region 返回主页

    /**
     * 返回tinyshop8的首页
     *
     * @return 将页面返回
     */
    @Override
    public ModelAndView doMainView()
    {
        return new ModelAndView(indexPage);
    }

    //endregion

    //region 封装方法

    //region 将界面接收的商品信息转换成实体类信息

    /**
     * 将界面接收的商品信息转换成实体类信息
     *
     * @param goods    页面商品封装的类
     * @param operator 是新增还是更新
     * @return 将商品信息和商品类型作为map返回
     * @throws Exception 直接抛出大异常
     */
    protected Map<Goods8JPA, GoodsType8JPA> turnHTMLGoods(
              final InnerGoods goods, TinyOperator operator)
              throws Exception
    {
        Map<Goods8JPA, GoodsType8JPA> resultMap = new
                  HashMap<>();

        Goods8JPA _goods = new Goods8JPA();

        //用户
        String username = trim(goods.getUsername());
        _goods.setUser8JPA(userService.findUserByUserName(username));

        //操作是新增还是删除
        String myOperator = "";

        if (operator == TinyOperator.ADD)
        {
            myOperator = "新增";
        }
        else
        {
            myOperator = "更新";
        }

        //名称
        String goodsName = trim(goods.getGoodsName());

        //(nullable, 400)
        if (getStringLength(goodsName) == 0 ||
                  getStringLength(goodsName) > 399)
        {
            throwDAOException(myOperator + "商品名称不能为空并且不能大于400个字符!");
        }

        _goods.setGoodsName(goodsName);

        //新增日期
        String goodsAddDate = trim(goods.getGoodsAddDate());

        if (getStringLength(goodsAddDate) == 0)
        {
            throwDAOException(myOperator + "日期不能为空!");
        }

        _goods.setGoodsAddDate(goodsAddDate);

        //成本价
        String goodsCostPrice = trim(goods.getGoodsCostPrice());

        if (getStringLength(goodsCostPrice) == 0)
        {
            throwDAOException(myOperator + "成本价不能为空!");
        }

        //TODO
        checkTinyShopPrice(goodsCostPrice);

        _goods.setGoodsCostPrice(Double.valueOf(goodsCostPrice));

        //市场价
        String goodsMarketPrice = trim(goods.getGoodsMarketPrice());

        if (getStringLength(goodsMarketPrice) == 0)
        {
            throwDAOException(myOperator + "市场价不能为空!");
        }

        //TODO
        checkTinyShopPrice(goodsMarketPrice);

        _goods.setGoodsMarketPrice(Double.valueOf(goodsMarketPrice));

        //货号
        String goodsProNo = trim(goods.getGoodsProNo());

        //(nullable, 50)
        if (getStringLength(goodsProNo) == 0 ||
                  getStringLength(goodsProNo) > 49)
        {
            throwDAOException(myOperator + "货号不能为空必须不能超过50个字符!");
        }

        _goods.setGoodsProNo(goodsProNo);

        //销售价格
        String goodsSellPrice = trim(goods.getGoodsSellPrice());

        if (getStringLength(goodsSellPrice) == 0)
        {
            throwDAOException(myOperator + "销售价格不能为空!");
        }

        //TODO
        checkTinyShopPrice(goodsSellPrice);

        _goods.setGoodsSellPrice(Double.valueOf(goodsSellPrice));

        //库存
        String goodsStoreNums = trim(goods.getGoodsStoreNums());

        if (getStringLength(goodsStoreNums) == 0)
        {
            throwDAOException(myOperator + "库存不能为空!");
        }

        _goods.setGoodsStoreNums(Integer.valueOf(goodsStoreNums));

        //编号
        String goodsNo = trim(goods.getGoodsNo());

        if (getStringLength(goodsNo) > 299)
        {
            throwDAOException(myOperator + "编号不能超过300个字符!");
        }

        _goods.setGoodsNo(goodsNo);

        //重量
        String goodsWeight = trim(goods.getGoodsWeight());

        //nullable(10)
        if (getStringLength(goodsWeight) == 0 ||
                  getStringLength(goodsWeight) > 9)
        {
            throwDAOException(myOperator + "重量不能超过10个字符!");
        }

        _goods.setGoodsWeight(goodsWeight);

        //副标题
        String goodsSubTitle = trim(goods.getGoodsSubTitle());

        if (getStringLength(goodsSubTitle) > 799)
        {
            throwDAOException(myOperator + "副标题不能超过800个字符!");
        }

        _goods.setGoodsSubTitle(goodsSubTitle);

        //类型
        String goodsType = trim(goods.getGoodsType());

        if (getStringLength(goodsType) == 0)
        {
            throwDAOException(myOperator + "商品类型不能为空!");
        }

        GoodsType8JPA _goodsType = goodsTypeService
                  .findGoodsTypeByName(goodsType);
        _goods.setGoodsType(_goodsType);

        //图片
        String goodsImages = trim(goods.getGoodsImages());

        //根据逗号裁剪
        if (getStringLength(goodsImages) > 1)
        {
            //首先截取最后一个逗号然后进行分割
            String[] goodsImagesA = goodsImages
                      .substring(0, getStringLength(goodsImages))
                      .split(",");
            List<String> goodsImagesList = new ArrayList<>();
            for (int i = 0; i < goodsImagesA.length; i++)
            {
                goodsImagesList.add(goodsImagesA[i]);
            }

            _goods.setGoodsImgs(goodsImagesList);
        }

        //关键词
        String goodsKeyWords = trim(goods.getGoodsKeyWords());

        _goods.setGoodsKeyWords(goodsKeyWords);

        resultMap.put(_goods, _goodsType);

        return resultMap;
    }
    //endregion

    //endregion

    //region 封装抛出异常方法

    /**
     * 封装抛出异常方法(抛出数据访问层方法)
     *
     * @param daoExp 异常信息
     * @return 返回异常
     * @throws DataAccessException 抛出大异常
     */
    private final DataAccessException throwDAOException(String daoExp)
              throws DataAccessException
    {
        throw new
                  DataAccessException(daoExp);
    }
    //endregion

}