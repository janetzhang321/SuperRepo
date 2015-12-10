/*
  Janet Zhang
  APCS1 pd5
  HW45 -- Come Together
  2015-12-10
*/


/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

class SuperArray implements ListInt {
    
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;
    
    //position of last meaningful value
    private int _lastPos;
    
    //size of this instance of SuperArray
    private int _size;
    
    
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }
    
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }
    
		
    //double capacity of this SuperArray
    public void expand() { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) { 
	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
    
    
    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
    	if(_size>=_data.length){
	    expand();
    	}
	//if(newVal.compareTo(0)==0){ _data[_lastPos+1]=-1;} //doesn't allow user to add 0 to the array, and lets you know it was invalid with -1
	else{_data[_lastPos+1]=newVal;} //or just do the regular thing
	_size++;
	_lastPos++;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
    	while(index>=_data.length){
	    expand();
	    _size=index;
	    _lastPos=index-1;
    	} 
    	//copy all the elements to the right of the given index to the pos to the right
    	//work backwards
      	for (int i=_size;i>index;i--){
	    _data[i]=_data[i-1];
	}
	//replace element at index with new val
	_data[index]=newVal;
	_size++;
	_lastPos++;
    }
    

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
        if(index<=_lastPos){
	    //copy all elements to right of given index to the pos to the left
	    for (int i=index;i<_size;i++){
		_data[i]=_data[i+1];
	    }
	    _size--;
	    _lastPos--;
        }
    }

    // ~~~~~~~~~~~~~~ TESTING ~~~~~~~~~~~~~~
    //return number of meaningful items in _data
    public int size() {return _size;}
    public int compareTo( Object other ) {
	if( other instanceof SuperArray ) {
	    if( this.size() > ((SuperArray)other).size() ) { return 1; }
	    else if( this.size() < ((SuperArray)other).size() ) { return -1; }
	    else { return 0; }
	}
	else if( other == null ) {
	    throw new NullPointerException( "\n Error: compareTo() Input is null" );
	}
	else {
	    throw new ClassCastException( "\n Error: compareTo() Input is not an instance of SuperArray" );
	}
    }
    public int linSearch(Comparable a) {
	if ( !(this instanceof SuperArray)){throw new ClassCastException("\n Error: Object was not of class SuperArray");}
	for(int i=0; i<((SuperArray)this).size(); i++)
	    { if (_data[i].compareTo(a)==0) return i;}
	return -1;
    }

    public boolean isSorted(){
	if ( !(this instanceof SuperArray)){throw new ClassCastException("\n Error: Object was not of class SuperArray");}
        for (int i=0 ; i<( (((SuperArray)this).size())-1 ) ;i++){
	    if (this._data[i].compareTo(this._data[i+1])>0)
		return false;
	}//num before is greater than the num after
	return true;
    }
    
    //main method for testing
    public static void main( String[] args ) {
	//mixed
	
	SuperArray a = new SuperArray();
	System.out.println("Printing empty ListInt a...");
	System.out.println(a);
	a.add( new Binary(2) );
	a.add( new Hexadecimal(60) );
	a.add( new Binary(16) );
	a.add( new Hexadecimal(100) );
	a.add( new Rational(2, 1) );

	System.out.println("Printing populated ListInt a...");
	System.out.println(a);

	System.out.println( a.linSearch(new Binary (60) ));
	System.out.println(a.linSearch(new Binary(2)));
	System.out.println(a.isSorted());
	
	//rational
	SuperArray r = new SuperArray();

	r.add( new Rational(1, 5) );
	r.add( new Rational(2, 5) );
	r.add( new Rational(3, 5) );	
	r.add( new Rational(4, 5) );	
	r.add( new Rational(5, 5) );

	System.out.println( r );
	System.out.println(r.linSearch(new Rational (60,60) ));
	System.out.println(r.linSearch(new Rational (2,5)));	
	System.out.println(r.isSorted());
	
	//binary
	SuperArray b = new SuperArray();

	b.add(new Binary (2) );
	b.add(new Binary (4) );
	b.add(new Binary (8) );
	b.add(new Binary (16) );
	b.add(new Binary (32) );
	b.add(new Binary (64) );
	b.add(new Binary (2) );

	System.out.println( b );
	System.out.println(b.linSearch(new Binary (2) ));
	System.out.println(b.linSearch(new Binary (10) ));
	System.out.println(b.linSearch(new Binary (32) ));	
	System.out.println(b.isSorted());
	
    }//end main
		
}//end class
