import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        

		for(int test_case = 1; test_case <= T; test_case++)
		{
            long answer =  0;
			int n = sc.nextInt();
            int [] arr = new int[n];
            for(int i = 0; i < n; i ++) {
                arr[i] = sc.nextInt();
			}
            int s = 0;
            while(s < arr.length) {
         		int maxVal = 0;
                int maxIdx = 0;
                  for(int i = s; i < n ; i ++) {
               		  if(arr[i] > maxVal) {
                          maxVal = arr[i];
                          maxIdx = i;
                      }
				  }
                
                for(int i = s; i <= maxIdx; i ++) {
                	if(maxVal > arr[i]) {
                    	answer += (maxVal - arr[i]);
                    }
                }
                s = maxIdx + 1;
            }
            System.out.println("#" + test_case+ " "+ answer);
            
        }
	}
}