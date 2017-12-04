package com.app.dao;  
  
  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.HashMap;  
  
  
import org.springframework.stereotype.Repository;  
  
import com.code.model.UserModel;  
  
/** 
 *  
 * @author worth
 */  
@Repository
public class UserDao {  
      
   public HashMap<String, String> map=new HashMap<String, String>();  
    /** 
     * @����ע����Ϣ 
     *  private Long id; 
        private String name; 
        private String password; 
        private String email;//ע���˺� 
        private int status;//����״̬ 
        private String validateCode;//������ 
        private Date  registerTime;//ע��ʱ�� 
     */  
    public void save(UserModel user){  
        System.out.println("cicicici");  
        map.put("id", String.valueOf(user.getId()));  
        map.put("email", user.getEmail());  
        map.put("validateCode", user.getValidateCode());  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");  
        String time=sdf.format(user.getRegisterTime());  
        map.put("registerTime", time);  
        int status=user.getStatus();  
        map.put("status", String.valueOf(status));  
        map.put("name", user.getName());  
        String t2=sdf.format(user.getLastActivateTime());  
        map.put("activeLastTime", String.valueOf(t2));  
        System.out.println("=======s========="+status);  
          
    }  
      
    /** 
     * @���� user 
     */  
    public void update(UserModel user){  
        map.put("email", user.getEmail());  
        map.put("validateCode", user.getValidateCode());  
        Date time=user.getRegisterTime();  
        map.put("registerTime", String.valueOf(time));  
        int status=user.getStatus();  
        map.put("status", String.valueOf(status));  
        System.out.println("=======st========="+status);  
    }  
      
    /** 
     * @throws ParseException  
     * @������Ϣ 
     */  
    public UserModel find(String email) throws ParseException{  
        UserModel user=new UserModel();  
        user.setEmail(map.get("email"));  
        user.setName(map.get("name"));  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");  
        Date day=sdf.parse(map.get("registerTime"));  
        user.setRegisterTime(day);  
        user.setStatus(Integer.valueOf(map.get("status")));  
        user.setValidateCode(map.get("validateCode"));  
  
        return user;  
    }  
  
}  