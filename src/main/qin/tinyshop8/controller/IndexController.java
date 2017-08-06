package qin.tinyshop8.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8_page.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/3 0003-3.<br/>
 * 主页控制层逻辑
 *
 * @author qinzhengying
 * @since 1.8 2017/8/3
 */
@Controller(value = "indexPageController")
@Scope("prototype")
@RequestMapping(value = "/indexPageController")
@SuppressWarnings("all")
public class IndexController extends BaseController
{
    private static final long serialVersionUID = -7239887827509429449L;

    //region 注入所需要的服务层

    //region 用户服务层
    /**
     * 用户服务层
     */
    private UserService userService;

    @Resource
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
    //endregion

    //endregion

    //region 登录实现

    /**
     * 登录实现
     *
     * @param user     用户实体类
     * @param response 回复
     */
    @RequestMapping(value = "/doLogin")
    public void doLogin(User8JPA user, HttpServletResponse response,
                        HttpServletRequest request)
    {
        try
        {
            doGetUser(user, response);

            //走到这里就说明都不为空
            //现在可以查询了(判断是否查询成功)
            if (userService.findUser(user))
            {
                request.getSession().setAttribute("password", "password");
                returnJson(str_success, response);
            }
            else
            {
                //就是不成功
                throwDataAccessException("用户查找失败, 登录失败! 检查用户名或密码是否正确!");
            }
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }

    //endregion

    //region 注册实现

    /**
     * 注册实现<br>
     * 新增用户记录
     *
     * @param user     用户实体类
     * @param response 回复
     */
    @RequestMapping(value = "/doRegister")
    public void doRegister(User8JPA user, HttpServletResponse response)
    {
        try
        {
            doGetUser(user, response);

            //实现注册功能
            FrameWorkDSCResult result = userService.registerUser(user);

            if (result.isDaoFlag())
            {
                //说明注册成功
                returnJson(str_success, response);
            }
            else
            {
                //输出异常信息
                String msg = "注册失败!" + result.getDaoException();
                returnJson(msg, response);
            }
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
    //endregion


}