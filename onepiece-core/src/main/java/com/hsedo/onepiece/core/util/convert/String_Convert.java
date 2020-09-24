package com.hsedo.onepiece.core.util.convert;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author  作者:CC
 * @Date	时间: 2020年9月21日 下午5:00:28
 * 类说明
 * String 类型转换
 */
public class String_Convert {
	
    // 将汉字转换为全拼  
    public static String getPingYin(String src) {  
  
        char[] t1 = null;  
        t1 = src.toCharArray();  
        String[] t2 = new String[t1.length];  
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();  
          
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);  
        String t4 = "";  
        int t0 = t1.length;  
        try {  
            for (int i = 0; i < t0; i++) {  
                // 判断是否为汉字字符  
                if (java.lang.Character.toString(t1[i]).matches(  
                        "[\\u4E00-\\u9FA5]+")) {  
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);  
                    t4 += t2[0];  
                } else  
                    t4 += java.lang.Character.toString(t1[i]);  
            }  
            // System.out.println(t4);  
            return t4;  
        } catch (BadHanyuPinyinOutputFormatCombination e1) {  
            e1.printStackTrace();  
        }  
        return t4;  
    }  
	
	/**
    * 转换成Integer
    * @param value
    * @return
    */
   public static Integer convertInteger(String value){
       Integer id = 0;
       try{
           id = Integer.parseInt(value);
       }catch (NumberFormatException e){
           //log.error("",e);
       }
       return id;
   }

	/**
    * 转换成short
    * @param value
    * @return
    */
   public static   short convertShort(String value){
       short id = 0;
       try{
           id = Short.parseShort(value);
       }catch (NumberFormatException e){
           //log.error("",e);
       }
       return id;
   }

   
   /**
    * 转换成Double
    * @param value
    */
   public static Double convertDouble(String value){
         Double d=0d;
         try{
             d=Double.parseDouble(value);
         }catch (NumberFormatException e){
            // log.error("",e);
         }
       return d;
   }

   /**
    * 转换成Float
    * @param value
    */
   public static Float convertFloat(String value){
       Float f=0f;
       try{
           f=Float.parseFloat(value);
       }catch (NumberFormatException e){
          // log.error("",e);
       }
       return f;
   }


   /**
    * 转换成Long
    * @param value
    */
   public static Long convertLong(String value){
       Long l = 0l;
       try{
           l=Long.parseLong(value);
       }catch (NumberFormatException e){
          // log.error("",e);
       }
       return l;
   }

}
