import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static long answer = Long.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] exp = br.readLine().toCharArray();
        calcNext(exp, 2, exp[0] - '0', exp.length);
        bw.write(answer + "\n");
        bw.flush();
    }

    private static void calcNext(char[] exp, int index, int result, int length) {
        if (index >= length) {
            answer = Math.max(result, answer);
            return;
        }
       
        calcNext(exp, index + 2, calculate(result, exp[index - 1], exp[index] - '0'), exp.length);
        
        if (index + 2 < length) {
            int right = calculate(exp[index] - '0', exp[index + 1], exp[index + 2] - '0');
            int left = calculate(result, exp[index - 1], right);
            calcNext(exp, index + 4, left, exp.length);
        }
    }


    private static int calculate(int op1, char operator, int op2) {
        switch (operator) {
            case '*':
                return op1 * op2;
            case '+':
                return op1 + op2;
        }
        return op1 - op2;
    }
}