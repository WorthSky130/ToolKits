package encryption;
import java.math.BigInteger;
import java.security.MessageDigest;
/*
SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，
被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD通过碰撞法都被破解了，
但是SHA仍然是公认的安全加密算法，较之MD更为安全*/
public class SHA {
          public static final String KEY_SHA = "SHA"; 
          public static final String KEY_MD = "MD5"; 
       public static String getResult(String inputStr){
		    BigInteger sha =null;
		    System.out.println("=======SHA加密前的数据:"+inputStr);
		    byte[] inputData = inputStr.getBytes(); 
		    try {
		       MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA); 
		       messageDigest.update(inputData);
		       sha = new BigInteger(messageDigest.digest()); 
		       System.out.println("SHA加密后:" + sha.toString()); 
		       System.out.println("长度：" + sha.toString().length());
		    } catch (Exception e) {e.printStackTrace();}
		    return sha.toString();
  }
  /**
   * md5
   * 
   * @param args
   */
       public static String getResultMD5(String inputStr)
       {
         System.out.println("=======MD5加密前的数据:"+inputStr);
         BigInteger bigInteger=null;
         try {
          MessageDigest md = MessageDigest.getInstance(KEY_MD); 
          byte[] inputData = inputStr.getBytes();
          md.update(inputData); 
          
          bigInteger = new BigInteger(1,md.digest()); 
         } catch (Exception e) {e.printStackTrace();}
         System.out.println("MD加密后:" + bigInteger.toString(16)); 
         System.out.println("长度：" + bigInteger.toString(16).length());
         return bigInteger.toString();
       }
       
       
       //md5加密
       
       public static String getMD5(String str) throws Exception {
    	   try {
    	   // 生成一个MD5加密计算摘要
    	   MessageDigest md = MessageDigest.getInstance("MD5");
    	   // 计算md5函数
    	   md.update(str.getBytes());
    	   // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
    	   // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
    	   return new BigInteger(1, md.digest()).toString(16);
    	   } catch (Exception e) {
    	   throw new Exception("MD5加密出现错误");
    	   }
    	  }
  
  
  
  public static void main(String args[])
  {
    try {
       String inputStr = "123456"; 
       //getResult(inputStr);
     getResultMD5(inputStr);
       
       String md5 = getMD5(inputStr);
       System.out.println(md5);
       System.out.println(md5.length());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}