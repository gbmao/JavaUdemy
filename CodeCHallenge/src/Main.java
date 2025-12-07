public class Main {
    public static void main(String[] args) {
        System.out.println(makeBricks(3, 1, 8));
        System.out.println(makeBricks(3, 1, 9));
        System.out.println(makeBricks(3, 2, 10));
        System.out.println(makeBricks(3, 2, 8));
        System.out.println(makeBricks(3, 2, 9));
        System.out.println(makeBricks(6, 1, 11));
        System.out.println(makeBricks(6, 0, 11));
        System.out.println(makeBricks(1, 4, 11));
        System.out.println(makeBricks(0, 3, 10));
        System.out.println(makeBricks(1, 4, 12));
        System.out.println(makeBricks(3, 1, 7));
        System.out.println(makeBricks(1, 1, 7));
        System.out.println(makeBricks(2, 1, 7));
        System.out.println(makeBricks(7, 1, 11));
        System.out.println(makeBricks(7, 1, 8));
        System.out.println(makeBricks(7, 1, 13));
        System.out.println(makeBricks(43, 1, 46));
        System.out.println(makeBricks(40, 1, 46));
        System.out.println(makeBricks(40, 2, 47));
        System.out.println(makeBricks(40, 2, 50));
        System.out.println(makeBricks(40, 2, 52));
        System.out.println(makeBricks(22, 2, 33));
        System.out.println(makeBricks(0, 2, 10));
        System.out.println(makeBricks(1000000, 1000, 1000100));
        System.out.println(makeBricks(2, 1000000, 100003));
        System.out.println(makeBricks(20, 0, 19));
        System.out.println(makeBricks(20, 0, 21));
        System.out.println(makeBricks(20, 4, 51));
        System.out.println(makeBricks(20, 4, 39));


    }

    public static boolean makeBricks(int small, int big, int goal) {
        int total = small + big * 5;
        boolean result = false;
        if (total >= goal + 5 && big > 0) {
            result = makeBricks(small, big - 1, goal);
        } else if (total >= goal + 1 && small > 0) {
            result = makeBricks(small - 1, big, goal);
        }

        return result == false ? total == goal : result;
    }
}
