import java.util.LinkedList;
import java.util.Collections;
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
        List<List<Integer>> results = new LinkedList<>(); // 存储结果
        List<int[]> heights = new LinkedList<>(); // 存储高度

        // 将每个点按照[起始点,高度]和[结束点,高度]加入到heights中，用高度的正负来区分起始点和结束点
        for (int[] building : buildings) {
            heights.add(new int[] { building[0], -building[2] });
            heights.add(new int[] { building[1], building[2] });

        }

        // 将点按照位置进行排序
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // 创建一个大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        int currentHeight = 0;
        int previousHeight = 0;
        maxHeap.offer(0);

        for (int[] building : heights) {
            if (building[1] < 0) {
                maxHeap.offer(-building[1]); // 起始点，此时将高度存入堆中
            } else {
                maxHeap.remove(building[1]); // 结束点，将高度从堆中移除
            }
            currentHeight = maxHeap.peek(); // 此时的最高高度
            if (currentHeight != previousHeight) { // 看此时的高度是否发生变化，若发生，则是要找的点
                List<Integer> tempList = new LinkedList<>();
                tempList.add(building[0]);
                tempList.add(currentHeight);
                results.add(tempList);
                previousHeight = currentHeight;
            }

        }
        return results;
    }

}
