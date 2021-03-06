package qin.tinyshop8_page.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.exceptions.dao.DuplicateInsertKeyDataAccessException;
import qin.javaee8.core.exceptions.dao.EmptyResultDataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ShopBasicDAOImpl;
import qin.tinyshop8_page.dao.UserDAO;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3 0003-3.<br/>
 * 用户数据访问层实现类
 *
 * @author qinzhengying
 * @since 1.8 2017/8/3
 */
@Repository
@SuppressWarnings("all")
public class UserDAOImpl
          extends ShopBasicDAOImpl<User8JPA, Long>
          implements UserDAO
{
    private static final long serialVersionUID = 4740665979069693308L;

    //region 提供默认构造函数
    public UserDAOImpl() throws Exception
    {
        superLogInfo("正在初始化用户数据访问层");
    }
    //endregion

    //region 重写实体类信息

    /**
     * 获取用户实体类 类 类型
     *
     * @return 返回获取到的实体类型
     */
    @Override
    public Class<User8JPA> getEntityClass()
    {
        return User8JPA.class;
    }

    //endregion

    //region 查询用户信息

    /**
     * 查询用户信息
     *
     * @param user 根据接收的用户实体类进行查找
     * @return 查询成功返回真 否则返回假
     * @throws DataAccessException 查询失败抛出异常
     */
    @Override
    public boolean findUser(User8JPA user) throws DataAccessException
    {
        List<User8JPA> userList = getSession()
                  .createQuery("from User8JPA where " +
                                         " username=:username and " +
                                         " password=:password ")
                  .setParameter("username", user.getUsername())
                  .setParameter("password", user.getPassword())
                  .list();

        if (userList.size() != 1)
        {
            throw new
                      EmptyResultDataAccessException("用户登录失败!");
        }

        return true;
    }
    //endregion

    //region 注册用户

    /**
     * 注册用户
     *
     * @param user 用户实体类
     * @return 返回查询结果大类
     * @throws DataAccessException 抛出数据访问层大异常
     */
    @Override
    public FrameWorkDSCResult registerUser(User8JPA user) throws DataAccessException
    {
        FrameWorkDSCResult result = new FrameWorkDSCResult();
        boolean resultFlag = false;
        //异常信息
        StringBuilder exceptions = new StringBuilder();

        try
        {
            //首先用户名和密码不能为空
            String username = user.getUsername();
            String password = user.getPassword();

            if (checkStringLength(username) && checkStringLength(password))
            {
                //执行新增
                //然后用户名不能在表中已存在
                List<User8JPA> searchList = getSession()
                          .createQuery("from User8JPA where username=:username ")
                          .setParameter("username", username)
                          .list();
                if (searchList.size() == 1)
                {
                    //说明表中已有记录抛出异常
                    DuplicateInsertKeyDataAccessException exp = new
                              DuplicateInsertKeyDataAccessException("用户名已在表中存在, 违反唯一性约束!");
                    exceptions.append("违反唯一性约束异常:[")
                              .append(exp)
                              .append("]");
                    resultFlag = false;
                    throw exp;
                }
                else
                {
                    //实现新增功能
                    getSession().save(user);
                    getTransaction().commit();
                    resultFlag = true;
                }
            }
            else
            {
                resultFlag = false;
                exceptions.append("\n用户名或密码为空, 注册失败!");
                //直接抛出异常
                throw new DataAccessException("用户名或密码为空, 注册失败!");
            }
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
        finally
        {
            if (exceptions.length() > 0)
            {
                Exception exception = new Exception(exceptions.toString());
                result.setDaoException(exception);
            }
            result.setDaoFlag(resultFlag);
            return result;
        }
    }
    //endregion

    //region 根据用户名查询用户信息

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 返回查询结果
     * @throws DataAccessException 如果查询失败就抛出大异常
     * @author qinzhengying
     * @since 1.8 2017/8/12
     */
    @Override
    public User8JPA findUserByUserName(String username)
              throws DataAccessException
    {
        List<User8JPA> userList = getSession()
                  .createQuery("from User8JPA where username=:username")
                  .setParameter("username", username)
                  .list();

        if (userList.size() != 1)
        {
            throw new
                      EmptyResultDataAccessException("用户查询失败!");
        }

        return userList.get(0);
    }

    //endregion


}