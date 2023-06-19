package Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class subSeqAL {
    public static void main(String[] args) {
        System.out.println(subSeqRet("","abc"));
    }
    static ArrayList<String> subSeqRet(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=subSeqRet(p+ch,up.substring(1));
        ArrayList<String> right=subSeqRet(p,up.substring(1));

        left.addAll(right);
        return left;
    }
}
