package org.example.Utils;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 23:50
 */
public class ValidatorUtil {
    private static final Pattern mobile_Pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");
    public static boolean isMobile(String mobile){
        return false;
    }
}
