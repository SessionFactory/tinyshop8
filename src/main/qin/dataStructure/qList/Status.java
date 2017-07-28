package qin.dataStructure.qList;

import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/7/24 0024-24.<br/>
 * 运行状态变量封装
 *
 * @author qinzhengying
 * @since 1.8 2017/7/24
 */
@SuppressWarnings("all")
public final class Status implements ShopBaseSupport
{
    private static final long serialVersionUID = 5719623592003099831L;

    private Status()
    {
    }

    /**
     * 最大值
     */
    public static int MAXSIZE = 20;

    /**
     * 封装真变量
     */
    private static int _true = 1;

    /**
     * 封装假变量
     */
    private static int _false = 0;

    /**
     * 封装ok变量
     */
    public static final int OK = _true;

    /**
     * 封装错误变量
     */
    public static final int ERROR = _false;

    /**
     * 返回true
     */
    public static final int TRUE = _true;

    /**
     * 返回false
     */
    public static final int FALSE = _false;
}