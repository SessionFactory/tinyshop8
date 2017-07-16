package qin.tinyshop8.utils;

import org.apache.log4j.Logger;
import qin.javaee8.core.JavaEE8BaseSupport;

/**
 * 商城最顶层接口
 *
 * @author qinzhengying
 * @since 1.8 2017/7/15
 */
public interface ShopBaseSupport extends JavaEE8BaseSupport
{
    @Override
    default Class getLogClass()
    {
        return ShopBaseSupport.class;
    }

    @Override
    default String getLog4jLocation()
    {
        return "D:\\idea2017WK\\tinyshop8\\src\\resources\\log4j.properties";
    }

    @Override
    default Logger getLogger()
    {
        return Logger.getLogger(ShopBaseSupport.class);
    }

    /**
     * 图片基本路径
     */
    String basePath = "http://localhost/tinyshopV3.0_data/";
}
