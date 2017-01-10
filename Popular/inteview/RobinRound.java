package inteview;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 轮询调度算法。
 * CPU接收多个请求，按照请求到达的顺序处理，每个请求执行一定的时间后执行下一个请求，未完成的请求放置到队尾
 * 计算请求等待的平均时间。
 *
 * 最短时间优先处理算法。
 * 先处理执行时间最短的请求，若执行时间相同则先处理先到达的请求
 * 计算请求等待的平均时间。
 * Created by Jokeria on 2017/1/10.
 */
public class RobinRound {
    class Request {
        int arriveTime;
        int remains;

        public Request(int arriveTime, int remains) {
            this.arriveTime = arriveTime;
            this.remains = remains;
        }
    }
    public double robinRound(int[] arrives, int[] remains, int slot) {
        if(arrives == null || remains == null || slot <= 0 || arrives.length != remains.length) {
            throw new RuntimeException("Invalid Input.");
        }

        Queue<Request> queue = new LinkedList<Request>();
        int curTime = 0;
        int waitSum = 0;
        int i = 0;
        while(i < arrives.length || !queue.isEmpty()) {
            if(!queue.isEmpty()) {
                Request peek = queue.poll();
                waitSum += curTime - peek.arriveTime;
                if(peek.remains > slot) {
                    curTime += slot;
                    peek.remains -= slot;
                    peek.arriveTime = curTime;
                } else {
                    curTime += peek.remains;
                    peek.remains = 0;
                }

                while(i < arrives.length && arrives[i] <= curTime) {
                    queue.offer(new Request(arrives[i], remains[i]));
                    i++;
                }

                if(peek.remains > 0) {
                    queue.offer(peek);
                }
            } else {
                curTime = arrives[i];
                queue.offer(new Request(arrives[i], remains[i]));
                i++;
            }
        }

        double res = ((double) waitSum) / arrives.length;
        return res;
    }

    public double shortestJobFirst(int[] arrives, int[] remains) {
        if(arrives == null || remains == null || arrives.length != remains.length) {
            throw new RuntimeException("Invalid Input.");
        }

        PriorityQueue<Request> heap = new PriorityQueue<Request>(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                if(o1.remains != o2.remains) {
                    return o1.remains - o2.remains;
                } else {
                    return o1.arriveTime - o2.arriveTime;
                }
            }
        });

        int curTime = 0;
        int waitSum = 0;
        int i = 0;
        while(i < arrives.length || !heap.isEmpty()) {
            if(!heap.isEmpty()) {
                Request peek = heap.poll();
                waitSum += curTime - peek.arriveTime;
                curTime += peek.remains;

                while(i < arrives.length && arrives[i] <= curTime) {
                    heap.offer(new Request(arrives[i], remains[i]));
                    i++;
                }
            } else {
                curTime = arrives[i];
                heap.offer(new Request(arrives[i], remains[i]));
                i++;
            }
        }

        return ((double)waitSum) / arrives.length;
    }

    public static void main(String[] args) {
        RobinRound instance = new RobinRound();
//        double res = instance.robinRound(new int[]{1,3,3,5,6}, new int[]{4,2,5,5,6}, 3);
//        System.out.println(res);

//        double res = instance.shortestJobFirst(new int[]{1,3,3,5,6}, new int[]{4,2,5,5,6});
        int[] req = {1, 3, 3, 6, 6, 6, 7};
        int[] dur = {2 ,2 ,3 ,2, 4, 4, 2};
        double res = instance.shortestJobFirst(req, dur);
        System.out.println(res);
    }
}
