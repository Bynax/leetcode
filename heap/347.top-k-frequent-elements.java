import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */
class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        return topKFrequentImp(nums, k);

    }

    /**
     * 使用HashMap和桶排序寻找出现频次topK的元素
     * 
     * @param nums
     * @param k
     * @return
     */
    static List<Integer> topKFrequentImp(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (nums == null || k <= 0) {
            return results;
        }
        // 建立[数字,频次]的map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int numsLength = nums.length;
        List<Integer>[] bucket = new List[nums.length + 1];

        // 建立[频次，数字]的bucket
        for (int key : freqMap.keySet()) {
            // 取出来的是[数字，频次]
            int freq = freqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(key);
        }

        // 根据频次得出结果
        for (int i = numsLength; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                results.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return results;

    }

    
}
