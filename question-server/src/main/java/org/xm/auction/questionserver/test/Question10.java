package org.xm.auction.questionserver.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question10 {
    /**
     * 两数之和
     *
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public static List<Integer> twoSum(List<Integer> nums, Integer target) {
        List<Integer> resList = Lists.newArrayList();
        for (int i = 0; i < nums.size(); i++) {
            Integer i1 = i;
            Integer n2 = target - nums.get(i);
            if (nums.contains(n2)) {
                Integer i2 = nums.indexOf(n2);
                resList.add(i1);
                resList.add(i2);
                break;
            } else {
                throw new RuntimeException("暂无符合目标条件数据");
            }
        }
        return resList;
    }

    /**
     *
     * 两数相加
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     */
    public static ListNode twoAdd(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null){
            return listNode2;
        } else if(listNode2 == null) {
            return listNode1;
        }
        // 判断两个链表是否等长,不等长则左补0使之相等
        if(size(listNode1) > size(listNode2)) {
            listNode2 = complete(listNode2,size(listNode1) - size(listNode2));
        } else {
            listNode1 = complete(listNode1,size(listNode2) - size(listNode1));
        }

        // 反转链表
        listNode1 = reverseList(listNode1);
        listNode2 = reverseList(listNode2);

        ListNode resListNode = new ListNode(0);
        ListNode listNode = resListNode;
        // 相加总和
        int sum = 0;
        // 进位值
        int prog = 0;
        while (listNode1 != null && listNode2 != null) {
            sum = listNode1.val + listNode2.val + prog;
            prog = sum / 10;
            sum = sum % 10;
            listNode.next = new ListNode(sum); // 尾插法
            listNode = listNode.next; // 后移
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        // 最高位还有进位
        if(prog != 0 ) {
            listNode.next = new ListNode(prog);
        } else {
            // 去掉最前面的0,防止反转后数值不对
            resListNode = resListNode.next;
        }
        return reverseList(resListNode);
    }

    /**
     * 获取链表长度
     * @param node
     * @return
     */
    public static int size(ListNode node) {
        if(node == null) {
            return 0;
        }
        int size = 0;
        while (node != null) {
            node = node.next;
            size ++;
        }
        return size;
    }

    /**
     * 左位补个0
     * @param node
     * @param num
     * @return
     */
    public static ListNode complete(ListNode node ,int num) {
        if(node == null || num <= 0) {
            return node;
        }
        for (int i = 0; i < num; i++) {
            ListNode n0 = new ListNode(0);
            n0.next = node;
            node = n0;
        }
        return node;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        /**
         * 两数之和
         */
//        List<Integer> list = Arrays.asList(1, 6, 9, 7, 3);
//        List<Integer> sum = twoSum(list, 7);
//        System.out.println(sum);

        /**
         * 两数相加
         */

        ListNode listNode1 = new ListNode(2);
//        listNode1.next = new ListNode(2);
//        listNode1 = listNode1.next;
        listNode1.next = new ListNode(4);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(5);
//        listNode2 = listNode2.next;
        listNode2.next = new ListNode(6);
        listNode2 = listNode2.next;
        listNode2.next = new ListNode(4);

        ListNode listNode = twoAdd(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
