package qin.dataStructure.qList;

import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/7/25 0025-25.<br/>
 * 封装的List接口<br>
 * 改进版的<code>{@link java.util.List}</code>
 *
 * @author qinzhengying
 * @since 1.8 2017/7/25
 */
public interface MyList<E> extends ShopBaseSupport
{
    //region 获取元素

    /**
     * 根据索引获取元素
     *
     * @param index 索引
     * @return 返回查找到的元素
     */
    E get(int index);
    //endregion

    //region 新增元素

    /**
     * 新增元素
     *
     * @param index 添加到哪里去
     * @param data  要添加的数据
     */
    default void add(int index, int data)
    {
    }
    //endregion

    //region 插入头结点

    /**
     * 插入头结点
     *
     * @param data 数据
     */
    default void addFirst(int data)
    {
    }
    //endregion
}
