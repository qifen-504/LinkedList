package cn.xdl;

public class test {
    public static void main(String[] args) {
        CircleLinkedlist cl =new CircleLinkedlist();
        cl.addFirst("德玛西亚",0);
        cl.addFirst("德玛西亚2",1);
        cl.addFirst("德玛西亚3",2);
        cl.addFirst("德玛西亚4",3);
        System.out.println("当前元素");
        cl.display();
        System.out.println("---------------------------------------");

        cl.addFirst("德玛西亚5",7);
        System.out.println("插入后元素");
        cl.display();
        cl.dele(5);
        System.out.println("删除后");
        cl.display();
        cl.update("德玛西亚6","德玛西亚4");
        System.out.println("修改后");
        cl.display();
        System.out.println("---------------------------------------");
        cl.add("诺克萨斯");
        cl.display();
        cl.addLast("艾欧尼亚");
        cl.display();
    }
}
