package com.app.web.controller;  
  
import java.text.ParseException;  
  
import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
  
import com.app.service.impl.RegisterValidateService;  
import com.app.tools.ServiceException;  
  
  
@Controller
public class RegisterController {  
      
    @Resource
    private RegisterValidateService service;  
      
    @RequestMapping(value="/register",method={RequestMethod.GET,RequestMethod.POST})  
    public ModelAndView load(HttpServletRequest request,HttpServletResponse response) throws ParseException{  
        String action = request.getParameter("action");  
        System.out.println("-----r----"+action);  
       
        ModelAndView mav=new ModelAndView();  
  
        if("register".equals(action)) {  
            //ע��  
            String email = request.getParameter("email");
            System.out.println("ҳ���ϵ�������룺"+email);  
            service.processregister(email);//�����伤��  
            mav.addObject("text","ע��ɹ�");  
            mav.setViewName("register_success");  
        }   
        else if("activate".equals(action)) {  
            //����  
            String email = request.getParameter("email");//��ȡemail  
            String validateCode = request.getParameter("validateCode");//������  
              
            try {  
                service.processActivate(email , validateCode);//���ü����  
                mav.setViewName("activate_success");  
            } catch (ServiceException e) {  
                request.setAttribute("message" , e.getMessage());  
                mav.setViewName("activate_failure");  
            }  
              
        }  
        return mav;  
    }  
      
  
}  