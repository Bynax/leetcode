import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */
class Solution218 {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        return getSkylineImp(buildings);
    }

    /**
     * 使用sweep line的方法解决skyline问题
     * 
     * @param buildings
     * @return
     */
    static List<List<Integer>> getSkylineImp(int[][] buildings) {
        // 创建一个比较器，传入到优先队列中以便建立大根堆
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        // 创建一个大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);

        
        return null;
    }
}
