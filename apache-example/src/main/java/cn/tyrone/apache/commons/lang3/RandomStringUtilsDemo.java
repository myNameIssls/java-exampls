package cn.tyrone.apache.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsDemo {

    public static void main(String[] args) {

        /**
         * 随机生成指定长度的字符串，中文环境下是乱码
         */
        String random = RandomStringUtils.random(5);
        System.out.println("RandomStringUtils.random:\t" + random);

        /**
         * 从指定字符串中生成指定长度的字符串
         */
        String random1 = RandomStringUtils.random(6, new char[]{'t', 'y', 'r', '4', '5', '6', 'o', 'n', 'e'});
        System.out.println("从指定字符串中生成指定长度的字符串：\t" + random1);

        /**
         * 生成指定长度的字符串
         * letters: 表示是否包含大小写字母，true：包含，false：不包含
         * numbers：表示是否包含数字，true：包含，false：不包含
         * 如果两个都是false，结果是随机生成指定长度的字符串，中文环境下是乱码
         */
        String random2 = RandomStringUtils.random(10, true, true);
        System.out.println(random2);

        /**
         * 随机生成指定长度[a-z,A-Z]的字符串，包含大小写
         */
        String randomAlphabetic = RandomStringUtils.randomAlphabetic(10);
        System.out.println("随机生成指定长度[a-z,A-Z]的字符串，包含大小写：\t" + randomAlphabetic);

        /**
         * 随机生成[a-z,A-Z]的字符串，包含大小写，其长度介于minLengthInclusive和minLengthInclusive之间
         */
        String randomAlphabetic1 = RandomStringUtils.randomAlphabetic(5, 10);
        System.out.println("随机生成[a-z,A-Z]的字符串，包含大小写，其长度介于minLengthInclusive和minLengthInclusive之间：\t" + randomAlphabetic1);

        /**
         * 随机生成指定长度数字字符串
         */
        String randomNumeric = RandomStringUtils.randomNumeric(5);
        System.out.println("随机生成指定长度数字字符串:\t" + randomNumeric);

        /**
         * 随机生成[0,9]数字字符串，其长度介于minLengthInclusive和minLengthInclusive之间
         */
        String randomAlphanumeric = RandomStringUtils.randomNumeric(5, 10);
        System.out.println("：\t" + randomAlphanumeric);

        /**
         * 随机生成指定长度的ascii码字符串（32位-126位ascii码）
         */
        String randomAscii = RandomStringUtils.randomAscii(10);
        System.out.println("随机生成指定长度的ascii码字符串：\t" + randomAscii);

        /**
         * 随机生成指定长度的ascii码字符串，取值包括标点符号、大小写字母、数字
         */
        String randomGraph = RandomStringUtils.randomGraph(10);
        System.out.println("随机生成指定长度的字符串：\t" + randomGraph);
    }

}
