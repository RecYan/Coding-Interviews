package Test07;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Yan_Jiang on 2018/12/12.
 * 用两个队列模拟栈
 */
public class StackWithTwoQueues<T> {

    Queue<T> q1 = new PriorityQueue<>();
    Queue<T> q2 = new PriorityQueue<>();

    public void push(T t) {
        if(!q1.isEmpty()){
            //向q1插入元素 模拟压栈
            q1.offer(t); //add() 底层调用了offer方法
        } else {
            q2.offer(t);
        }

    }

    // 将元素入队q1 删除时 则当q2队列不为空是将q1出队的元素 入队q2 然后删除与栈中对应的元素
    public T pop() {

        if(q1.isEmpty() && q2.isEmpty()) {
            System.out.println("模拟队列为空...");
        } else{
            if(q2.isEmpty()) {
                while(q1.size() != 1) { //保留最后一个元素 用来模拟出栈
                    q2.offer(q1.poll()); //将 1到n-1 的元素 入队q2
                }
                return q1.poll(); //出栈操作
            }
            if(q1.isEmpty()) {
                while(q2.size() != 1) {
                    q1.offer(q2.poll());
                }
                return q2.poll();
            }
        }

        return null;
    }
}
