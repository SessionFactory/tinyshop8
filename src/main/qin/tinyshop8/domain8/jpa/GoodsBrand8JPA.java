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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;

/**
 * 商品品牌实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/19
 */
@Entity
@Table(name = "jpa_goodsbrand")
@SuppressWarnings("all")
public class GoodsBrand8JPA
          extends SuperLongEntity
          implements ShopBaseSupport
{
    private static final long serialVersionUID = -780774304133751049L;

    private final String classAnnotation = "品牌jpa实体类";

    //region 主键

    @Column(name = "brand_id")
    @Override
    @Id
    @GeneratedValue
    public Long getId()
    {
        return super.getId();
    }

    //endregion

    //region 构造函数和toString

    public GoodsBrand8JPA(String brandName, String brandURL, Integer brandSort)
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

    public GoodsBrand8JPA() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }
    //endregion

    //region 品牌名称
    /**
     * 品牌名称
     */
    private String brandName;

    @Column(name = "brand_name", nullable = true, length = 300)
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

    @Column(name = "brand_url")
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

    @Column(name = "brand_sort")
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
    private Set<Goods8JPA> goods8JPASet = new HashSet<>();

    @OneToMany(targetEntity = Goods8JPA.class, cascade = REMOVE,
              fetch = EAGER)
    @JoinColumn(name = "join_goods_brand_m2o", foreignKey =
    @ForeignKey(name = "fk_goods_brand_m2o"))
    @JoinTable(name = "jpa_goods_brand_set", foreignKey =
    @ForeignKey(name = "fk_jpa_goods_brand_set"))
    public Set<Goods8JPA> getGoods8JPASet()
    {
        return goods8JPASet;
    }

    public void setGoods8JPASet(Set<Goods8JPA> goods8JPASet)
    {
        this.goods8JPASet = goods8JPASet;
    }
    //endregion
}