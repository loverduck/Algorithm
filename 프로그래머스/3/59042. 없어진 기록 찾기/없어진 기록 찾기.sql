-- 코드를 입력하세요
SELECT animal_id, name
FROM ANIMAL_OUTS
WHERE animal_id NOT IN (
    SELECT animal_id
    FROM ANIMAL_INS
)
ORDER BY animal_id;