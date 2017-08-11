package qin.tinyshop8_page.controller;

import org.springframework.web.servlet.ModelAndView;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.MainViewSupport;
import qin.tinyshop8.utils.ShopBaseSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}