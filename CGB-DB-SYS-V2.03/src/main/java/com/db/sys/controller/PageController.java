package com.db.sys.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
      @RequestMapping("doIndexUI")
	  public String doIndexUI(){
		  return "starter";
	  }
      /**
       * 返回分页页面
       */
      @RequestMapping("doPageUI")
      public String doPageUI(){
    	 //...
      	 return "common/page";
      }
      
      @RequestMapping("doLoginUI")
      public String doLoginUI(){
      	return "login";
      }
      /****user pages **/
      @RequestMapping("user/doUserListUI")
	  public String doUserListUI(){
		  return "sys/user_list";
	  }
	  @RequestMapping("user/doUserEditUI")
	  public String doUserEditUI(){
		  return "sys/user_edit";
	  }
	  @RequestMapping("user/doUpdatePwdUI")
      public String doUpdatePwdUI(){
    	  return "sys/pwd_edit";
      }

}
