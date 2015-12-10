/*
  Janet Zhang
  APCS1 pd5
  HW43 -- This or That
  2015-12-07
*/
//skeleton file for class Binary

public class Binary implements Comparable{

    //inst vars
    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
    	_decNum=0;
    	_binNum="0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	if (n>=0){
	    _decNum=n;
	    _binNum=decToBin(n);
	}
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
    	_binNum=s;
    	_decNum=binToDec(s);
    }

    public String getBinNum(){return _binNum;}
    public int getDecNum(){return _decNum;}

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
    	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
	String r=""; //"hello"+n;
	if (n==0) return "0";
	while (n>0){
	    r=n%2+r; //build from right to left
	    n=n/2; //keep dividing
	}
	return r;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/  
	String bin="";
	if (n>0){
	    bin=decToBinR(n/2)+n%2; //build from right to left
	}
	return bin;
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	/****** YOUR IMPLEMENTATION HURRR ******/   
	int dec=0;
	int bin=Integer.parseInt(s);
	int c=0;
	int lastD;
	double num;
	while (c<s.length()) {//stop when c reaches the length of s
	    lastD=bin%10;//the last digit
	    num=Math.pow(2,c);//2^c
	    dec+=num*lastD;
	    bin=bin/10;//reduce the number
	    c++;
	}
	return dec;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/  
	int dec=0;
	int c=s.length()-1;
	if (s.length()>=1) {
	    int firstD=Integer.parseInt(s.substring(0, 1));
	    int multiplier=(int)Math.pow(2,c);
	    dec+=firstD*multiplier+
		binToDecR(s.substring(1,s.length()));
	}
	return dec;
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/
      	if (!(other instanceof Comparable)){throw new ClassCastException("\n Error: equals() input was not of class Binary");}
	else if (other==null){throw new NullPointerException("\n Error: equals() input was null");}
	else if ( ((Binary)other)==this  ||
		  ((Binary)other)._binNum.equals(this._binNum) )
	    {return true;}
	return false;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
   public int compareTo( Object other ) {
	if ( other instanceof Comparable ) {
	    if (other instanceof Hexadecimal) {
		if( this._decNum < ((Hexadecimal)other).getDecNum() ) { return -1;}
		else if( this._decNum == ((Hexadecimal)other).getDecNum() ) {return 0;}
		else {return 1;}
	    }
	    else if (other instanceof Binary){
		if( this._decNum < ((Binary)other).getDecNum() ) {return -1;}
		else if( this._decNum == ((Binary)other).getDecNum() ) {return 0;}
		else {return 1;}
	    }
	    else if (other instanceof Rational) {
		if( this._decNum < ((Rational)other).floatValue() ) { return -1; }
		else if( this._decNum > ((Rational)other).floatValue() ) { return 1; }
		else { return 0; }
	    }
	}
	else if (other==null){throw new NullPointerException("\n Error: compareTo() input was null");}
	else {throw new ClassCastException("\n Error: compareTo() input was not of numerical class");}
	return -1;
    }

	//main method for testing
	public static void main( String[] args ) {

	    System.out.println();
	    System.out.println( "Testing ..." );

	    Binary b1 = new Binary(5);
	    Binary b2 = new Binary(5);
	    Binary b3 = b1; // new Binary(5)
	    Binary b4 = new Binary(7);

	    //Bin<->Dec Test cases
	
	    String r="";
	    /*
	      r+=decToBinR(5);r+="\n";
	      r+=decToBinR(100);r+="\n";
	      r+=decToBinR(30);r+="\n";
	      r+=decToBinR(63);r+="\n";
	      r+=decToBinR(420);r+="\n";
	      r+=decToBinR(47);r+="\n";
	      r+=decToBinR(64);r+="\n";
	      r+=decToBinR(22);r+="\n";
	    */
	
	    r+=binToDecR("101");r+="\n";
	    r+=binToDecR("1100100");r+="\n";
	    r+=binToDecR("11110");r+="\n";
	    r+=binToDecR("111111");r+="\n";
	    r+=binToDecR("110100100");r+="\n";
	    r+=binToDecR("101111"); r+="\n";
	    r+=binToDecR("1000000"); r+="\n";
	    r+=binToDecR("10110"); r+="\n";
	
	    System.out.println(r);
	

	    System.out.println( b1 );//101
	    System.out.println( b2 );//101
	    System.out.println( b3 );//101  
	    System.out.println( b4 );//111       
	    System.out.println( "\n==..." );
	    System.out.println( b1 == b2 ); //should be false
	    System.out.println( b1 == b3 ); //should be true

	    System.out.println( "\n.equals()..." );
	    System.out.println( b1.equals(b2) ); //should be true
	    System.out.println( b1.equals(b3) ); //should be true
	    System.out.println( b3.equals(b1) ); //should be true
	    System.out.println( b4.equals(b2) ); //should be false
	    System.out.println( b1.equals(b4) ); //should be false

	    System.out.println( "\n.compareTo..." );
	    System.out.println( b1.compareTo(b2) ); //should be 0
	    System.out.println( b1.compareTo(b3) ); //should be 0
	    System.out.println( b1.compareTo(b4) ); //should be neg
	    System.out.println( b4.compareTo(b1) ); //should be pos
	    /*=========================================


	      =========================================*/
	}//end main()

    } //end class
