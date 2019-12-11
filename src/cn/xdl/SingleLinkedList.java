package cn.xdl;


import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import javafx.beans.binding.ObjectExpression;

import static jdk.nashorn.internal.runtime.Debug.id;

public class SingleLinkedList {
    private int size ;//链表节点的个数
    private Node head;//头部节点

    /**
     * 创建一个空的链表
     */
    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    private class Node {
        private Object data;//每个节点的数据
        private Node next;//指向下一个节点的指针

        public Node(Object data) {

            this.data = data;
        }
    }

    /**
     * 向链表头部添加元素
     */
    public Object addFromHead(Object obj) {
        Node newStart = new Node(obj);
        if (size == 0) {
            head = newStart;
        } else {
            newStart.next = head;
            head = newStart;
        }
        size++;
        return obj;
    }

    /**
     * 从链表指定位置追加
     */
        public void addFromMid(int index,Object obj){
            Node newNode = new Node(obj);
//            if (head==null||size==0){
//                head=newNode;
//                return;
//            }
            if (size > 1 && index <= size){

                Node cur = head; //记录目标位置后一个结点
                Node pre = head; //记录目标位置前一个结点

                for (int i =1;i<=index;i++){
                     pre=cur;
                     cur=cur.next;
                    if(i==index){
                        pre.next=newNode;
                        newNode.next=cur;
                        break;
                    }
                }
                size++;
            }else{
                throw  new IndexOutOfBoundsException("位置不合法");
            }
        }
    /**
     * 从链表尾部追加元素
     */
        public void addFromLast(Object obj){
            Node newNode = new Node(obj);
            Node node=head;
            int temp = size;
            while (temp>0){
                if (node.next==null){
                    node.next=newNode;
                }else{
                    node=node.next;
                }
                temp--;
            }
            size++;
        }

        /**
         * 从链表头部删除元素
         */
        public Object deleFromHead () {
            Object obj = head.data;
            head = head.next;
            size--;
            return obj;
        }
    /**
     * 删除链表尾部元素
     */
    public void deleFromLast(){
        if (head==null){
            throw new NullPointerException("链表无元素");
        }else if (head.next==head){
            head=null;
            return;
        }else {
            Node cur = head;
            while (cur.next!=null&&cur.next.next!=null){
                cur=cur.next;//找到倒数第二个节点
            }
            cur.next=null;//倒数第二个节点的next赋值null

        }
        size--;

    }
    /**
     * 从指定位置删除元素
     */
    public boolean deleFromMid(int index){
        if (size>1&&index<=size){
            Node pre =head;
            for (int i =1;i<=index;i++){
                if (i==index){
                    pre.next=pre.next.next;
                    break;
                }else {
                    pre =pre.next;
                }
            }
            size --;
        }else {
            throw  new IndexOutOfBoundsException("位置不合法");
        }
    return true;

    }

    /**
     * 修改链表数据
         */
        public boolean update (Object obj){
            Node now = head;
            int temp = size;
            while (temp > 0) {
                if (obj.equals(now.data)) {
                    now.data = obj;
                    return true;
                } else {
                    now = now.next;
                }
                temp--;
            }
            return false;
        }
        public Node findNode (Object obj){
            Node now = head;
            int temp = size;
            while (temp > 0) {
                if (obj.equals(now.data)) {
                    return now;
                } else {
                    now = now.next;
                }
                temp--;
            }
            return null;
        }
    //显示节点信息
      public void display(){
                 if(size >0){
                         Node node = head;
                         int tempSize = size;
                         if(tempSize == 1){//当前链表只有一个节点
                                 System.out.println("["+node.data+"]");
                                 return;
                             }
                         while(tempSize>0){
                                 if(node.equals(head)){
                                         System.out.print("["+node.data+"-->");
                                     }else if(node.next == null){
                                         System.out.print(node.data+"]");
                                     }else{
                                         System.out.print(node.data+"-->");
                                     }
                                 node = node.next;
                                 tempSize--;
                             }
                         System.out.println();
                     }else{//如果链表一个节点都没有，直接打印[]
                         System.out.println("[]");
                     }

             }

         }




