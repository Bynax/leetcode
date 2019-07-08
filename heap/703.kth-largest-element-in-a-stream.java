import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */
class KthLargest {
    private final int k;
    private PriorityQueue<Integer> minHeap;
    private int minHeapSize;

    /**
     * 
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        this.minHeapSize=0;
        for (int num : nums) {
            minHeap.offer(num);
            minHeapSize++;
            if(minHeapSize>k){
                minHeap.poll();
            }
        }

    }

    /**
     * 
     * @param val
     * @return
     */
    public int add(int val) {
        minHeap.offer(val);
        this.minHeapSize++;
        if(minHeapSize>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
