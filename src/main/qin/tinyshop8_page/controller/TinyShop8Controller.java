package qin.tinyshop8_page.controller;

import org.springframework.web.servlet.ModelAndView;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.MainViewSupport;
import qin.tinyshop8.utils.ShopBaseSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * tinyshop8控制层抽象接口
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
@SuppressWarnings("all")
public interface TinyShop8Controller extends ShopBaseSupport,
          MainViewSupport
{
    //region 定义基本变量

    //region 页面访问基本路径
    /**
     * 页面访问基本路径
     */
    String basePath = "/tinyshop8";
    //endregion

    //region 返回主页
    /**
     * 返回主页
     */
    String indexPage = basePath + "/doMainView";
    //endregion

    //endregion

    //region 返回tinyshop8的首页

    /**
     * 返回tinyshop8的首页
     *
     * @return 将页面返回
     */
    @Override
    ModelAndView doMainView();

    //endregion

    //region 一期显示功能 2017-8-5

    //region 显示所有商品信息

    /**
     * 显示所有商品信息
     *
     * @param response
     */
    @Deprecated
    void showAllGoods(HttpServletResponse response);
    //endregion

    //region 显示所有商品类型信息

    /**
     * 显示所有商品类型信息
     *
     * @param response
     */
    void showAllGoodsType(HttpServletResponse response);
    //endregion

    //region 显示所有商品品牌信息

    /**
     * 显示所有商品品牌信息
     *
     * @param response
     */
    void showAllGoodsBrand(HttpServletResponse response);
    //endregion

    //endregion

    //region 一期功能改进

    //region 根据登录的用户查找商品信息

    /**
     * 根据登录的用户查找商品信息<br>
     * 每个用户对应多个商品, 并不需要将所有的商品信息都显示出来,
     * 根据登录的用户去查找对应的商品然后将它的商品信息打印出来即可
     *
     * @param user     登录的用户信息
     * @param response 回复
     * @param request  请求
     */
    void showAllGoods(User8JPA user, HttpServletResponse response,
                      HttpServletRequest request);
    //endregion

    //endregion

    //region 二期(一期改进 2017-8-11)

    //region 新增商品信息

    /**
     * 新增商品信息
     *
     * @param goods    将页面接收的变量值用一个内部类封装
     * @param response 回复
     * @author qinzhengying
     * @since 1.8 2017/8/12
     */
    void addGoods(InnerGoods goods, HttpServletResponse response);
    //endregion

    //region 显示商品类型(2017/8/11)

    /**
     * 显示商品类型<br>
     *
     * @return 将商品类型字符串返回
     * @author qinzhengying
     * @since 1.8 2017/8/11
     */
    String showGoodsTypeCombobox();
    //endregion

    //endregion

    //region 定义一个内部类(接收商品信息)

    /**
     * 商品信息内部类(用于接收界面数据)
     *
     * @author qinzhengying
     * @since 1.8 2017/8/12
     */
    class InnerGoods implements Serializable
    {
        private static final long serialVersionUID = 7962962092767599477L;

        //region 名称
        /**
         * 名称
         */
        private String goodsName;

        public String getGoodsName()
        {
            return goodsName;
        }

        public void setGoodsName(String goodsName)
        {
            this.goodsName = goodsName;
        }
        //endregion

        //region 新增日期
        /**
         * 新增日期
         */
        private String goodsAddDate;

        public String getGoodsAddDate()
        {
            return goodsAddDate;
        }

        public void setGoodsAddDate(String goodsAddDate)
        {
            this.goodsAddDate = goodsAddDate;
        }
        //endregion

        //region 成本价
        /**
         * 成本价
         */
        private String goodsCostPrice;

        public String getGoodsCostPrice()
        {
            return goodsCostPrice;
        }

        public void setGoodsCostPrice(String goodsCostPrice)
        {
            this.goodsCostPrice = goodsCostPrice;
        }
        //endregion

        //region 市场价
        /**
         * 市场价
         */
        private String goodsMarketPrice;

        public String getGoodsMarketPrice()
        {
            return goodsMarketPrice;
        }

        public void setGoodsMarketPrice(String goodsMarketPrice)
        {
            this.goodsMarketPrice = goodsMarketPrice;
        }
        //endregion

        //region 货号
        /**
         * 货号
         */
        private String goodsProNo;

        public String getGoodsProNo()
        {
            return goodsProNo;
        }

        public void setGoodsProNo(String goodsProNo)
        {
            this.goodsProNo = goodsProNo;
        }
        //endregion

        //region 销售价
        /**
         * 销售价
         */
        private String goodsSellPrice;

        public String getGoodsSellPrice()
        {
            return goodsSellPrice;
        }

        public void setGoodsSellPrice(String goodsSellPrice)
        {
            this.goodsSellPrice = goodsSellPrice;
        }
        //endregion

        //region 销售数量
        /**
         * 销售数量
         */
        private String goodsStoreNums;

        public String getGoodsStoreNums()
        {
            return goodsStoreNums;
        }

        public void setGoodsStoreNums(String goodsStoreNums)
        {
            this.goodsStoreNums = goodsStoreNums;
        }
        //endregion

        //region 编号
        /**
         * 编号
         */
        private String goodsNo;

        public String getGoodsNo()
        {
            return goodsNo;
        }

        public void setGoodsNo(String goodsNo)
        {
            this.goodsNo = goodsNo;
        }
        //endregion

        //region 重量
        /**
         * 重量
         */
        private String goodsWeight;

        public String getGoodsWeight()
        {
            return goodsWeight;
        }

        public void setGoodsWeight(String goodsWeight)
        {
            this.goodsWeight = goodsWeight;
        }
        //endregion

        //region 副标题
        /**
         * 副标题
         */
        private String goodsSubTitle;

        public String getGoodsSubTitle()
        {
            return goodsSubTitle;
        }

        public void setGoodsSubTitle(String goodsSubTitle)
        {
            this.goodsSubTitle = goodsSubTitle;
        }
        //endregion

        //region 类型
        /**
         * 类型
         */
        private String goodsType;

        public String getGoodsType()
        {
            return goodsType;
        }

        public void setGoodsType(String goodsType)
        {
            this.goodsType = goodsType;
        }
        //endregion

        //region 图片
        /**
         * 图片
         */
        private String goodsImages;

        public String getGoodsImages()
        {
            return goodsImages;
        }

        public void setGoodsImages(String goodsImages)
        {
            this.goodsImages = goodsImages;
        }
        //endregion

        //region 关键词
        /**
         * 关键词
         */
        private String goodsKeyWords;

        public String getGoodsKeyWords()
        {
            return goodsKeyWords;
        }

        public void setGoodsKeyWords(String goodsKeyWords)
        {
            this.goodsKeyWords = goodsKeyWords;
        }
        //endregion

        //region 用户名
        private String username;

        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }
        //endregion

        //region 二期新特性
        /**
         * 图片集合
         *
         * @author qinzhengying
         * @since 1.8 2017/8/13
         */
        private List<String> imagesList = new ArrayList<>();

        public List<String> getImagesList()
        {
            return imagesList;
        }

        public void setImagesList(List<String> imagesList)
        {
            this.imagesList = imagesList;
        }
        //endregion

    }

    //endregion

    //region 定义一个内部枚举

    /**
     * tinyshop的操作 新增或更新
     *
     * @author qinzhengying
     * @since 1.8 2017/8/12
     */
    enum TinyOperator
    {
        /**
         * 新增
         */
        ADD,
        /**
         * 更新
         */
        UPDATE
    }
    //endregion

    //region 三期

    /**
     * 检查所有tinyshop里的价格(后期会重写此方法)
     * 根据字符串中截取, 判断是否都是数字, 接收的价格必须是数字<br>
     * (<br>
     * &nbsp;&nbsp;1.不能是负数<br>
     * &nbsp;&nbsp;2.必须大于0<br>
     * &nbsp;&nbsp;3.必须是11.11格式数字<br>
     * &nbsp;&nbsp;4.小数点 不能再末尾<br>
     * )
     *
     * @param price 需要检查的价格
     * @throws Exception 如果检查失败就直接抛出异常
     */
    default void checkTinyShopPrice(String price) throws Exception
    {
    }
    //endregion


}