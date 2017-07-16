package qin.tinyshop8.domain;

import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperLongEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16 0016-16.<br/>
 * 商品实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
public class Goods
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = -5597681811297260091L;

    private final String classAnnotation = "商品实体类";

    //region 构造函数和toString()方法
    public Goods() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Goods{");
        sb.append(classAnnotation).append(":\n");
        sb.append(", goodsType=").append(goodsType).append("\n");
        sb.append(", goodsCategory=").append(goodsCategory).append("\n");
        sb.append(", goodsSpec=").append(goodsSpec).append("\n");
        sb.append(", goodsName='").append(goodsName).append('\'').append("\n");
        sb.append(", goodsSubTitle='").append(goodsSubTitle).append('\'').append("\n");
        sb.append(", goodsKeyWords='").append(goodsKeyWords).append('\'').append("\n");
        sb.append(", goodsProNo='").append(goodsProNo).append('\'').append("\n");
        sb.append(", goodsImgs=").append(goodsImgs).append("\n");
        sb.append(", goodsNo='").append(goodsNo).append('\'').append("\n");
        sb.append(", goodsStoreNums=").append(goodsStoreNums).append("\n");
        sb.append(", goodsWeight='").append(goodsWeight).append('\'').append("\n");
        sb.append(", goodsSellPrice=").append(goodsSellPrice).append("\n");
        sb.append(", goodsMarketPrice=").append(goodsMarketPrice).append("\n");
        sb.append(", goodsCostPrice=").append(goodsCostPrice).append("\n");
        sb.append('}');
        return sb.toString();
    }

    /**
     * 带参数的构造函数
     *
     * @param goodsName        名称
     * @param goodsSubTitle    副标题
     * @param goodsKeyWords    关键词
     * @param goodsProNo       编号
     * @param goodsNo          货号
     * @param goodsStoreNums   库存
     * @param goodsWeight      重量
     * @param goodsSellPrice   零售价
     * @param goodsMarketPrice 市场价
     * @param goodsCostPrice   成本价
     */
    public Goods(String goodsName, String goodsSubTitle,
                 String goodsKeyWords, String goodsProNo,
                 String goodsNo, Integer goodsStoreNums,
                 String goodsWeight, Double goodsSellPrice,
                 Double goodsMarketPrice, Double goodsCostPrice)
    {
        this.goodsName = goodsName;
        this.goodsSubTitle = goodsSubTitle;
        this.goodsKeyWords = goodsKeyWords;
        this.goodsProNo = goodsProNo;
        this.goodsNo = goodsNo;
        this.goodsStoreNums = goodsStoreNums;
        this.goodsWeight = goodsWeight;
        this.goodsSellPrice = goodsSellPrice;
        this.goodsMarketPrice = goodsMarketPrice;
        this.goodsCostPrice = goodsCostPrice;
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

    //region 商品类型
    /**
     * 商品类型
     */
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

    //region 商品分类
    /**
     * 商品分类
     */
    private GoodsCategory goodsCategory;

    public GoodsCategory getGoodsCategory()
    {
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory)
    {
        this.goodsCategory = goodsCategory;
    }
    //endregion

    //region 商品品牌
    /**
     * 商品品牌
     */
    private GoodsSpec goodsSpec;

    public GoodsSpec getGoodsSpec()
    {
        return goodsSpec;
    }

    public void setGoodsSpec(GoodsSpec goodsSpec)
    {
        this.goodsSpec = goodsSpec;
    }
    //endregion

    //region 商品名称
    /**
     * 商品名称
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

    //region 编号
    /**
     * 编号
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

    //region 相册
    /**
     * 相册
     */
    private List<String> goodsImgs = new ArrayList<>();

    public List<String> getGoodsImgs()
    {
        return goodsImgs;
    }

    public void setGoodsImgs(List<String> goodsImgs)
    {
        this.goodsImgs = goodsImgs;
    }
    //endregion

    //region 货号
    /**
     * 货号
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

    //region 库存
    /**
     * 库存
     */
    private Integer goodsStoreNums;

    public Integer getGoodsStoreNums()
    {
        return goodsStoreNums;
    }

    public void setGoodsStoreNums(Integer goodsStoreNums)
    {
        this.goodsStoreNums = goodsStoreNums;
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

    //region 零售价
    /**
     * 零售价
     */
    private Double goodsSellPrice;

    public Double getGoodsSellPrice()
    {
        return goodsSellPrice;
    }

    public void setGoodsSellPrice(Double goodsSellPrice)
    {
        this.goodsSellPrice = goodsSellPrice;
    }
    //endregion

    //region 市场价
    /**
     * 市场价
     */
    private Double goodsMarketPrice;

    public Double getGoodsMarketPrice()
    {
        return goodsMarketPrice;
    }

    public void setGoodsMarketPrice(Double goodsMarketPrice)
    {
        this.goodsMarketPrice = goodsMarketPrice;
    }
    //endregion

    //region 成本价
    /**
     * 成本价
     */
    private Double goodsCostPrice;

    public Double getGoodsCostPrice()
    {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(Double goodsCostPrice)
    {
        this.goodsCostPrice = goodsCostPrice;
    }
    //endregion
}