/*
  Team Irrational -- Mei Huang, Janet Zhang
  APCS1 pd5
  HW42 -- Array of Titanium
  2015-12-05
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
    private int[] _data;
    
    //position of last meaningful value
    private int _lastPos;
    
    //size of this instance of SuperArray
    private int _size;
    
    
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() { 
	_data = new int[10];
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
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) { 
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
    
    
    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) {
    	if(_size>=_data.length){
    		expand();
    	}
	    if(newVal==0){_data[_lastPos+1]=-1;} //doesn't allow user to add 0 to the array, and lets you know it was invalid with -1
	    else{_data[_lastPos+1]=newVal;} //or just do the regular thing
	    _size++;
	    _lastPos++;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) {
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


    //main method for testing
    public static void main( String[] args ) {
    	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  SuperArray curtis = new SuperArray();
	  System.out.println("Printing empty SuperArray curtis...");
	  System.out.println(curtis);
	
	  for( int i = 0; i < curtis._data.length; i++ ) {
	  curtis.set(i,i*2);
	  curtis._size++; //necessary bc no add() method yet
	  }
	
	  System.out.println("Printing populated SuperArray curtis...");
	  System.out.println(curtis);
	
	  System.out.println("testing get()...");
	  for( int i = 0; i < curtis._size; i++ ) {
	  System.out.print( "item at index" + i + ":\t" );
	  System.out.println( curtis.get(i) );
	  }
	
	  System.out.println("Expanded SuperArray curtis:");
	  curtis.expand();
	  curtis.add(5);
	  System.out.println(curtis.size());
	  System.out.println(curtis);
	    
	  System.out.println("Inseting item into SuperArray curtis:");
	  curtis.add(1,10);
	  System.out.println(curtis);
	    
	  System.out.println("Removing item from SuperArray curtis:");
	  curtis.remove(1);
	  System.out.println(curtis);
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
    	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    	
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);
    
	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

    	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****
    ListInt a=new SuperArray();
    
	System.out.println("Printing empty ListInt a...");
	System.out.println(a);
	
	a.add(5);
	a.add(4);
	a.add(3);
	a.add(2);
	a.add(1);
	
	System.out.println("Printing populated ListInt a...");
	System.out.println(a);
	

	a.remove(3);
	System.out.println("Printing ListInt a post-remove...");
	System.out.println(a);
	a.remove(3);
	System.out.println("Printing ListInt a post-remove...");
	System.out.println(a);
	
	
	a.add(3,99);
	System.out.println("Printing ListInt a post-insert...");
	System.out.println(a);
	a.add(2,88);
	System.out.println("Printing ListInt a post-insert...");
	System.out.println(a);
	a.add(1,77);
	System.out.println("Printing ListInt a post-insert...");
	System.out.println(a);
	a.add(7,3);
	System.out.println("Printing ListInt a post-insert...");
	System.out.println(a);
	
    a.add(20,4);
    System.out.println(a);
    a.remove(4);
    System.out.println(a);
    System.out.println(a.size());
    System.out.println(a.get(1));
    }//end main
		
}//end class