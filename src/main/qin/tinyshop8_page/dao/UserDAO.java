package qin.tinyshop8_page.dao;

import qin.javaee8.core.dao.DAOSupport8;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/8/3 0003-3.<br/>
 * 用户数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/8/3
 */
public interface UserDAO extends DAOSupport8<User8JPA, Long>,
          ShopBaseSupport
{
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
    User8JPA findUserByUserName(String username) throws DataAccessException;
    //endregion

    //region 查询用户信息

    /**
     * 查询用户信息
     *
     * @param user 根据接收的用户实体类进行查找
     * @return 查询成功返回真 否则返回假
     * @throws DataAccessException 查询失败抛出异常
     */
    boolean findUser(User8JPA user) throws DataAccessException;
    //endregion

    //region 注册用户

    /**
     * 注册用户
     *
     * @param user 用户实体类
     * @return 返回查询结果大类
     * @throws DataAccessException 抛出数据访问层大异常
     */
    FrameWorkDSCResult registerUser(User8JPA user) throws DataAccessException;
    //endregion
}
