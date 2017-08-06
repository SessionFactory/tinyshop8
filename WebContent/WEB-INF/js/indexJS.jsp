<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%-- 主页面的javascript脚本文件 --%>
<script type="text/javascript">
    //region 定义后台访问的基本路径
    /** 定义后台访问的基本路径*/
    basePath = "/indexPageController/";
    //endregion

    //region 页面一开始就要运行的方法
    $(function ()
            {
                //region 登录实现
                $('#doLogin').click(function ()
                        {
                            login();
                        }
                );
                //endregion

                //region 注册实现
                $('#doRegister').click(function ()
                        {
                            register();
                        }
                );
                //endregion
            }
    );
    //endregion

    //region 登录实现
    /**
     * 登录实现
     */
    function login()
    {
        //首先接收界面的用户名和密码的值
        var username = $('#username').val();
        var password = $('#password').val();

        //检查用户名和密码是否为空
        checkUser(username, password);

        var url = basePath + "doLogin.com?username=" + username +
                "       &&password=" + password;

        //将用户名和密码传送到后台实现登录
        $.ajax
        (
                {
                    url: url,
                    method: 'POST',
                    success: function (msg)
                    {
                        if (msg === "success")
                        {
                            window.location.href = "/tinyshop8/doMainView2.com?" +
                                    "username=" + username;
                        }
                    }
                }
        );
    }

    //endregion

    //region 注册实现
    /**
     * 注册实现
     */
    function register()
    {
        //首先接收界面的用户名和密码的值
        var username = $('#username').val();
        var password = $('#password').val();

        //检查用户名和密码是否为空
        checkUser(username, password);

        var url = basePath + "doRegister.com?username=" + username +
                "       &&password=" + password;

        //将用户名和密码传送到后台实现登录
        $.ajax(
                {
                    url: url,
                    method: 'POST',
                    success: function (msg)
                    {
                        alert(msg);
                    }
                }
        );
    }

    //endregion

    //region 抽取检查用户信息方法
    /**
     * 抽取检查用户信息方法
     * @param username 用户名
     * @param password 密码
     */
    function checkUser(username, password)
    {
        //用户名和密码都不能为空
        if (username.length === 0 || password.length === 0)
        {
            alert("用户名和密码不能为空!");
            return;
        }
    }

    //endregion

</script>
