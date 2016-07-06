-- members 테이블 생성 쿼리
CREATE table members(
	m_id varchar(40) primary key not null,						-- 아이디
	m_pw varchar(20) not null,									-- 비밀번호
	m_name varchar(20) not null,								-- 이름
	m_age varchar(3) not null,									-- 나이
	m_gender varchar(10) not null,								-- 성별
	m_introduce varchar(100) not null							-- 자기소개
) ;

-- Sample 정보 입력
INSERT INTO members(m_id, m_pw, m_name, m_age, m_gender, m_introduce) 
values ('sara@gmail.com', '1234', 'Sara', '8', '여자', '잘 부탁합니다.');


