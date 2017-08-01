package qin.tinyshop8.domain8.jpa;

import qin.tinyshop8.utils.SuperLongEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/1 0001-1.<br/>
 * 用户实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/8/1
 */
@Entity
@Table(name = "jpa_user")
@SuppressWarnings("all")
public class User8JPA extends SuperLongEntity
{
    private final String classAnnotation = "用户jpa实体类";

    //region 构造函数和toString()

    public User8JPA() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("User8JPA{");
        sb.append("username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public User8JPA(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    //endregion

    //region 重写get方法

    @Id
    @GeneratedValue
    @Override
    public Long getId()
    {
        return super.getId();
    }

    //endregion

    //region 用户名和密码
    private String username;

    @Column(name = "username", length = 30, nullable = true, unique = true)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    private String password;

    @Column(name = "password", length = 10, nullable = true)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    //endregion

    //region 一个用户对应多个商品信息
    private Set<Goods8JPA> goods8JPASet = new HashSet<>();

    @OneToMany(targetEntity = Goods8JPA.class, cascade = CascadeType.REMOVE,
              fetch = FetchType.EAGER)
    @JoinColumn(name = "join_user_goodsSet", foreignKey =
    @ForeignKey(name = "join_fk_user_goodsSet"))
    @JoinTable(name = "jpa_user_goodsSet_table", foreignKey =
    @ForeignKey(name = "table_user_goodsSet"))
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