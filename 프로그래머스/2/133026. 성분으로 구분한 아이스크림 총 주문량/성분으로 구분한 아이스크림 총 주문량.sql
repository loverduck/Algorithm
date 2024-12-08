-- 코드를 입력하세요
SELECT ingredient_type, SUM(total_order) AS TOTAL_ORDER
FROM first_half as f, icecream_info as i
WHERE f.FLAVOR = i.FLAVOR
GROUP BY ingredient_type
ORDER BY total_order;