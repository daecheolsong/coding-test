import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc ++) {
            StringBuilder result = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            String yearMonthDay = br.readLine();
            int year = Integer.parseInt(yearMonthDay.substring(0, 4));
            if(year < 1000) {
                result.append("0");
            }
            if(year < 100) {
                result.append("0");
            }
            if(year < 10) {
                result.append("0");
            }
            result.append(year).append("/");
            int month = Integer.parseInt(yearMonthDay.substring(4, 6));
            if (month <= 0 || month >= 13) {
                sb.append(-1);
                sb.append("\n");
                continue;
            }
            if(month < 10) {
                result.append("0");
            }
            result.append(month).append("/");
            int day = Integer.parseInt(yearMonthDay.substring(6));
            if (day < 0 || day > getDaysByMonth(month)) {
                sb.append(-1);
                sb.append("\n");
                continue;
            }
            if (day < 10) {
                result.append("0");
            }
            result.append(day);
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int getDaysByMonth(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 2) {
            return 28;
        }
        return 30;
    }
}
