package jian.zhi.offer;

import java.util.LinkedList;

/**
 * 0,1,2,3,...,n-1这n个数字组成一个圆圈，从0开始每次从圆圈中删除第m个数字，求从圆圈中删除的最后一个数字
 * 解法一：用链表的形式表示一个圆圈，n-1次遍历，每次遍历走m步
 * 解法二：用数学公式求解,f(n,m) = (f(n-1,m) + m ) % n, f(1,m) = 0;
 * Created by Jokeria on 2017/1/3.
 */
public class LastNumberInCircle {

    public int lastNumberInCircle(int n, int m) {
        if(n <= 0 || m <= 0) {
            return -1;
        }

        LinkedNode head = new LinkedNode(0);
        LinkedNode tail = head;
        for(int i = 1; i < n; i++) {
            LinkedNode temp = new LinkedNode(i);
            tail.next = temp;
            tail = temp;
        }
        tail.next = head;

        LinkedNode pre = tail;
        LinkedNode cur = head;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                pre = cur;
                cur = cur.next;
            }

            pre.next = cur.next;
            cur = cur.next;
        }

        return cur.val;
    }

    public int lastNumberInCircle2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int last = 0;
        for(int i = 2; i <= n; i++) {
            last = (last + m ) % i;
        }

        return last;
    }

    public static void main(String[] args) {
        LastNumberInCircle instance = new LastNumberInCircle();
//        int res = instance.lastNumberInCircle(10, 10);
        int res = instance.lastNumberInCircle2(6, 3);
        System.out.println(res);
    }


}
