    /**1.1先删除主外键关系,创建一个用户表*/
    drop table xdl_user cascade constraints;
    create table xdl_user(
	    user_id	INT constraint PK_xdl_user_user_id primary key,
		login_name	VARCHAR2(64) constraint UK_xdl_user_login_name_uk unique,
		nick_name	VARCHAR2(64),
		real_name	VARCHAR2(64),
		grade_id	INT,
		password	VARCHAR2(100) not null,
		email	VARCHAR2(200),
		province	VARCHAR2(100),
		recommender	VARCHAR2(100),
		sex	VARCHAR2(64),
		birth	Date,
		location	VARCHAR2(100),
		school	VARCHAR2(200),
		company	VARCHAR2(200),
		card_number	VARCHAR2(64),
		mobile	VARCHAR2(64),
		phone	VARCHAR2(64),
		msn	VARCHAR2(64),
		Qq	VARCHAR2(64),
		website	VARCHAR2(64),
		send_address	VARCHAR2(100),
		zipcode	VARCHAR2(32),
		hobby	VARCHAR2(64),
		verify_flag	VARCHAR2(64),
		verify_code	VARCHAR2(64),
		last_login_time	date,
		last_login_ip	VARCHAR2(64),
		area	VARCHAR2(100),
		head_pic	VARCHAR2(50)
    );
    /**建立用户表id自增序列，首先要删除*/
    drop sequence sq_xdl_user_user_id;
    create sequence sq_xdl_user_user_id;
    
    /**建立分类表*/
    drop table xdl_category cascade constraints;
    create table xdl_category(
    	category_id	INT constraint PK_xdl_category_category_id primary key,
		name	VARCHAR2(50),
		turn	INT,
		description	VARCHAR2(50),
		parent_id	INT
    );
    /**建立类别表id自增序列*/
    drop sequence sq_xdl_category_category_id;
    create sequence sq_xdl_category_category_id;
    
    insert into xdl_category values(0,'图片',0,'图书啊',null);
    insert into xdl_category values(sq_xdl_category_category_id.nextval,'小说',1,'小说啊',0);
    insert into xdl_category values(sq_xdl_category_category_id.nextval,'文学',2,'文学啊',0);
    insert into xdl_category values(sq_xdl_category_category_id.nextval,'军事',3,'军事啊',0);
    
    /**建立图书资讯表*/
    drop table xdl_news cascade constraints;
    create table xdl_news(
		id	INT  constraint PK_xdl_new_id primary key,
		title	VARCHAR2(100),
		content	VARCHAR2(200),
		release_time date,
		sticky	CHAR(1)
    );
    
    /**建立图书资讯id自增序列，首先要删除*/
    drop sequence sq_xdl_news_id;
    create sequence sq_xdl_news_id;
    
    insert into xdl_news(id,title,content)values(sq_xdl_news_id.nextval,'《格林童话》出新版啦！','《格林童话》出新版啦！');
    insert into xdl_news values(sq_xdl_news_id.nextval,'《体育周刊》更新了！','虽然火箭队抢七失败了，但是整场比赛表现还是很不错的',sysdate,'n');
    insert into xdl_news values(sq_xdl_news_id.nextval,'《体育头条》更新了！！','奥沙利文-打球速度太快所以叫火箭',sysdate-4,'n');
    insert into xdl_news values(sq_xdl_news_id.nextval,'《体育日记》更新了！！！','博尔特-百米世界记录保持者，纪录是9.58秒',sysdate-33,'n');
    
    /**建立商品表*/
       drop  table  xdl_product  cascade  constraints;
		 create  table  xdl_product(
		 	product_id	INT  constraint  xdl_product_product_id_pk primary key,
			name	VARCHAR2(50),
			keywords	VARCHAR2(50),
			add_time	DATE,
			picture	VARCHAR2(50),
			big_picture	VARCHAR2(50),
			fixed_price	INT,
			lower_price	INT,
			description	VARCHAR2(100),
			author	VARCHAR2(100),
			publishing	VARCHAR2(100),
			publish_time	Date,
			isbn	VARCHAR2(100),
			language	VARCHAR2(100),
			which_edtion	VARCHAR2(100),
			total_page	VARCHAR2(100),
			bind_layout	VARCHAR2(100),
			book_size	VARCHAR2(100),
			editor_description	VARCHAR2(2000),
			catalog	VARCHAR2(2100),
			book_summary	VARCHAR2(2100),
			author_summary	VARCHAR2(2100),
			extracts	VARCHAR2(2100),
			print_time	DATE,
			print_number	INT,
			paper_type	VARCHAR2(100),
			print_frequency	VARCHAR2(100)    
		 );
