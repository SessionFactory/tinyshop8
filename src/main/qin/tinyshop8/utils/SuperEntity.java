package qin.tinyshop8.utils;

import java.io.Serializable;

/**
 * 超级实体类封装<br>
 * 由于包里自带的超级实体类默认实现了
 * <code>{@link qin.javaee8.core.JavaEE8BaseSupport}</code>
 * 接口, 所以在配置文件上会发生错误<br>
 * 这里重写这个接口重新实现, 由子类自己实现
 *
 * @param <T> 任意 主键 类型
 * @author qinzhengying
 * @since 1.8 2017/7/15
 */
public interface SuperEntity<T extends Serializable>
{
    /**
     * 获取我的主键
     *
     * @return 返回获取到的主键
     */
    T getId();

    /**
     * 设置主键
     *
     * @param id
     */
    void setId(T id);
}