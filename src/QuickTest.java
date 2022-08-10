import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuickTest {
    public static void main(String[] args) {

        String s ="aabbccdde";
        String s2 ="bbccddeaa";
        String s3 ="abcd";
        System.out.println(splitSubString(s3));
//        HashMap hash1 = parse(s);
//        HashMap hash2 = parse(s2);
//        HashMap hash3 = parse(s3);
//        System.out.println(hash1);
//        System.out.println(hash1.equals(hash2));
//        System.out.println(hash2.equals(hash3));
    }

    //split sub Strings
    public static ArrayList<String> splitSubString(String str){
        int length = str.length();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            for(int j=length-1;j>=i;j--){
                String sub = (str.substring(i,j+1));
                if(!sub.equals(""))
                    list.add(sub);
            }

        }
        return list;
    }

    public static HashMap<Character, Integer> parse(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            int times = hash.computeIfAbsent(c, key -> 0);
            hash.put(c, times + 1);
        }
        return hash;
    }
}
