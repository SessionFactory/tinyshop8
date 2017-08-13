package qin.tinyshop8_page.controller.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8_page.controller._abstract.TinyShop8ControllerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

import static qin.tinyshop8_page.controller.TinyShop8Controller.TinyOperator.ADD;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 商品控制层实现类
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
@Controller(value = "_TinyShop8Controller")
@Scope("prototype")
@RequestMapping(value = "/tinyshop8")
@SuppressWarnings("all")
public class TinyShop8Controller_
          extends TinyShop8ControllerImpl
{
    private static final long serialVersionUID = 377255544027903955L;

    //region 返回首页

    /**
     * 返回tinyshop8的首页
     *
     * @return 将页面返回
     */
    @RequestMapping(value = "/doMainView")
    @Override
    public ModelAndView doMainView()
    {
        return super.doMainView();
    }

    @RequestMapping(value = "/doMainView2")
    public ModelAndView doMainView2(User8JPA user)
    {
        return super.doMainView();
    }

    //endregion

    //region 显示所有商品信息

    /**
     * 显示所有商品信息
     *
     * @param response
     */
    //@RequestMapping(value = "/showAllGoods")
    @Deprecated
    @Override
    public void showAllGoods(HttpServletResponse response)
    {
        try
        {
            //首先查询所有商品信息
            final List<Goods8JPA> goodsList = goodsService
                      .findAll();

            if (goodsList.size() == 0)
            {
                throw new
                          Exception("TinyShop8Controller_.查询所有商品信息失败!并没有任何商品信息");
            }

            //写入json
            JSONArray jsonArray = new JSONArray();

            for (Iterator<Goods8JPA> it = goodsList.iterator(); it.hasNext(); )
            {
                JSONObject jsonObject = new JSONObject();

                Goods8JPA goods = it.next();

                //名称
                jsonObject.put("goodsName", goods.getGoodsName());
                //编号
                jsonObject.put("goodsProNo", goods.getGoodsProNo());
                //添加时间
                jsonObject.put("goodsAddDate", goods.getGoodsAddDate());
                //市场价
                jsonObject.put("goodsMarketPrice", goods.getGoodsMarketPrice());
                //所属类型
                jsonObject.put("goodsType", "type");
                //品牌
                jsonObject.put("goodsBrand", "brand");

                jsonArray.add(jsonObject);
            }

            String baseStr = "{\"total\":" + goodsList.size() + ",\"rows\":";
            baseStr = baseStr + jsonArray.toString() + "}";
            returnJson(baseStr, response);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
    //endregion

    //region 显示所有商品类型信息

    /**
     * 显示所有商品类型信息
     *
     * @param response
     */
    @RequestMapping(value = "/showAllGoodsType")
    @Override
    public void showAllGoodsType(HttpServletResponse response)
    {
        try
        {
            //查询全部商品类型信息
            List<GoodsType8JPA> goodsTypeList = goodsTypeService
                      .findAll();

            if (goodsTypeList.size() == 0)
            {
                throw new
                          Exception("TinyShop8Controller_." +
                                              "查询所有商品类型信息失败!并没有任何商品类型信息");
            }

            //写入json
            JSONArray jsonArray = new JSONArray();

            for (Iterator<GoodsType8JPA> it = goodsTypeList.iterator(); it.hasNext(); )
            {
                JSONObject jsonObject = new JSONObject();

                GoodsType8JPA goodsType = it.next();

                //名字
                jsonObject.put("goodsTypeName", goodsType.getTypeName());
                //排序
                jsonObject.put("goodsTypeSort", goodsType.getTypeSort());
                //别名
                jsonObject.put("goodsTypeAlias", goodsType.getTypeAlias());
                //上级类型
                jsonObject.put("goodsParent", "parent");

                jsonArray.add(jsonObject);
            }

            String baseStr = "{\"total\":" + goodsTypeList.size() + ",\"rows\":";
            baseStr = baseStr + jsonArray.toString() + "}";
            returnJson(baseStr, response);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
    //endregion

    //region 显示所有商品品牌信息

    /**
     * 显示所有商品品牌信息
     *
     * @param response
     */
    @Override
    public void showAllGoodsBrand(HttpServletResponse response)
    {
        try
        {
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
    //endregion

    //region 根据用户查找商品信息

    /**
     * 根据登录的用户查找商品信息<br>
     * 每个用户对应多个商品, 并不需要将所有的商品信息都显示出来,
     * 根据登录的用户去查找对应的商品然后将它的商品信息打印出来即可
     *
     * @param user     登录的用户信息
     * @param response 回复
     */
    @RequestMapping(value = "/showAllGoods")
    @Override
    public void showAllGoods(User8JPA user, HttpServletResponse response,
                             HttpServletRequest request)
    {
        try
        {
            //直接输入地址不可以访问
            if (request.getSession().getAttribute("password") == null)
            {
                returnJson("清先登录!", response);
                //throw new ServletException("请先登录!");
            }

            //判断用户是否为空, 为空就直接抛出异常
            if (user == null)
            {
                returnJson("请先登录再访问此页,  谢谢!", response);
                return;
            }

            //首先接收用户名
            String username = trim(user.getUsername());
            //然后直接根据用户名查询商品信息

            //首先查询所有商品信息
            final List<Goods8JPA> goodsList = goodsService
                      .findGoodsByUser(username);

            if (goodsList.size() == 0)
            {
                throw new
                          Exception("TinyShop8Controller_.查询所有商品信息失败!并没有任何商品信息");
            }

            //写入json
            JSONArray jsonArray = new JSONArray();

            for (Iterator<Goods8JPA> it = goodsList.iterator(); it.hasNext(); )
            {
                JSONObject jsonObject = new JSONObject();

                Goods8JPA goods = it.next();

                //编号
                jsonObject.put("goodsId", goods.getId());
                //名称
                jsonObject.put("goodsName", goods.getGoodsName());
                //编号
                jsonObject.put("goodsProNo", goods.getGoodsProNo());
                //添加时间
                jsonObject.put("goodsAddDate", goods.getGoodsAddDate());
                //市场价
                jsonObject.put("goodsMarketPrice", goods.getGoodsMarketPrice());
                String type = "";
                GoodsType8JPA goodsType = goods.getGoodsType();
                if (goodsType == null)
                {
                    //language=html
                    type = new StringBuilder()
                              .append("<font style='color: red; font-weight: lighter; '>")
                              .append("所对应的商品类型为空!</font>").toString();
                }
                else
                {
                    type = new StringBuilder()
                              .append("<font style='color: blue;'>")
                              .append(goodsType.getTypeName())
                              .append("</font>").toString();
                }
                //所属类型
                jsonObject.put("goodsType", type);
                //品牌
                jsonObject.put("goodsBrand", "暂未开通此服务!");

                jsonArray.add(jsonObject);
            }

            String baseStr = "{\"total\":" + goodsList.size() + ",\"rows\":";
            baseStr = baseStr + jsonArray.toString() + "}";
            returnJson(baseStr, response);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }

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
    @RequestMapping(value = "/addGoods")
    @Override
    public void addGoods(final InnerGoods goods, final HttpServletResponse response)
    {
        try
        {
            FrameWorkDSCResult result = goodsService
                      .addGoods(turnHTMLGoods2(goods, ADD));

            if (result.isDaoFlag())
            {
                returnJson(str_success, response);
            }
            else
            {
                returnJson(result.getDaoException(), response);
            }
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }

    //endregion

    //region 显示商品类型信息

    /**
     * 显示商品类型<br>
     *
     * @return 将商品类型作为字符串返回
     * @author qinzhengying
     * @since 1.8 2017/8/11
     */
    //@RequestMapping(value = "/iniGoodsType")
    @Override
    public String showGoodsTypeCombobox()
    {
        try
        {
            //查询所有商品类型实体类信息
            List<GoodsType8JPA> goodsTypeList = goodsTypeService
                      .findAll();

            //将排序后的商品类型名称写入前台页面
            StringBuilder ajax = new StringBuilder();

            for (Iterator<GoodsType8JPA> it = goodsTypeList.iterator();
                      it.hasNext(); )
            {
                GoodsType8JPA e = it.next();
                //language=html
                ajax.append("<option>").append(e.getTypeName()).append("</option>");
            }

            return ajax.toString();
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
            return str_failed;
        }
    }

    //endregion

    //endregion


}