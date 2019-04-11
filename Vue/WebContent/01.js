// 1.2  options是框架的配置信息
function Vue(options){
	
	// el 全称是element,也是rootElement 的简写
	var rootElement=options.el;
	
	// 根据id 找到js对象(通过document找到的对象一般叫js对象)
	var div=document.getElementById(rootElement);
	
	// 设置它的背景色
	div.style.backgroundColor="#FF0000";
	
}

// 2. 用框架

try {
	
// 2.1 设置配置信息
	var options = {"el":"app"};
	
// 2.2 启动框架
	var vue = new Vue(options);
	
} catch(e) {
	
	console.log(e);
	
}