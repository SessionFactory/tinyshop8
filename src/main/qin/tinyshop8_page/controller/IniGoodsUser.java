package qin.tinyshop8_page.controller;

import qin.javaee8.core.SessionBasic;
import qin.javaee8.core.exceptions.dao.EmptyResultDataAccessException;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/8/6 0006-6.<br/>
 * 初始化商品和用户数据类
 *
 * @author qinzhengying
 * @since 1.8 2017/8/6
 */
@SuppressWarnings("all")
public class IniGoodsUser implements SessionBasic,
          ShopBaseSupport
{
    private static final long serialVersionUID = -6292755003234349497L;

    //region 初始化方法

    /**
     * 初始化用户和商品表中的数据
     *
     * @throws Exception 抛出大异常
     */
    public void ini() throws Exception
    {
        //首先查找用户
        User8JPA user = (User8JPA) session
                  .createQuery("from User8JPA where username='administrator'")
                  .list().get(0);

        if (user == null)
        {
            throw new
                      EmptyResultDataAccessException("用户记录为空, 无法新增!");
        }

        //新增
        //首先新增一个类型
        GoodsType8JPA computer = new GoodsType8JPA("电脑", "computer", 0);
        //新建3台电脑
        Goods8JPA huashuo = new Goods8JPA(simpleDataFormat.format(getDate(2017, 8, 6)),
                                          "华硕（ASUS）玩家国度GX800VH7820 18.4英寸ROG双独显水冷游戏笔记" +
                                                    "本电脑 I7-7820HK 64G内存 1.5TB固态",
                                          "huashuoComputer", "11298064083", "11298064083",
                                          10, "2.5KG", 69999d, 71000d, 70000d);
        Goods8JPA weixing = new Goods8JPA(simpleDataFormat.format(getDate(2017, 8, 6)),
                                          "微星 MSI GT83VR 7RF-203CN 18.4英寸游戏笔记本电脑 （i7-7920HQ " +
                                                    "32G 512G+1T 双GTX1080 WIN10 机械键盘）黑",
                                          "weixingComputer", "1989750687", "1989750687",
                                          10, "2.5KG", 40999d, 40999d, 40999d);
        Goods8JPA waixingren = new Goods8JPA(simpleDataFormat.format(getDate(2017, 8, 6)),
                                             "外星人Alienware17C-R2738 17.3英寸游戏笔记本电脑(i7-7700HQ 16G " +
                                                       "256GSSD+1T GTX1060 6G独显 FHD Win10)",
                                             "waixingrenComputer", "4335716", "4335716",
                                             10, "2.5KG", 18999d, 18999d, 18999d);
        user.getGoods8JPASet().add(huashuo);
        user.getGoods8JPASet().add(weixing);
        user.getGoods8JPASet().add(waixingren);

        huashuo.setUser8JPA(user);
        weixing.setUser8JPA(user);
        waixingren.setUser8JPA(user);

        huashuo.setGoodsType(computer);
        weixing.setGoodsType(computer);
        waixingren.setGoodsType(computer);

        computer.getGoods8JPASet().add(huashuo);
        computer.getGoods8JPASet().add(weixing);
        computer.getGoods8JPASet().add(waixingren);

        session.update(user);
        session.save(computer);
        session.save(huashuo);
        session.save(weixing);
        session.save(waixingren);

        transaction.commit();
    }
    //endregion

}