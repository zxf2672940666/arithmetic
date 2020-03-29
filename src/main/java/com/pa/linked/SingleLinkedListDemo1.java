package com.pa.linked;

public class SingleLinkedListDemo1 {

    public static void main(String[] args) {
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(3, "林冲", "豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.add(heroNode4);

        linkedList.list();
    }
}

//定义一个SingleLinkedList来管理我们的英雄
class SingleLinkedList {
    //先初始化一个头结点，头结点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");


    //添加节点到单向链表
    //不考虑编号顺序时
    //1、找到当前链表的最后节点
    //2、将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助
        HeroNode temp = head;
        //遍历链表找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向链表的最后
        temp.next = heroNode;
    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

//定义一个HeroNode，每个HeroNode的对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
