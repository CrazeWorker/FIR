package com.zc.node;

import org.junit.Test;

public class ListArrays<T> {
    // 插入位置为index的位置
    public void insert(ListNode<T> head,ListNode<T> node,int index){
        ListNode<T> p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
    }

    // 遍历打印链表
    public void print(ListNode<T> head) {
        ListNode<T> p = head.next;
        while (p != null) {
            System.out.print(p.value+" ");
            p = p.next;
        }
        System.out.println();
    }

    // 求链表长度size
    public int size(ListNode<T> head){
        ListNode<T> p = head.next;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    // 链表尾部插入
    public void insert(ListNode<T> head,ListNode<T> node) {
        ListNode<T> p = head.next;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
    }

    // 链表指定位置删除
    public void remove(ListNode<T> head, int index) {
        ListNode<T> p = head;
        ListNode<T> q = p.next;
        for (int i = 0; i < index; i++) {
            p = q;
            q = q.next;
        }
        p.next = q.next;
        q.next = null;
    }

    @Test
    public void testInsert() {
        ListNode<Integer> head = new ListNode<>();
        head.value = null;
        ListNode<Integer> p1 = new ListNode<>();
        p1.value = 1;
        head.next = p1;
        ListNode<Integer> p2 = new ListNode<>();
        p2.value = 2;
        p1.next = p2;
        ListNode<Integer> p3 = new ListNode<>();
        p3.value = 3;
        p2.next = p3;
        ListNode<Integer> p4 = new ListNode<>();
        p4.value = 4;
        p3.next = p4;
        ListNode<Integer> p5 = new ListNode<>();
        p5.value = 5;
        p4.next = p5;
        ListArrays<Integer> tools = new ListArrays<>();
        //测试打印
        tools.print(head);
        //测试插入index位置
        ListNode<Integer> node = new ListNode<>();
        node.value = 13;
        tools.insert(head,node,3);
        tools.print(head);
        //测试求链表长度size
        System.out.println(tools.size(head));
        //测试尾部插入
        ListNode<Integer> node2 = new ListNode<>();
        node2.value = 1;
        tools.insert(head, node2);
        tools.print(head);
        //测试删除
        tools.remove(head, 2);
        tools.print(head);
    }
}
