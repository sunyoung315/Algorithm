-- 코드를 작성해주세요
WITH RECURSIVE TREE AS (
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT e.ID, e.PARENT_ID, t.GENERATION + 1 AS GENERATION
    FROM ECOLI_DATA e
    INNER JOIN TREE t
    ON e.PARENT_ID = t.ID
)

# SELECT * FROM TREE;

SELECT COUNT(ID) AS COUNT, GENERATION
FROM TREE
WHERE ID NOT IN (SELECT PARENT_ID FROM TREE t WHERE TREE.GENERATION + 1 = T.GENERATION)
GROUP BY GENERATION
ORDER BY GENERATION;

