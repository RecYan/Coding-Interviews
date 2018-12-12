package Test07;

import java.util.Stack;

/**
 * Created by Yan_Jiang on 2018/12/12.
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class MyQueue<T> {

    // 插入栈，插入的数据 -- 模拟队列的插入操作
    private Stack<T> stack1 = new Stack<>();
    // 弹出栈，弹出数据 -- 模拟队列的删除操作
    private Stack<T> stack2 = new Stack<>();

    // 队列的插入操作 只在stack1中插入
    public void appendTail(T t) {
        stack1.add(t);
    }

    // 删除操作，在队列头部删除结点
    public T deleteHead() {
        //stack2为空时 将stack1中元素压人stack2
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        } else {
            System.out.println("stack2不为空...");
        }

        return stack2.pop();
    }


}
