package com.db.common.java.model;
/**消息业务接口*/
interface MessageService{
	void sendMsg(String msg);
}
class MessageServiceImpl implements MessageService{
	@Override
	public void sendMsg(String msg) {
		System.out.println(msg);
	}

}
//=============================================
//1.通过继承方式实现功能扩展
class SubMessageServiceImpl extends MessageServiceImpl{
	@Override
	public void sendMsg(String msg) {
		long t1=System.nanoTime();
		super.sendMsg(msg);
		long t2=System.nanoTime();
		System.out.println("execute time :"+(t2-t1));
	}
}
//2.继承方式实现扩展的应用分析
//1.优势:可读性好,扩展简单
//2.劣势:
//1)耦合性比较强(子类与父类)
//2)假如有多个目标对象需要进行功能扩展,类个数会增加,代码冗余也会比较大

//=======================================================
//1.通过创建兄弟类的方式实现功能扩展
class ProxyMessageService implements MessageService{
	private MessageService msgService;
	public ProxyMessageService(MessageService msgService) {
		this.msgService=msgService;
	}
	@Override
	public void sendMsg(String msg) {
		long t1=System.nanoTime();
		this.msgService.sendMsg(msg);
		long t2=System.nanoTime();
		System.out.println("execute time :"+(t2-t1));
	}
}
//2.兄弟类方式扩展应用分析
//1)优势:耦合性比较低,扩展类的个数会减少(一个接口写一个扩展类就可以了).
//2)劣势:方法中代码冗余还是比较高,每个接口都要自己写扩展实现类.
//=============================================
public class TestProxy01 {
	static void testProxy01(){
		MessageService proxy=
		new SubMessageServiceImpl();
		proxy.sendMsg("hello zhangzhen");
	}
	static void testProxy02(){
		//target
		MessageServiceImpl target=new MessageServiceImpl();
	    //proxy
	    MessageService proxy=
	    new ProxyMessageService(target);
	    //执行方法
	    proxy.sendMsg("hello liangtao");
	}
    public static void main(String[] args) {
		testProxy01();
	}
}







