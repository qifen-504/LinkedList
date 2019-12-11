package cn.xdl;


import com.sun.deploy.security.SelectableSecurityManager;

import javax.xml.stream.events.NotationDeclaration;

public class CircleLinkedlist {
    private int size ;//链表节点的个数
    private Node head;//头部节点

    private class Node {
        private Object data;//每个节点的数据
        private Node next;//指向下一个节点的指针

        public Node(Object data) {

            this.data = data;
        }
    }
    /**
     * 头部插入元素
     */
    public void add(Object obj){
        Node newNode =new Node(obj);
        int temp=0;
        for (Node cur = head;;cur=cur.next){
            temp++;
            if (temp==size){
                cur.next=newNode;
                newNode.next=head;
                head=newNode;
                break;
            }
        }
        size++;
    }
    /**
     * 从尾部增加
     */
    public void addLast(Object obj){
        Node newNode = new Node(obj);
        int temp=0;
        for (Node cur =head;;cur=cur.next){
            temp++;
            if (temp==size){
                cur.next=newNode;
                newNode.next=head;
                break;
            }
        }
        size++;

    }
    /**
     * 指定位置添加元素
     * @param obj 要添加的元素
     * @param index 指定的下标
     */
    public void addFirst(Object obj,int index){
        Node newNode =new Node(obj);
        if (head==null){
            head=newNode;
            head.next=head;
            size++;
        }else{
            Node node = head;
            int temp = 0;
            for (Node cur =head;;cur=cur.next){
                temp++;
                if (temp==index){
                    //将当前元素指向的位置给新节点指向
                    //再将当前元素指向新节点
                    newNode.next=cur.next;
                    cur.next=newNode;
                    if(index==size){
                        //最后一个元素
                        newNode.next=head;
                    }
                    size++;
                    break;
                }
            }
        }
    }

    /**
     * 删除元素
     */
    public void dele(int index) {
        if (index % size == 0) {
            //循环链表 考虑下标超过size
            head = head.next;
            size--;
        } else {
            int temp = 0;
            for (Node cur = head; ; cur = cur.next) {
                temp++;
                if (temp == index) {
                    cur.next = cur.next.next;
                    size--;
                    break;
                }
            }
        }
    }
    public void display(){
        int temp=0;
        for (Node cur = head;;cur=cur.next){
            System.out.print(cur.data+" ");
            temp++;
            if (temp==size){
                break;
            }
        }
        System.out.println();
        System.out.println("元素数量:"+temp);
    }
    /**
     * 修改元素
     */
    public boolean update (Object obj,Object targetObj){
        Node now = head;
        int temp = size;
        while (temp > 0) {
            if (targetObj.equals(now.data)) {
                now.data = obj;
                return true;
            } else {
                now = now.next;
            }
            temp--;
        }
        return false;
    }
}
