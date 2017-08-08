package qin.tinyshop8_page.controller;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.utils.ini.SuperPrintException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/7 0007-7.<br/>
 * 保存商品类型信息
 *
 * @author qinzhengying
 * @since 1.8 2017/8/7
 */
public class SaveGoodsTypeData implements SuperPrintException,
          SessionBasic
{
    private static final long serialVersionUID = -6713082970268100026L;

    /**
     * 保存商品类型信息
     */
    @Override
    public void ini()
    {
        try
        {
            GoodsType8JPA parent = new GoodsType8JPA("手机", "mobile", 0);
            //配件
            GoodsType8JPA peijian = new GoodsType8JPA("手机配件", "mobileConfig", 1);
            peijian.setParentType(parent);
            //娱乐
            GoodsType8JPA yule = new GoodsType8JPA("娱乐", "mobileYL", 2);
            yule.setParentType(parent);

            Set<GoodsType8JPA> childrenSet = new HashSet<>();
            childrenSet.add(peijian);
            childrenSet.add(yule);

            parent.setChildrenSet(childrenSet);

            session.save(parent);
            session.save(peijian);
            session.save(yule);

            transaction.commit();
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }

    @Test
    public void iniTest()
    {
        ini();
    }


}