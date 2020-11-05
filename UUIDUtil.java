
import java.util.UUID;
/**
 * UUID工具类
 * 
 * @author yiricy
 * @date 2020年11月5日
 */
public class UUIDUtil {
	
	//传入需要获取的随机序列长度，返回一个随机序列
	public static String randomString(int lenth) {
		String replace1 = UUID.randomUUID().toString().replace("-", "");
		
		
		//长度不够时，扩容
		
		while (replace1.length() < lenth) {

			String replace2 = UUID.randomUUID().toString().replace("-", "");
			replace1 += replace2;
				
		}
		return replace1.substring(0, lenth);
	
	}
	
	//传入需要获取的随机序列长度，和需要的序列类型：传入letter返回纯字母序列，传入number返回纯数字序列
	public static String randomString(int lenth , String needString) {
		
		
		//接收参数为letter时
		if(needString.equals("letter")) {
			
			//生成一个只有字母的字符串
			String UUIDStr = UUID.randomUUID().toString().replace("-", "").replaceAll("\\d+","");
			
			while (UUIDStr.length() < lenth) {
				
				//长度不够时，扩容
				String replace2 = UUID.randomUUID().toString().replace("-", "").replaceAll("\\d+","");
				UUIDStr += replace2;
			}
			
			
			return UUIDStr.substring(0, lenth);
		}
		
		
		//接受参数为number时
		if (needString.equals("number")) {
			//生成一个只有字母的字符串
			String UUIDStr = UUID.randomUUID().toString().replace("-", "").replaceAll("[a-zA-Z]","");
			
			while (UUIDStr.length() < lenth) {
				
				//长度不够时，扩容
				String replace2 = UUID.randomUUID().toString().replace("-", "").replaceAll("[a-zA-Z]","");
				UUIDStr += replace2;
			}
			
			
			return UUIDStr.substring(0, lenth);
		}
		
		
		return "参数异常";
	
		
	}
}
