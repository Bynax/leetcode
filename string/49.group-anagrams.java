import java.util.*;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagramsImp(strs);
    }

    /**
     * 使用count和hash的方法实现groupAnagrams
     * @param strs
     * @return
     */
    List<List<String>> groupAnagramsImp(String[] strs){
        if(strs.length==0){
            return new ArrayList<>();
        }
        HashMap<String,List<String>> results = new HashMap<>();
        int[] count = new int[26];
        String key;
        for(String str:strs){
            // 将count数组各个元素都置为0
            Arrays.fill(count, 0);
            for(char c:str.toCharArray()){
                count[c-'a']++;
            }
            // 生成每一个str对应的key
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append("#");
                sb.append(count[i]);
            }
            key = sb.toString();
            if(!results.containsKey(key)){
                results.put(key, new ArrayList<>());
            }
            results.get(key).add(str);
        }

        return new ArrayList<>(results.values());
    }
}
