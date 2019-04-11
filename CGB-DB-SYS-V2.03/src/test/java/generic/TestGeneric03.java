package generic;

public class TestGeneric03 {
	static Class<?> get(Class<?> c){return null;}
	public static void main(String[] args)
	throws Exception{
		Class<TestGeneric03> c1=
		TestGeneric03.class;//类对象
		//如下的泛型中传入的？就是通配符
		Class<?> c2=
		Class.forName("generic.TestGeneric03");
		System.out.println(c1==c2);//true
	}
}
