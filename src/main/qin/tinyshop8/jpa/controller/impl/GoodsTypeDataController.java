package qin.tinyshop8.jpa.controller.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8_page.dao.GoodsTypeDAO;
import qin.tinyshop8.utils.ShopBaseSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

/**
 * Created by Administrator on 2017/7/23 0023-23.<br/>
 *
 * @author qinzhengying
 * @since 1.8 2017/7/23
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/tinyshop8_goodstype")
public class GoodsTypeDataController implements ShopBaseSupport
{
    private static final long serialVersionUID = 9107154167303881263L;

    private GoodsTypeDAO goodsTypeDAO;

    @Resource
    public void setGoodsTypeDAO(GoodsTypeDAO goodsTypeDAO)
    {
        this.goodsTypeDAO = goodsTypeDAO;
    }

    @RequestMapping(value = "/add")
    public void add(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            GoodsType8JPA goodsType8JPA = new GoodsType8JPA();
            String type_name = request.getParameter("type_name");
            goodsType8JPA.setTypeName(type_name.trim());
            String type_alias = request.getParameter("type_alias");
            goodsType8JPA.setTypeAlias(type_alias.trim());
            String type_sort = request.getParameter("type_sort");
            goodsType8JPA.setTypeSort(Integer.valueOf(type_sort.trim()));

            String parent = request.getParameter("parent");

            GoodsType8JPA parentType = new GoodsType8JPA();

            if (parent.trim().length() > 1)
            {
                parentType = goodsTypeDAO
                          .getById(goodsTypeDAO.getIdByTypeName(parent));
            }

            goodsTypeDAO.add(goodsType8JPA, parentType, new HashSet<>());
            returnJson("添加成功", response);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
}