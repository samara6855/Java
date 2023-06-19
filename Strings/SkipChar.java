package Strings;

public class SkipChar {
    public static void main(String[] args) {
        SkipChar("","ababcdad");
    }

    static void SkipChar(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch=='a') {
            SkipChar(p, up.substring(1));
        }else{
            SkipChar(p+ch,up.substring(1));
        }
    }
}
