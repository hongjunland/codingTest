
import java.util.HashMap;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        new Solution().solution("one4seveneight"	);
        new Solution().solution("23four5six7");
        new Solution().solution("2three45sixseven"	);
        new Solution().solution("123"	);
    }
}
class Solution {
    final static String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
    final static String[] text ={"zero","one","two","three","four","five","six","seven","eight","nine"};
    HashMap<String, String> hashMap;
    public int solution(String s) {
        hashMap = new HashMap<>();
        for(int i = 0; i < 10; i++){
            hashMap.put(text[i], nums[i]);
        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                result+=s.charAt(i);
                continue;
            }
            sb.append(s.charAt(i));
            if(hashMap.containsKey(sb.toString())){
                result+=hashMap.get(sb.toString());
                sb = new StringBuilder();
            }
        }
        return Integer.parseInt(result);
    }
}
