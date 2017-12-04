package com.app.service.impl;

import java.text.ParseException;  
import java.util.Date;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import com.app.dao.UserDao;  
//import com.app.tools.MD5Tool;
import com.app.tools.MD5Util;  
import com.app.tools.SendEmail;  
import com.app.tools.ServiceException;  
import com.code.model.UserModel;  



/** 
*  
* @author worthsky 
* 
*/  
@Service
public class RegisterValidateService {
  
	 @Autowired
	 private UserDao userDao;  
	      
	    /** 
	     * ����ע�� 
	     */  
	   
	    public void processregister(String email){  
//	    	�û������email����
	        UserModel user=new UserModel();  
	        Long as=5480l;  
	        user.setId(as);  
	        user.setName("ws");  
	        user.setPassword("123456");  
	        user.setEmail(email);  
	        user.setRegisterTime(new Date());  
	        user.setStatus(0);
	        ///������ڰ�ȫ�����Խ������봦��ĸ����ӵ㣬�����������򵥴���  
	        //user.setValidateCode(MD5Tool.MD5Encrypt(email));  
	        user.setValidateCode(MD5Util.encode2hex(email));  
	          
	        userDao.save(user);//����ע����Ϣ  
	          
	        //���͵��ʼ�����  
	        StringBuffer sb=new StringBuffer("����������Ӽ����˺ţ�48Сʱ��Ч����������ע���˺ţ�����ֻ��ʹ��һ�Σ��뾡�켤�</br>");  
	        sb.append("<a href=\"http://localhost:8080/EmailValidate/register?action=activate&email=");  
	        sb.append(email);   
	        sb.append("&validateCode=");   
	        sb.append(user.getValidateCode());  
	        sb.append("\">http://localhost:8080/EmailValidate/register?action=activate&email=");   
	        sb.append(email);  
	        sb.append("&validateCode=");  
	        sb.append(user.getValidateCode());  
	        sb.append("</a>");  
	          
	        //�����ʼ�  
	        SendEmail.send(email, sb.toString());  
	        System.out.println("�����ʼ�");  
	          
	    }  
	      
	    /** 
	     * ������ 
	     * @throws ParseException  
	     */  
	      ///���ݼ������email����  
	    public void processActivate(String email , String validateCode)throws ServiceException, ParseException{    
	         //���ݷ��ʲ㣬ͨ��email��ȡ�û���Ϣ  
	        UserModel user=userDao.find(email);  
	        //��֤�û��Ƿ����   
	        if(user!=null) {    
	            //��֤�û�����״̬    
	            if(user.getStatus()==0) {   
	                ///û����  
	                Date currentTime = new Date();//��ȡ��ǰʱ��    
	                //��֤�����Ƿ����   
	                currentTime.before(user.getRegisterTime());  
	                if(currentTime.before(user.getLastActivateTime())) {    
	                    //��֤�������Ƿ���ȷ    
	                    if(validateCode.equals(user.getValidateCode())) {    
	                        //����ɹ��� //�������û��ļ���״̬��Ϊ�Ѽ���   
	                        System.out.println("==sq==="+user.getStatus());  
	                        user.setStatus(1);//��״̬��Ϊ����  
	                        System.out.println("==sh==="+user.getStatus());  
	                        userDao.update(user);  
	                    } else {    
	                       throw new ServiceException("�����벻��ȷ");    
	                    }    
	                } else { throw new ServiceException("�������ѹ��ڣ�");    
	                }    
	            } else {  
	               throw new ServiceException("�����Ѽ�����¼��");    
	            }    
	        } else {  
	            throw new ServiceException("������δע�ᣨ�����ַ�����ڣ���");    
	        }    
	            
	    }   
	
	
}