drop sequence   xdl_product_product_id_seq;
create sequence   xdl_product_product_id_seq;
insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '让子弹飞','子弹  飞   葛优 姜文 发哥',sysdate-100,'img/book01.jpg',
 'img/big/book01.jpg',100,20,'让子弹飞啊','姜文','兄弟连出版社',sysdate-100,
  'ISBN_0001','简体中文','第三版','350页','简装','16K',
  '编辑描述 你猜有没有','第一章之后就没有了','告诉你了就是让子弹飞',
  '不知道是个演员 还是个导演','吃着火锅唱着歌',sysdate-100,5000,'泥皮','第五次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '藏地密码4','藏地 密码 吗 喜马拉雅  ',
  sysdate-100,'img/book02.jpg','img/big/book02.jpg',
  100,20,'藏地密码，去西藏查查密码',
  '河马','北京电子工业出版社',sysdate-50,'ISBNisbn00xx2',
  '简体中文','第二版','300页','简装',
  '16K','第四部喜马拉雅的诱惑','第一章到第五章','听说喜马拉雅是神的住宿，门钥匙在哪里？',
  '河马爱神仙','',sysdate-20,
  3000,'牛皮','第3次影印'
  );
  
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '藏地密码5','藏地 密码 哈哈',sysdate-100,'img/book03.jpg',
  'img/big/book03.jpg',120,50,'让藏地来了密码','河马','兄弟连出版社',
  sysdate-100,'ISBN_0102','简体中文','第五版','250页','精装','16K',
  '长篇小说很棒棒','第一章主人公卒','让藏地带一个密码','编剧和作家',
  '遥远的藏地有一个密码叫高伟萎',sysdate-100,2000,'牛皮纸','修正液版');
insert into xdl_product values(xdl_product_product_id_seq.nextval,'藏地密码6','藏地 啊藏地',
sysdate-100,'img/book04.jpg','img/big/book04.jpg',88,30,'藏地密码密码',
'西藏人民','中国出版社',sysdate-100,'ISBN_0004','繁体中文',
'第四版','180页','精装','20k','编辑描述 你猜有没有',
'第一章之后就没有了','告诉你了就是藏地密码','不知道是不是一个人',
'哈哈哈哈哈 ',sysdate-100,4800,'牛皮','第四次加印');

insert into xdl_product values(xdl_product_product_id_seq.nextval,'黑道飞云20年','古惑仔 山鸡 陈浩南',
sysdate-100,'img/book05.jpg','img/big/book05.jpg',100,20,'黑道飞云20年啊',
'山鸡','人民出版社',sysdate-100,'ISBN_0005','简体中文',
'第三版','500页','精装','16k','编辑描述 你猜有没有',
'第一章之后就没有了','告诉你了就是黑道飞云20年','是个古惑仔',
'指导我大哥是谁吗',sysdate-100,5000,'金皮','第六次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'风雨哈佛路','风雨 哈佛 路',sysdate-100,'img/book06.jpg',
'img/big/book06.jpg',100,99,'风雨哈佛路','外国人',
'总监出版社',sysdate-200,'ISBN_0002','简体中文','第二版','350页',
'精装','16k','编辑描述','第一章','风雨哈佛路','外国妞','吃着火锅唱着歌',
sysdate-100,5000,'牛皮纸','第二次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'奈良美智','奈良 美 智',sysdate-100,'img/book07.jpg',
'img/big/book07.jpg',100,99,'奈良美智','日本人',
'总监出版社',sysdate-200,'ISBN_0003','简体中文','第二版','350页',
'精装','16k','编辑描述','第一章','奈良美智','日本r','吃着火锅唱着歌',
sysdate-100,5000,'牛皮纸','第二次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'说服力','ppt 说 说服力 会说话',sysdate-100,'img/book08.jpg',
'img/big/book08.jpg',100,20,'说服力 让你的PPT会说话',
'张志 刘俊 包翔','人民邮电出版社',sysdate-300,'ISBN_0008',
'简体中文','第一版','520页','精装','16K','编辑描述 让你的PPT会说话',
'第一章说服力了','说服力 ...省略一万字','不知道是一个人写到还是三个人写的..',
'让你的PPT会说话',sysdate-100,10000,'宣纸','第一次精印');

