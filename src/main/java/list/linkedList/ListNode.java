package list.linkedList;

import lombok.Data;

/**
 * @Author: ymm
 * @Date: 2018/10/21 20:26
 * @Description:
 */
@Data
public class ListNode<T> {
    T date;
    ListNode<T> next;
}
