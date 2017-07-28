package qin.utils2;

import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/7/26 0026-26.<br/>
 * 模仿c程序的数组功能<br>
 * 如果想要重写方法可以实现此接口重写
 *
 * @author qinzhengying
 * @author c
 * @since 1.8 2017/7/26
 */
public interface ArrayUtils extends ShopBaseSupport
{
    //region 翻转数组里的所有元素

    /**
     * 翻转数组里的所有元素
     *
     * @param array 任意类型数组
     * @param <T>   任意类型
     * @return 返回反转后的数组
     */
    default <T> T[] reverseArray(T[] array)
    {
        //记录长度
        int length = array.length;

        //循环交换
        for (int i = 0; i < length / 2; i++)
        {
            T t = array[i];
            int index = length - i - 1;
            array[i] = array[index];
            array[index] = t;
        }

        return array;
    }
    //endregion


}
