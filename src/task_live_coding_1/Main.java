package task_live_coding_1;

public class Main {

    public static void main(String[] args) {
        System.out.println(isWordPalindrom("РаТор"));

    }
    public static boolean isWordPalindrom(String str){
        str = str.toLowerCase();
        char []arr = str.toCharArray();
        int y = arr.length-1;
        for (int x = 0; x<y; x++,y--){
            if (arr[x]!=arr[y]){
                return false;
            }
        }
        return true;
    }
}