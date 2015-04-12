
public class BitManip {

	public static void main(String[] args) {
	/*	int num = 0b01110;

		System.out.println(getbit(num, 0));
		System.out.println(getbit(num, 1));
		System.out.println(getbit(num, 2));
		System.out.println(getbit(num, 3));
		System.out.println(getbit(num, 4));
		
		int x = 0b00011000;
		System.out.println(Integer.toBinaryString(setbit(x, 1)));
		System.out.println(Integer.toBinaryString(setbit(x, 2)));
		System.out.println(Integer.toBinaryString(setbit(x, 3)));
		System.out.println(Integer.toBinaryString(setbit(x, 5)));
		
		
		int y = 0b01110000;
		
		System.out.println(Integer.toBinaryString(clearbit(y, 0)));
		System.out.println(Integer.toBinaryString(clearbit(y, 4)));
		System.out.println(Integer.toBinaryString(clearbit(y, 5)));
		*/
		
		int z = 0b01111000;
		
		System.out.println(Integer.toBinaryString(clearBitRange(z, 4,5)));
		System.out.println(Integer.toBinaryString(clearBitRange(z, 3,5)));
		System.out.println(Integer.toBinaryString(clearBitRange(z, 1,5)));
		System.out.println(Integer.toBinaryString(clearBitRange(z, 1,6)));
		
		
	}
	
	public static boolean getbit(int num, int i){
		
		//shift 1 over by i bits, eg. 00010000
		//and with num, clear all bits other than the bit
		//at i. Compare to 0, if not 0, then bit i is 1
		return ((num & (1<<i)) != 0);
	}
	
	
	public static int setbit(int num, int i){
		
		/*
		 * 0001000 | 0100111 
		 * 
		 * 0101111
		 */
		return (num | (1<<i));
	}
	
	
	public static int clearbit(int num, int i){
		/*
		 * 1110111 & num
		 */
		
		return num & (~(1<<i));
	}
	
	public static int clearBitRange(int num, int i, int j){
		/*
		 * eg. 01101101
         
         i = 2, j =5
         
         left = (~0)<<(5+1) = 11000000
         right = (1<<i) - 1 = 00000100- 00000001 = 00000011
         
         left | right = 11000011
		 */
		
		int left = ((~0)<<j+1);
		int right = ((1<<i)-1);
		int mask = left | right;
		
		int cleared = mask & num;
		
		return cleared;
	}

}
