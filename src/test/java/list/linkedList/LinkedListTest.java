package list.linkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @Author: ymm
 * @Date: 2018/10/21 20:30
 * @Description:
 */
public class LinkedListTest {

    @Test
    public void addListNode() {
        ListNode<Integer> head = null;

        /*增加节点*/
        for(int i=1;i<=5;i++){
            ListNode<Integer> node = new ListNode<>();
            node.setDate(new Random().nextInt(100));
            head = LinkedList.addListNode(head, node, i);
        }
        /*遍历*/
        LinkedList.traverse(head);

        /*删除头节点*/
        head = LinkedList.removeListNode(head, 1);
        LinkedList.traverse(head);

        /*删除中间节点*/
        head =LinkedList.removeListNode(head, 2);
        LinkedList.traverse(head);

        /*删除尾节点*/
        head =LinkedList.removeListNode(head, 3);
        LinkedList.traverse(head);

    }

    @Test
    public void traverse() {
    }

    @Test
    public void size() {
    }
}