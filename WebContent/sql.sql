DROP TABLE WORKER PURGE;

-- ADMIN
CREATE TABLE WORKER (
    ID VARCHAR2(20) PRIMARY KEY,
    PWD VARCHAR2(20),
    NAME VARCHAR2(40),
    PHONE VARCHAR2(20)
);

-- 쇼핑몰 회원들의 정보를 저장하는 테이블
-- 기본키를 삭제하되 참조되는 항목들도 같이 삭제
ALTER TABLE MEMBER DROP PRIMARY KEY CASCADE;
-- 기존 member 테이블 삭제
drop table member purge;

CREATE TABLE MEMBER (
    ID VARCHAR2(20) PRIMARY KEY,
    PWD VARCHAR2(20),
    NAME VARCHAR2(40),
    EMAIL VARCHAR2(40),
    ZIP_NUM VARCHAR2(7),
    ADDRESS VARCHAR2(100),
    PHONE VARCHAR2(20),
    USEYN CHAR(1) DEFAULT 'Y',
    INDATE DATE DEFAULT SYSDATE
);

ALTER TABLE PRODUCT DROP PRIMARY KEY CASCADE;
DROP TABLE PRODUCT PURGE;

CREATE TABLE PRODUCT(
    PSEQ NUMBER(5) PRIMARY KEY,
    NAME VARCHAR2(100),
    KIND CHAR(1),
    PRICE1 NUMBER(7) DEFAULT '0', -- 원가
    PRICE2 NUMBER(7) DEFAULT '0', -- 판매가
    PRICE3 NUMBER(7) DEFAULT '0', -- 수익
    CONTENT VARCHAR2(1000), -- 상품설명
    IMAGE VARCHAR2(50) DEFAULT 'DEFAULT.JPG', -- 상품이미지
    USEYN CHAR(1) DEFAULT 'Y', -- 현재판매중여부
    BESTYN CHAR(1) DEFAULT 'N', -- 베스트상품 여부
    INDATE DATE DEFAULT SYSDATE -- 등록일
);

DROP SEQUENCE PRODUCT_SEQ;
CREATE SEQUENCE PRODUCT_SEQ START WITH 1;

ALTER TABLE CART DROP PRIMARY KEY CASCADE;
DROP TABLE CART PURGE;

CREATE TABLE CART (
    CSEQ NUMBER(10) PRIMARY KEY, -- 장바구니번호
    ID VARCHAR2(16) REFERENCES MEMBER(ID), -- 주문자 아이디 (fk: member.id)
    PSEQ NUMBER(5) REFERENCES PRODUCT(PSEQ), -- 주문 상품번호(fk: product.pseq)
    QUANTITY NUMBER(5) DEFAULT 1, -- 주문수량
    RESULT CHAR(1) DEFAULT '1', -- 1:미처리, 2:처리
    INDATE DATE DEFAULT SYSDATE -- 주문일
);

DROP SEQUENCE CART_SEQ;
CREATE SEQUENCE CART_SEQ START WITH 1 INCREMENT BY 1;

ALTER TABLE ORDERS PRIMARY KEY CASCADE;
DROP TABLE ORDERS PURGE;

CREATE TABLE ORDERS(
    OSEQ NUMBER(10) PRIMARY KEY, -- 주문번호
    ID VARCHAR2(16) REFERENCES MEMBER(ID), -- 주문자 아이디
    INDATE DATE DEFAULT SYSDATE -- 주문일 
);

DROP SEQUENCE ORDERS_SEQ;
CREATE SEQUENCE ORDERS_SEQ START WITH 1 INCREMENT BY 1;

ALTER TABLE ORDER_DETAIL DROP PRIMARY KEY CASCADE;
DROP TABLE ORDER_DETAIL PURGE;

CREATE TABLE ORDER_DETAIL (
    ODSEQ NUMBER(10) PRIMARY KEY, -- 주문상세번호
    OSEQ NUMBER(10) REFERENCES ORDERS(OSEQ), -- 주문번호
    PSEQ NUMBER(5) REFERENCES PRODUCT(PSEQ), -- 상품번호
    QUANTITY NUMBER(5) DEFAULT 1, -- 주문수량
    RESULT CHAR(1) DEFAULT '1' -- 1: 미처리, 2: 처리
);

DROP SEQUENCE ORDER_DETAIL_SEQ;
CREATE SEQUENCE ORDER_DETAIL_SEQ START WITH 1 INCREMENT BY 1;

