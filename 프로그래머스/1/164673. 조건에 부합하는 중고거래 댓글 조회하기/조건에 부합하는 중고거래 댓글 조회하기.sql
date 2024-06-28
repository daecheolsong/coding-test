-- 코드를 입력하세요
SELECT a.title, b.BOARD_ID, b.reply_id, b.writer_id, b.contents, 
date_format(b.created_date,'%Y-%m-%d')as Created_date
from USED_GOODS_board as a
inner join USED_GOODS_reply as b 
on a.board_id = b.board_id
where a.created_date between '2022-10-01' and '2022-10-30'
order by b.created_date asc, a.title asc;
