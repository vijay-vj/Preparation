package HackerRank;

public class BitWiseManipulationsXOR {
	
	public static void main(String args[]) {
		int x=4; 
		int y =2; 
		
		System.out.println( 5 ^ 1);
		System.out.println(1 );
		
		for(int i=0; i< 100; i++) {
			if( (i ^ 4) == 2  ) {
				System.out.println("Found at: " + i );
			}
		}
		// showBits(a ^ b);
	}
	

	   public static void showBits(int param) {
	      int mask = 1 << 31;

	      for (int i = 1; i <= 32; i++,
	            param <<= 1) {
	         System.out.print((param & mask) ==
	            0 ? "0" : "1");
	         if (i % 8 == 0)
	            System.out.print(" ");
	      }
	      System.out.println();
	   }
	   
}
