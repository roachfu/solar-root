package com.roachfu.solar.common.util.id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 身份证最后一位校验工具类
 *
 * @author fuqiang
 * @datetime 2017/5/22 14:39
 */
public class IDCardUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(IDCardUtils.class);

    /** 身份证正则 */
    private static final String ID_CARD_REGEX = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";

    /** 每位加权因子 */
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /** 取11模之后的值对应的身份证第18位 */
    private static final String[] MOD_CODE = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    /** 省份代码 ：省份名 */
    private static Map<String, String> provinces= new ConcurrentHashMap<>();
    static {
        provinces.put("11", "北京");
        provinces.put("12", "天津");
        provinces.put("13", "河北");
        provinces.put("14", "山西");
        provinces.put("15", "内蒙古");
        provinces.put("21", "辽宁");
        provinces.put("22", "吉林");
        provinces.put("23", "黑龙江");
        provinces.put("31", "上海");
        provinces.put("32", "江苏");
        provinces.put("33", "浙江");
        provinces.put("34", "安徽");
        provinces.put("35", "福建");
        provinces.put("36", "江西");
        provinces.put("37", "山东");
        provinces.put("41", "河南");
        provinces.put("42", "湖北");
        provinces.put("43", "湖南");
        provinces.put("44", "广东");
        provinces.put("45", "广西");
        provinces.put("46", "海南");
        provinces.put("50", "重庆");
        provinces.put("51", "四川");
        provinces.put("52", "贵州");
        provinces.put("53", "云南");
        provinces.put("54", "西藏");
        provinces.put("61", "陕西");
        provinces.put("62", "甘肃");
        provinces.put("63", "青海");
        provinces.put("64", "宁夏");
        provinces.put("65", "新疆");
    }

    private IDCardUtils() {
        // 构造器私有化
    }
    
    /**
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     * </p>
     * <p>
     * 前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
     * 第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     * 第17位数字表示性别：奇数表示男性，偶数表示女性；
     * 第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
     * 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少？
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     * </p>
     *
     * @param idCard 身份证号
     * @return true:正确；false:错误
     */
    public static boolean verifyIdCard(String idCard) {
        // 非18位为假
        if (!idCard.matches(ID_CARD_REGEX)) {
            LOGGER.error("身份证号码有误，请重新输入. . . ");
            return false;
        }
        // 前两位身份验证
        if(provinces.get(idCard.substring(0, 2)) == null){
            LOGGER.error("身份证前两位的省份有误, {}. . . ", provinces.get(idCard.substring(0, 2)));
            return false;
        }
    
        // 获取前17位
        char[] chars = idCard.substring(0, 17).toCharArray();
        int[] prefixNum = convertCharToInt(chars);
        // 前17位和权值相乘的总和
        int prefixSum = calculatorByWeight(prefixNum);
        // 获取第18位
        String last = idCard.substring(17, 18);
    
        // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
        if (!last.equalsIgnoreCase(MOD_CODE[prefixSum % 11])) {
            LOGGER.error("身份证最后一位匹配码不正确. . . ");
            return false;
        }
        return true;
    }
    
    /**
     * 将字符数组转为整型数组
     *
     * @param chars 身份证前17位
     * @return 整型数组
     */
    private static int[] convertCharToInt(char[] chars) {
        int[] prefixNum = new int[chars.length];
        int k = 0;
        for (char temp : chars) {
            prefixNum[k++] = Character.getNumericValue(temp);
        }
        return prefixNum;
    }
    
    /**
     * 计算身份证的前17位和对应的权值相乘之后的和
     */
    private static int calculatorByWeight(int[] prefixNum) {
        int sum = 0;
        for (int i = 0; i < prefixNum.length; i++) {
            sum = sum + prefixNum[i] * WEIGHT[i];
        }
        return sum;
    }
}
