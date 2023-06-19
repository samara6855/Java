package Strings;

public class SkipString {
    public static void main(String[] args) {
        String str = SkipString("bcdAppleDe");
        System.out.println(str);
    }

    static String SkipString(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("Apple")) {
            return SkipString(up.substring(5));
        }else {
            return up.charAt(0) + SkipString(up.substring(1));
        }
    }
}
