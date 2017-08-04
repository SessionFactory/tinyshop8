package qin.tinyshop8.utils.ini;

import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/8/1 0001-1.<br/>
 * 重写输出异常信息方法
 *
 * @author qinzhengying
 * @since 1.8 2017/8/1
 */
public interface SuperPrintException extends ShopBaseSupport
{
    //region 以字符串形式输出异常信息

    /**
     * 以字符串形式输出异常信息
     *
     * @param ex 需要输出的异常
     * @return 返回字符串形式
     */
    @Override
    default String printStackTraceInfo(Exception ex)
    {
        StringBuilder sb = new StringBuilder();

        StackTraceElement[] stackTraceElements = ex.getStackTrace();

        for (int i = 0; i < stackTraceElements.length; i++)
        {
            StackTraceElement stackTraceElement = stackTraceElements[i];

            sb
                      .append("cause by class:")
                      .append(stackTraceElement.getClassName())
                      .append("\tcause by file name:")
                      .append(stackTraceElement.getFileName())
                      .append("\tcause by line number:")
                      .append(stackTraceElement.getLineNumber())
                      .append("\tcause by method:")
                      .append(stackTraceElement.getMethodName());
        }

        return sb.toString();
    }
    //endregion

    //region 实现初始化

    /**
     * 初始化表中信息
     */
    void ini();
    //endregion
}