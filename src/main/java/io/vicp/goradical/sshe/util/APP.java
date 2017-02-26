package io.vicp.goradical.sshe.util;

import java.security.MessageDigest;

public class APP {
	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			UUIDHexGenerator uuid = new UUIDHexGenerator();
//			Serializable generate = uuid.generate(null, null);
//			System.out.println(generate);
//		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			System.out.println(new String(md5.digest(new StringBuilder("hello").toString().getBytes("utf-8"))));
			System.out.println(new String(md5.digest("hello".getBytes())));
			System.out.println(DataUtil.md5("hello"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
