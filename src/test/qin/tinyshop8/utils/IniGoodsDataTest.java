package qin.tinyshop8.utils;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/7/16 0016-16.<br/>
 *
 * @author qinzhengying
 */
public class IniGoodsDataTest
{
    @Test
    public void ini() throws Exception
    {
        ApplicationContext applicationContext = new
                  ClassPathXmlApplicationContext("applicationContext.xml");
        IniGoodsData i = (IniGoodsData) applicationContext
                  .getBean("iniGoodsData");
        i.ini();
    }

}