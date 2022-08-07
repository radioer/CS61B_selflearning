public class HelloNumbers {
    public static void main(String[] args) {
        /** the first program i write down
         * */
        int x = 0; // 0 1 3 6 10
        int temp = 0;
        while (x < 10) {
            temp = temp + x; // 0 1 3
            System.out.print(temp + " ");
            x = x + 1;
        }
        System.out.println();
    }
}