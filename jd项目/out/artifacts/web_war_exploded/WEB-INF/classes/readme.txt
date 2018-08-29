一、注册功能
  1.建立一张用户表，注意有对应的序列 约束
    	建表和序列之前先删除表和序列
    1.1先删除主外键关系
    drop table xdl_user cascade constraints;
    create table XDL_USER  (
   ID                   NUMBER                          not null,
   LOGIN_NAME           VARCHAR2(50),
   NICK_NAME            VARCHAR2(50),
   REAL_NAME            VARCHAR2(50),
   GRADE_ID             NUMBER,
   PASSWORD             VARCHAR2(50),
   EMAIL                VARCHAR2(50),
   RECOMMENDER          VARCHAR2(50),
   SEX                  VARCHAR2(2),
   PROVINCE             VARCHAR2(100),
   BIRTH                DATE,
   SCHOOL               VARCHAR2(100),
   COMPANY              VARCHAR2(50),
   CARD_NUMBER          VARCHAR2(50),
   MOBILE               VARCHAR2(50),
   PHONE                VARCHAR2(50),
   MSN                  VARCHAR2(50),
   QQ                   VARCHAR2(50),
   WEBSITE              VARCHAR2(100),
   SEND_ADDRESS         VARCHAR2(100),
   ZIPCODE              VARCHAR2(50),
   HOBBY                VARCHAR2(100),
   LAST_LOGIN_TIME      DATE,
   LAST_LOGIN_IP        VARCHAR2(50),
   HEAD_PIC             VARCHAR2(50),
   AREA                 VARCHAR2(100)
);

alter table XDL_USER
   add constraint PK_XDL_USER primary key (ID);
  2.建立一个项目 ，根据表，设计一个实体类
  3.设计一个DAO 接口，设计一个插入数据到用户表中的抽象方法
  4.设计一个DAO接口的实现类 完成功能
    DBCPUtil--连接池的工具类（导入连接池和数据库驱动包）
    	利用jdbc编程的五步
  5.编写一个DAO工程类 提供DAO的实现类
  6.编写service类 提供注册方法(通过调用DAO接口的实现类里边的方法)
  
  |       测试                                                                                                                                              |
  -----------------------------M----------------------------
  
  7.导入对应的jsp文件，让register.jsp发出注册请求，显示注册失败的信息，注册成功则跳转到registerOK.jsp-------------V
  8.写一个负责注册的servlet，完成M层的调用和页面跳转     ---------------C
  
 二.完成产品分类的显示
 1.建表，对应的序列   建立之前先删除表和序列
 	插入测试数据
 2.针对分类表，建立实体类Xdl_category 
 3.编写一个Xdl_category  DAO接口
 4.DAO实现类
 5.编写工厂类
 6.service类
 7.servlet
 8.book.jsp上使用jstl + el 显示数据
  
 三、完成图书资讯的展示
 1.建表，对应的序列 建立之前先删除表和序列
 2.实体类News
 3.NewsDAO
 4.DAO实现类
 5.工厂类
 6.service
 7.servlet
 8.book.jsp
            
   