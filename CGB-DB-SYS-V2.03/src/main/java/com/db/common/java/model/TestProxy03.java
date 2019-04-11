package com.db.common.java.model;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//模拟mybatis中如何直接为接口产生代理对象
interface SearchDao{
	String search(String key);
}
interface MessageDao{
	 void sendMsg(String msg);
}
//代理工厂
class DaoProxyFactory{
	/**
	 * <T>应用在方法的返回值左侧时表示这个方法是泛型方法
	 * @param targetCls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T>T getProxy(Class<T> targetCls){
		return (T)Proxy.newProxyInstance(
				targetCls.getClassLoader(),
				new Class[]{targetCls},//interfaces
				new DaoProxyHandler(targetCls));
	} 
}
//代理对象处理器
class DaoProxyHandler implements InvocationHandler{
	private Class<?> targetClass;
	public DaoProxyHandler(Class<?> targetClass) {
		this.targetClass=targetClass;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke ");
		String namespace=targetClass.getName();
		String methodId=method.getName();
		System.out.println(namespace+"."+methodId);
		//.......session
		return null;
	}
}
//基于JDK的代理机制为目标接口SearchDao创建代理对象.
public class TestProxy03 {
	public static void main(String[] args) {
		DaoProxyFactory factory=new DaoProxyFactory();
		SearchDao dao=factory.getProxy(SearchDao.class);
	    System.out.println(dao.getClass().getName());
	    dao.search("cgb1811");
	}
}
