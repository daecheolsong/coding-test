
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int [] f = new int[101];
            int test_idx = sc.nextInt();
            
            
        	for(int i = 0; i < 1000; i++) {
            	f[sc.nextInt()]++;    
            }
            int max_idx = 0;
            
            for(int i = 1; i <= 100; i++) {
                if(f[max_idx] <= f[i]) {
                    max_idx = i;
                }
            }
			System.out.println("#"+test_idx + " " + max_idx);
		}
	}
}