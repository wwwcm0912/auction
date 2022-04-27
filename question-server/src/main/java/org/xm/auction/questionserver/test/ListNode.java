package org.xm.auction.questionserver.test;

import lombok.Data;

@Data
public class ListNode {
    int val; // 数据：节点数据
    ListNode next; // 对象: 引用下一个节点对象,

    public ListNode (int v){
        val = v;
    }
}
