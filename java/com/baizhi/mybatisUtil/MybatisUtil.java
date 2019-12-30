package com.baizhi.mybatisUtil;

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
	
	//获取sqlsession连接
	public static SqlSession getSqlsession(){
		SqlSession ss=tl.get();
		if(ss==null){
			ss=sessionFactory.openSession();
			tl.set(ss);
		}
		return ss; 
	}
	//关闭资源 ，线程绑定解除
	public static void close(){
		try {
			//尝试是否能获取连接
			SqlSession ss= getSqlsession();
			tl.remove();
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事务的提交
	public static void commit(){
		try {
			SqlSession ss= getSqlsession();
			ss.commit();
			//调用关闭资源的方法
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事务的回滚
		public static void rollback(){
			try {
				SqlSession ss= getSqlsession();
				ss.rollback();
				//调用关闭资源的方法
				close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
