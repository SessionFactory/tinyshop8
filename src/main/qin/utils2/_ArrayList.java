package qin.utils2;

/**
 * Created by Administrator on 2017/7/30 0030-30.<br/>
 * 线性表顺序存储结构
 *
 * @author qinzhengying
 * @since 1.8 2017/7/30
 */
@SuppressWarnings("all")
public class _ArrayList<E> implements _List<E>
{
    //region 定义必备变量
    /**
     * 存放一个数组来存放数据
     */
    private Object[] elementData;

    /**
     * 线性表最大长度
     */
    private Integer maxsize;

    //endregion

    //region 构造函数

    public _ArrayList() throws Exception
    {
        elementData = new Object[10];
        superLogInfo("正在初始化线性表顺序存储结构类");
    }
    //endregion

    //region 定义变量以及别的方法

    /**
     * 根据最大长度来初始化这个线性表
     *
     * @param maxsize 最大长度
     */
    public _ArrayList(Integer maxsize)
    {
        this.maxsize = maxsize;
        elementData = new Object[maxsize];
    }

    //endregion

    //region 迭代

    /**
     * 迭代数组中的元素
     *
     * @return 返回字符串
     */
    public String iterator()
    {
        StringBuilder result = new StringBuilder();

        result.append("数组中的元素:\n");

        for (int i = 0; i < elementData.length; i++)
        {
            result.append("\t").append(elementData[i])
                      .append(", ");
        }

        //截取最后一个逗号
        int lastIndexOf = result.toString().lastIndexOf(",");

        return result.toString().substring(0, lastIndexOf);
    }
    //endregion

    //region 新增元素(已测试成功)

    /**
     * 新增数据指针
     */
    private int index = 0;

    //region 检查数组是否越界

    /**
     * 检查数组是否越界
     *
     * @param index 索引值大小
     */
    private void ensureCapacityInternal(int index)
    {
        if (index == elementData.length || index < 0)
        {
            //有异常后把index清空否则后面会自加index
            index = 0;
            throw new ArrayIndexOutOfBoundsException("数组越界, 添加失败!");
        }
    }
    //endregion

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     * <p>
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.<br>
     * 新增元素默认在数组最后一个位置进行添加
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    @Override
    public boolean add(E e)
    {
        boolean flag = false;

        try
        {
            ensureCapacityInternal(index);

            //定义新增计数器
            StringBuilder msg = new StringBuilder()
                      .append("in ArrayList.add():")
                      .append("数组长度为")
                      .append(index)
                      .append(" 添加的元素为:")
                      .append(e)
                      .append("}");

            superLogInfo(msg.toString());

            if (elementData.length < 1)
            {
                throw new NullPointerException("in ArrayList.add:链表长度为0, 无法完成新增!");
            }

            elementData[index] = e;

            //添加元素之后执行自加
            ++index;

            flag = true;
        }
        catch (Exception ex)
        {
            superLogInfo("in ArrayList.add:添加失败!");
            printStackTrace(ex);
        }
        finally
        {
            return flag;
        }
    }
    //endregion

    //region 删除任意元素

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).<br>
     * 删除任意元素
     *
     * @param object element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *                                       is not supported by this list
     */
    @Override
    public boolean remove(Object object)
    {
        return false;
    }
    //endregion

    //region 在指定位置添加指定的元素(已测试成功)

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    @Override
    public void add(int index, E element)
    {
        try
        {
            //定义一个旧的数组用于存放原来的数据
            Object[] oldElementData = elementData;

            int size = elementData.length;

            //检查是否越界
            if ((size + 1) > maxsize)
            {
                //扩大容量为100倍
                elementData = new Object[maxsize * 100];
            }

            //将旧数组里的所有内容拷贝到elementData中
            for (int i = 0; i < oldElementData.length; i++)
            {
                elementData[i] = oldElementData[i];
            }

            //用arraycopy
            /*System.arraycopy(elementData, index, elementData, index + 1,
                             size - index);
            elementData[index] = element;
            size++;*/

            //插入到末尾
            if (index == size)
            {
                elementData[index] = element;
                size++;
                return;
            }

            //移动位置
            for (int j = size; j > index; j--)
            {
                elementData[j] = elementData[j - 1];
            }

            //插入数据
            elementData[index] = element;
            size++;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    //endregion

    //region 根据索引删除元素

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.<br>
     * 根据索引删除元素
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *                                       is not supported by this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    @Override
    public E remove(int index)
    {
        return null;
    }
    //endregion

    //region 根据索引获取元素

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    @Override
    public E get(int index)
    {
        return null;
    }
    //endregion
}