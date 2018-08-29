    /**1.1��ɾ���������ϵ,����һ���û���*/
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
    /**�����û���id�������У�����Ҫɾ��*/
    drop sequence sq_xdl_user_user_id;
    create sequence sq_xdl_user_user_id;
    
    /**���������*/
    drop table xdl_category cascade constraints;
    create table xdl_category(
    	category_id	INT constraint PK_xdl_category_category_id primary key,
		name	VARCHAR2(50),
		turn	INT,
		description	VARCHAR2(50),
		parent_id	INT
    );
    /**��������id��������*/
    drop sequence sq_xdl_category_category_id;
    create sequence sq_xdl_category_category_id;
    
    insert into xdl_category values(0,'ͼƬ',0,'ͼ�鰡',null);
    insert into xdl_category values(sq_xdl_category_category_id.nextval,'С˵',1,'С˵��',0);
    insert into xdl_category values(sq_xdl_category_category_id.nextval,'��ѧ',2,'��ѧ��',0);
    insert into xdl_category values(sq_xdl_category_category_id.nextval,'����',3,'���°�',0);
    
    /**����ͼ����Ѷ��*/
    drop table xdl_news cascade constraints;
    create table xdl_news(
		id	INT  constraint PK_xdl_new_id primary key,
		title	VARCHAR2(100),
		content	VARCHAR2(200),
		release_time date,
		sticky	CHAR(1)
    );
    
    /**����ͼ����Ѷid�������У�����Ҫɾ��*/
    drop sequence sq_xdl_news_id;
    create sequence sq_xdl_news_id;
    
    insert into xdl_news(id,title,content)values(sq_xdl_news_id.nextval,'������ͯ�������°�����','������ͯ�������°�����');
    insert into xdl_news values(sq_xdl_news_id.nextval,'�������ܿ��������ˣ�','��Ȼ���������ʧ���ˣ����������������ֻ��Ǻܲ����',sysdate,'n');
    insert into xdl_news values(sq_xdl_news_id.nextval,'������ͷ���������ˣ���','��ɳ����-�����ٶ�̫�����Խл��',sysdate-4,'n');
    insert into xdl_news values(sq_xdl_news_id.nextval,'�������ռǡ������ˣ�����','������-���������¼�����ߣ���¼��9.58��',sysdate-33,'n');
    
    /**������Ʒ��*/
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
 '���ӵ���','�ӵ�  ��   ���� ���� ����',sysdate-100,'img/book01.jpg',
 'img/big/book01.jpg',100,20,'���ӵ��ɰ�','����','�ֵ���������',sysdate-100,
  'ISBN_0001','��������','������','350ҳ','��װ','16K',
  '�༭���� �����û��','��һ��֮���û����','�������˾������ӵ���',
  '��֪���Ǹ���Ա ���Ǹ�����','���Ż�����Ÿ�',sysdate-100,5000,'��Ƥ','����μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '�ص�����4','�ص� ���� �� ϲ������  ',
  sysdate-100,'img/book02.jpg','img/big/book02.jpg',
  100,20,'�ص����룬ȥ���ز������',
  '����','�������ӹ�ҵ������',sysdate-50,'ISBNisbn00xx2',
  '��������','�ڶ���','300ҳ','��װ',
  '16K','���Ĳ�ϲ�����ŵ��ջ�','��һ�µ�������','��˵ϲ�����������ס�ޣ���Կ�������',
  '��������','',sysdate-20,
  3000,'ţƤ','��3��Ӱӡ'
  );
  
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '�ص�����5','�ص� ���� ����',sysdate-100,'img/book03.jpg',
  'img/big/book03.jpg',120,50,'�òص���������','����','�ֵ���������',
  sysdate-100,'ISBN_0102','��������','�����','250ҳ','��װ','16K',
  '��ƪС˵�ܰ���','��һ�����˹���','�òصش�һ������','��������',
  'ңԶ�Ĳص���һ������и�ΰή',sysdate-100,2000,'ţƤֽ','����Һ��');
insert into xdl_product values(xdl_product_product_id_seq.nextval,'�ص�����6','�ص� ���ص�',
sysdate-100,'img/book04.jpg','img/big/book04.jpg',88,30,'�ص���������',
'��������','�й�������',sysdate-100,'ISBN_0004','��������',
'���İ�','180ҳ','��װ','20k','�༭���� �����û��',
'��һ��֮���û����','�������˾��ǲص�����','��֪���ǲ���һ����',
'���������� ',sysdate-100,4800,'ţƤ','���Ĵμ�ӡ');

