һ��ע�Ṧ��
  1.����һ���û���ע���ж�Ӧ������ Լ��
    	���������֮ǰ��ɾ���������
    1.1��ɾ���������ϵ
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
  2.����һ����Ŀ �����ݱ����һ��ʵ����
  3.���һ��DAO �ӿڣ����һ���������ݵ��û����еĳ��󷽷�
  4.���һ��DAO�ӿڵ�ʵ���� ��ɹ���
    DBCPUtil--���ӳصĹ����ࣨ�������ӳغ����ݿ���������
    	����jdbc��̵��岽
  5.��дһ��DAO������ �ṩDAO��ʵ����
  6.��дservice�� �ṩע�᷽��(ͨ������DAO�ӿڵ�ʵ������ߵķ���)
  
  |       ����                                                                                                                                              |
  -----------------------------M----------------------------
  
  7.�����Ӧ��jsp�ļ�����register.jsp����ע��������ʾע��ʧ�ܵ���Ϣ��ע��ɹ�����ת��registerOK.jsp-------------V
  8.дһ������ע���servlet�����M��ĵ��ú�ҳ����ת     ---------------C
  
 ��.��ɲ�Ʒ�������ʾ
 1.������Ӧ������   ����֮ǰ��ɾ���������
 	�����������
 2.��Է��������ʵ����Xdl_category 
 3.��дһ��Xdl_category  DAO�ӿ�
 4.DAOʵ����
 5.��д������
 6.service��
 7.servlet
 8.book.jsp��ʹ��jstl + el ��ʾ����
  
 �������ͼ����Ѷ��չʾ
 1.������Ӧ������ ����֮ǰ��ɾ���������
 2.ʵ����News
 3.NewsDAO
 4.DAOʵ����
 5.������
 6.service
 7.servlet
 8.book.jsp
            
   