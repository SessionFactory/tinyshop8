package qin.utils2;

import org.junit.Test;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/7/30 0030-30.<br/>
 *
 * @author qinzhengying
 */
public class _ArrayListTest implements ShopBaseSupport
{
    @Test
    public void add() throws Exception
    {
        _ArrayList<Integer> arrayList = new _ArrayList<>(100);

        /*ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(1, 1);
        System.out.println(arrayList1);*/

        for (int i = 0; i < 100; i++)
        {
            System.out.println(arrayList.add(i));
        }

        arrayList.add(10, 9900);

        superLogInfo(arrayList.iterator());
    }

}