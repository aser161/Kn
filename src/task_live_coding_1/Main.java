package task_live_coding_1;

public class Main {

    public static void main(String[] args) {
        System.out.println(isWordPalindrom("РОТор"));

    }
    public static boolean isWordPalindrom(String str){
        if (str.length()!=5){
            return false;
        }
        str = str.toLowerCase();
        char []arr = str.toCharArray();
        return arr[0]==arr[4]&&arr[1]==arr[3];
    }
}