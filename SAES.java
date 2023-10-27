package org.example;





import javax.crypto.Cipher;
import java.beans.Encoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SAES {

    //D.2.1 密钥加     s1:状态矩阵 s2:密钥
    static  String[]  addKey(String[] s1,String[] s2){
        String[] s = new String[4];
        for(int i = 0; i<4; i++){
            s[i]=Integer.toBinaryString(
                    Integer.parseInt(s1[i],2)^
                            Integer.parseInt(s2[i],2));

            while(s[i].length()<4){ //左补0
                s[i]="0"+s[i];
            }
        }

        //System.out.println("轮密钥加:"+s[0]+s[1]+s[2]+s[3]);

        return s;
    }

    //D.2.2 半字节代替

    //S盒
    static String SBox[][]={
            {"1001","0100","1010","1011"},
            {"1101","0001","1000","0101"},
            {"0110","0010","0000","0011"},
            {"1100","1110","1111","0111"}
    };
    static String[] NS(String[] S){



        String s[] = new String[4];
        for(int i=0;i<4;i++){
            int x = Integer.parseUnsignedInt(S[i].substring(0,2),2);
            int y = Integer.parseUnsignedInt(S[i].substring(2,4),2);
            s[i] = SBox[x][y];
        }

        //System.out.println("半字节替代:"+s[0]+s[1]+s[2]+s[3]);

        return s;
    }

    //逆 半字节替代
    //逆 S盒
    static  String _SBox[][]={
            {"1010","0101","1001","1011"},
            {"0001","0111","1000","1111"},
            {"0110","0000","0010","0011"},
            {"1100","0100","1101","1110"}
    };
    static String[] _NS(String[] S){
        String s[] = new String[4];
        for(int i=0;i<4;i++){
            int x = Integer.parseUnsignedInt(S[i].substring(0,2),2);
            int y = Integer.parseUnsignedInt(S[i].substring(2,4),2);
            s[i] = _SBox[x][y];
        }
        //System.out.println("逆半字节替代:"+s[0]+s[1]+s[2]+s[3]);
        return s;
    }

    //D.2.3 行位移(逆 行位移)
    static String[] SR(String[] S){
        String[] s = {S[0],S[3],S[2],S[1]};

        //System.out.println("行位移:"+s[0]+s[1]+s[2]+s[3]);
        return s;
    }

    //D.2.4 列混淆
    static String[][] GFmlp= {
            {"0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000"},
            {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"},
            {"0000","0010","0100","0110","1000","1010","1100","1110","0011","0001","0111","0101","1011","1001","1111","1101"},
            {"0000","0011","0110","0101","1100","1111","1010","1001","1011","1000","1101","1110","0111","0100","0001","0010"},
            {"0000","0100","1000","1100","0011","0111","1011","1111","0110","0010","1110","1010","0101","0001","1101","1001"},
            {"0000","0101","1010","1111","0111","0010","1101","1000","1110","1011","0100","0001","1001","1100","0011","0110"},
            {"0000","0110","1100","1010","1011","1101","0111","0001","0101","0011","1001","1111","1110","1000","0010","0100"},
            {"0000","0111","1110","1001","1111","1000","0001","0110","1101","1010","0011","0100","0010","0101","1100","1011"},
            {"0000","1000","0011","1011","0110","1110","0101","1101","1100","0100","1111","0111","1010","0010","1001","0001"},
            {"0000","1001","0001","1000","0010","1011","0011","1010","0100","1101","0101","1100","0110","1111","0111","1110"},
            {"0000","1010","0111","1101","1110","0100","1001","0011","1111","0101","1000","0010","0001","1011","0110","1100"},
            {"0000","1011","0101","1110","1010","0001","1111","0100","0111","1100","0010","1001","1101","0110","1000","0011"},
            {"0000","1100","1011","0111","0101","1001","1110","0010","1010","0110","0001","1101","1111","0011","0100","1000"},
            {"0000","1101","1001","0100","0001","1100","1000","0101","0010","1111","1011","0110","0011","1110","1010","0111"},
            {"0000","1110","1111","0001","1101","0011","0010","1100","1001","0111","0110","1000","0100","1010","1011","0101"},
            {"0000","1111","1101","0010","1001","0110","0100","1011","0001","1110","1100","0011","1000","0111","0101","1010"}
    };
    static String[] MC(String[] S){
        int[] a ={Integer.parseInt(S[0],2),Integer.parseInt(S[1],2),Integer.parseInt(S[2],2),Integer.parseInt(S[3],2)};
        String[] s = new String[4];
        s[0] = Integer.toBinaryString(Integer.parseInt(GFmlp[1][a[0]],2)^Integer.parseInt(GFmlp[4][a[1]],2));
        s[2] = Integer.toBinaryString(Integer.parseInt(GFmlp[1][a[2]],2)^Integer.parseInt(GFmlp[4][a[3]],2));
        s[1] = Integer.toBinaryString(Integer.parseInt(GFmlp[4][a[0]],2)^Integer.parseInt(GFmlp[1][a[1]],2));
        s[3] = Integer.toBinaryString(Integer.parseInt(GFmlp[4][a[2]],2)^Integer.parseInt(GFmlp[1][a[3]],2));


        for(int i =0;i<4;i++){
            while(s[i].length()<4){
                s[i]="0"+s[i];
            }
        }
        //System.out.println("列混淆"+s[0]+s[1]+s[2]+s[3]);
        return s;
    };
    //逆列混淆
    static String[] _MC(String[] S){
        int[] a ={Integer.parseInt(S[0],2),Integer.parseInt(S[1],2),Integer.parseInt(S[2],2),Integer.parseInt(S[3],2)};
        String[] s = new String[4];
        s[0] = Integer.toBinaryString(Integer.parseInt(GFmlp[9][a[0]],2)^Integer.parseInt(GFmlp[2][a[1]],2));
        s[2] = Integer.toBinaryString(Integer.parseInt(GFmlp[9][a[2]],2)^Integer.parseInt(GFmlp[2][a[3]],2));
        s[1] = Integer.toBinaryString(Integer.parseInt(GFmlp[2][a[0]],2)^Integer.parseInt(GFmlp[9][a[1]],2));
        s[3] = Integer.toBinaryString(Integer.parseInt(GFmlp[2][a[2]],2)^Integer.parseInt(GFmlp[9][a[3]],2));

        for(int i =0;i<4;i++){
            while(s[i].length()<4){
                s[i]="0"+s[i];
            }
        }
        //System.out.println("逆列混淆"+s[0]+s[1]+s[2]+s[3]);
        return s;
    }


    //D3 密钥扩展
    //  RCON
    static String[] RC={"10000000","00110000"};
    static String[] keyExpend(String key){
        String[] w = new String[6];

        w[0] = key.substring(0,8);
        w[1] = key.substring(8,16);
        w[2] = Integer.toBinaryString(
                Integer.parseInt(w[0],2)^
                        Integer.parseInt(RC[0],2)^
                        Integer.parseInt(
                                SBox[Integer.parseInt(w[1].substring(4,6),2)][Integer.parseInt(w[1].substring(6,8),2)]+
                                        SBox[Integer.parseInt(w[1].substring(0,2),2)][Integer.parseInt(w[1].substring(2,4),2)]
                                ,2));
        w[3] = Integer.toBinaryString(Integer.parseInt(w[2],2)^Integer.parseInt(w[1],2));
        for(int i=2;i<4;i++){
            while (w[i].length() < 8) {
                w[i]="0"+w[i];
            }
        }
        w[4] = Integer.toBinaryString(
                Integer.parseInt(w[2],2)^
                        Integer.parseInt(RC[1],2)^
                        Integer.parseInt(
                                SBox[Integer.parseInt(w[3].substring(4,6),2)][Integer.parseInt(w[3].substring(6,8),2)]+
                                        SBox[Integer.parseInt(w[3].substring(0,2),2)][Integer.parseInt(w[3].substring(2,4),2)]
                                ,2));
        w[5] = Integer.toBinaryString(Integer.parseInt(w[4],2)^Integer.parseInt(w[3],2));
        for(int i=2;i<6;i++){
            while (w[i].length() < 8) {
                w[i]="0"+w[i];
            }
        }
        return w;
    }

    static String encrypt(String plaintext,String key){
        //密钥扩展
        String[] Key01={keyExpend(key)[0].substring(0,4),
                keyExpend(key)[0].substring(4,8),
                keyExpend(key)[1].substring(0,4),
                keyExpend(key)[1].substring(4,8),};
        String[] Key23={keyExpend(key)[2].substring(0,4),
                keyExpend(key)[2].substring(4,8),
                keyExpend(key)[3].substring(0,4),
                keyExpend(key)[3].substring(4,8),};
        String[] Key45={keyExpend(key)[4].substring(0,4),
                keyExpend(key)[4].substring(4,8),
                keyExpend(key)[5].substring(0,4),
                keyExpend(key)[5].substring(4,8),};

        //将plaintext转化成数组
        String[] plainText = {
                plaintext.substring(0,4),
                plaintext.substring(4,8),
                plaintext.substring(8,12),
                plaintext.substring(12,16)
        };
        //addKey1轮密钥加
        //NS半字节替代
        //SR行位移
        //MC列混淆
        //addKey2轮密钥加
        //NS半字节替代
        //SR行位移
        String[] ciphertext = addKey(SR(NS(addKey(MC(SR(NS(addKey(plainText,Key01)))),Key23))),Key45);

        return ciphertext[0]+ciphertext[1]+ciphertext[2]+ciphertext[3];
    }

    public static String decode(String ciphertext, String key){
        //密钥扩展
        String[] Key01={keyExpend(key)[0].substring(0,4),
                keyExpend(key)[0].substring(4,8),
                keyExpend(key)[1].substring(0,4),
                keyExpend(key)[1].substring(4,8),};
        String[] Key23={keyExpend(key)[2].substring(0,4),
                keyExpend(key)[2].substring(4,8),
                keyExpend(key)[3].substring(0,4),
                keyExpend(key)[3].substring(4,8),};
        String[] Key45={keyExpend(key)[4].substring(0,4),
                keyExpend(key)[4].substring(4,8),
                keyExpend(key)[5].substring(0,4),
                keyExpend(key)[5].substring(4,8),};
        //密文数组
        String[] cipherText = {
                ciphertext.substring(0,4),
                ciphertext.substring(4,8),
                ciphertext.substring(8,12),
                ciphertext.substring(12,16)
        };
        String[] plaintext = addKey(_NS(SR(_MC(addKey(_NS(SR(addKey(cipherText,Key45))),Key23)))),Key01);
        return plaintext[0]+plaintext[1]+plaintext[2]+plaintext[3];
    }

    //加密字符串
    static String encryptString(String plainText, String key) {
        String ciphertext = "";                       //密文
        String binaryText = "";                       //单个字符的二进制表示
        String cipherBinaryText = "";                 //加密后的二进制字符串
        String plainBinaryType = "[0*1*]*[1*0*]*";    //二进制类型的明文
        //如果明文是二进制类型
        if (plainText.matches(plainBinaryType)) {
            while ((plainText.length() % 16) != 0) {       //不是16的整数，左补零
                plainText = "0" + plainText;
            }
            for (int i = 0; i < plainText.length() / 16; i++) {
                ciphertext += encrypt(plainText.substring(0 + 16 * i, 16 + 16 * i), key);
            }
        }
        //如果明文是字符串类型
        else {
            char[] strChar = plainText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串加密
            for (int i = 0; i < strChar.length; i++) {
                binaryText = Integer.toBinaryString(strChar[i]);

                while (binaryText.length() < 16) {
                    binaryText = "0" + binaryText;      //小于16位，左补0
                }
                //将加密后的二进制字符串转换成字符，然后拼接成明文
                cipherBinaryText = encrypt(binaryText, key);
                ciphertext += Character.toString((char) Integer.parseInt(cipherBinaryText, 2));
            }
        }
        return ciphertext;
    }

    //解密字符串
    static String decodeString(String cipherText, String key){
        String plaintext = "";                        //明文
        String binaryText = "";                       //单个字符的二进制表示
        String plainBinaryText = "";                  //解密后的二进制字符串
        String cipherBinaryType ="[0*1*]*[1*0*]*";   //二进制类型的密文

        //如果密文是二进制类型
        if (cipherText.matches(cipherBinaryType)) {
            while ((cipherText.length() % 16) != 0) {       //不是16的整数，左补零
                cipherText = "0"+ cipherText;
            }
            for (int i = 0; i < cipherText.length() / 16; i++) {
                plaintext += decode(cipherText.substring(0 + 16 * i, 16 + 16 * i), key);
            }
        }
        //如果密文是字符串类型
        else {
            char[] strChar = cipherText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串解密
            for (int i = 0; i < strChar.length; i++) {
                binaryText = Integer.toBinaryString(strChar[i]);

                while (binaryText.length() < 16) {
                    binaryText = "0" + binaryText;      //小于16位，左补0
                }
                //将解密后的二进制字符串转换成字符
                plainBinaryText = decode(binaryText, key);
                plaintext += Character.toString((char) Integer.parseInt(plainBinaryText, 2));
            }
        }
        return plaintext;
    }

    //双重加密
    static String doubleEncrypt(String plainText,String key1,String key2){
        return encryptString(encryptString(plainText,key1),key2);
    }

    //双重解密
    static String doubleDecode(String cipherText,String key1,String key2){
        return decodeString(decodeString(cipherText,key2),key1);
    }

    //中间相遇攻击
    static ArrayList Meet_in_the_middle_attack(String plainText,String cipherText){

        //密钥一 密钥二
        String key1="";
        String key2="";
        //加密后的文本
        String[] plaintextArr=new String[65536];
        //解密后的文本
        String[] ciphertextArr=new String[65536];
        //密钥对个数
        ArrayList key = new ArrayList();

        for(int i=0;i<65536;i++) {
            key1 = Integer.toBinaryString(i);
            while (key1.length() < 16) {               //不够16位向左补0
                key1 = "0" + key1;
            }
            plaintextArr[i] = encryptString(plainText, key1);
        }

        for(int j=0;j<65536;j++){
            key2 = Integer.toBinaryString(j);
            while (key2.length() < 16) {               //不够16位向左补0
                key2 = "0" + key2;
            }
            ciphertextArr[j] = decodeString(cipherText,key2);
        }

        for(int i=0;i<65536;i++){
            for(int j=0;j<65536;j++){
                if(plaintextArr[i].equals(ciphertextArr[j])){
                    String k1 = Integer.toBinaryString(i);
                    String k2 = Integer.toBinaryString(j);
                    while(k1.length()<16){
                        k1="0"+k1;
                    }
                    while(k2.length()<16){
                        k2="0"+k2;
                    }
                    key.add(k1+"+"+k2);
                }
            }
        }
        return key;
    }

    //三重加密
    //Key(k1+k2) 模式
    static String tripleEncrypt(String plainText,String key1,String key2){
        return encryptString(decodeString(encryptString(plainText,key1),key2),key1);
    }
    //Key(k1+k2+k3) 模式
    static String tripleEncrypt(String plainText,String key1,String key2,String key3){
        return encryptString(encryptString(encryptString(plainText,key1),key2),key3);
    }

    //三重解密
    //Key(k1+k2) 模式
    static String tripleDecode(String cipherText,String key1,String key2){
        return decodeString(encryptString(decodeString(cipherText,key1),key2),key1);
    }
    //Key(k1+k2+k3) 模式
    static String tripleDecode(String cipherText,String key1,String key2,String key3){
        return decodeString(decodeString(decodeString(cipherText,key3),key2),key1);
    }

    //生成初始向量
    static String generateVI(){
        Random r = new Random();
        String VI = Integer.toBinaryString(r.nextInt(65536));
        while(VI.length()<16){
            VI="0"+VI;
        }
        System.out.println(VI);
        return VI;
    }

    //CBC加密
    static String CBC_Encrypt(String plainText,String key,String IV){
        String ciphertext = "";                       //密文
        String binaryText = "";                       //单个字符的二进制表示
        String plainBinaryType = "[0*1*]*[1*0*]*";    //二进制类型的明文
        //如果明文是二进制类型
        if (plainText.matches(plainBinaryType)) {
            while ((plainText.length() % 16) != 0) {       //不是16的整数，左补零
                plainText = "0" + plainText;
            }
            //处理第一个分组
            String segment = plainText.substring(0, 16);
            String res = Integer.toBinaryString(Integer.parseInt(segment,2)^Integer.parseInt(IV,2));
            while (res.length()<16){
                res = "0"+res;
            }
            String temp = encrypt(res,key);
            ciphertext = ciphertext+temp;
            //处理后面的分组
            for (int i = 1; i < plainText.length() / 16; i++) {
                segment = plainText.substring(0 + 16 * i, 16 + 16 * i);
                res = Integer.toBinaryString(Integer.parseInt(segment,2)^Integer.parseInt(temp,2));
                while (res.length()<16){
                    res = "0"+res;
                }
                temp = encrypt(res,key);
                ciphertext = ciphertext+temp;
            }
        }
        //如果明文是字符串类型
        else {
            char[] strChar = plainText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串加密
            //处理第一个分组
            binaryText = Integer.toBinaryString(strChar[0]);
            while (binaryText.length() < 16) {
                binaryText = "0" + binaryText;            //小于16位，左补0
            }
            String res = Integer.toBinaryString(Integer.parseInt(binaryText,2)^Integer.parseInt(IV,2));
            while (res.length()<16){
                res = "0"+res;
            }
            String temp = encrypt(res,key);
            ciphertext += Character.toString((char) Integer.parseInt(temp, 2));

            //处理后面的分组
            for (int i = 1; i < strChar.length; i++) {
                binaryText = Integer.toBinaryString(strChar[i]);
                while (binaryText.length() < 16) {
                    binaryText = "0" + binaryText;      //小于16位，左补0
                }
                res = Integer.toBinaryString(Integer.parseInt(binaryText,2)^Integer.parseInt(temp,2));
                while (res.length()<16){
                    res = "0"+res;
                }
                temp = encrypt(res,key);
                ciphertext += Character.toString((char) Integer.parseInt(temp, 2));
            }
        }
        return ciphertext;
    }

    //CBC解密
    static String CBC_Decode(String cipherText,String key,String IV){
        String plaintext = "";                        //明文
        String binaryText = "";                       //单个字符的二进制表示
        String plainBinaryText = "";                  //解密后的二进制字符串
        String cipherBinaryType ="[0*1*]*[1*0*]*";   //二进制类型的密文

        //如果密文是二进制类型
        if (cipherText.matches(cipherBinaryType)) {
            while ((cipherText.length() % 16) != 0) {       //不是16的整数，左补零
                cipherText = "0"+ cipherText;
            }
            //处理第一个分组
            String segment = cipherText.substring(0, 16);
            String temp = segment;
            String cipherRes = decode(segment,key);     //解密结果
            String res = Integer.toBinaryString(Integer.parseInt(cipherRes,2)^Integer.parseInt(IV,2));  //相与结果
            while (res.length()<16){
                res = "0"+res;
            }
            plaintext += res;
            //处理后面的分组
            for (int i = 1; i < cipherText.length() / 16; i++) {
                segment += decode(cipherText.substring(0 + 16 * i, 16 + 16 * i), key);
                cipherRes = decode(segment,key);
                res = Integer.toBinaryString(Integer.parseInt(cipherRes,2)^Integer.parseInt(temp,2));  //相与结果
                while (res.length()<16){
                    res = "0"+res;
                }
                plaintext += res;
                temp = segment;
            }
        }
        //如果密文是字符串类型
        else {
            char[] strChar = cipherText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串解密
            //处理第一个分组
            binaryText = Integer.toBinaryString(strChar[0]);
            while (binaryText.length() < 16) {
                binaryText = "0" + binaryText;            //小于16位，左补0
            }
            String temp = binaryText;
            String cipherRes = decode(binaryText,key);     //解密结果
            String res = Integer.toBinaryString(Integer.parseInt(cipherRes,2)^Integer.parseInt(IV,2));  //相与结果
            while (res.length()<16){
                res = "0"+res;
            }
            plaintext += Character.toString((char) Integer.parseInt(res, 2));

            for (int i = 1; i < strChar.length; i++) {
                binaryText = Integer.toBinaryString(strChar[i]);
                while (binaryText.length() < 16) {
                    binaryText = "0" + binaryText;            //小于16位，左补0
                }
                cipherRes = decode(binaryText,key);
                res = Integer.toBinaryString(Integer.parseInt(cipherRes,2)^Integer.parseInt(temp,2));  //相与结果
                while (res.length()<16){
                    res = "0"+res;
                }
                //将解密后的二进制字符串转换成字符
                plaintext += Character.toString((char) Integer.parseInt(res, 2));
                temp = binaryText;
            }
        }
        return plaintext;
    }

    public static void main(String[] args) {


        String plainText = "陷阵之志，有死无生";
        String key = "0010110101010101";
        //加密后的文本
        String ciphertext="";
        //解密后的文本
        String plaintext="";

        //加密字符串或者二进制文本
        System.out.println("明文是:"+plainText);
        /*ciphertext = encryptString(plainText,key);
        System.out.println("加密后的密文:"+ciphertext);
        plaintext = decodeString(ciphertext,"0010110101010101");
        System.out.println("解密后的明文:"+plaintext);*/

        String key1 = "0010110101010101";
        String key2 = "0011010110100111";
        String key3 = "1010010111110000";

        //双重 加密 解密
        /*ciphertext=doubleEncrypt(plainText,key1,key2);
        System.out.println("双重加密后的文本:"+ciphertext);
        plaintext =doubleDecode(ciphertext,key1,key2);
        System.out.println("双重解密后的文本:"+plaintext);*/

        /*//中间相遇攻击
        ArrayList thekey;
        thekey = Meet_in_the_middle_attack(plaintext,ciphertext);
        for (int i = 0; i < thekey.size(); i++) {
            String eachKey = (String) thekey.get(i);
            System.out.println(eachKey);
        }*/

        //三重 加密 解密
        /*ciphertext=tripleEncrypt(plainText,key1,key2);
        System.out.println("(Key=k1+k2模式) 三重加密后的文本:"+ciphertext);
        plaintext =tripleDecode(ciphertext,key1,key2);
        System.out.println("(Key=k1+k2模式) 三重解密后的文本:"+plaintext);

        ciphertext=tripleEncrypt(plainText,key1,key2,key3);
        System.out.println("(Key=k1+k2+k3模式) 三重加密后的文本:"+ciphertext);
        plaintext =tripleDecode(ciphertext,key1,key2,key3);
        System.out.println("(Key=k1+k2+k3模式) 三重解密后的文本:"+plaintext);*/

        //CBC 加密 解密
        //String IV = generateVI();
        String IV = "1010000000101010";

        //加密
        ciphertext = CBC_Encrypt(plainText,key,IV);
        System.out.println("CBC加密后的文本:"+ciphertext);
        //密文：畸拽컫㣰憿風ᴈ﹢㓪
        //解密
        System.out.println("没有替换或修改密文时：");
        plaintext = CBC_Decode(ciphertext,key,IV);
        System.out.println("CBC解密后的文本:"+plaintext);

        System.out.println("替换密文：");
        plaintext = CBC_Decode("畸你好㣰憿ᴈ﹢㓪",key,IV);
        System.out.println("CBC解密后的文本:"+plaintext);

        System.out.println("修改密文：");
        plaintext = CBC_Decode("畸拽컫㣰憿風ᴈ﹢㓪尽快发啦",key,IV);
        System.out.println("CBC解密后的文本:"+plaintext);
    }
}

