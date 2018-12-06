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

//ʹ��springע�ⴴ�����ƶ���ʹ��spring������
@Controller("hello999")
public class HelloController {

	@RequestMapping("/mv")//���� ��ӳ�䣺��Ҫ������������url����һ��
	public @ResponseBody String  mv(){
	 
		System.out.println("�ļ��ϴ�ִ��");
		
		return "hello";
		
	}
	
	@RequestMapping("/upload2")//���� ��ӳ�䣺��Ҫ������������url����һ��
	public @ResponseBody String  upload2(MultipartFile upload,HttpServletRequest request) throws IllegalStateException, IOException {
	  System.out.println("spring mvc �ļ��ϴ�");
	  //1.��ȡ�ļ�����·��
  	String basePath=request.getSession().getServletContext().getRealPath("/WEB-INF/uploads");
  	
	  //2. Ϊ�˷����ļ��й��࣬ʹ�õ������ڴ���һ������Ŀ¼
  	  String datePath=new  SimpleDateFormat("yyyy-MM-dd").format(new  Date());
  	  
	   //3. �ж�Ŀ¼�Ƿ���� 
  	  File file= new File(basePath,datePath);
  	  if(!file.exists()){
  		  file.mkdirs();
  	  }
  	   //4. ��ȡ�ļ���
  	  String fileName=upload.getOriginalFilename();
  	  //5.������ļ���
  	String uuid=UUID.randomUUID().toString().replace("-", "");
  	fileName=uuid+"_"+fileName;
  	  //6.���ļ�д��ָ��λ��
	  upload.transferTo(new File(file,fileName));
	  return "king";
		
	}
	
	
	
	@RequestMapping("/upload")//���� ��ӳ�䣺��Ҫ������������url����һ��
	public @ResponseBody String  upload(HttpServletRequest request) throws Exception{
		 //1.�жϱ��Ƿ�֧���ļ����ϴ�
		   boolean isMultiForm=ServletFileUpload.isMultipartContent(request);
		   if(!isMultiForm){
			     return "hello";
			    }
		 //2.����DiskFileItemFactory����
		   DiskFileItemFactory factory=new DiskFileItemFactory(); 
		   //factory.setRepository(new File("D://temp"));//���û����ļ���Ŀ¼
		   //��commons-fileupload��ʹ�û���ġ�ԭ�� ��С�Ƿ񳬹�10kb,
		   //�������10kb��ʹ����ʱ�ļ���Ϊ���棬���С��10kb��ʹ���ڴ���Ϊ���档
		   
		 //3.����ServletFileUpload����

		   ServletFileUpload sfu= new ServletFileUpload(factory);

		   //4.����request,�õ�FileItem����ļ���

		   List<FileItem> items=sfu.parseRequest(request);

		   //5.�ж�FileItem�Ƿ����ļ��ֶ�

		   for(FileItem item:items){
			 //6���ǣ���ӡ���
		    if(item.isFormField()){ //���ֶΣ����ļ�
		        String fieldName=item.getFieldName();//��ͨ�ֶε�����
		        String fieldValue=item.getString("UTF-8");//��ͨ�ֶε��ֶ�ֵ
		        System.out.println(fieldName+":"+fieldValue);

		    }else{
		    	//7.�ǣ�д�ļ�
		    	String basePath=request.getSession().getServletContext().getRealPath("/WEB-INF/uploads");
		    	System.out.println(basePath);
		    	File file=new File(basePath);
		    	if(!file.exists()){
		    		file.mkdirs();
		    	}
		    	//��ȡ�ļ���
		    	String fileName=item.getName();
		    	String uuid=UUID.randomUUID().toString().replace("-", "").toUpperCase();
		    	fileName=uuid+"_"+fileName; //������ļ�������ֹ�ظ�
		    	System.out.println(fileName);
		    	item.write(new File(file,fileName));
		    	//ɾ����ʱ�ļ���
		    	item.delete();
		    }
		   }

		   
		
		return "hello";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
