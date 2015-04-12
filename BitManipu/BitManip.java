
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
		
		
		
		System.out.println(Integer.toBinaryString(~0));
		int z = 0b01111000;
		
		System.out.println(Integer.toBinaryString(clearBitRange(z, 4,5)));
		System.out.println(Integer.toBinaryString(clearBitRange(z, 3,5)));
		System.out.println(Integer.toBinaryString(clearBitRange(z, 1,5)));
		System.out.println(Integer.toBinaryString(clearBitRange(z, 1,6)));
		
		
		int n = 0b10000000000;
		int m = 0b10011;
		int i = 2; 
		int j = 6;
		System.out.println(Integer.toBinaryString(insertBits(n, m, i, j)));
		
		
		
		int xx = 0b011100000;
		System.out.println(Integer.toBinaryString(clearBitsMSBtoI(xx, 7)));
		
		
		int x = 0b01101110;
		System.out.println(Integer.toBinaryString(clearBitsItoZero(x, 2)));
		
		*/
		
		
		int bb = 0b00100000;
		System.out.println(Integer.toBinaryString(updateBits(bb, 1, 1)));
		System.out.println(Integer.toBinaryString(updateBits(bb, 2, 1)));
	}
	
	
	
	public static int updateBits(int num, int i, int v){
		int mask = ~(1<<i);
		return (num & mask) | (v<<i);
	}
	public static int clearBitsItoZero(int num, int i){
		int mask = ~(-1 >>> (31-i));
		
		return num & mask;
	}
	
	public static int clearBitsMSBtoI(int num, int i){
		/*
		 * eg. input: 011000  i = 4
		 *     output: 1000
		 */
		
		return num & ((1<<i)-1);
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
		
		System.out.println("Left = " + Integer.toBinaryString(left));
		
		int right = ((1<<i)-1);
		
		System.out.println("Right = " + Integer.toBinaryString(right));
		
		int mask = left | right;
		
		System.out.println("Mask = " + Integer.toBinaryString(mask));
		
		int cleared = mask & num;
		
		return cleared;
	}
	
	
	public static int insertBits(int n, int m, int i, int j){
		/*
		 *eg. n = 10000000000 
		 *    m = 10011
		 *    i = 2
		 *    j = 6
		 *    
		 *    output: 10001001100
		 */
		
		
		//Clear n from inclusive i to inclusive j
		
		int left = (~0)<<(j+1);
		int right = (1<<i)-1;
		
		int mask = left | right;
		
		int cleared_n = n & mask;
		
		//shift m to correct position
		int shifted_m = m<<i;
		
		
		//combine
		
		return cleared_n | shifted_m;
		
	}

}
