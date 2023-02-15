public class CS203_2_4_TEST {
    public static void main(String[] args) {

        int min = 0;
        boolean[] a={true,true,true,true,true,true};
        int max = a.length - 1;
        while (max != min + 1) {
            int middle = (max + min) / 2;
            if (a[middle]) {
                max = middle;
            } else {
                min = middle;
            }
        }
        System.out.printf("%d,%d", max, min);
        System.out.println();


    }

}


