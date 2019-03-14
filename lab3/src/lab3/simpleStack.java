/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;


/**
 *
 * @author Pradeep
 
 */
public class simpleStack<T extends Comparable<T>> {
    private static final int MAXN = 10;
    private int top;
    private T[] array;
    
    public simpleStack() {
        top = -1;
        array = (T[])new Comparable[MAXN];
    }

    public boolean push(T item) {
        if (top >= MAXN-1)
            return false;
        else
            array[++top] = item;
            return true;
    }

    public T pop() {
        if (top == -1)
            return null;
        else
            return array[top--];
    }

    public void print() {
        for (int i = top; i >= 0; i--)
            System.out.println(array[i] + " ");
    }
    
    public static void main(String[] args) {
        simpleStack<Character> stack = new simpleStack();
        Character             item = 0;
        System.out.println("This is a RPN calculator. Enter operands and operators: ");
        
        
        try {
            
            
            while (item.compareTo('\n') != 1) {
                item = (char)System.in.read();
                if (item.compareTo('+')==0 ){
                    int i1 = Character.getNumericValue(stack.pop());
                    int i2 = Character.getNumericValue(stack.pop());
                    int i3 = i1+i2;
                    char c = Integer.toString(i3).charAt(0);
                    stack.push(c);
                }
                
                else if(item.compareTo('-')==0){
                   
                    int i1 = Character.getNumericValue(stack.pop());
                    int i2 = Character.getNumericValue(stack.pop());
                    int i3 = i2-i1;
                    char c = Integer.toString(i3).charAt(0);
                    stack.push(c); 
                }
                
                else if(item.compareTo('=')==0){
                    
                    Character c = stack.pop();
                    System.out.println("top value is " + c);
                    stack.push(c);
                    
                }
                else if (item.compareTo('Q')==0){
                    System.out.println("satck contained");
                    stack.print();
                }
                
                else{
                   stack.push(item);
                   
                } 
                 item = (char)System.in.read();
            }
            System.out.println();
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
