import java.util.Scanner;

public class Main_8320_이홍준 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		for(int i = 1 ; i <= Math.sqrt(num); i++) {
			for(int j = i ; j <= num; j++) {
				if(i*j<=num) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
