package qin.tinyshop8_page.controller._abstract;

import org.springframework.web.servlet.ModelAndView;
import qin.tinyshop8_page.controller.TinyShop8Controller;
import qin.tinyshop8_page.service.GoodsBrandService;
import qin.tinyshop8_page.service.GoodsService;
import qin.tinyshop8_page.service.GoodsTypeService;

import javax.annotation.Resource;

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

}