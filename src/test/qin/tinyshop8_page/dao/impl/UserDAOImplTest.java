package qin.tinyshop8_page.dao.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8_page.dao.UserDAO;

/**
 * Created by Administrator on 2017/8/4 0004-4.<br/>
 *
 * @author qinzhengying
 */
public class UserDAOImplTest implements ShopBaseSupport
{
    @Test
    public void findUser() throws Exception
    {
        ApplicationContext applicationContext = new
                  ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext
                  .getBean("userDAOImpl");
        User8JPA user8JPA = new User8JPA("root", "root");
        //superLogInfo(userDAO.findUser(user8JPA));
        superLogInfo(userDAO.registerUser(new User8JPA("tinyshop", "tinyshop")));
    }

}