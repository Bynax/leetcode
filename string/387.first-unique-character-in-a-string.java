/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution387 {
    public static int firstUniqChar(String s) {
        return firstUniqCharImp(s);
    }

    /**
     * 
     * @param s
     * @return
     */
    static int firstUniqCharImp(String s){
        int[] counter = new int[26]; // 申请数组
        char[] s2Array = s.toCharArray();
        int s2ArrayLength = s2Array.length;
        for(int i=0;i<s2ArrayLength;i++){ 
            counter[s2Array[i]-'a'] +=1; // 记录频次
        }

        for(int i=0;i<s2ArrayLength;i++){
            if(counter[s2Array[i]-'a']==1){ 
                return i;
            }
        }
        return -1;
    }
}

