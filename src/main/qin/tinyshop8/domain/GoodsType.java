package qin.tinyshop8.domain;

import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperLongEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/16 0016-16.<br/>
 * 商品类型实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
public class GoodsType
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = 696094279066665038L;

    /***/
    private final String classAnnotation = "商品类型实体类";

    //region 构造函数和toString()方法
    public GoodsType() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsType{");
        sb.append(classAnnotation).append('\'').append("\n");
        sb.append(", typeName='").append(typeName).append('\'').append("\n");
        sb.append(", typeAttr='").append(typeAttr).append('\'').append("\n");
        sb.append('}').append("\n");
        return sb.toString();
    }

    /**
     * @param typeName
     * @param typeAttr 规格
     */
    public GoodsType(String typeName, String typeAttr)
    {
        this.typeName = typeName;
        this.typeAttr = typeAttr;
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

    //region 类型名称
    /**
     * 类型名称
     */
    private String typeName;

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
    //endregion

    //region 类型规格
    /**
     * 类型规格
     */
    private GoodsSpec typeSpec;

    public GoodsSpec getTypeSpec()
    {
        return typeSpec;
    }

    public void setTypeSpec(GoodsSpec typeSpec)
    {
        this.typeSpec = typeSpec;
    }
    //endregion

    //region 品牌
    /**
     * 品牌
     */
    private GoodsBrand typeBrand;

    public GoodsBrand getTypeBrand()
    {
        return typeBrand;
    }

    public void setTypeBrand(GoodsBrand typeBrand)
    {
        this.typeBrand = typeBrand;
    }
    //endregion

    //region 规格
    /**
     * 规格
     */
    private String typeAttr;

    public String getTypeAttr()
    {
        return typeAttr;
    }

    public void setTypeAttr(String typeAttr)
    {
        this.typeAttr = typeAttr;
    }
    //endregion

    //region 与商品多对一
    /**
     * 与商品多对一
     */
    private Set<Goods> typeSet = new HashSet<>();

    public Set<Goods> getTypeSet()
    {
        return typeSet;
    }

    public void setTypeSet(Set<Goods> typeSet)
    {
        this.typeSet = typeSet;
    }
    //endregion
}