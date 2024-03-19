import java.util.*;
class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int extIdx = 0;
        if(ext.equals("date")) {
            extIdx = 1;
        } else if(ext.equals("maximum")) {
            extIdx = 2;
        } else if(ext.equals("remain")) {
            extIdx = 3;
        }
        
        List<int[]> filteredData = new ArrayList<>();
        
        for(int i = 0; i < data.length; i ++) {
            int [] d = data[i];
            if(d[extIdx] < val_ext) {
                filteredData.add(d);
            }
        }
        
        int sortIdx = 0;
        if(sort_by.equals("date")) {
            sortIdx = 1;
        } else if(sort_by.equals("maximum")) {
            sortIdx = 2;
        } else if(sort_by.equals("remain")) {
            sortIdx = 3;
        }
        final int finalsIdx = sortIdx;
        
        Collections.sort(filteredData, (d1, d2) -> {
            return d1[finalsIdx] - d2[finalsIdx];
        });
            
        
        return filteredData;
    }
}