CREATE table board(
	b_number int not null primary key auto_increment,		-- 글 번호
	b_title varchar(30) not null,												-- 글 제목
	b_writer varchar(20) not null,											-- 글 작성자
	b_content text not null,														-- 글 내용
	b_hit int default 0,																-- 글 조회수
	b_date datetime not null														-- 작성일자
);

DROP table board;
-- 리플(댓글) 기능 --
ALTER TABLE board ADD (
b_group int not null,																-- 글 원본과 그룹핑
b_depth int default 0,																-- 글 깊이
b_indent int default 0																-- 글 인덴트
);