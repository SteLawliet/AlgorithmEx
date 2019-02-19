package Stack.QueueImpl;

/**
 * @program: exam
 * @description: QueueByStack
 * @author: Zhaoziqi
 * @create: 2019-02-19 22:20
 **/
import java.util.Stack;

public class QueueByStack {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    //使用stack1来保存后来push的
    //每次出栈时如果
    //俩个栈有俩种情况入
    public void push(int node) {
        this.stack1.push(node);
    }

    public int pop() {
        if(this.stack2.isEmpty()){
            while(!stack1.isEmpty()){
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.pop();
    }
}
