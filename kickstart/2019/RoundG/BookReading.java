import java.util.Scanner;

public class BookReading {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        int caseSeq = 0;
        int totalNum = 0;
        int tornNum = 0;
        int peopleNum = 0;

        while (caseCount-- > 0) {
            caseSeq++;
            totalNum = input.nextInt();
            tornNum = input.nextInt();
            peopleNum = input.nextInt();
            boolean[] isTorn = new boolean[totalNum + 1];

            int[] peoples = new int[peopleNum];
            for (int i = 0; i < tornNum; i++) {
                isTorn[input.nextInt()] = true;
            }
            for (int i = 0; i < peopleNum; i++) {
                peoples[i] = input.nextInt();
            }

            System.out.println(String.format("Case #%d: %d", caseSeq, solution(totalNum, peopleNum, isTorn, peoples)));

        }

    }

    static int solution(int totalNum, int peopleNum, boolean[] isTorn, int[] peoples) {

        int count = 0;
        int[] fx = new int[totalNum + 1];
        int fxCount = 0;
        for (int people : peoples) {
            for (int j = 1; j * people <= totalNum; j++) {
                if (!isTorn[j * people]) {
                    fxCount++;
                }
            }
            fx[people] = fxCount;
            fxCount = 0;
        }
        for (int people : peoples) {
            count += fx[people];
        }

        return count;
    }

}