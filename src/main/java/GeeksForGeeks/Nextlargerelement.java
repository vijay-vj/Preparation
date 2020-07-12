package GeeksForGeeks;

import java.util.Scanner;
import java.util.Stack;

public class Nextlargerelement {

	public static void main(String[] args) {
		int[] arr = { 7, 8, 1,2, 4 };
		nextLargerElementv1(arr);
//		Scanner sc = new Scanner(System.in);
//	    int t = sc.nextInt();
//	    while (t > 0) {
//	        int n = sc.nextInt();
//	        long[] arr = new long[n];
//	        
//	        for (int i = 0; i < n; i++) {
//	            arr[i] = sc.nextInt();
//	        }
//	        nextLargerElementv1(arr);;
//	         
//	        t--;
//	    }

	}
	
	public static void nextLargerElementv1(int[] arr) {
		
		Stack<Integer> a = new Stack<>();
		for(int i=0; i<arr.length; i++) {
			if(a.empty() || arr[i]  < arr[a.peek()]) {
				a.push(i);
			}else {
				while(  !a.isEmpty() && arr[i] > arr[a.peek()] ) {
					arr[a.pop()] = arr[i]; 
				}
				a.push(i);
			}
		}
		
		while(!a.isEmpty()) {
			arr[a.pop()] = -1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void nextLargerElement(int[] arr) {
		try {

			int k = 0;
			int[] newArr = new int[arr.length];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > arr[k]) {
					while (k < i) {
						newArr[k] = arr[i];
						k++;
					}
				}
			}

			while (k <= arr.length - 1) {
				newArr[k] = -1;
				k++;
			}

			for (int i = 0; i < newArr.length; i++) {
				System.out.print(newArr[i] + " ");
			}
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
