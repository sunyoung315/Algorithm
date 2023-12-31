package silver.boj_10989_수_정렬하기_3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// buffered를 써야 하는 문제... 시간 초과..
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] count = new int[10000];
		for(int i = 0; i < N; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 1; i < 10000; i++) {
			count[i] += count[i-1];
		}
		
		
		int[] result = new int[N];
		for(int i = N-1; i >=0; i--) {
			int idx = arr[i];
			count[idx]--;
			result[count[idx]] = arr[i];
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
		
	}
}
