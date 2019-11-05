import java.util.Scanner;

public class BookReading {

    /**
     * Main中定义读写的模版
     * 
     * @param args
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt(); // 总测试用例数
        int caseSeq = 0; // 当前轮到第几个测试用例
        int totalNum = 0; // 每次书的总页数
        int tornNum = 0; // 撕掉的总页数
        int peopleNum = 0; // 共有多少人

        while (caseCount-->0) {
            caseSeq++;
            totalNum = input.nextInt();
            tornNum = input.nextInt();
            peopleNum = input.nextInt();
            boolean []isTorn = new boolean[totalNum+1];
            int[] peoples = new int[peopleNum];
            for (int i = 0; i < tornNum; i++) {
                isTorn[input.nextInt()] = true;
            }
            for (int i = 0; i < peopleNum; i++) {
                peoples[i] = input.nextInt();
            }
            System.out.println(String.format("Case #%d: %d", caseSeq,solution(totalNum,peopleNum, isTorn, peoples)));

        }
        input.close();

    }

    /**
     * 
     * 给定缺少页数和人的编号返回总共阅读的页数
     * 
     * @param totalNum
     * @param tornPages
     * @param peoples
     * @return
     */
    static int solution(int totalNum,int peopleNum, boolean[] isTorn,int[] peoples) {
        if(totalNum==0||peopleNum==0){
            return 0;
        }
        int count = 0;
        int []fx = new int[totalNum+1];
        int fxCount = 0;
        for (int i = 1; i <= totalNum; i++) {
            for (int j = 1; j* i<= totalNum; j++) {
                if(!isTorn[j*i]){
                    fxCount++;
                }
            }
            fx[i] = fxCount;
            fxCount = 0;
        }
        for (int people : peoples) {
            count+=fx[people];
        }

        for (int i = 0; i < totalNum; i++) {
            System.out.print(fx[i]+" ");
        }
        System.out.println();

        return count;
       
    }



}