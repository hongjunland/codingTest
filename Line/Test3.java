import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        new Solution().solution(3, new String[]{"development","marketing","hometask"},
                new String[]{"recruitment","education","officetask"},new String[]{"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"});
    }
    private static class Solution {
        List<Integer> AnswerList;
        List<Employee> employeesList;
        HashMap<Integer, Boolean> remoteEmployeeMap;
        HashMap<String,Boolean> remoteMap;
        HashMap<String,Boolean> officeMap;
        public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
            AnswerList = new ArrayList<>();
            employeesList = new ArrayList<>();
            remoteEmployeeMap = new HashMap<>();
            for(int i = 0 ; i < remote_tasks.length; i++){
                remoteMap.put(remote_tasks[i], true);
            }
            for(int i = 0 ; i < office_tasks.length; i++){
                officeMap.put(office_tasks[i], true);
            }
            for(int i = 0 ; i < employees.length; i++){
                String[] split = employees[i].split(" ");
                List<String> departments = new ArrayList<>();
                for(int j = 1 ; j < split.length; j++){
                    departments.add(split[i]);
                }
                employeesList.add(new Employee(i,Integer.parseInt(split[0]), departments));
            }
            for(int i = 0 ; i < employees.length ; i++){
                Employee employee = employeesList.get(i);
                boolean flag = false;
                for(int j = 0 ; j < employee.department.size(); j++){
                    if(remoteMap.containsKey(employee.department[j])){

                    }
                }
            }

            int[] answer = new int[AnswerList.size()];
            for(int i = 0 ; i < answer.length ; i++){
                answer[i] = AnswerList.get(i);
            }
            Arrays.sort(answer);
            System.out.println(Arrays.toString(answer));
            return answer;
        }
        boolean isRemoteEmp(int idx){
            return false;
        }
        class Employee{
            int emp_no;
            int team_no;
            List<String> department;
            boolean isRemote;

            public Employee(int emp_no, int team_no, List<String> department) {
                this.emp_no = emp_no;
                this.team_no = team_no;
                this.department = department;
            }
        }
    }
}
