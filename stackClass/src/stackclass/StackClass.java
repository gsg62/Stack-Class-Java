/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackclass;

/**
 *
 * @author ggear
 */
public class StackClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackClass myStack = new StackClass();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.peekTop());
        myStack.pop();
        System.out.println(myStack.peekTop());                
    }
       /**
     * Provides constant for default capacity
     */
    private final int DEFAULT_CAPACITY = 10;
    /** 
     * Provides constant -999999 for access failure messaging
     */
    public static final int FAILED_ACCESS = -999999;
    /**
     * Stores current capacity of queue class
     */
    private int capacity;
    /**
     * Stores current size of queue class
     */
    private int size;
    /**
     * Integer array stores stack data
     */
    private int[] stackData;
    /**
     * Stores stack top index
     */
    private int stackTopIndex;
    /**
     * Default constructor
     */
    public StackClass()
    {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        stackData = new int[capacity];   
        stackTopIndex = -1;
    }
    /**
     * Initialization constructor
     * <p>
     * @param capacitySetting - initial capacity of stackData class
     */
    public StackClass(int capacitySetting)
    {
        size = 0;
        capacity = capacitySetting;
        stackData = new int[capacity];   
        stackTopIndex = -1;
    }
    /**
     * Copy constructor
     * <p>
     * @param copied SimpleStackClass object to be copiedcapacitySettingcopied 
     */
    public StackClass(StackClass copied)
    {
        capacity = copied.capacity;
        stackData = new int[copied.capacity]; 
        size = copied.size;
        int index = 0;
        while( index < size ) 
        {
            stackData[index] = copied.stackData[index];
            index++;
        }
    }
    /**
     * Checks for resize and resizes to twice the current capacity if needed
     * <p>
     * @return success of operation 
     */
    private boolean checkForReSize()
    {
        // size check
        if( capacity == size - 1 ){
            capacity = 2*capacity;
            // saves values from last setArray and creates new larger setArray
            int[] copyValues = stackData;
            stackData = new int[capacity];    
            int index = 0;
            // adds all values into new array
            while( index < size ) 
            {
                stackData[index] = copyValues[index];
                index++;
            }
            return true;
        }
        return false;
    }
    /**
     * Reports stack empty status
     * <p>
     * @return Boolean evidence of empty list
     */
    public boolean isEmpty()
    {
        return( size == 0 );
    }
    /**
     * Checks for resize, then pushes value onto stack
     * <p>
     * Note: end of array is always the top of the stack;
     * index is incremented and then value is appended to array
     * <p>
     * @param newValue - Value to be pushed onto stack
     */
    public void push(int newValue)
    {
        checkForReSize();
        stackTopIndex++;
        stackData[stackTopIndex] = newValue;
        size++;
    }
    /**
     * Removes and returns data from top of stack
     * <p>
     * @return value if successful, FAILED_ACCESS if not
     */
    public int pop()
    {
        int val = stackData[stackTopIndex];
        stackData[stackTopIndex] = 0;
        stackTopIndex--;
        return val;
    }
    /**
     * provides peek at top of stack
     * <p>
     * @return value if successful, FAILED_ACCESS if not
     */
    public int peekTop()
    {
        if( stackData[stackTopIndex] == 0 )
        {
            return FAILED_ACCESS;
        }
        return stackData[stackTopIndex];
    }
    /**
     * Clears stack by setting size to zero and top index to negative one
     */
    public void clear()
    {
        size = 0;
        stackData = new int[DEFAULT_CAPACITY];
        stackTopIndex = -1;
    }
}
