package cn.jwg.materialdesgin.core.utils.string;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串的工具类，包括校验，拼接...
 */
public class StringUtils {

    /**
     * 判断是否为手机号
     */
    public static boolean isPhoneNumber(String phone) {
        //由于电话号码更新太快了，实在不行就只校验第一位："^1\\d{10}$"
        Pattern p = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 校验字符串长度
     */
    public static boolean length6_18(String str) {
        return !(str.length() < 6 || str.length() > 18);
    }

    /**
     * 校验字符串是否为字母或者数字
     */
    public static boolean aZ09(String str) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 校验密码6-20位，ascii码值从20-7E
     */
    public static boolean checkPwdForm(String str) {
        Pattern p = Pattern.compile("^[\\x20-\\x7E]{6,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 校验是否为邮箱
     */
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 屏蔽几位邮箱号码
     */
    public static String addStarForEmail(String str, int count) {
        int ix = str.indexOf("@");
        if (ix > -1) {
            String front = "";
            if (ix > count) {
                front = str.substring(0, count);
            }
            str = front + "***" + str.substring(ix);
        }
        return str;
    }

    /**
     * 屏蔽几位手机号码
     */
    public static String addStarForPhone(String str) {
        int start = 3;
        int end = 6;
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (start <= i && i <= end) {
                c[i] = '*';
            }
        }
        str = String.valueOf(c);
        return str;
    }

    /**
     * 去掉所有空格
     */
    public static String removeStrSpace(String str) {
        String content = str.replaceAll(" ", "");
        return content;
    }


    public static Integer removeContent(String content, String str) {
        String result = content.replaceAll(str, "");
        return Integer.parseInt(result);
    }

    /**
     * 将:替换成-
     */
    public static String replaceStrColon(String str) {
        String content = str.replaceAll(":", "-");
        return content;
    }

    /**
     * 使用UTF-8解析url
     */
    public static String urlDecode(String url) {
        String decodeUrl = null;
        try {
            decodeUrl = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            decodeUrl = url;
            e.printStackTrace();
        }
        return decodeUrl;
    }

    /**
     * 切割字符串（获取手机号后三位）
     */
    public static String getLastThreePhotoNumber(String photoNumber) {
        String str = "001";
        try {
            str = photoNumber.substring(8, 11);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 去掉.0
     */
    public static String formatData(double data) {
        if (data == (long) data) {
            return String.format("%d", (long) data);
        } else {
            return String.format("%s", data);
        }

    }

    /**
     * 去掉.0
     */
    public static String formatStringData(String data) {
        double resultData = Double.parseDouble(data);
        if (resultData == (long) resultData) {
            return String.format("%d", (long) resultData);
        } else {
            return String.format("%s", resultData);
        }

    }

    /**
     * 是否包含中文
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        return m.find() ? true : false;
    }

    /**
     * 月日时分秒，0-9前补0
     */
    @NonNull
    public static String fillZero(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

    /**
     * 截取掉前缀0以便转换为整数
     *
     * @see #fillZero(int)
     */
    public static int trimZero(@NonNull String text) {
        try {
            if (text.startsWith("0")) {
                text = text.substring(1);
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String formatPhoneNum(String phoneNum) {
        if(TextUtils.isEmpty(phoneNum) || phoneNum.length() != 11) {
            return phoneNum;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(phoneNum.substring(0, 3)).append(" ").append(phoneNum.substring(3, 7)).append(" ").append(phoneNum.substring(7));
        return stringBuilder.toString();
    }
}
