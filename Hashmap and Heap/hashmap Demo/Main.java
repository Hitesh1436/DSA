import java.util.*;

public class Main {

  public static void main(String[] args) {
    //declare and initialize
     
    HashMap<String, Integer> hm = new HashMap<>();

    //put

    hm.put("India", 628);
    hm.put("China", 837);
    hm.put("Dubai", 120);

    // System.out.println(hm);

    hm.put("India", 200);  // update krdega India key ke liye value ko from 628 to 200
    
    hm.put("Pak", 837);
    hm.put("US", 443);

    // System.out.println(hm);
    
    
    //get

    int indData = hm.get("India");
    // System.out.println(indData);


    // containsKey

    boolean isChinaPresent = hm.containsKey("China");  // true dega bcz exist krta h
    boolean isBangladeshPresent = hm.containsKey("Bangladesh");  // false dega bcz ni exist krta hmre liye 
    
    // System.out.println(isChinaPresent);
    // System.out.println(isBangladeshPresent);
    
    //keySet

    // HashSet<String> keys = hm.keySet(); 
    for(String key : hm.keySet() ){
        // System.out.println(key);
    }
    
    //size
    // System.out.println(hm.size());
    
    
    


  }
}