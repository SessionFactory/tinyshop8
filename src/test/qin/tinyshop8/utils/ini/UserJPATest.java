package qin.tinyshop8.utils.ini;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qin.tinyshop8_page.controller.IniGoodsUser;

/**
 * Created by Administrator on 2017/8/2 0002-2.<br/>
 *
 * @author qinzhengying
 */
public class UserJPATest
{
    @Test public void _IniGoodsUser() throws Exception{
        IniGoodsUser i = new IniGoodsUser();
        i.ini();
    }

    //@Test
    public void ini() throws Exception
    {
        String bean = "iniUserJPA";
        ApplicationContext applicationContext = new
                  ClassPathXmlApplicationContext("applicationContext.xml");

        /*GoodsTypeJPA_Adminstarator springBean =
                  (GoodsTypeJPA_Adminstarator)
                            applicationContext.getBean(bean);
        springBean.ini();*/

        UserJPA userJPA = (UserJPA) applicationContext
                  .getBean(bean);
        userJPA.ini();
    }

}