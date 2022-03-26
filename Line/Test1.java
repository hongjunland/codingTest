import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
//        new Solution().solution(new String[]{"team_name : db application_name : dbtest error_level : info message : test",
//                "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"});
        new Solution().solution(new String[]{"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"});
    }
    static private class Solution {
        final String[] tag = {"team_name","application_name","error_level","message"};
        public int solution(String[] logs) {
            int answer = 0;
            for(int i = 0 ; i< logs.length ; i++){
                String[] split = logs[i].split(" ");
                System.out.println(Arrays.toString(split));
                if(split.length!=12 || logs[i].length()>100){
                    answer++;
                    System.out.println("길이 문제");
                    continue;
                }
                boolean flag = false;
//                0 1 2 3
//                0 3 6 9
                for(int j = 0 ;  j < 12 ; j++){
                    if(j%3==0 && !tag[j/3].equals(split[j])){
                        flag = true;
                        System.out.println("태그명 다름");
                        break;
                    }
                    if(j%3==1 && !split[j].equals(":")){
                        flag = true;
                        System.out.println(": 없음");
                        break;
                    }
                    if(j%3==2){
                        String pattern = "^[a-zA-Z]*$";
                        if(!Pattern.matches(pattern,split[j])) {
                            flag = true;
                            System.out.println(split[j]);
                            System.out.println("숫자 또는 특수문자가 있음");
                            break;
                        }
                    }
                }
                if(flag) answer++;
            }
            System.out.println(answer);
            return answer;
        }
    }
}