ALTER TABLE QNA DROP PRIMARY KEY CASCADE;
DROP TABLE QNA PURGE;

CREATE TABLE QNA (
    QSEQ NUMBER(5) PRIMARY KEY, -- 글번호
    SUBJECT VARCHAR2(300), -- 제목
    CONTENT VARCHAR2(1000), -- 문의내용
    REPLY VARCHAR2(1000), -- 답변내용
    ID VARCHAR2(1000), -- 작성자(FK : MEMBER.ID)
    REP CHAR(1) DEFAULT '1', -- 1: 답변 무, 2: 답변 유
    INDATE DATE DEFAULT SYSDATE -- 작성일
);

DROP SEQUENCE QNA_SEQ;
CREATE SEQUENCE QNA_SEQ START WITH 1 INCREMENT BY 1;

ALTER TABLE ADDRESS DROP PRIMARY KEY CASCADE;
DROP TABLE ADDRESS PURGE;

CREATE TABLE ADDRESS (
    ZIP_NUM VARCHAR2(7) NOT NULL,
    SIDO VARCHAR2(30) NOT NULL,
    GUGUN VARCHAR2(55) NOT NULL,
    DONG VARCHAR2(400) NOT NULL,
    ZIP_CODE VARCHAR2(30),
    BUNJI VARCHAR2(30)
);

INSERT INTO WORKER VALUES ('admin', 'admin', '최준호', '010-2172-7798');
INSERT INTO WORKER VALUES ('scott', 'tiger', 'jun', '010-2172-7798');
SELECT * FROM worker;

INSERT INTO MEMBER(ID, PWD, NAME, ZIP_NUM, ADDRESS, PHONE) VALUES ('one', '1111', '김나리', '133-110', '서울시 성동구 성수동 1가 1번지 21호', '017-777-7777');
INSERT INTO MEMBER(ID, PWD, NAME, ZIP_NUM, ADDRESS, PHONE) VALUES ('two', '2222', '이백합', '130-120', '서울시 송파구 잠실2동 리센츠 아파트 201동 505호', '011-123-4567');
SELECT * FROM MEMBER;

insert into product(pseq, name, kind, price1, price2, price3, content, image) values( product_seq.nextval, '크로그다일부츠', '2', 40000, 50000, 10000, '오지니랄 크로그다일부츠 입니다.', 'w2.jpg');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '롱부츠', '2', 40000, 50000, 10000,'따뜻한 롱부츠 입니다.', 'w-28.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w-26.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '슬리퍼', '4', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w-25.jpg', 'y');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '회색힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w9.jpg', 'n');
insert into product(pseq, name, kind, price1, price2, price3, content, image) values(product_seq.nextval, '여성부츠', '2', 12000, 18000, 6000, '여성용 부츠', 'w4.jpg');​
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(product_seq.nextval, '핑크샌달', '3', 5000, 5500, 500,'사계절용 샌달입니다.', 'w-10.jpg', 'y');​
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values(product_seq.nextval, '슬리퍼', '3', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w11.jpg', 'y');​
insert into product(pseq, name, kind, price1, price2, price3, content, image) values( product_seq.nextval, '스니커즈', '4', 15000, 20000, 5000,'활동성이 좋은 스니커즈입니다.', 'w1.jpg');​
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-09.jpg','n');​
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '스니커즈', '5', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w-05.jpg','n');

insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두1', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두2', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두3', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두4', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두5', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두6', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두7', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두8', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두9', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');
insert into product(pseq, name, kind, price1, price2, price3, content, image, bestyn) values( product_seq.nextval, '남성용 구두10', '2', 40000, 50000, 10000, '활동성이 좋은 힐입니다.', 'w-14.jpg','n');

SELECT * FROM PRODUCT;

INSERT INTO CART(CSEQ, ID, PSEQ, QUANTITY) VALUES (CART_SEQ.NEXTVAL, 'one', 1, 1);

INSERT INTO ORDERS(OSEQ, ID) VALUES (ORDERS_SEQ.NEXTVAL, 'two');
INSERT INTO ORDERS(OSEQ, ID) VALUES (ORDERS_SEQ.NEXTVAL, 'one');
INSERT INTO ORDERS(OSEQ, ID) VALUES (ORDERS_SEQ.NEXTVAL, 'one');
INSERT INTO ORDERS(OSEQ, ID) VALUES (ORDERS_SEQ.NEXTVAL, 'two');
SELECT * FROM ORDERS;

INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 1, 1, 1);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 1, 2, 5);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2, 4, 3);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 2, 5, 2);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 3, 3, 1);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 3, 2, 1);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 4, 6, 2);
INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) VALUES (ORDER_DETAIL_SEQ.NEXTVAL, 4, 1, 2);
SELECT * FROM ORDER_DETAIL;

INSERT INTO QNA(QSEQ, SUBJECT, CONTENT, ID) VALUES (QNA_SEQ.NEXTVAL, '테스트', '질문내용1', 'one');
INSERT INTO QNA(QSEQ, SUBJECT, CONTENT, ID) VALUES (QNA_SEQ.NEXTVAL, '테스트2', '질문내용2', 'one');

CREATE OR REPLACE VIEW CART_VIEW
AS
SELECT 
    C.CSEQ, C.ID, C.PSEQ, C.QUANTITY, C.RESULT, C.INDATE
    , P.NAME AS PNAME, P.PRICE2
    , M.NAME AS MNAME
FROM CART C, PRODUCT P, MEMBER M
WHERE
    C.PSEQ = P.PSEQ
    AND M.ID = C.ID;

SELECT * FROM CART_VIEW;

CREATE OR REPLACE VIEW ORDER_VIEW
AS
SELECT
    D.ODSEQ, D.PSEQ, D.QUANTITY, D.RESULT
    , O.OSEQ, O.ID, O.INDATE
    , M.NAME AS MNAME, M.ZIP_NUM, M.ADDRESS, M.PHONE
    , P.NAME AS PNAME, P.PRICE2
FROM ORDERS O, ORDER_DETAIL D, MEMBER M, PRODUCT P
WHERE
    O.OSEQ = D.OSEQ
    AND M.ID = O.ID
    AND P.PSEQ = D.PSEQ;

SELECT * FROM ORDER_VIEW;

CREATE OR REPLACE VIEW BEST_PRO_VIEW
AS
SELECT * FROM (
    SELECT ROWNUM, PSEQ, NAME, PRICE2, IMAGE
    FROM PRODUCT WHERE BESTYN = 'y' ORDER BY INDATE DESC
) WHERE ROWNUM <= 4;

SELECT * FROM BEST_PRO_VIEW;

CREATE OR REPLACE VIEW NEW_PRO_VIEW
AS
SELECT * FROM (
    SELECT ROWNUM, PSEQ, NAME, PRICE2, IMAGE
    FROM PRODUCT WHERE USEYN = 'Y' ORDER BY INDATE DESC
) WHERE ROWNUM <= 4;

SELECT * FROM NEW_PRO_VIEW;

SELECT * FROM address;

DELETE FROM ADDRESS;

select * from best_pro_view;

 SELECT * FROM MEMBER;
 SELECT * FROM MEMBER where id = 'one';
 SELECT * FROM address where dong like '%소사동%';

 SELECT COLUMN_NAME, DATA_TYPE FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='MEMBER';
 SELECT
     A.COLUMN_ID AS NO
     , B.COMMENTS AS "논리명"
     , A.COLUMN_NAME AS "물리명"
     , A.DATA_TYPE AS "자료 형태"
     , A.DATA_LENGTH AS "길이"
     , DECODE(A.NULLABLE, 'N', 'No', 'Y', 'Yes') AS "Null 허용"
     , '' AS "식별자"
     , A.DATA_DEFAULT AS "기본값"
     , B.COMMENTS AS "코멘트"
 FROM ALL_TAB_COLUMNS A
     LEFT JOIN ALL_COL_COMMENTS B
         ON A.OWNER = B.OWNER
             AND A.TABLE_NAME = B.TABLE_NAME
             AND A.COLUMN_NAME = B.COLUMN_NAME
 WHERE
     A.TABLE_NAME LIKE 'MEMBER'
 ORDER BY A.COLUMN_ID;

 ALTER TABLE MEMBER MODIFY ZIP_NUM VARCHAR2(20);

 SELECT * FROM member;

DELETE FROM member
WHERE id = 'juno';

SELECT * FROM product where pseq = 1;

UPDATE ORDER_DETAIL
SET
    RESULT = '2'
WHERE OSEQ = 21;

select * from member;

select * from product where pseq = 7;

SELECT * FROM ORDERS;

select * from ORDER_DETAIL;

select * from qna;

DELETE FROM qna;