insert into xdl_product values(xdl_product_product_id_seq.nextval,'�ڵ�����20��','�Ż��� ɽ�� �º���',
sysdate-100,'img/book05.jpg','img/big/book05.jpg',100,20,'�ڵ�����20�갡',
'ɽ��','���������',sysdate-100,'ISBN_0005','��������',
'������','500ҳ','��װ','16k','�༭���� �����û��',
'��һ��֮���û����','�������˾��Ǻڵ�����20��','�Ǹ��Ż���',
'ָ���Ҵ����˭��',sysdate-100,5000,'��Ƥ','�����μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'�������·','���� ���� ·',sysdate-100,'img/book06.jpg',
'img/big/book06.jpg',100,99,'�������·','�����',
'�ܼ������',sysdate-200,'ISBN_0002','��������','�ڶ���','350ҳ',
'��װ','16k','�༭����','��һ��','�������·','����','���Ż�����Ÿ�',
sysdate-100,5000,'ţƤֽ','�ڶ��μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'��������','���� �� ��',sysdate-100,'img/book07.jpg',
'img/big/book07.jpg',100,99,'��������','�ձ���',
'�ܼ������',sysdate-200,'ISBN_0003','��������','�ڶ���','350ҳ',
'��װ','16k','�༭����','��һ��','��������','�ձ�r','���Ż�����Ÿ�',
sysdate-100,5000,'ţƤֽ','�ڶ��μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'˵����','ppt ˵ ˵���� ��˵��',sysdate-100,'img/book08.jpg',
'img/big/book08.jpg',100,20,'˵���� �����PPT��˵��',
'��־ ���� ����','�����ʵ������',sysdate-300,'ISBN_0008',
'��������','��һ��','520ҳ','��װ','16K','�༭���� �����PPT��˵��',
'��һ��˵������','˵���� ...ʡ��һ����','��֪����һ����д������������д��..',
'�����PPT��˵��',sysdate-100,10000,'��ֽ','��һ�ξ�ӡ');

insert into xdl_product values(xdl_product_product_id_seq.nextval,
'�ټ�������','�ټ� ������ ��',sysdate-100,'img/book09.jpg','img/big/book09.jpg',
100,20,'�ټ�������','���','����?����?��֪�������',sysdate-300,'ISBN_0009',
'��������','�����','400ҳ','��װ','16K','�༭���� ����һ������',
'��һ���ҵı�Ư����','��Ư���� ...ʡ��һ����','��֪������˭..','�ټ�������',
sysdate-100,2500,'��ֽ','������ӡ');

 insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '����','�� �� �˲�',sysdate-100,'img/book10.jpg',
 'img/big/book10.jpg',100,20,'�˲�ָ��','�������߱���','�ֵ���������',sysdate-100,
  'ISBN_0010','��������','��һ��','350ҳ','��װ','16K',
  '��Ϊ���ţ���������һ��֮��','�ܹ�36��','�˲ųɳ��ر�',
  '��������','�����Ϊ������ʿ�����Ǻ�ʿ��',sysdate-100,5000,'ţƤ','�����ε�һ��ӡˢ'); 
  insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '�ֵ���Ϊѧ','�ֵ� ��Ϊ ����ѧ ��Ϊѧ',sysdate-100,'img/book11.jpg',
 'img/big/book11.jpg',100,20,'����һ��������Ϊ�������������','��ΰΰ','�ֵ���������',sysdate-100,
  'ISBN_0011','��������','������','350ҳ','��װ','16K',
  '��Ϊ����ϢϢ���','�ܹ�31��','Ҫ��ѧϰ����ѧ�����ȶ�����',
  '��̫ЧӦ ��������','ͣ������������ɣҶ���ڶ��»�',sysdate-100,5000,'�ؼ�ֽ','����μ�ӡ'); 
  
  select * from  xdl_product;
  
  /**�������ࡢ��Ʒ��ϵ��*/
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

/**������*/
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

/**��Ʒ�ղر�*/
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

/**�ջ���ַ��*/
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

/**��Ʊ��Ϣ��*/
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
