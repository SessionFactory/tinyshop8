package qin.javaee8.testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qin.tinyshop8.utils.ShopBaseSupport;

public class MakeTable implements ShopBaseSupport
{
    Session session =
              (
                        (SessionFactory) new
                                  ClassPathXmlApplicationContext("applicationContext.xml")
                                  .getBean("sessionFactory")
              ).openSession();

    Transaction transaction = session.beginTransaction();

    @Test
    public void make()
    {

    }
}