import java.util.ArrayDeque;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
class Solution239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowImp(nums, k);
    }

    /**
     * 最大滑动窗口值的dequeue实现
     * @param nums
     * @param k
     * @return
     */
    static int[] maxSlidingWindowImp(int[] nums,int k){
        // 边界判断
        if(nums==null||k<=0){
            return new int[0];
        }
        if(k==1){
            return nums;
        }

        ArrayDeque<Integer> indexQueue = new ArrayDeque<>(); // 存储窗口最大值下标的队列
        int numsLength = nums.length;
        int []results = new int[numsLength-k+1];
        int resutsIndex = 0;

        for(int i=0;i<numsLength;i++){
            // 丢弃失效元素下标
            if(!indexQueue.isEmpty()&&indexQueue.peek()<i-k+1){
                indexQueue.poll();
            }

            // 从队尾向对首方向丢弃小于当前值的元素
            while(!indexQueue.isEmpty()&&nums[indexQueue.peekLast()]<=nums[i]){
                indexQueue.pollLast();
            }
            // 添加当前元素
            indexQueue.add(i);

            // 判断是否要输出结果，也就是是否到了窗口的边缘
            if(i>=k-1){
                results[resutsIndex++] = nums[indexQueue.peek()];
            }
        }
        return results;
    
     }
}

