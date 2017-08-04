package qin.tinyshop8.utils.ini;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/8/2 0002-2.<br/>
 *
 * @author qinzhengying
 */
public class UserJPATest
{
    @Test
    public void ini() throws Exception
    {
        String bean = "ini_administrator_goodsType";
        ApplicationContext applicationContext = new
                  ClassPathXmlApplicationContext("applicationContext.xml");

        GoodsTypeJPA_Adminstarator springBean =
                  (GoodsTypeJPA_Adminstarator)
                            applicationContext.getBean(bean);
        springBean.ini();

        /*UserJPA userJPA = (UserJPA) applicationContext
                  .getBean(bean);
        userJPA.ini();*/
    }

}