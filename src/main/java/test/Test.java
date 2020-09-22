package test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 16:51
 */
public class Test {

    public static void main(String[] args) {

        List list = new ArrayList<>();


        System.out.println("couponcode1395".hashCode());
        long d2 = Long.valueOf("couponcode1395".hashCode()) % 8;
        long b2 = Long.valueOf("couponcode1395".hashCode()) / 8 % 64;
        System.out.println(d2);
        System.out.println(b2);

        int i = (int) (197186295340L % 8);
        int j = (int) (197186295340L / 8 % 64);
        System.out.println(i);
        System.out.println(j);

        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));

        BigDecimal decimal = new BigDecimal("0.1");
        int m = (int) (decimal.floatValue() * 10.0f);
        System.out.println(m);

        String sendUrl = "https://action.weixin.qq.com/busifavor/getcouponinfo?coupon_code=9200812187644059128&open_id=o8eok0w_BJG6Lo4_7yC1dEY9CVP0&out_request_no=CC_1131_20208110037&send_coupon_merchant=1548146391&sign=1EBC5FF2C70608564DCEFA478EBABC2643DA289A3A21BBFFFBFD6F98CF26A192&stock_id=1296010000000093#wechat_redirect";
        String keyValue = sendUrl.substring(sendUrl.indexOf("?")+1, sendUrl.indexOf("#"));
        Map<String, Object> map = stringToMap(keyValue);
        Long cardTemplateId = Long.valueOf(map.get("coupon_code").toString());
        System.out.println(cardTemplateId);

    }

    public static Map<String, Object> stringToMap(String str) {
        Objects.requireNonNull(str);
        String[] strs = str.split("&");
        Map<String, Object> map = new HashMap<>(16);
        for (String s : strs) {
            String[] ms = s.split("=");
            map.put(ms[0], ms[1]);
        }
        return map;
    }

}
