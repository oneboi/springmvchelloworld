package com.oneboi.controller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oneboi.domain.Account;

//使用spring注解创建控制对象，使用spring来管理
@Controller("hello999")
public class HelloController {

	@RequestMapping("/mv")//请求 的映射：他要和浏览器请求的url保持一致
	public @ResponseBody String  mv(){
	 
		System.out.println("文件上传执行");
		
		return "hello";
		
	}
	
	@RequestMapping("/upload2")//请求 的映射：他要和浏览器请求的url保持一致
	public @ResponseBody String  upload2(MultipartFile upload,HttpServletRequest request) throws IllegalStateException, IOException {
	  System.out.println("spring mvc 文件上传");
	  //1.获取文件保存路径
  	String basePath=request.getSession().getServletContext().getRealPath("/WEB-INF/uploads");
  	
	  //2. 为了仿制文件夹过多，使用当天日期创建一个二级目录
  	  String datePath=new  SimpleDateFormat("yyyy-MM-dd").format(new  Date());
  	  
	   //3. 判断目录是否存在 
  	  File file= new File(basePath,datePath);
  	  if(!file.exists()){
  		  file.mkdirs();
  	  }
  	   //4. 获取文件名
  	  String fileName=upload.getOriginalFilename();
  	  //5.随机化文件名
  	String uuid=UUID.randomUUID().toString().replace("-", "");
  	fileName=uuid+"_"+fileName;
  	  //6.把文件写到指定位置
	  upload.transferTo(new File(file,fileName));
	  return "king";
		
	}
	
	
	
	@RequestMapping("/upload")//请求 的映射：他要和浏览器请求的url保持一致
	public @ResponseBody String  upload(HttpServletRequest request) throws Exception{
		 //1.判断表单是否支持文件上上传
		   boolean isMultiForm=ServletFileUpload.isMultipartContent(request);
		   if(!isMultiForm){
			     return "hello";
			    }
		 //2.创建DiskFileItemFactory对象
		   DiskFileItemFactory factory=new DiskFileItemFactory(); 
		   //factory.setRepository(new File("D://temp"));//设置缓存文件的目录
		   //（commons-fileupload是使用缓存的。原则： 大小是否超过10kb,
		   //如果超过10kb则使用临时文件作为缓存，如果小于10kb则使用内存作为缓存。
		   
		 //3.创建ServletFileUpload对象

		   ServletFileUpload sfu= new ServletFileUpload(factory);

		   //4.解析request,得到FileItem对象的集合

		   List<FileItem> items=sfu.parseRequest(request);

		   //5.判断FileItem是否是文件字段

		   for(FileItem item:items){
			 //6不是，打印输出
		    if(item.isFormField()){ //表单字段，非文件
		        String fieldName=item.getFieldName();//普通字段的名称
		        String fieldValue=item.getString("UTF-8");//普通字段的字段值
		        System.out.println(fieldName+":"+fieldValue);

		    }else{
		    	//7.是，写文件
		    	String basePath=request.getSession().getServletContext().getRealPath("/WEB-INF/uploads");
		    	System.out.println(basePath);
		    	File file=new File(basePath);
		    	if(!file.exists()){
		    		file.mkdirs();
		    	}
		    	//获取文件名
		    	String fileName=item.getName();
		    	String uuid=UUID.randomUUID().toString().replace("-", "").toUpperCase();
		    	fileName=uuid+"_"+fileName; //随机化文件名，防止重复
		    	System.out.println(fileName);
		    	item.write(new File(file,fileName));
		    	//删除临时文件。
		    	item.delete();
		    }
		   }

		   
		
		return "hello";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
