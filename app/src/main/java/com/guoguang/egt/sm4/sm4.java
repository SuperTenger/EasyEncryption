package com.guoguang.egt.sm4;

public class sm4 {
	// JNI
	//加密
	/**
	 * 
	 * @param jSource
	 * @param len   jSource长度
	 * @param jKey
	 * @return
	 */
	public native byte[] SMS4Encrypt(byte [] jSource,int len,byte [] jKey);
	//解密
	/**
	 * 
	 * @param input_data    
	 * @param len    jSource长度
	 * @param output_data
	 * @return
	 */
	public native byte[]   SMS4Decrypt(byte [] jSource,int len,byte [] jKey);
	 static {
	        System.loadLibrary("sm4");
	    }
}
