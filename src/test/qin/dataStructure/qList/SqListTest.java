package qin.dataStructure.qList;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/28 0028-28.<br/>
 *
 * @author qinzhengying
 */
public class SqListTest
{

    @Test
    public void get() throws Exception
    {
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList);
        MySqList<Integer> mySqList = new
                  MySqList<>(new Integer[]{1, 2, 3, 4, 5});
    }


}