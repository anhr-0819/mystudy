-- 회원 데이터
insert into t_member
  (name,tel,email,password,post_code,basic_addr,detail_addr,authority_no)
  values
  ('admin','000-0000-0000','admin@test.com','0000','000-0000','addr','detail addr','관리자'),
  ('test1','111-1111-1111','test1@test.com','1111','111-1111','addr','detail addr','일반회원'),
  ('test2','222-2222-2222','test2@test.com','1111','222-2222','addr','detail addr','일반회원'),
  ('test3','333-3333-3333','test3@test.com','1111','333-3333','addr','detail addr','일반회원'),
  ('test4','444-4444-4444','test4@test.com','1111','444-4444','addr','detail addr','일반회원'),
  ('test5','555-5555-5555','test5@test.com','1111','555-5555','addr','detail addr','일반회원'),
  ('test6','666-6666-6666','test6@test.com','1111','666-6666','addr','detail addr','일반회원');