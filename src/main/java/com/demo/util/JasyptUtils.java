package com.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;

public class JasyptUtils {

	public static final String PASSWORD = "password";
	public static final String ALGORITHM = "PBEWithMD5AndDES";

	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
        List<Integer> partition = new ArrayList<>();
        //Step1: Setup a lastFound char index as 26 letter
        int[] lastFound = new int[26];
		System.out.println('a');

        //Step2: Fill the lastFound position for each char
        for(int i = 0; i < S.length(); i++) {
//    		System.out.println(S.charAt(i));

//    		System.out.println(S.charAt(i) - 'a');
            lastFound[S.charAt(i) - 'a'] = i;

        }

      //Step3: Run while loop and find how much we have to expand end boundries
        int i = 0;
        while(i < S.length()){
            int end = lastFound[S.charAt(i) - 'a'];

            int j = i;
            //Step4: while loop to check from current i to end
            while(j < end){
                end = Math.max(end, lastFound[S.charAt(j++) - 'a']);
            }
            //Step5: getting the partition range and adding 1 for zero index compensation
            partition.add(j - i + 1);
            i = j + 1;
        }
		System.out.println(partition);

//		System.out.println("encrypt");
//		System.out.println(encrypt("testtest"));
//		System.out.println("decrypt");
//		System.out.println(decrypt("Nm109uGs6vlfGR/c0lVBZfJK2hctr8Z0"));
	}

	public static String encrypt(String pw) {
	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	    encryptor.setPassword(PASSWORD);
	    encryptor.setAlgorithm(ALGORITHM);
	    encryptor.setPoolSize(1);
		return encryptor.encrypt(pw);
	}
	
	public static String decrypt(String pw) {
	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	    encryptor.setPassword(PASSWORD);
	    encryptor.setAlgorithm(ALGORITHM);
	    encryptor.setPoolSize(1);
		return encryptor.decrypt(pw);
	}
}
