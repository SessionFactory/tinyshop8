package qin.dataStructure.chain;

import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/7/29 0029-29.<br/>
 * 结点类
 *
 * @author qinzhengying
 * @since 1.8 2017/7/
 */
public class Node implements ShopBaseSupport
{
    private static final long serialVersionUID = -1278170861417453749L;

    //region 指针域(下一个元素)
    /**
     * 指针域(下一个元素)
     */
    public Node next;
    //endregion

    //region 数据域元素
    /**
     * 数据域元素
     */
    public int elementData;
    //endregion

    //region 带参数的构造函数

    /**
     * 带参数的构造函数
     *
     * @param elementData 数据域
     */
    public Node(int elementData)
    {
        this.elementData = elementData;
    }
    //endregion

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("next=").append(next);
        sb.append(", elementData=").append(elementData);
        sb.append('}');
        return sb.toString();
    }
}