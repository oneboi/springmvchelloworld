package com.oneboi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.oneboi.domain.Account;

//使用spring注解创建控制对象，使用spring来管理
@Controller("hello999")
public class HelloController {
	
	@Autowired
	private Account account;
	
	@RequestMapping("/hello")//请求 的映射：他要和浏览器请求的url保持一致
	public String sayHello(Integer id){
		System.out.println(" hello request...."+id);
		return "hello";
	}

	@RequestMapping("/user")//请求 的映射：他要和浏览器请求的url保持一致
	public String getUser(@RequestBody String  body){
		System.out.println(" hello reques99t...." +body);
		return "hello";
	}
	
//	@RequestMapping("/mv")//请求 的映射：他要和浏览器请求的url保持一致
//	public @ResponseBody Account  mv(){
//		Account accounts=findAccountById(1);
//		System.out.println(accounts);
//		return accounts;
//	}
	@RequestMapping("/mv")//请求 的映射：他要和浏览器请求的url保持一致
	public @ResponseBody Account  mv(){
		Account accounts=findAccountById(1);
		System.out.println(accounts);
		return accounts;
	}
	private Account findAccountById(Integer id) {
		account.setId(1);
		account.setName("king");
		account.setMoney("10000000");
		return account;
	}
}
