package qin.tinyshop8_page.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8_page.dao.UserDAO;
import qin.tinyshop8_page.service.UserService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/3 0003-3.<br/>
 * 用户服务层实现类
 *
 * @author qinzhengying
 * @since 1.8 2017/8/3
 */
@Service
@Transactional
@SuppressWarnings("all")
public class UserServiceImpl implements UserService
{
    private static final long serialVersionUID = 5115953879399647686L;

    //region 注入数据访问层
    /**
     * 注入用户数据访问层
     */
    private UserDAO userDAO;

    @Resource
    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }
    //endregion

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
        return userDAO.findUser(user);
    }

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
        return userDAO.registerUser(user);
    }
}