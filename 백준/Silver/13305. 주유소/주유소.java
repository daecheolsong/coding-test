import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer> cost = new ArrayList<>();
    public static ArrayList<Integer> cities = new ArrayList<>();
    public static int [] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            cost.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            cities.add(Integer.parseInt(st.nextToken()));
        }

        result = new int[n - 1];

        result[0] = cities.get(0);

        for (int i = 1; i < n - 1; i++) {
            int cost = cities.get(i);
            int fillCity = Math.min(result[i - 1], cost);
            result[i] = fillCity;
        }

        long answer = 0;

        for (int i = 0; i < n - 1; i++) {
            answer +=(long)result[i] * cost.get(i);
        }

        System.out.println(answer);


    }
}