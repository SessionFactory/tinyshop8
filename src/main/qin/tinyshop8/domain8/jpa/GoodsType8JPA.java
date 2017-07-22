package qin.tinyshop8.domain8.jpa;

import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperLongEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;

/**
 * 商品类型实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/19
 */
@Entity
@Table(name = "jpa_goodstype")
@SuppressWarnings("all")
public class GoodsType8JPA
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = -4839046412840546324L;

    private final String classAnnotation = "商品jpa分类实体类";

    //region 构造函数和toString()

    /**
     * @param typeName  名称
     * @param typeAlias 别名
     * @param typeSort  排序
     */
    public GoodsType8JPA(String typeName, String typeAlias, Integer typeSort)
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

    public GoodsType8JPA() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }
    //endregion

    //region 主键

    @Id
    @GeneratedValue
    @Column(name = "type_id")
    @Override
    public Long getId()
    {
        return super.getId();
    }

    //endregion

    //region 对应多个商品信息
    /**
     * 对应多个商品信息
     */
    private Set<Goods8JPA> goods8JPASet = new HashSet<>();

    @OneToMany(targetEntity = Goods8JPA.class, cascade = REMOVE,
              fetch = EAGER)
    @JoinColumn(name = "join_goods_type_m2o", foreignKey =
    @ForeignKey(name = "fk_goods_type_m2o"))
    @JoinTable(name = "jpa_goods_type_set", foreignKey =
    @ForeignKey(name = "fk_jpa_goods_type_set"))
    public Set<Goods8JPA> getGoods8JPASet()
    {
        return goods8JPASet;
    }

    public void setGoods8JPASet(Set<Goods8JPA> goods8JPASet)
    {
        this.goods8JPASet = goods8JPASet;
    }
    //endregion

    //region 下级分类
    /**
     * 下级分类
     */
    private Set<GoodsType8JPA> childrenSet = new HashSet<>();

    @OneToMany(targetEntity = GoodsType8JPA.class, cascade = REMOVE,
              fetch = EAGER)
    @JoinColumn(name = "join_goods_children_m2o", foreignKey =
    @ForeignKey(name = "fk_goods_children_m2o"))
    @JoinTable(name = "jpa_goods_children_set", foreignKey =
    @ForeignKey(name = "fk_jpa_goods_children_set"))
    public Set<GoodsType8JPA> getChildrenSet()
    {
        return childrenSet;
    }

    public void setChildrenSet(Set<GoodsType8JPA> childrenSet)
    {
        this.childrenSet = childrenSet;
    }
    //endregion

    //region 上级分类
    /**
     * 上级分类
     */
    private GoodsType8JPA parentType;

    @ManyToOne(targetEntity = GoodsType8JPA.class, cascade = REMOVE,
              fetch = EAGER)
    @JoinColumn(name = "parent_id", foreignKey =
    @ForeignKey(name = "fk_parent"))
    public GoodsType8JPA getParentType()
    {
        return parentType;
    }

    public void setParentType(GoodsType8JPA parentType)
    {
        this.parentType = parentType;
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
    private String typeName;

    @Column(name = "type_name", nullable = true, length = 200)
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

    @Column(name = "type_alias", length = 500)
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

    @Column(name = "type_sort")
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