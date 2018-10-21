package list.linkedList;

public  class LinkedList {

    /*插入节点*/
    public static <T> ListNode<T> addListNode(ListNode<T> head, ListNode<T>  insertListNode, int position){
        if(head == null){
            return insertListNode;
        }

        int listSize = size(head);
        /*可以插入到最后一个节点的下一个节点*/
        if(position > listSize+1 || position < 1 ){
            System.out.println("插入位置不正确,改链表的总长度为"+listSize);
            return head;
        }

        /*从头节点插入*/
        if(position == 1){
            insertListNode.setNext(head);
            return insertListNode;
        }else{
            ListNode<T> previousListNode = head;
            int count = 1;
            /*这里要找到插入位置的前一个节点*/
            while(count < position-1){
                previousListNode = previousListNode.getNext();
                count++;
            }
            ListNode<T> currentListNode = previousListNode.getNext();
            insertListNode.setNext(currentListNode);
            previousListNode.setNext(insertListNode);
            return head;
        }
    }

    /*删除节点*/
    public static <T> ListNode<T> removeListNode(ListNode<T> head, int position){
        if(head ==null){
            System.out.println("改链表为空");
            return null;
        }
        int listSize = size(head);
        if(position<1 || position >listSize){
            System.out.println("删除位置不正确，该链表长度为"+listSize);
            return head;
        }

        if(position == 1){
            ListNode<T> currentListNode = head.getNext();
            head = null;
            return currentListNode;
        }else{
            int count = 1;
            ListNode<T> previoustListNode = head;
            while (count < position-1){
                previoustListNode = previoustListNode.getNext();
                count++;
            }
            ListNode<T> currentListNode = previoustListNode.getNext();
            previoustListNode.setNext(currentListNode.getNext());
            currentListNode.setNext(null);
            return head;

        }
    }


    /*遍历链表*/
    public static <T> void  traverse(ListNode<T> head){
        ListNode<T> currentListNode = head;

        while(currentListNode.getNext() != null){
            System.out.print(currentListNode.getDate()+" -> ");
            currentListNode = currentListNode.getNext();
        }
        System.out.println(currentListNode.getDate());
    }


    /*链表长度*/
    public static <T> int size(ListNode<T>  head){
        int count = 0;
        ListNode<T>  currentListNode = head;
        while(currentListNode != null){
            count++;
            currentListNode = currentListNode.getNext();
        }
        return count;
    }

}
