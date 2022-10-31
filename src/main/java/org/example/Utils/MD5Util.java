package org.example.Utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 14:12
 */
@Component
public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static final String salt = "1a2b3c4d";
    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    public static String fromPassToDBPass(String fromPass, String salt){
        String str = salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass, String salt){
        String fromPass = inputPassToFromPass(inputPass);
        return fromPassToDBPass(fromPass, salt);
    }

    public static void main(String[] args) {
        int k = 1;
        for(int i=1;i<=11;i++){
            k *= i;
        }
        System.out.println(k);
        String inputPass = "123456";
        String fromPass = inputPassToFromPass(inputPass);
        System.out.println(fromPass);
        System.out.println(fromPassToDBPass(fromPass, salt));
        System.out.println(inputPassToDBPass(inputPass, salt));
    }
}
