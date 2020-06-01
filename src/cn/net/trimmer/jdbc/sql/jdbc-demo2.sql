-- Create accounts , use test jdbc-demo project
create table ACCOUNTS
(
  accountno   NUMBER(10) not null,
  accountname VARCHAR2(30),
  password    VARCHAR2(11),
  balance     NUMBER(10,2),
  opendate    DATE
);
-- Add comments to the table 
comment on table ACCOUNTS
  is 'jdbc 测试-账户信息表';
-- Add comments to the columns 
comment on column ACCOUNTS.accountno
  is '账户编码';
comment on column ACCOUNTS.accountname
  is '账户名称';
comment on column ACCOUNTS.password
  is '账户密码';
comment on column ACCOUNTS.balance
  is '账户余额';
comment on column ACCOUNTS.opendate
  is '账户开户时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ACCOUNTS add constraint ACCOUNTNO primary key (ACCOUNTNO);
--------------------------------------------------------------------
-- Create sequence 
create sequence SEQ_ACCOUNT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;
--------------------------------------------------------------------
-- 增加一列
-- insert into ACCOUNTS values(seq_account.nextval,?,?,?,?)
-- 删除一列
--delete from ACCOUNTS where accountno = ?
-- 修改一列
--update ACCOUNTS set accountname = ?, password = ?, balance = ? ,  openDate = ? where accountno = ?
-- 查询一列
select accountno,accountname,password,balance,opendate from ACCOUNTS where accountno = '42';