public class RecursionEx {

    public int test(int a) {

        if (a == 0) {
            return 0;
        } else {

            return a + test(++a);
        }

    }

    public static void main(String[] args) {

        RecursionEx ex = new RecursionEx();


        System.out.println(ex.test(5));


    }


}
