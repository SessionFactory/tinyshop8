package qin.tinyshop8.utils.ini;

import org.springframework.stereotype.Controller;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain8.jpa.User8JPA;

/**
 * Created by Administrator on 2017/8/1 0001-1.<br/>
 * 初始化用户信息
 *
 * @author qinzhengying
 * @since 1.8 2017/8/1
 */
@Controller(value = "iniUserJPA")
@SuppressWarnings("all")
public class UserJPA implements SuperPrintException,
          SessionBasic
{
    private static final long serialVersionUID = -4209085877841867047L;

    //region 初始化用户信息

    /**
     * 初始化用户信息
     */
    @Override
    public void ini()
    {
        try
        {
            User8JPA administrator = new User8JPA("administrator", "administrator");
            User8JPA root = new User8JPA("root", "root");

            session.save(administrator);
            session.save(root);

            transaction.commit();

            superLogInfo("初始化用户信息SUCCESS!");
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
    //endregion


}