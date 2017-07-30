package qin.dataStructure.qList;

import org.junit.Test;
import qin.dataStructure.chain.SingleLinkedList;

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
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.add(1, 1);
        System.out.println(singleLinkedList);

        //LinkedList<Integer> integers = new LinkedList<>();
        //integers.add(1, 1);
    }


}