-- 회원
DROP TABLE IF EXISTS tapp_member RESTRICT;
DROP TABLE IF EXISTS member_photo RESTRICT;

-- 회원
CREATE TABLE tapp_member (
	id           INT  NOT NULL COMMENT '회원ID', -- 회원ID
	name         VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	tel          VARCHAR(30)  NULL     COMMENT '전화', -- 전화
	email        VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	password     VARCHAR(255) NOT NULL COMMENT '암호', -- 암호
	post_code    VARCHAR(8)   NULL     COMMENT '우편번호', -- 우편번호
	basic_addr   VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
	detail_addr  VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
	created_date DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일', -- 등록일
	last_login   DATETIME     NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '최종접속일', -- 최종접속일
	authority_no VARCHAR(10)  NULL     COMMENT '권한' -- 권한
)
COMMENT '회원';

-- 회원
ALTER TABLE tapp_member
	ADD CONSTRAINT PK_tapp_member -- 회원 기본키
	PRIMARY KEY (
	id -- 회원ID
	);

ALTER TABLE tapp_member
  modify column id int not null auto_increment;

-- 회원
ALTER TABLE tapp_member
	ADD CONSTRAINT FK_authority_TO_tapp_member -- 권한 -> 회원
	FOREIGN KEY (
	authority_no -- 권한
	)
	REFERENCES authority ( -- 권한
	authority_no -- 권한구분
	);

	-- 회원사진
  CREATE TABLE member_photo (
  	file_path VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
  	id        int          NOT NULL COMMENT '회원ID', -- 회원ID
  	profile   BOOLEAN      NULL     COMMENT '프로필사진설정' -- 프로필사진설정
  )
  COMMENT '회원사진';

  -- 회원사진
  ALTER TABLE member_photo
  	ADD CONSTRAINT PK_member_photo -- 회원사진 기본키
  	PRIMARY KEY (
  	file_path -- 파일경로
  	);
