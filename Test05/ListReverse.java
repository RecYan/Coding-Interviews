package Test05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Yan_Jiang on 2018/12/10.
 * 输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class ListReverse {

    //节点定义
    public static class ListNode {

        int val; // 结点的值
        ListNode next; // 下一个结点
        ListNode pre; // 下一个结点

    }
    public static ArrayList<Integer> result = new ArrayList<>();

    //非递归方式：使用栈结构
    public static ArrayList<Integer> Reverse(ListNode node) {

        Stack<ListNode> stack = new Stack<>();

        if(node == null){
            return null;
        }

        //遍历链表 并将值存入栈中
        while(node != null) {
            stack.push(node);
            node = node.next; //节点向后移动
        }

        ListNode tmp ;
        //遍历取出栈中节点的值
        while(!stack.isEmpty()) {
            tmp = stack.pop();
            result.add(tmp.val);
        }
        return result;
    }

    //递归方式
    public static ArrayList<Integer> Reverse_recursively(ListNode node) {

        if(node == null){
            return null;
        } else{
            //进行递归
            Reverse_recursively(node.next);
            result.add(node.val);
        }
        return result;

    }

    //将原链表逆序
    public static ArrayList<Integer> ReverseList(ListNode node) {

        ListNode next = null;
        ListNode pre = null;

        while(node != null) {

            next = node.next; //记录下一个节点
            node.next = pre; //改变链表顺序
            //pre和当前节点一次向后移动
            pre = node;
            node = next;
        }

        //将每个节点的值放入result中
        while(pre!=null){
            result.add(pre.val);
            pre = pre.next;
        }


        return result;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

//        System.out.println(Reverse(root));

//        System.out.println(Reverse_recursively(root));
        System.out.println(ReverseList(root));
    }


}
