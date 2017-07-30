package qin.dataStructure.chain;

import qin.dataStructure.qList.MyList;

/**
 * Created by Administrator on 2017/7/29 0029-29.<br/>
 * 单链表
 *
 * @author qinzhengying
 * @since 1.8 2017/7/
 */
public class SingleLinkedList<E> implements MyList<E>
{
    private static final long serialVersionUID = -5307166916526555364L;

    //region 获取元素

    /**
     * 根据索引获取元素
     *
     * @param index 索引
     * @return 返回查找到的元素
     */
    @Override
    public E get(int index)
    {
        return null;
    }

    //endregion

    //region 定义头结点
    /**
     * 头结点
     */
    private Node first;
    //endregion

    //region 定义结点位置
    /**
     * 结点位置
     */
    private int pos = 0;
    //endregion

    //region 插入头结点
    /**
     * 插入头结点
     * @param data 数据
     */
    @Override
    public void addFirst(int data)
    {
        Node node = new Node(data);
        node.next = first;
        first = node;
    }
    //endregion

    //region 新增元素

    /**
     * 新增元素(在任意位置新增数据)
     *
     * @param index 添加到哪里去
     * @param data  要添加的数据
     */
    @Override
    public void add(int index, int data)
    {
        Node node = new Node(data);
        Node current = first;
        Node previous = first;
        while (pos != index)
        {
            previous = current;
            current = current.next;
            pos++;
        }
        node.next = current;
        previous.next = node;
        pos = 0;
    }

    //endregion

    //region 显示所有结点信息

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("SingleLinkedList{");
        sb.append("first=").append(first);
        sb.append(", pos=").append(pos);
        sb.append("}\n");

        Node current = first;
        while (current != null)
        {
            sb.append(current);
            current = current.next;
        }

        return sb.toString();
    }

    //endregion
}