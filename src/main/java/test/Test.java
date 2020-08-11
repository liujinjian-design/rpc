package test;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 16:51
 */
public class Test {

    public static void main(String[] args) {

        String s = "刘金鸡奖";
        checkUnicodeStrMaxLen(s);

    }

    private static int checkUnicodeStrMaxLen(String str) {
        String regEx = "[\\u4e00-\\u9fa5]";
        String term = str.replaceAll(regEx, "aa");
        return term.length();
    }
}
