package qin.tinyshop8.utils;

import qin.javaee8.core.support.SuperEntity8;

/**
 * 超级Long型主键实体类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
public class SuperLongEntity implements ShopBaseSupport,
          SuperEntity8<Long>
{
    private static final long serialVersionUID = -6850158350527621790L;

    private Long id;

    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;
    }
}