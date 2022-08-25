public class ArrayDeque <T>{
    private T[] item = (T[]) new Object[8];
    private int size;
    private int nextFirst;
    private int nextLast;

    private static int refector = 2;
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
        size -= 1;
        nextLast -= 1;
        if(size == item.length / (2 * refector)){
            resize(size / refector);
        }
    }

    public void removeFirst() {
        size -= 1;
        nextFirst += 1;
        if(size == item.length / (2 * refector)){
            resize(size / refector, nextFirst + 1, nextLast - 1);
        }
    }
    private void resize(int newSize, int startIndex, int endIndex){
        T[] newItem = (T[]) new Object[newSize];
        if (startIndex <= endIndex){

        }
        System.arraycopy(item, 0, newItem, 0, size);
        size = newSize;
        item = newItem;
    }
    public void addFirst(T addedFirstItem){
        item[nextFirst] = addedFirstItem;
        nextFirst -= 1;
        size += 1;
        if (size == item.length){
            resize(size * refector, 0, 0);
        }
        if (nextFirst == -1){
            nextFirst = item.length - 1;
        }
    }

    public void addLast(T addedLastItem){
        item[nextLast] = addedLastItem;
        nextLast += 1;
        size += 1;
        if (size == item.length){
            resize(size * refector);
        }
        if (nextLast == item.length){
            nextLast = 0;
        }
    }

    public static void main(String[] args) {
        /**
         * this task is worth doing, but now i have no time to do this 2022/8/24
         */
    }
}
