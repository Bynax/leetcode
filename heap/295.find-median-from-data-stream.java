import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */
class MedianFinder {
    PriorityQueue<Integer> minHeap; // 存储较大的部分
    PriorityQueue<Integer> maxHeap; // 存储较小的部分
    boolean even; // 要像哪个堆中添加元素的tag

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>(); 
        maxHeap = new PriorityQueue<>((a, b) -> (b - a)); 
        even = true;

    }


    /**
     * 添加元素
     * @param num
     */
    public void addNum(int num) {
        if (even) { // 向最小堆中添加元素
            maxHeap.offer(num); // 先将num添加到最大堆中
            minHeap.offer(maxHeap.poll()); // 将最大堆中的堆顶元素添加到最小堆中

        } else { // 向最大堆中添加元素。步骤同上
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even; // 更改tag
    }

    /**
     * 寻找中位数
     * @return
     */
    public double findMedian() {
        if (even) {
            return minHeap.peek() + (maxHeap.peek() - minHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
