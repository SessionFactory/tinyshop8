package qin.tinyshop8.domain8;

import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperLongEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 商品类型实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/19
 */
public class GoodsType8
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = -4839046412840546324L;

    private final String classAnnotation = "商品分类实体类";

    //region 构造函数和toString()

    /**
     * @param typeName  名称
     * @param typeAlias 别名
     * @param typeSort  排序
     */
    public GoodsType8(String typeName, String typeAlias, Integer typeSort)
    {
        this.typeName = typeName;
        this.typeAlias = typeAlias;
        this.typeSort = typeSort;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsType8{");
        sb.append("classAnnotation='").append(classAnnotation).append('\'');
        sb.append(", typeName='").append(typeName).append('\'');
        sb.append(", typeAlias='").append(typeAlias).append('\'');
        sb.append(", typeSort=").append(typeSort);
        sb.append('}');
        return sb.toString();
    }

    public GoodsType8() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }
    //endregion

    //region 对应多个商品信息
    /**
     * 对应多个商品信息
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

    //region 下级分类
    /**
     * 下级分类
     */
    private Set<GoodsType8> childrenSet = new HashSet<>();

    public Set<GoodsType8> getChildrenSet()
    {
        return childrenSet;
    }

    public void setChildrenSet(Set<GoodsType8> childrenSet)
    {
        this.childrenSet = childrenSet;
    }
    //endregion

    //region 上级分类
    /**
     * 上级分类
     */
    private GoodsType8 parentType;

    public GoodsType8 getParentType()
    {
        return parentType;
    }

    public void setParentType(GoodsType8 parentType)
    {
        this.parentType = parentType;
    }
    //endregion

    //region 下级分类
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

    //region 名称
    /**
     * 名称
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

    //region 别名
    /**
     * 别名
     */
    private String typeAlias;

    public String getTypeAlias()
    {
        return typeAlias;
    }

    public void setTypeAlias(String typeAlias)
    {
        this.typeAlias = typeAlias;
    }
    //endregion

    //region 排序
    /**
     * 排序
     */
    private Integer typeSort;

    public Integer getTypeSort()
    {
        return typeSort;
    }

    public void setTypeSort(Integer typeSort)
    {
        this.typeSort = typeSort;
    }
    //endregion
}