public class Test4 {
    public static void main(String[] args) {
        new Solution().solution(new int[]{3, 7, 2, 4}, new int[]{4, 5, 5, 2	});
    }
    private static class Solution {
        public int solution(int[] arr, int[] brr) {
            int answer = -1;
            return answer;
        }
        class Cell implements Comparable<Cell>{
            int idx;
            int current;
            int target;
            public Cell(int idx, int current, int target) {
                this.idx = idx;
                this.current = current;
                this.target = target;
            }

            @Override
            public int compareTo(Cell o) {
                int cmp = Integer.compare(current,target);
                return cmp == 0 ? Integer.compare(idx,o.idx) : cmp;
            }
        }
    }
}
