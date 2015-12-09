/*
  Preme Team -- Janet Zhang, Kathy Lau
  APCS1 pd5
  HW44 -- This or That or Fourteen Other Things
  2015-12-08
*/

public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";

    public Hexadecimal() {
        _decNum = 0;
        _hexNum = "0";
    }

    public Hexadecimal( int n ) {
        _decNum = n;
        _hexNum = decToHexR( n );
    }

    public Hexadecimal( String s ) {
        _decNum = hexToDec( s );
        _hexNum = s;
    }

    /*
      public String toString() {
      return ("Decimal: " + _decNum + "\n" + "Hexadecimal: " + _hexNum + "\n");
      }
    */

    // Accessor Methods
    public int getDec()
    {return _decNum;}

    public String toString()
    {return _hexNum;}

    /*=====================================
      String decToHex(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of hex digits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "2"
      decToHex(3) -> "3"
      decToHex(10) -> "A"
      decToHex(16) -> "10"
      decToHex(20) -> "14"
      decToHex(32) -> "20"
      decToHex(42) -> "2A"
      =====================================*/
    public static String decToHex( int n ) {
     	String ans = "";
     	for (; n > 0; n/=16) {
     	    ans = HEXDIGITS.substring(n%16, n%16 + 1) + ans;	}
     	return ans;
    }

    public static String decToHexR( int n ) {
      	if (n > 0) {
      	    return (decToHexR(n/16) + HEXDIGITS.substring(n%16, n%16 + 1) );      	}
      	else
      	    return "";}

    public static int hexToDec(String s){
	int dec = 0;
	for (int i = 0;i<s.length();i++){//index counter
	    String digit=s.substring(i,i+1);//gets the digit from what index you're on
	    int pow=(int)Math.pow(16, Math.abs(s.length()-i-1));//gets the power of the index
	    dec+= (HEXDIGITS.indexOf(digit))*pow;}
	return dec;}

    public static int hexToDecR(String s){
	int dec = 0;
	if (s.length()>=1){//base case
	    String digit=s.substring(0,1);//gets the first digit
	    int pow=(int)Math.pow(16, Math.abs(s.length()-1));//gets the power of the index
	    dec+= (HEXDIGITS.indexOf(digit))*pow + hexToDecR(s.substring(1,s.length()));}
	return dec;}
    
    /*=============================================*/
    public boolean equals( Object other ) {
     	if (this == other)
     	    return true;
     	if ( !(other instanceof Hexadecimal) )
     	    return false;
     	return ( (_decNum == ((Hexadecimal)other)._decNum)
     		 && (_hexNum.equals( ((Hexadecimal)other)._hexNum ) ) );
    }


    public int compareTo( Object other ) {
     	if ( !(other instanceof Hexadecimal) )
     	    throw new ClassCastException("\n Error: compareTo() input was not of class Hexadecimal");
     	return _decNum - ((Hexadecimal)other)._decNum;
    }
    //main method for testing
    public static void main( String[] args ) {
	//Hexadecimal h1 = new Hexadecimal("10FFD"); //69629
	System.out.println(hexToDec("10FD")); //4349

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(26);
	Hexadecimal h2 = new Hexadecimal(26);
	Hexadecimal h3 = h1; // new Hexdecimal(5)
	Hexadecimal h4 = new Hexadecimal("10FFD"); //69629
	//System.out.println(hexToDec("10FD")); //4349

	System.out.println( h1 );//1A
	System.out.println( h2 );//1A
	System.out.println( h3 );//1A  
	System.out.println( h4 );//10FFD       
	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
	
	// Null Pointer Input Test
	Object thing = null;
	System.out.println(h1.equals(thing));

	// Invalid Object Parameter Input Test
	thing = new Object();
	System.out.println(h1.equals(thing));
	/*=========================================
	  ==========================================*/

    }//end main()

} //end class
