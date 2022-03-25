import java.lang.reflect.Array;

public class ArrayDeque<type>{
    int size = 0;
    type[] Items;
    int rear = -1;
    int front = -1;
    int length = 8;
    double usage_rate = 0.25;

    public ArrayDeque(){
        Items = (type[]) new Object[length];
    }
    
    public type[] ArrayDeque(ArrayDeque other){
        length = other.length;
        Items = (type[]) new Object[length];
        int i = 0;
        int j = other.front;
        if(other.isEmpty()){
            return Items;
        }else {
            do {
                Items[i++] = (type) other.Items[j];
                j = (j + 1) % length;
            } while (j != other.front);
            front = 0;
            rear = length -1;
            return Items;
        }


    }

    public int size(){
        return size;
    }

    public void addFirst(type item){
        if(isFull()){
            resize_large();
        }else if(isEmpty()){
            front += 1;
            rear += 1;
            Items[front] = item;
            size += 1;
        }else{
            front += 1;
            Items[front] = item;
            size += 1;
        }
    }

    public void addLast(type item){
        if(isFull()){
            resize_large();
        }else if(isEmpty()){
            front += 1;
            rear += 1;
            Items[rear] = item;
            size += 1;
        }{
            rear += 1;
            Items[rear] = item;
            size += 1;
        }
    }

    public type removeFirst(){
        if(isEmpty()){
            return null;
        }else if(front == rear){
            type returnValue = Items[front];
            front = -1;
            rear = -1;
            size -= 1;
            return returnValue;
        }else{
            type returnValue = Items[front];
            front += 1;
            size -= 1;
            if((size/length)<usage_rate && length>8){
                resize_small();

            }
            return returnValue;
        }
    }

    public type removeLast(){
        if(isEmpty()){
            return null;
        }else if(front == rear){
            type returnValue = Items[rear];
            front = -1;
            rear = -1;
            size -= 1;
            return returnValue;
        }else{
            type returnValue = Items[rear];
            rear -= 1;
            size -= 1;
            if((size/length)<usage_rate && length>8){
                resize_small();
            }
            return returnValue;
        }

    }

    public boolean isFull(){
        return (rear+1)%length==front;
    }


    public boolean isEmpty(){
        return front==-1;
    }

    public type get(int index){
        return Items[index];
    }

    public type getLast(){
        return Items[rear];
    }

    public void resize_large(){
        type[] tempArray = (type[]) new Object[length*2];
        int i = 0;
        int j = front;
        do{
            tempArray[i++] = Items[j];
            j = (j+1)%length;
        }while(j!=front);
        front = 0;
        rear = length-1;
        Items = tempArray;
        length = length*2;
    }

    public void printDeque(){
        for(int i=0; i<length; i++){
            if(Items[i] != null){
                System.out.print(Items[i]);
            }
        }
    }

    public void resize_small(){
        type[] tempArray = (type[]) new Object[length/2];
        int i = 0;
        int j = front;
        do{
            tempArray[i++] = Items[front];
            j = (j+1)%length;
        }while(j != front);
        front = 0;
        length = length/2;
        rear = length - 1;
        Items = tempArray;
    }


}
