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
 * 商品分类实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
public class GoodsCategory
          extends SuperLongEntity
          implements ShopBaseSupport
{

    private static final long serialVersionUID = -5469521917495325400L;

    private final String classAnnotation = "商品分类实体类";

    //region 构造函数和toString()方法
    public GoodsCategory() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsCategory{");
        sb.append(classAnnotation).append('\'').append("\n");
        sb.append(", categoryName='").append(categoryName).append('\'').append("\n");
        sb.append(", categoryAlias='").append(categoryAlias).append('\'').append("\n");
        sb.append(", categoryParent=").append(categoryParent).append("\n");
        sb.append(", categoryType=").append(categoryType).append("\n");
        sb.append(", categorySort=").append(categorySort).append("\n");
        sb.append(", categorySet=").append(categorySet).append("\n");
        sb.append('}').append("\n");
        return sb.toString();
    }

    /**
     * @param categoryName  名称
     * @param categoryAlias 别名
     * @param categorySort  排序
     */
    public GoodsCategory(String categoryName,
                         String categoryAlias, Integer categorySort)
    {
        this.categoryName = categoryName;
        this.categoryAlias = categoryAlias;
        this.categorySort = categorySort;
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

    //region 名称
    /**
     * 名称
     */
    private String categoryName;

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    //endregion

    //region 别名
    /**
     * 别名
     */
    private String categoryAlias;

    public String getCategoryAlias()
    {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias)
    {
        this.categoryAlias = categoryAlias;
    }
    //endregion

    //region 上级
    /**
     * 上级
     */
    private GoodsCategory categoryParent;

    public GoodsCategory getCategoryParent()
    {
        return categoryParent;
    }

    public void setCategoryParent(GoodsCategory categoryParent)
    {
        this.categoryParent = categoryParent;
    }
    //endregion

    //region 下级
    /**
     * 下级
     */
    private Set<GoodsCategory> childrenSet = new HashSet<>();

    public Set<GoodsCategory> getChildrenSet()
    {
        return childrenSet;
    }

    public void setChildrenSet(Set<GoodsCategory> childrenSet)
    {
        this.childrenSet = childrenSet;
    }
    //endregion

    //region 类型
    /**
     * 类型
     */
    private GoodsType categoryType;

    public GoodsType getCategoryType()
    {
        return categoryType;
    }

    public void setCategoryType(GoodsType categoryType)
    {
        this.categoryType = categoryType;
    }
    //endregion

    //region 排序
    /**
     * 排序
     */
    private Integer categorySort;

    public Integer getCategorySort()
    {
        return categorySort;
    }

    public void setCategorySort(Integer categorySort)
    {
        this.categorySort = categorySort;
    }
    //endregion

    //region 与商品多对一
    /**
     * 与商品多对一
     */
    private Set<Goods> categorySet = new HashSet<>();

    public Set<Goods> getCategorySet()
    {
        return categorySet;
    }

    public void setCategorySet(Set<Goods> categorySet)
    {
        this.categorySet = categorySet;
    }
    //endregion
}