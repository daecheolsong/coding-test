-- 코드를 작성해주세요
SELECT ED2.ID AS ID, ED2.GENOTYPE AS GENOTYPE, ED.GENOTYPE AS PARENT_GENOTYPE FROM ECOLI_DATA ED INNER JOIN ECOLI_DATA ED2 ON ED.ID = ED2.PARENT_ID
WHERE ED.GENOTYPE & ED2.GENOTYPE = ED.GENOTYPE