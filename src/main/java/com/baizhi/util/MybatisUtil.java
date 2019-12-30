package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
	private static SqlSessionFactory sessionFactory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sessionFactory=new SqlSessionFactoryBuilder().build(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//��ȡsqlsession����
	public static SqlSession getSqlsession(){
		SqlSession ss=tl.get();
		if(ss==null){
			ss=sessionFactory.openSession();
			tl.set(ss);
		}
		return ss; 
	}
	//�ر���Դ ���̰߳󶨽��
	public static void close(){
		try {
			//�����Ƿ��ܻ�ȡ����
			SqlSession ss= getSqlsession();
			tl.remove();
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//������ύ
	public static void commit(){
		try {
			SqlSession ss= getSqlsession();
			ss.commit();
			//���ùر���Դ�ķ���
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����Ļع�
		public static void rollback(){
			try {
				SqlSession ss= getSqlsession();
				ss.rollback();
				//���ùر���Դ�ķ���
				close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
