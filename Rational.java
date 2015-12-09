/*
  Team Irrational-Janet Zhang, Mei Huang
  APCS1 pd5
  HW41 -- In America, the Driver Sits on the Left
  2015-12-03
*/

//PHASE 1
class Rational implements Comparable {
    public  int n;
    public  int d;
    public Rational(){
	n=0; d=1;
    }
    public Rational(int n, int d){
	if (d==0) {
	    n=0;
	    d=1;
        }
	this.n=n;
	this.d=d;
    }
    public String toString(){return n + "/" + d;}
    public double floatValue(int n, int d){
	return (n*1.0)/d;
    }
    public void multiply(Rational other){
	int otherS=other.toString().indexOf("/");
	int otherL=other.toString().length();
	int otherN=Integer.parseInt(other.toString().substring(0,otherS));
	//System.out.println(otherN);
	int otherD=Integer.parseInt(other.toString().substring(otherS+1,otherL));
	//System.out.println(otherD);
	n*=otherN;
	d*=otherD;
    }
    public void divide(Rational other){
	int otherS=other.toString().indexOf("/");
	int otherL=other.toString().length();
	int otherN=Integer.parseInt(other.toString().substring(0,otherS));
	//System.out.println(otherN);
	int otherD=Integer.parseInt(other.toString().substring(otherS+1,otherL));
	//System.out.println(otherD);
	n/=otherN;
	d/=otherD;
    }

    //PHASE 2
    public static int max(int a, int b){
	if (a>b){
	    return a;}
	else{
	    return b;}}//return int
    public void add(Rational other){
	int otherS=other.toString().indexOf("/");
	int otherL=other.toString().length();
	int otherN=Integer.parseInt(other.toString().substring(0,otherS));
	//System.out.println("otherN: "+otherN);
	int otherD=Integer.parseInt(other.toString().substring(otherS+1,otherL));
	//System.out.println("otherD: "+otherD);
	//System.out.println("newN1: "+n*otherD);
	//System.out.println("newD: "+d*otherD);
	int otherT=d*otherN; //System.out.println("newN2: "+otherT);
	n=n*otherD+otherT; d=d*otherD;
    }
    public void subtract(Rational other){
	int otherS=other.toString().indexOf("/");
	int otherL=other.toString().length();
	int otherN=Integer.parseInt(other.toString().substring(0,otherS));
	//System.out.println("otherN: "+otherN);
	int otherD=Integer.parseInt(other.toString().substring(otherS+1,otherL));
	//System.out.println("otherD: "+otherD);
	//System.out.println("newN1: "+n*otherD);
	//System.out.println("newD: "+d*otherD);
	int otherT=d*otherN; //System.out.println("newN2: "+otherT);
	n=n*otherD-otherT; d=d*otherD;
    }
    public int gcd(){
	if(n == d || n == 0 || d == 0) {
	    return max(n,d);}//the output when a and b are equal
	return gcd(n%d, d%n);//else, keep modulating until a==b(in above) and return it
    }
    public void reduce(){
        int i=gcd();n=n/i;d=d/i;
    }
    //PHASE 3
    
    public double maxN(double a, double b){
	if (a>b){
	    return a;}
	else{
	    return b;}}//return double
    public static int gcd(int a, int b){
	if(a == b || a == 0 || b == 0) {
	    return max(a,b);}//the output when a and b are equal
	return gcd(a%b, b%a);//else, keep modulating until a==b(in above) and return it
    }
    public int compareTo(Object other){
        ((Rational)other).reduce();
	int otherS=other.toString().indexOf("/");
	int otherL=other.toString().length();
	int otherN=Integer.parseInt(other.toString().substring(0,otherS));
	int otherD=Integer.parseInt(other.toString().substring(otherS+1,otherL));
	double numO=floatValue(otherN,otherD);
        double numN=floatValue(n,d);
	if (numO==(numN)) return 0;
	else if (numO==maxN(numO,numN)) return 1;
	else return -1;
    }
    //PHASE 4
    
    //equals helper to check equivalence of Rational objects
    public boolean equalsH(Rational r){
      	int slash=r.toString().indexOf("/");
      	int length=r.toString().length();
    	int n=Integer.parseInt(r.toString().substring(0,slash));//finds n
    	int d=Integer.parseInt(r.toString().substring(slash+1,length));//finds d
      	return (floatValue(n,d)==floatValue(this.n,this.d));//n/d are equal to n/d?
    }
    //overwritten equals method to check equivalence
    public boolean equals(Object o){
      	if (!(o instanceof Rational)){return false;}
      	return equalsH((Rational)o);//typecasts o, which is a instance of Object to Rational
    }
   	
    public static void main(String[] args) {
    Rational goose = new Rational(2,0); //Stores the rational number 0/1 bc invalid params
	Rational t = new Rational (4,18); //Stores the rational number 4/18
	Rational r = new Rational (2,3); //Stores the rational number 2/3
	Rational s = new  Rational (1,2); //Stores the rational number 1/2
	System.out.println("r: "+r);
	System.out.println("s: "+s);
	System.out.println("t: "+t);
	//Part1
	System.out.println("\nMultiplying r by s...");
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	System.out.println("\nDividing r by s...");
	r.divide(s); //Multiplies r by s, changes r to 2/6.  s remains ½
	//Part2
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	System.out.println("\nAdding s to r...");
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	System.out.println("\nSubtracting s from r...");
	r.subtract(s);
	System.out.println("r now equals: "+ r);
	System.out.println("s now equals: "+ s);
	t.reduce(); //Changes t to 2/9
	System.out.println("t now equals: "+ t);
		
	//Part3
	System.out.println("\nComparing t to s...");
	System.out.println("if t is greater than s: return 1 \nif t is less than s: return -1 \nif t is equal to s: return 0");
	System.out.println(t.compareTo(s));
		
	//Part4
	System.out.println("\nis t .equals to s?");
	System.out.println(t.equals(s));//false
	System.out.println("\nis t .equals to t?");
	System.out.println(t.equals(t));//true
	System.out.println("\nis t .equals to 4/18?");
	System.out.println(t.equals(4/18));//false
	System.out.println("\nis t .equals to 2/9?");
	System.out.println(t.equals(2/9));//false
    }
}
