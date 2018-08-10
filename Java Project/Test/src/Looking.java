import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Looking {

	public static void main(String[] args) {
		Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        String str = "Gaurav";
        System.out.println("String : " + str.substring(6,6));
        if(str.substring(3,1).isEmpty()) {
            System.out.println("empty");
        }
        
       /* Iterator iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }*/
        System.out.println(premiumPhone);
	}
}
