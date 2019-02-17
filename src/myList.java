

//Se importan las librerias. 
import java.util.ArrayList;


public class myList <E> implements iPila<E> {
	protected ArrayList<E> data;
	//Lista para el stack 
    public myList(){
        data = new ArrayList<E>();
    }

    //Pone un elemento al inicio del stack.
    public void push(E item) {
        data.add(item);
    }

    //Quita un elemento del inicio del stack. 
    public E pop() {
        if (data.size() > 0) {
            return data.remove(size() - 1);
        }
        return null;
    }
    
    //Recupera el primer elemento del Stack 
    public E peek() {
        if (data.size() > 0) {
            return data.get(size()-1);
        }
        return null;
    }

    //Para ver si esta vacio o no. 
    public boolean empty() {
        return size() == 0;
    }

   //Para ver el tamaño. 
    public int size() {
        return data.size();
    }

}
