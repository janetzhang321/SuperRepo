public interface ListInt{
    
    //doubles the list 
    void expand(); 
    
    //adds n to the end of an array
    void add(Comparable n);
    
    //adds n to the index of an array if the index exists
    void add(int index, Comparable n);
    
    //removes the value of array[index] and left-justification
    void remove(int index);
    
    //returns the size
    int size();
    
    //return value at specified index 
    Comparable get(int index); 
    
    //mutator -- set value at index to newVal, 
    //           return old value at index
    Comparable set(int index, Comparable newValue);
    
    
}
