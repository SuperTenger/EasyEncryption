package com.guoguang.encryptdemo;

import com.guoguang.egt.sm4.Util;
import com.guoguang.egt.sm4.sm4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 2018-07-25.
 */

public class Sm4Util {
    /**
     * 计算SM4校验值:将传入的工作密钥或主密钥加密32个0
     *
     * @param key 工作密钥/主密钥
     * @return 校验值
     */
    private String getSm4VerifyValue(String key) {
        sm4 Sm4 = new sm4();
        return Util.byteToString(Sm4.SMS4Encrypt(Util.hexToByte("00000000000000000000000000000000"), 16, Util.hexToByte(key)));
    }

    /**
     * 计算SM4加密数值：将工作密钥加密异或后的账号密码
     *
     * @param key    工作密钥
     * @param source 异或后账号密码
     * @return 加密结果
     */
    private String getSm4EncryptValue(String key, String source) {
        sm4 Sm4 = new sm4();
        return Util.byteToString(Sm4.SMS4Encrypt(Util.hexToByte(source), 16, Util.hexToByte(key)));
    }

    /**
     * 计算SM4解密结果：一般用于主密钥解密被主密钥加密过的工作密钥
     *
     * @param key    主密钥
     * @param source 工作密钥
     * @return 解密结果
     */
    private String getSm4DecryptValue(String key, String source) {
        sm4 Sm4 = new sm4();
        return Util.byteToString(Sm4.SMS4Decrypt(Util.hexToByte(source), 16, Util.hexToByte(key)));
    }

}
