public class ArrayDeque <T>{
    private T[] item = (T[]) new Object[8];
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public T get(int i){
        return item[i];
    }

    public int getSize(){
        return size;
    }

    public void removeLast(){

    }

    public void addFirst(T addedFirstItem){
        item[nextFirst] = addedFirstItem;
        nextFirst -= 1;
        if (nextFirst < 0){
            nextFirst = item.length - 1;
        }
    }

    public void addLast(T addedLastItem){
        item[nextLast] = addedLastItem;
        nextLast += 1;
    }

    public static void main(String[] args) {
        /**
         * this task is worth doing, but now i have no time to do this 2022/8/24
         */
    }
}
