package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point implements Serializable{
	private static final long serialVersionUID = 7881941938240536376L;
	int x;
	int y;
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + "]";
	}
}
public class TestSerializable01 {
	public static void main(String[] args) throws Exception{
		//对象创建
		Point p1=new Point();
		p1.x=10;
		//对象序列化
	/*	ObjectOutputStream out=
		new ObjectOutputStream(
		new FileOutputStream("s1.txt"));
		out.writeObject(p1);
		out.close();*/
		//对象反序列化
		ObjectInputStream in=
		new ObjectInputStream(new FileInputStream("s1.txt"));
		Point p2=(Point)in.readObject();
		System.out.println(p2);
		in.close();
		
	}
}
