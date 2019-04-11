package generic;

import java.util.List;

/**泛型类:约束方法参数类型，返回值类型*/
class Container<T>{
	public void add(T t){}
	public T get(){return null;}
}
class ContainerUtil{
	/**泛型方法：返回值左侧的<T>只是用于说明此方法是泛型方法*/
	<T>List<T> sort(List<T> list){return null;}
	/**泛型方法*/
	<T>T search(List<T> list){return null;}
}
/**泛型类*/
class Containers<A,B,C,D>{
	C c;
	D d;
	public void add(A a){}
	public void take(B b){}
}
public class TestGeneric02 {
    public static void main(String[] args) {
    	Container<String> c1=new Container<String>();
	    c1.add("100");
	    Container<Integer> c2=new Container<Integer>();
	    c2.add(100);
	    
	    Containers<String,Integer,Double,Boolean> cc=
	    new Containers<String,Integer,Double,Boolean>();
	    cc.add("TEDU");
    }
}












