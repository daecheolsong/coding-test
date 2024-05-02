import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            char[] numbers = st.nextToken().toCharArray();
            int count = Integer.parseInt(st.nextToken());
            int [] v = new int[numbers.length];
            List<int[]> cases = new ArrayList<>();
            List[] list = new List[count + 1];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<String>();
            }

            fillCases(numbers.length, 0, 0, v, cases);
            find(numbers, cases, count, list);

            int maxValue = 0;
            List<String> finishList = list[0];
            for (String s : finishList) {
                int intValue = Integer.parseInt(s);
                if(intValue > maxValue) {
                    maxValue = intValue;
                }
            }
            System.out.println("#" + test_case + " " + maxValue);
        }
    }

    public static void find(char[] numbers, List<int[]> cases,int count, List[] list) {

        char[] copy = new char[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }
        String s = new String(copy);

        List<String> curList = list[count];

        if (curList.contains(s)) {
            return;
        }
        curList.add(s);
        if (count == 0) {
            return;
        }
        for (int i = 0; i < cases.size(); i++) {
            int[] pick = cases.get(i);
            swap(pick[0], pick[1], numbers);
            find(numbers, cases, count - 1, list);
            swap(pick[0], pick[1], numbers);
        }

    }

    public static void swap(int i, int j, char[] numbers) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void fillCases(int n, int next, int depth, int[] v, List<int []> cases) {

        if(depth == 2) {
            int [] pick = new int[2];
            int pickCount = 0;
            for (int i = 0; i < v.length; i++) {
                if(v[i] == 1) {
                    pick[pickCount++] = i;
                }
            }
            cases.add(pick);
            return;
        }

        for (int i = next; i < n; i++) {
            v[i] = 1;
            fillCases(n, i + 1, depth + 1, v, cases);
            v[i] = 0;
        }
    }
}