insert into xdl_product values(xdl_product_product_id_seq.nextval,
'再见出租屋','再见 出租屋 屋',sysdate-100,'img/book09.jpg','img/big/book09.jpg',
100,20,'再见出租屋','李冰','生活?读书?新知三联书店',sysdate-300,'ISBN_0009',
'简体中文','第五版','400页','精装','16K','编辑描述 这是一本好书',
'第一章我的北漂生活','北漂生活 ...省略一万字','不知道这是谁..','再见出租屋',
sysdate-100,2500,'竹纸','第六次印');

 insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '将才','将 大将 人才',sysdate-100,'img/book10.jpg',
 'img/big/book10.jpg',100,20,'人才指南','将才作者本人','兄弟连出版社',sysdate-100,
  'ISBN_0010','简体中文','第一版','350页','简装','16K',
  '成为将才，必先掌握一技之长','总共36章','人才成长必备',
  '著名作家','不想成为将军的士兵不是好士兵',sysdate-100,5000,'牛皮','第三次第一次印刷'); 
  insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '怪诞行为学','怪诞 行为 心理学 行为学',sysdate-100,'img/book11.jpg',
 'img/big/book11.jpg',100,20,'这是一本关于行为和心理方面的著作','高伟伟','兄弟连出版社',sysdate-100,
  'ISBN_0011','简体中文','第三版','350页','简装','16K',
  '行为理性息息相关','总共31章','要想学习心理学，必先读此书',
  '马太效应 从众心理','停车做爱枫林晚，桑叶红于二月花',sysdate-100,5000,'特级纸','第五次加印'); 
  
  select * from  xdl_product;
  
  /**建立分类、产品关系表*/
  drop table xdl_category_product cascade constraints;
  create table xdl_category_product(
  		id	NUMBER constraint PK_xdl_category_product primary key,
		category_id	INT,
		product_id	INT,
		constraint FK_xdl_category_product_cid foreign key(category_id) references xdl_category(category_id),
 		constraint FK_xdl_category_product_pid foreign key(product_id) references xdl_product(product_id)
		);
		
  drop sequence sq_xdl_category_product_id;
  create sequence sq_xdl_category_product_id;
  
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,21,1);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,21,2);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,21,3);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,21,4);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,21,5);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,21,6);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,22,7);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,22,8);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,22,9);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,22,10);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,22,11);
  
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,26,1);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,29,2);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,26,3);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,29,4);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,26,5);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,29,6);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,26,7);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,29,8);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,26,9);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,29,10);
  insert into XDL_CATEGORY_PRODUCT values(sq_xdl_category_product_id.nextval,26,11);
  
select * from xdl_product p inner join xdl_category_product cp on p.product_id=cp.product_id where category_id =21;

select * from xdl_product p inner join xdl_category_product cp on p.product_id=cp.product_id 
where category_id =21 and rownum<=2 order by print_number;

select name from (select name,rownum r from (select p.* from xdl_product p inner join xdl_category_product cp on p.product_id=cp.product_id 
where category_id =21 order by print_number)where rownum <4)where r >0;

/**订单表*/
drop table xdl_order cascade constraints;
create table xdl_order(
	order_id	INT constraint PK_xdl_order_order_id primary key,
	user_id	INT not null,
	status	VARCHAR2(10),
	order_time	date,
	total_price	INT,
	payment_id	INT not null,
	invoice_id	INT not null,
	reveive_address_id	INT not null,
	bak	VARCHAR2(200)
);
drop sequence sq_xdl_order_id ;
create sequence sq_xdl_order_id start with 1000;

/**商品收藏表*/
drop table xdl_interest cascade constraints;
create table xdl_interest(
	id	INT  constraint PK_xdl_interest_id primary key,
	user_id	INT references xdl_user(user_id),
	product_id	INT references xdl_product(product_id),
	collect_time	date,
	bak	VARCHAR2(200)
);
drop sequence sq_xdl_interest_id ;
create sequence sq_xdl_interest_id;

/**收货地址表*/
drop table xdl_receive_address cascade constraints;
create table xdl_receive_address(
	reveive_address_id	INT constraint PK_xdl_receive_address_id primary key,
	user_id	INT references xdl_user(user_id),
	receive_name	VARCHAR2(50),
	province	VARCHAR2(50),
	address	VARCHAR2(50),
	zipcode	VARCHAR2(50),
	mobile	VARCHAR2(50),
	telephone	VARCHAR2(50),
	email	VARCHAR2(50),
	area	VARCHAR2(50)
);

drop sequence sq_xdl_receive_address_id;
create sequence sq_xdl_receive_address_id;

/**发票信息表*/
drop table xdl_invoice cascade constraints;
create table xdl_invoice(
	invoice_id	INT constraint PK_xdl_invoice_id primary key,
	types	VARCHAR(50),
	title	VARCHAR(50),
	content	VARCHAR(50),
	company	VARCHAR(50)
);
drop sequence sq_xdl_invoice_id;
create sequence sq_xdl_invoice_id;
