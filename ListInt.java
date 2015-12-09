public interface ListInt{
    
    //doubles the list 
    void expand(); 
    
    //adds n to the end of an array
    void add(int n);
    
    //adds n to the index of an array if the index exists
    void add(int n, int index);
    
    //removes the value of array[index] and left-justification
    void remove(int index);
    
    //returns the size
    int size();
    
    //return value at specified index 
    int get(int index); 
    
    //mutator -- set value at index to newVal, 
    //           return old value at index
    int set(int index, int newValue);
    
    
}