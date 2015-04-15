public class BitwiseOperation {

	public static void main(String[] args) {
		
		/*
		 * Arithmetic shift
		 * 
		 * Bits are shifted out of either end are discarded
		 * 
		 * in a left arithmetic shift, zeros are shifted in 
		 * on the right
		 * 
		 * in a right arithmetic shift, the sign bit (MSB) is 
		 * shifted in on the left, thus preserving the sign of the
		 * operand
		 * 
		 *  
		 *  In java, all integer types are signed, 
		 *  
		 *  the << and >> performs arithmetic shift
		 *  
		 *  
		 *  In a logical shift, zeros are shifted in to replace
		 *  the discarded bits. the logical shift and the arithmetic
		 *  left shift are exactly the same. 
		 *  
		 *  
		 *  However, as the logical right shift inserts value 0 bits
		 *  into the MSB, instead of copying the sign bit, it is ideal
		 *  for unsigned binary numbers, while arithmetic right shift
		 *  is ideal for signed two's complement binary numbers
		 *  In Java, >>> is used to perform logical right shift. 
		 *  
		 */
		
		
		
		
		//System.out.println(printBinary2(0.75));
		
		int a =0b01111;
		int b = 0b11011;
		int c = a^b;
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(c>>1));
		c= c>>1;
		c=c>>1;
		c=c>>1;
		System.out.println(Integer.toBinaryString(c));
		
	
	}
	
	
	/*public static void printBinary(double x){
		System.out.print(".");
		for(int i =0; i<31; i++){
			x = x * 2;
			if(x>=1){
				System.out.print("1");
				x=x-1;
			}
			else{
				System.out.print("0");
			}
		}
		
		System.out.println();
	}
	
	*/
	public static String printBinary2(double x){
		if(x>=1 || x<=0)
			return "ERROR";
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		
		while(x > 0){
			
			if(sb.length()>=32)
				return "ERROR";
			double r = x * 2;
			
			
			if(r>=1){
				sb.append(1);
				x = r-1;
			}
			else{
				sb.append(0);
				x = r;
			}
		}
		
		return sb.toString();
	}
	
}