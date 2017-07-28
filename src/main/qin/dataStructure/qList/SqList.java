package qin.dataStructure.qList;

import static qin.dataStructure.qList.Status.MAXSIZE;

/**
 * Created by Administrator on 2017/7/24 0024-24.<br/>
 * 定义顺序链表存储结构
 *
 * @author qinzhengying
 * @since 1.8 2017/7/24
 */
@SuppressWarnings("all")
public class SqList<E> implements MyList<E>
{
    private static final long serialVersionUID = 6054086044751182752L;

    //region 定义数组存储数据元素, 最大值为MAXSIZE
    /**
     * 定义数组存储数据元素, 最大值为MAXSIZE
     */
    private Object[] elementData;

    public Object[] getElementData()
    {
        return elementData;
    }

    public void setElementData(Object[] elementData)
    {
        this.elementData = elementData;
    }
    //endregion

    //region 构造函数
    public SqList()
    {
        this(MAXSIZE);
    }

    //region 提供带参数构造函数进行初始化
    public SqList(int size)
    {
        elementData = new Object[size];
    }
    //endregion

    //endregion

    //region 线性表当前长度
    /**
     * 线性表当前长度
     */
    private int size;
    //endregion

    //region 获取元素

    /**
     * 获取元素
     *
     * @param index 索引值
     * @return 返回获取到的元素值
     */
    @Override
    public E get(int index)
    {
        //首先做判断, 这里会增强ArrayList里的判断
        if (size == 0 || index < 1 || index > size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        //获取前一个元素
        return (E) elementData[index - 1];
    }
    //endregion

    //region 复制ArrayList专用方法

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index)
    {
        return new StringBuilder()
                  .append("Index: ")
                  .append(index)
                  .append(", Size: ")
                  .append(size).toString();
    }
    //endregion

    //region 新增元素

    /**
     * 新增元素
     *
     * @param elements 指定元素新增
     * @return 新增成功返回true 否则返回false
     */
    //@Override
    public boolean add(E elements, int insertLocation)
    {
        //线性表已满
        //if (size == MAXSIZE) return false;
        if (insertLocation >= size) return false;

        //插入数据不在表尾
        if (insertLocation < size)
        {
            //将要插入位置后数据元素向后移动一位
            for (int k = size - 1; size >= insertLocation - 1; k--)
            {
                elementData[k + 1] = elementData[k];
            }
        }

        //将元素插入
        elementData[insertLocation - 1] = elements;
        size++;

        return true;
    }

    //endregion

}