-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, CONCAT_WS(" ", u.CITY, u.STREET_ADDRESS1, u.STREET_ADDRESS2) as 전체주소,
CONCAT_WS('-', SUBSTR(u.TLNO, 1, 3), SUBSTR(u.TLNO, 4, 4), SUBSTR(u.TLNO, 8, 4)) as 전화번호
FROM (SELECT WRITER_ID
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(BOARD_ID) >= 3) as w
JOIN USED_GOODS_USER as u
ON u.USER_ID = w.WRITER_ID
ORDER BY 1 DESC;