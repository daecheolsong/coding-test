-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT, FNI.FISH_NAME AS FISH_NAME FROM FISH_INFO FI INNER JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
GROUP BY(FNI.FISH_NAME) ORDER BY FISH_COUNT DESC