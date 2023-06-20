package Strings;

import java.util.ArrayList;

public class permutationCount {
    public static void main(String[] args) {
        System.out.println(permutationCount("","abcde"));
    }

    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch=up.charAt(0);
        int count=0;
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count + permutationCount(f+ch+s,up.substring(1));
        }
        return count;
    }
}
