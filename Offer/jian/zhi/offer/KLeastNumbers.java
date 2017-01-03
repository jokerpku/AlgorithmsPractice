package jian.zhi.offer;

import java.util.Arrays;

/**
 * 获取链表中最小的K个数
 * 用一个大小为K的最大堆维护结果
 * Created by Jokeria on 2016/12/20.
 */
public class KLeastNumbers {
    public int[] getKLeastNumbers(LinkedNode head, int k) {
        if(head == null || k == 0) {
            throw new RuntimeException("Invalid input.");
        }

        MaxHeap heap = new MaxHeap(k);
        LinkedNode node = head;
        while(node != null) {
            if(heap.size() < k) {
                heap.add(node.val);
            } else if(node.val < heap.max()){
                heap.add(node.val);
            }
            node = node.next;
        }

        if(heap.size() < k) { // 链表长度小于k
            throw new RuntimeException("The length of the list is smaller than k.");
        }
        return heap.getNums();
    }

    public static void main(String[] args) {
        LinkedNode n1 = new LinkedNode(3);
        LinkedNode n2 = new LinkedNode(7);
        LinkedNode n3 = new LinkedNode(4);
        LinkedNode n4 = new LinkedNode(1);
        LinkedNode n5 = new LinkedNode(5);
        LinkedNode n6 = new LinkedNode(6);
        LinkedNode n7 = new LinkedNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        KLeastNumbers instance = new KLeastNumbers();
        int[] res = instance.getKLeastNumbers(n1, 0);
        for(int num : res) {
            System.out.print(num + " ");
        }
    }
}

class MaxHeap {
    private int[] nums;
    private int size;

    public MaxHeap(int k) {
        size = 0;
        nums = new int[k+1];
        nums[0] = 0;
    }

    public int size() {
        return size;
    }

    public int[] getNums() {
        if(nums.length <= 1) {
            return null;
        } else {
            return Arrays.copyOfRange(nums, 1, nums.length);
        }
    }

    public int max() {
        return nums[1];
    }

    public void add(int num) {
        if(size < nums.length-1) {
            nums[++size] = num;
            if(size == nums.length-1) { // 堆中有K个元素
                init();
            }
        } else {
            nums[1] = num;
            sink(1);
        }
    }

    private void sink(int index) {
        int i = index;
        while(2*i < nums.length) {
            int next = 2*i;
            if(next+1 < nums.length && nums[next+1] > nums[next]) {
                next = next + 1;
            }
            int temp = nums[i];
            nums[i] = nums[next];
            nums[next] = temp;

            i = next;
        }
    }

    private void init() {
        int i = (nums.length-1) >> 1;
        while(i > 0) {
            sink(i);
            i--;
        }
    }

}
