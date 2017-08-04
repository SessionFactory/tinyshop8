package qin.tinyshop8.controller;

import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ini.SuperPrintException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/3 0003-3.<br/>
 * 顶层控制层
 *
 * @author qinzhengying
 * @since 1.8 2017/8/3
 */
@SuppressWarnings("all")
public class BaseController implements SuperPrintException
{
    private static final long serialVersionUID = -8103707620227117481L;

    //region 重写父类初始化方法
    @Override
    public void ini()
    {
    }
    //endregion

    //region 将抛出默认构造函数异常封装

    /**
     * 抛出无参数的数据访问层异常
     *
     * @param msg 接收的消息
     * @throws DataAccessException 接收数据访问层异常
     */
    protected void throwDataAccessException(String msg) throws DataAccessException
    {
        if (msg != null)
        {
            throw new DataAccessException(msg);
        }
        throw new DataAccessException();
    }
    //endregion

    //region 将获取用户的方法封装出来

    /**
     * 将获取用户的方法封装出来
     *
     * @param user     用户实体类
     * @param response 请求
     * @throws IOException         抛出io异常
     * @throws DataAccessException 抛出数据访问层异常
     */
    protected void doGetUser(User8JPA user, HttpServletResponse response)
              throws IOException, DataAccessException
    {
        //接收用户名和密码(由于从前台接受的值有空格所以要去除)
        String username = trim(user.getUsername());
        String password = trim(user.getPassword());

        //判断用户名和密码是否为空
        if (!(checkStringLength(username)))
        {
            returnJson("用户名不能为空!", response);
            throwDataAccessException(null);
        }
        if (!(checkStringLength(password)))
        {
            returnJson("密码不能为空", response);
            throwDataAccessException(null);
        }

        //重新设置值
        user.setPassword(password);
        user.setUsername(username);
    }
    //endregion

}