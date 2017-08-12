package qin.tinyshop8.utils;

import org.apache.log4j.Logger;
import qin.javaee8.core.JavaEE8BaseSupport;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;

/**
 * 商城最顶层接口
 *
 * @author qinzhengying
 * @since 1.8 2017/7/15
 */
public interface ShopBaseSupport extends JavaEE8BaseSupport
{
    //region 重写父类方法
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
    //endregion

    /**
     * 图片基本路径
     */
    String basePath = "http://localhost/tinyshopV3.0_data/";

    //region 2017/7/22

    /**
     * 定义数据访问层提示开始字符串
     */
    String daoStart = "<<<<<<<<<<<<<<<<<<<<<<<<<<<";

    /**
     * 定义数据访问层提示结束字符串
     */
    String daoEnd = ">>>>>>>>>>>>>>>>>>>>>>>>>>>";

    //endregion

    //region md5加密

    /**
     * 实现,d5加密
     *
     * @param inStr 需要加密的字符串
     * @return 返回已加密的字符
     */
    default String string2MD5(String inStr)
    {
        MessageDigest md5 = null;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++)
        {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
            {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }
    //endregion

    //region 定义格式化时间变量
    /**
     * 定义格式化时间变量
     */
    SimpleDateFormat simpleDataFormat =
              new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //endregion

    //region 封装获取字符串长度方法

    /**
     * 封装获取字符串长度方法
     *
     * @param str 需要获取的字符串
     * @return 返回长度
     */
    default int getStringLength(String str)
    {
        return str.length();
    }
    //endregion
}

/*
DROP DATABASE tinyshop8;
CREATE DATABASE tinyshop8
DEFAULT CHARSET utf8;
 */
