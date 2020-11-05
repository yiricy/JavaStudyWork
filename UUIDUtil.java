package com.javaoop.xsb;
import java.util.UUID;
/**
 * UUID工具类
 * 
 * @author yiricy
 * @date 2020年11月5日
 */
public final class UUIDUtil {
	
	//传入需要获取的随机序列长度，返回一个随机序列
	public static String randomString(int lenth) {
		
		//创建StringBuilder对象
		StringBuilder sb = new StringBuilder();
		
		//长度不够时，扩容
		 do {
			 sb.append(UUID.randomUUID().toString().replace("-", ""));	
		} while (sb.length() < lenth);
			
		return sb.substring(0, lenth);
		}
	
	//传入需要获取的随机序列长度，和需要的序列类型：传入letter返回纯字母序列，传入number返回纯数字序列
	public static String randomString(int lenth , String needString) {
		
		
		//接收参数为letter时
		if(needString.equals("letter")) {
			
			//创建StringBuilder对象
			StringBuilder sb = new StringBuilder();
			
			//长度不够时，扩容
			 do {
				 sb.append(UUID.randomUUID().toString().replace("-", "").replaceAll("\\d+",""));	
			} while (sb.length() < lenth);
			
			return sb.substring(0, lenth);
		}
		
		
		//接受参数为number时
		if(needString.equals("letter")) {
			
			//创建StringBuilder对象
			StringBuilder sb = new StringBuilder();
			
			//长度不够时，扩容
			 do {
				 sb.append(UUID.randomUUID().toString().replace("-", "").replaceAll("[a-zA-Z]",""));	
			} while (sb.length() < lenth);
			
			return sb.substring(0, lenth);
		}
		
		
		return "参数异常";
		
		
	}
}
