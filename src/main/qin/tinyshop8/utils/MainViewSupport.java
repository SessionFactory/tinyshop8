package qin.tinyshop8.utils;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 将doMainView抽象成一个接口
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
@SuppressWarnings("all")
public interface MainViewSupport
{
    /**
     * 返回页面的首页
     *
     * @return 直接新建一个实例返回
     */
    ModelAndView doMainView();
}
