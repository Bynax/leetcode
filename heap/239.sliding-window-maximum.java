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

    static int[] maxSlidingWindowImp(int[] nums,int k){
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
            if(!indexQueue.isEmpty()&&indexQueue.peek()<i-k+1){
                indexQueue.poll();
            }

            while(!indexQueue.isEmpty()&&nums[indexQueue.peekLast()]<=nums[i]){
                indexQueue.pollLast();
            }
            indexQueue.add(i);

            if(i>=k-1){
                results[resutsIndex++] = nums[indexQueue.peek()];
            }
        }
        return results;
        

     }
}

