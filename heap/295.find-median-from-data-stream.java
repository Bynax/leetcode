import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean even;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // 存储偏小的那部分数据
        maxHeap = new PriorityQueue<>((a, b) -> (b - a)); // 存储偏大的数据
       even = true;

    }

    public void addNum(int num) {
        if(even){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even){
            return minHeap.peek()+(maxHeap.peek()-minHeap.peek())/2.0;
        }else{
          return  minHeap.peek();
        }
        

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
