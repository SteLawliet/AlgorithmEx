package Stack;

/**
 * @program: exam
 * @description: ss
 * @author: Zhaoziqi
 * @create: 2019-02-20 23:36
 **/

import java.util.Stack;

/*
题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（
注意：这两个序列的长度是相等的）
*/
public class Solution {

    //1.按pushA的序列遍历压入s栈
    //2.检查s栈的顶元素是不是和popA的j号元素相等。
    //3.如果相等就pop出，j++
    //循环2的操作直到栈为空或者popA遍历完
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length < 1 || popA.length < 1) {
            return false;
        }
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while (j <= i && s.peek() == popA[j]) {
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}