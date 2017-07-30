package qin.utils2;

import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * 模仿c语言集合框架抽取的功能接口
 *
 * @param <E> 任意类型
 * @author qinzhengying
 * @since 1.8 2017/7/30
 */
public interface _Collection<E> extends ShopBaseSupport
{
    //region 新增元素

    /**
     * 新增元素<br>
     * 默认添加在链表的最后一个元素
     *
     * @param e 需要新增的元素
     * @return 返回新增结果
     */
    boolean add(E e);
    //endregion

    //region 删除元素

    /**
     * 删除元素
     *
     * @param object 需要删除的元素
     * @return 返回删除结果
     */
    boolean remove(Object object);
    //endregion
}
