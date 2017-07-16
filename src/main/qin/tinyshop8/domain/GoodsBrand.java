package qin.tinyshop8.domain;

import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperLongEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2017/7/16 0016-16.<br/>
 * 品牌实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
public class GoodsBrand
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = -5597681811297260091L;

    private final String classAnnotation = "品牌实体类";

    //region 构造函数和toString()方法
    public GoodsBrand() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsBrand{");
        sb.append('\'').append("\n");
        sb.append(", brandName='").append(brandName).append('\'').append("\n");
        sb.append(", brandURL='").append(brandURL).append('\'').append("\n");
        sb.append(", brandSort=").append(brandSort).append("\n");
        sb.append('}').append("\n");
        return sb.toString();
    }

    /**
     * @param brandName 品牌名称
     * @param brandURL  网址
     * @param brandSort 排序
     */
    public GoodsBrand(String brandName, String brandURL, Integer brandSort)
    {
        this.brandName = brandName;
        this.brandURL = brandURL;
        this.brandSort = brandSort;
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

    //region 读和写

    /**
     * 写方法
     *
     * @param output 需要输出对象
     * @throws IOException 直接抛出大异常
     */
    public void writeObject(ObjectOutputStream output) throws IOException
    {
    }

    /**
     * 读对象
     *
     * @param input 输入对象
     * @throws IOException 直接抛出大异常
     */
    public void readObject(ObjectInputStream input) throws IOException
    {
    }
    //endregion

    //region 一个品牌对应一个类型
    private GoodsType goodsType;

    public GoodsType getGoodsType()
    {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType)
    {
        this.goodsType = goodsType;
    }
    //endregion


}