package com.ljj.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liujinjian
 * @Date: 2020/8/20 15:02
 */
public class Test {

    public static void main(String[] args) {
        String m = "{\n" +
                "    \"bizId\": 03400,\n" +
                "}";
        CardTemplate cardTemplate = JSON.parseObject(m, CardTemplate.class);
        System.out.println(cardTemplate.getBizId());
    }


    private static class CardTemplate {
        private Integer bizId;

        public Integer getBizId() {
            return bizId;
        }

        public void setBizId(Integer bizId) {
            this.bizId = bizId;
        }
    }
}
