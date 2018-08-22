package com.guoguang.encryptdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 2018-07-25.
 */

public class Ansi98Util {
    /**
     * 将两个字符串进行异或操作
     *
     * @param str1 字符串一
     * @param str2 字符串二
     * @return 异或后的数据
     */
    private String twoStringXor(String str1, String str2) {
        List<Byte> b1 = new ArrayList<Byte>();
        List<Byte> b2 = new ArrayList<Byte>();
        String xorstr = "";
        for (int i = 0; i < str1.length(); i++) {
            b1.add((byte) Integer.parseInt(str1.substring(i, i + 1), 16));
        }

        for (int i = 0; i < str1.length(); i++) {
            b2.add((byte) Integer.parseInt(str2.substring(i, i + 1), 16));
        }
        if (b1.size() != b2.size()) {
            return null;
        }
        for (int i = 0; i < b1.size(); i++) {
            xorstr += Integer.toHexString(b1.get(i) ^ b2.get(i));
        }

        return xorstr.toUpperCase();
    }

    /**
     * 获取ANSI98标准格式的PIN（用于与账号进行异或）
     *
     * @param pin  密码
     * @param mode 模式：0（16位数据格式）  1（32位数据格式）
     * @return
     */
    private String getAnsi98Pin(String pin, int mode) {
        String pinLength = Integer.toHexString(pin.length());
        String result = "0" + pinLength + pin;
        int resultLength = result.length();
        if (mode == 0) {
            for (int i = 0; i < 16 - resultLength; i++) {
                result = result + "F";
            }
        } else if (mode == 1) {
            for (int i = 0; i < 32 - resultLength; i++) {
                result = result + "F";
            }
        }
        return result;
    }

    /**
     * 获取ANSI98标准格式的账号（用于与密码进行异或）
     *
     * @param acco 账号
     * @param mode 模式：0（16位数据格式） 1（32位数据格式）
     * @return
     */
    private String getAnsi98Acco(String acco, int mode) {
        String result = "";
        int accoLength = acco.length();

        if (accoLength > 12) {
            result = acco.substring(accoLength-13,accoLength-1);
        } else if (accoLength == 12) {
            result = acco;
        } else if (accoLength < 12) {
            for (int i = 0; i < 12 - accoLength; i++) {
                result = "0" + acco;
            }
        }

        if (mode == 0) {
            result = "0000" + result;
        } else if (mode == 1) {
            result = "00000000000000000000" + result;
        }

        return result;
    }
}
