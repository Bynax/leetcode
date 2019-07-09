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
     * 构造函数
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(); // 设立最小堆
        this.minHeapSize=0; // 初始化最小堆元素计数器
        for (int num : nums) { 
            minHeap.offer(num); // 向堆中添加元素
            minHeapSize++; // 更新计数器
            if(minHeapSize>k){ 
                minHeap.poll(); // 堆中元素大于k时候poll出堆顶元素
            }
        }

    }

    /**
     * 添加元素
     * @param val
     * @return
     */
    public int add(int val) {
        minHeap.offer(val); // 向堆中添加元素
        this.minHeapSize++; //
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
