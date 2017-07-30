package qin.dataStructure.qList;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/28 0028-28.<br/>
 *
 * @author qinzhengying
 * @since 1.8 2017/7/
 */
@Deprecated
public class MySqList<E> implements MyList<E>
{
    //region 提供构造函数
    public MySqList(Object[] elementData)
    {
        this.elementData = elementData;
    }

    //endregion

    protected Object[] elementData;

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
                  .append(elementData.length).toString();
    }
    //endregion

    //region 获取数组里的元素

    /**
     * 获取数组里的元素
     *
     * @param index 索引
     * @return 返回查找到的元素
     */
    @Override
    public E get(int index)
    {
        //做判断
        if (index > elementData.length || index < 0)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        return (E) elementData[index];
    }
    //endregion

    //region toString

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("MySqList{");
        sb.append("elementData=").append(Arrays.toString(elementData));
        sb.append('}');
        return sb.toString();
    }

    //endregion
}