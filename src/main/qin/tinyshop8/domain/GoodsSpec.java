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
 * 商品规格实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
public class GoodsSpec
          extends SuperLongEntity
          implements ShopBaseSupport
{

    private static final long serialVersionUID = 7043304906616760558L;

    /***/
    private final String classAnnotation = "商品规格实体类";

    //region 构造函数和toString()方法
    public GoodsSpec() throws Exception
    {
        superLogInfo("正在初始化" + classAnnotation);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsSpec{");
        sb.append(classAnnotation).append('\'').append("\n");
        sb.append(", specName='").append(specName).append('\'').append("\n");
        sb.append(", specType='").append(specType).append('\'').append("\n");
        sb.append(", specNote='").append(specNote).append('\'').append("\n");
        sb.append('}').append("\n");
        return sb.toString();
    }

    /**
     * @param specName 名称
     * @param specType 类型
     * @param specNote 备注
     */
    public GoodsSpec(String specName, String specType, String specNote)
    {
        this.specName = specName;
        this.specType = specType;
        this.specNote = specNote;
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
    private String specName;

    public String getSpecName()
    {
        return specName;
    }

    public void setSpecName(String specName)
    {
        this.specName = specName;
    }
    //endregion

    //region 类型
    /**
     * 类型
     */
    private String specType;

    public String getSpecType()
    {
        return specType;
    }

    public void setSpecType(String specType)
    {
        this.specType = specType;
    }
    //endregion

    //region 备注
    /**
     * 备注
     */
    private String specNote;

    public String getSpecNote()
    {
        return specNote;
    }

    public void setSpecNote(String specNote)
    {
        this.specNote = specNote;
    }
    //endregion

    //region 与商品多对一
    /**
     * 与商品多对一
     */
    private Set<Goods> specSet = new HashSet<>();

    public Set<Goods> getSpecSet()
    {
        return specSet;
    }

    public void setSpecSet(Set<Goods> specSet)
    {
        this.specSet = specSet;
    }
    //endregion
}