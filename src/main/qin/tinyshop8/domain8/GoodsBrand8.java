package qin.tinyshop8.domain8;

import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperLongEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * 商品品牌实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/19
 */
public class GoodsBrand8
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = -780774304133751049L;

    private final String classAnnotation = "品牌实体类";

    //region 构造函数和toString

    public GoodsBrand8(String brandName, String brandURL, Integer brandSort)
    {
        this.brandName = brandName;
        this.brandURL = brandURL;
        this.brandSort = brandSort;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsBrand8{");
        sb.append(classAnnotation).append('\'');
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", brandURL='").append(brandURL).append('\'');
        sb.append(", brandSort=").append(brandSort);
        sb.append('}');
        return sb.toString();
    }

    public GoodsBrand8() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }
    //endregion

    //region 品牌名称
    /**
     * 品牌名称
     */
    private String brandName;

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }
    //endregion

    //region 品牌网址
    /**
     * 品牌网址
     */
    private String brandURL;

    public String getBrandURL()
    {
        return brandURL;
    }

    public void setBrandURL(String brandURL)
    {
        this.brandURL = brandURL;
    }
    //endregion

    //region 品牌排序
    /**
     * 品牌排序
     */
    private Integer brandSort;

    public Integer getBrandSort()
    {
        return brandSort;
    }

    public void setBrandSort(Integer brandSort)
    {
        this.brandSort = brandSort;
    }
    //endregion

    //region 一个品牌对应多个商品
    /**
     * 一个品牌对应多个商品
     */
    private Set<Goods8> goods8Set = new HashSet<>();

    public Set<Goods8> getGoods8Set()
    {
        return goods8Set;
    }

    public void setGoods8Set(Set<Goods8> goods8Set)
    {
        this.goods8Set = goods8Set;
    }
    //endregion
}