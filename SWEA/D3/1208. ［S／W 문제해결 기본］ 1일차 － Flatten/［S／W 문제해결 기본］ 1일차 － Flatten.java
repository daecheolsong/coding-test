import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int[] boxes = new int[100];
            int dump = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }
            processDump(boxes, dump);
            Arrays.sort(boxes);
            int diff = boxes[boxes.length - 1] - boxes[0];
            System.out.println("#" + test_case + " " + diff);
        }
    }

    public static void processDump(int[] boxes, int dump) {

        for (int i = 0; i < dump; i++) {
            Arrays.sort(boxes);
            int minL = boxes[0];
            int maxL = boxes[boxes.length - 1];
            if (maxL <= 0 || maxL - minL <= 1) {
                return;
            }
            boxes[boxes.length - 1]--;
            boxes[0]++;
        }
    }

}