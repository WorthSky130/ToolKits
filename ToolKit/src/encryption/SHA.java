package encryption;
import java.math.BigInteger;
import java.security.MessageDigest;
/*
SHA(Secure Hash Algorithm����ȫɢ���㷨��������ǩ��������ѧӦ������Ҫ�Ĺ��ߣ�
���㷺��Ӧ���ڵ����������Ϣ��ȫ������Ȼ��SHA��MDͨ����ײ�������ƽ��ˣ�
����SHA��Ȼ�ǹ��ϵİ�ȫ�����㷨����֮MD��Ϊ��ȫ*/
public class SHA {
          public static final String KEY_SHA = "SHA"; 
          public static final String KEY_MD = "MD5"; 
       public static String getResult(String inputStr){
		    BigInteger sha =null;
		    System.out.println("=======SHA����ǰ������:"+inputStr);
		    byte[] inputData = inputStr.getBytes(); 
		    try {
		       MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA); 
		       messageDigest.update(inputData);
		       sha = new BigInteger(messageDigest.digest()); 
		       System.out.println("SHA���ܺ�:" + sha.toString()); 
		       System.out.println("���ȣ�" + sha.toString().length());
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
         System.out.println("=======MD5����ǰ������:"+inputStr);
         BigInteger bigInteger=null;
         try {
          MessageDigest md = MessageDigest.getInstance(KEY_MD); 
          byte[] inputData = inputStr.getBytes();
          md.update(inputData); 
          
          bigInteger = new BigInteger(1,md.digest()); 
         } catch (Exception e) {e.printStackTrace();}
         System.out.println("MD���ܺ�:" + bigInteger.toString(16)); 
         System.out.println("���ȣ�" + bigInteger.toString(16).length());
         return bigInteger.toString();
       }
       
       
       //md5����
       
       public static String getMD5(String str) throws Exception {
    	   try {
    	   // ����һ��MD5���ܼ���ժҪ
    	   MessageDigest md = MessageDigest.getInstance("MD5");
    	   // ����md5����
    	   md.update(str.getBytes());
    	   // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
    	   // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
    	   return new BigInteger(1, md.digest()).toString(16);
    	   } catch (Exception e) {
    	   throw new Exception("MD5���ܳ��ִ���");
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