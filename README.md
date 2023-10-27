# S-AES
## 闯关报告
#### 第一关 基本测试

根据S-AES算法编写和调试程序，提供GUI解密支持用户交互。输入可以是16bit的数据和16bit的密钥，输出是16bit的密文。

程序的主要GUI如图所示：

![image](https://github.com/revovle2/S-AES/assets/93172576/ab6ccf48-14e8-4198-9710-320874d44cfd)

<p align="center">图1 S-AES加解密的主GUI界面</p>

当用户未输入明文时，UI会给予提示：

![image](https://github.com/revovle2/S-AES/assets/93172576/de93f543-af7e-4c46-8709-f070672cc5ae)

<p align="center">图2 未输入明文</p>

当用户未输入密钥时，UI会提示：

![image](https://github.com/revovle2/S-AES/assets/93172576/fcc51706-4118-48b0-9fe5-9005807a9500)

<p align="center">图3 未输入密钥</p>


此外，本GUI提供了自动生成16bits密钥的按钮，点击即可生成：

![image](https://github.com/revovle2/S-AES/assets/93172576/203ee7be-780a-4d0c-b2c4-fca463dddfe4)

<p align="center">图4 自动生成16bits密钥</p>

第一关要求加密16bits明文，即明文和密钥位数相等

选择明文：1100111011001011

选择密钥：0001110010001010

加密结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/414ff813-f378-4f6f-9d63-aa0ec990514d)

<p align="center">图5 加密16bits明文</p>

而随后，我们对得到的密文 1110110110000101 进行解密结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/292e8e6d-9d12-405d-8a39-3fbca33092d9)

<p align="center">图6 解密16bits明文</p>

而得到明文结果为：1100111011001011 与加密前一致，至此，第一关基本测试已完成。

#### 第二关 交叉测试

考虑到是"算法标准"，所有人在编写程序的时候需要使用相同算法流程和转换单元(替换盒、列混淆矩阵等)，以保证算法和程序在异构的系统或平台上都可以正常运行。设有A和B两组位同学(选择相同的密钥K)；则A、B组同学编写的程序对明文P进行加密得到相同的密文C；或者B组同学接收到A组程序加密的密文C，使用B组程序进行解密可得到与A相同的P。

在本次测试中，我们uttu小组与Andrade小组进行了交叉测试，加解密结果如下：

第一轮，选择密钥 1010101010101010 ，加密明文1100110011001100 

本组加密结果如下:

![3D402C29F057CD90495566ADBA370507](https://github.com/revovle2/S-AES/assets/93172576/aaf479d0-769a-460f-8dbb-f70d9813c9db)

<p align="center">图7 本组加密明文</p>

Andrade组加密结果：

![img21](https://github.com/revovle2/S-AES/assets/93172576/b1e63863-0741-47f0-863c-7f82efa48789)

<p align="center">图8 测试小组加密明文</p>

随后，我们两组将所得密文解密，结果如下：

本组解密结果如下：

![39F2B5BF42694689693E3E920F82AE83](https://github.com/revovle2/S-AES/assets/93172576/e88a0915-598f-4b46-b36b-21ec563ed8f6)

<p align="center">图7 本组解密密文1</p>

Andrade小组解密结果如下：

![img23](https://github.com/revovle2/S-AES/assets/93172576/1f83d31c-f1e7-4b51-8242-e239554e5203)


<p align="center">图8 Andrade组解密密文</p>

第二轮测试：同样选择密钥1010101010101010 明文为1010000111001011

本组加密结果如下：

![D942D4C297B9B8A20553FC736C56CF28](https://github.com/revovle2/S-AES/assets/93172576/1ccd4169-2f29-4a8b-b865-277af7a1c00a)

<p align="center">图9 本组加密明文2</p>

Andrade小组加密结果如下：

![img25](https://github.com/revovle2/S-AES/assets/93172576/64a535c6-afb4-4472-92c1-0ec3e3d05ead)

<p align="center">图10 测试小组加密明文2</p>

对得到的密文1110110111000000 测试一致

本组解密结果如下：

![52F460E349B3665D022B21F6E8B685F8](https://github.com/revovle2/S-AES/assets/93172576/d73206c8-ebb0-4d7e-8a2b-8636c4f4c3d3)

<p align="center">图11 本小组解密密文2</p>

Andrade小组解密结果如下：

![B4139BEFD558B3A8E8C647115884D8F5](https://github.com/revovle2/S-AES/assets/93172576/abbd457b-7bf4-4d12-84e6-4351463293d0)

<p align="center">图12 Andrade组解密密文2</p>

至此，第二关的组件测试未发现差错，完美通过。

#### 第三关  拓展功能

考虑到向实用性扩展，加密算法的数据输入可以是ASII编码字符串(分组为2 Bytes)，对应地输出也可以是ACII字符串(很可能是乱码)。

本程序输入的名密文可以兼容，即不需要切换功能，输入为二进制与ASCII码甚至中文均可

加密明文cqu，密钥为0010110101101011

加密结果如下（有乱码）：

![image](https://github.com/revovle2/S-AES/assets/93172576/256a2e8a-94c0-431d-9dfa-bf7662976d72)

<p align="center">图13 加密明文cqu</p>

解密结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/37b58b0d-219c-4ba3-8bbb-8561ed826397)

<p align="center">图14 解密密文㢒夡</p>

选择第二组数据：加密明文：重庆大学 密钥选择0100101100100110

加密结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/aa62a12f-c4c9-4e8f-a96d-7f0f81497dcd)

<p align="center">图15 加密明文重庆大学</p>

解密结果如下：
![image](https://github.com/revovle2/S-AES/assets/93172576/3a1ecfbe-bfe0-4418-94bb-f486b008db48)

<p align="center">图16 解密密文ꙩ臭鸆蹭</p>

至此，第三关的要求已经全部实现，甚至加装了加密中文功能，完美通过第三关！

#### 第四关 多重加密

##### 4.1 双重加密

将S-AES算法通过双重加密进行扩展，分组长度仍然是16 bits，但密钥长度为32 bits。

双重加密的GUI如图所示：

![image](https://github.com/revovle2/S-AES/assets/93172576/485f94ce-3d0c-4d39-ae3b-d21a8c394907)

<p align="center">图17 双重加密GUI</p>

使用方法同A-AES的GUI ，但是要两个密钥

测试加密明文cquse 密钥1 密钥2 分别为0100111111011110  1000010100001010  测试结果如下：得到密文硚됄Ї琊ࡗ

![image](https://github.com/revovle2/S-AES/assets/93172576/e2c7cc76-c03e-4a2a-9939-bffb2e976333)

<p align="center">图18 双重加密cquse</p>

解密结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/70bfe8e3-c21f-4e3e-a476-b9401604100c)

<p align="center">图19 双重解密硚됄Ї琊ࡗ</p>

同时，我们选择明文 重庆大学大数据与软件学院 密钥1 0111010101001010 密钥2 0001000111010011

结果如下 加密得到ꓹ㎜毭㟼毭莨觡꧶㒹㟼䰖

![image](https://github.com/revovle2/S-AES/assets/93172576/2c8a3777-00db-4a05-880f-4c1e1c32715c)

<p align="center">图20 双重加密重庆大学大数据与软件学院</p>

随后我们对密文进行解密，结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/9693ec46-2c0a-4003-8ec0-e5b5a256d882)

<p align="center">图21 双重解密ꓹ㎜毭㟼毭莨觡꧶㒹㟼䰖得到重庆大学大数据与软件学院</p>

至此，关卡4-1已经通过，随后来到关卡4-2

###### 4.2 中间相遇攻击

假设你找到了使用相同密钥的明、密文对(一个或多个)，请尝试使用中间相遇攻击的方法找到正确的密钥Key(K1+K2)。

我们采用关卡4-1的两组明文密文 cquse+硚됄Ї琊ࡗ的中间相应攻击结果如下


![image](https://github.com/revovle2/S-AES/assets/93172576/7679c270-2ba4-446c-b0b3-272c7b5c1da4)

<p align="center">图22 中间相遇攻击4-1第一组数据</p>

破解结果两个key为 0100111111011110+1000010100001010

而我们测试加密明文cquse 密钥1 密钥2 分别为0100111111011110  1000010100001010  测试结果如下：得到密文硚됄Ї琊ࡗ

破解结果与加密一致

我们选择 重庆大学大数据与软件学院 与 ꓹ㎜毭㟼毭莨觡꧶㒹㟼䰖 来破解
加密时密钥分别为密钥1 0111010101001010 密钥2 0001000111010011

结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/090fbdb3-aaa3-4951-84cf-fbd299ca68b9)

<p align="center">图23 中间相遇攻击4-1第二组数据</p>

至此，4-2关卡中测试全部通过！

###### 4.3 三重加密

将S-AES算法通过三重加密进行扩展，下面两种模式选择一种完成：(1)按照32 bits密钥Key(K1+K2)的模式进行三重加密解密，(2)使用48bits(K1+K2+K3)的模式进行三重加解密。
在本程序中，三重加密GUI如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/f442425f-618a-441a-a24d-2823c74fdcf3)
<p align="center">图24 三重加密GUI</p>

三个按钮可以分别随机生成密钥，当第一第二个密钥输入，而第三个密钥未输入时，采用32bits密钥 K1+k2的模式进行三重加密triple S-AES，而三个密钥都输入时，使用48bits(K1+K2+K3)的模式进行三重加解密。

我们选择测试明文 CQU 采用32bits进行三重加密，密钥1 2分别为 0000100111100110  1011110111101100 加密得到密文늌胺ヱ ，结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/2b913630-b6ee-4538-8b51-c3531ad92e73)

<p align="center">图25 三重加密CQU 模式一</p>

解密结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/e044ffbb-bbe0-4a1d-8c4e-63f9fb0a7692)

<p align="center">图26 三重解密到CQU 模式一</p>

随后我们同样加密CQU 采用模式二：48bits三重加密 密钥3为 0000100001100001  加密得到 密文：냱฼㸸 结果如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/6e94f9aa-78be-45b0-9dd6-6a44f1dcad07)

<p align="center">图27 三重加密CQU 模式二</p>

随后我们对密文进行解密：

![image](https://github.com/revovle2/S-AES/assets/93172576/18f0f9b5-8237-4b88-bf61-5e5a27f7e109)

<p align="center">图28 三重解密到CQU 模式二</p>

当然，如果加密密钥不足会有提示：

![image](https://github.com/revovle2/S-AES/assets/93172576/98a5a269-bed3-4b31-82cc-2604239549cc)

<p align="center">图29 密钥不足</p>

至此，4-3关卡已经完美通过，第四关已经打通！

#### 第五关 工作模式

基于S-AES算法，使用密码分组链(CBC)模式对较长的明文消息进行加密。注意初始向量(16 bits) 的生成，并需要加解密双方共享。在CBC模式下进行加密，并尝试对密文分组进行替换或修改，然后进行解密，请对比篡改密文前后的解密结果。

CBC模式的GUI如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/0aa54110-2bc0-4243-ba67-c1b437da20c1)
<p align="center">图30 基于S-AES的CBC加密UI</p>

我们选用较长的明文  He still alive , he still survive ! uzi , yyds! 
使用密钥 0000001000001110 初始向量为 0011010111110110

加密结果如下：ꊝᖀ垾驖사ี炗ퟕ䷺긨ࡘ᧤턆蠽暘⌵ᒳݙ셀ꌤ꼶褜㫜䥔嫛엮⢌⺷힧�㻘嘹춎瑎�嗑슞瞮ल潚ﾰƯ嵭諣蚷矱

![image](https://github.com/revovle2/S-AES/assets/93172576/f620df95-24af-47b6-a002-4cb686b25b9f)


<p align="center">图31 基于S-AES的CBC加密较长的明文</p>

解密结果：

![image](https://github.com/revovle2/S-AES/assets/93172576/a093c787-ffbc-4af5-8f6e-021d7fa7dfbb)

<p align="center">图32 基于S-AES的CBC解密较长的密文</p>

随后，我们对密文分组进行修改再解密：

![image](https://github.com/revovle2/S-AES/assets/93172576/24995034-d5e2-4941-b0d8-c9b69bb0942d)

<p align="center">图33 将某个字符改成1</p>

![image](https://github.com/revovle2/S-AES/assets/93172576/a17ca622-90b5-4777-a9be-6352b5b212ff)
<p align="center">图34 替换密文分组</p>
发现解密结果与原文有不少差异
至此，第五关通关，测试完美结束。
谢谢您对闯关报告的观看！

[TOC]

## 开发手册

#### 1、算法简介

​	S-AES是一个面向教育的算法，但不是安全的加密算法。它与AES的性质和结构类似，但使用的参数更少。明文分组和密钥长度均为16比特。

​	1、密钥扩展。
​		S-AES将初始的16位密钥扩展成48位密钥，以便每轮都可以使用一个不同的轮密钥。

​	2、加密算法。
​		加密算法使用四个不同的函数或变换：密钥加(A~k~ )、半字节替代(NS)、行位移(SR)和列混淆(MC)。
$$
加密算法：C=A_{k_2}(SR(NS(A_{k_1}(MC(SR(NS(A_{k_0}(P))))))))
$$
​	3、解密算法。
​		它本质上是加密算法的逆运算。
$$
解密算法：P=A_{k_0}(INS(ISR(IMC(A_{k_1}(INS(IRS(A_{k_2}(C))))))))
$$
​	4、拓展功能。
​		本项目除了支持16位文本和16位密钥的加密解密功能外，还实现了对ASCLL字符串，中文，任意位数二进制文本(位数不足16的倍数将左补0)的加密解密，以及二重加密，中间相遇攻击，三重加密，CBC模式加密解密模块。提供了GUI便于用户操作。

### 2、详细介绍

#### 2.1 基本功能模块

```` java
//D.2.1 密钥加     text:状态矩阵 key:密钥
    static  String[]  addKey(String[] text,String[] key){
        String[] s = new String[4];
        for(int i = 0; i<4; i++){
            s[i]=Integer.toBinaryString(
                    Integer.parseInt(text[i],2)^
                            Integer.parseInt(key[i],2));

            while(s[i].length()<4){ //左补0
                s[i]="0"+s[i];
            }
        }
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
	//NS
    static String[] NS(String[] text){
        String s[] = new String[4];
        for(int i=0;i<4;i++){
            int x = Integer.parseUnsignedInt(text[i].substring(0,2),2);
            int y = Integer.parseUnsignedInt(text[i].substring(2,4),2);
            s[i] = SBox[x][y];
        }
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
	//_NS
    static String[] _NS(String[] Text){
        String s[] = new String[4];
        for(int i=0;i<4;i++){
            int x = Integer.parseUnsignedInt(Text[i].substring(0,2),2);
            int y = Integer.parseUnsignedInt(Text[i].substring(2,4),2);
            s[i] = _SBox[x][y];
        }
        return s;
    }

//D.2.4 列混淆
	// 模x^4+x+1的GF(2^4)上的乘法表
    static String[][] GFmlp= {            {"0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000","0000"},
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
	//列混淆 MC
static String[] MC(String[] Text){
    int[] a ={Integer.parseInt(Text[0],2),Integer.parseInt(Text[1],2),Integer.parseInt(Text[2],2),Integer.parseInt(Text[3],2)};
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
    return s;
};
	//逆列混淆
static String[] _MC(String[] Text){
        int[] a ={Integer.parseInt(Text[0],2),Integer.parseInt(Text[1],2),Integer.parseInt(Text[2],2),Integer.parseInt(Text[3],2)};
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
        return s;
    }

//D3 密钥扩展
    //RCON轮常数
    static String[] RC={"10000000","00110000"};
	//密钥扩展
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
````

### 2.2 加密解密算法

```` java
//加密算法
public static String encrypt(String plaintext, String key){
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
    
    	//密文数组
        String[] ciphertext = 			addKey(SR(NS(addKey(MC(SR(NS(addKey(plainText,Key01)))),Key23))),Key45);
    
        return ciphertext[0]+ciphertext[1]+ciphertext[2]+ciphertext[3];
    }


//解密算法
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
    
    	//明文数组
        String[] plaintext = addKey(_NS(SR(_MC(addKey(_NS(SR(addKey(cipherText,Key45))),Key23)))),Key01);
        return plaintext[0]+plaintext[1]+plaintext[2]+plaintext[3];
    }
````

### 2.3 扩展算法

#### 2.3.1 字符串加密、解密

​	支持两种格式：二进制字符串类型以及普通字符串类型（包括ASCll码字符、中文字符等）

```` java
//加密字符串
    public static String encryptString(String plainText, String key) {
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
                ciphertext += Character.toString((char) 			Integer.parseInt(cipherBinaryText, 2));
            }
        }
        return ciphertext;
    }

 //解密字符串
    public static String decodeString(String cipherText, String key){
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
````

#### 2.3.2 双重加密、双重解密

​	采用两个密钥对文本进行加密解密。

```` java
 //双重加密
    public static String doubleEncrypt(String plainText, String key1, String key2){
        return encryptString(encryptString(plainText,key1),key2);
    }
//双重解密
    public static String doubleDecode(String cipherText, String key1, String key2){
        return decodeString(decodeString(cipherText,key2),key1);
    }
````

#### 2.3.3 中间相遇攻击

​	该算法时间复杂度较高，运行需要等待一段时间。

```` java
 //中间相遇攻击
    public static ArrayList Meet_in_the_middle_attack(String plainText, String cipherText){

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
````

#### 2.3.4 三重加密解密

​	支持两个密钥或者三个密钥。

```` java
//三重加密
        //Key(k1+k2) 模式
    public static String tripleEncrypt(String plainText, String key1, String key2){
        return encryptString(decodeString(encryptString(plainText,key1),key2),key1);
    }
        //Key(k1+k2+k3) 模式
    public static String tripleEncrypt(String plainText, String key1, String key2, String key3){
        return encryptString(encryptString(encryptString(plainText,key1),key2),key3);
    }

//三重解密
        //Key(k1+k2) 模式
    public static String tripleDecode(String cipherText, String key1, String key2){
        return decodeString(encryptString(decodeString(cipherText,key1),key2),key1);
    }
        //Key(k1+k2+k3) 模式
    public static String tripleDecode(String cipherText, String key1, String key2, String key3){
        return decodeString(decodeString(decodeString(cipherText,key3),key2),key1);
    }
````

#### 2.3.5 CBC工作模式

```` java
/*********************************生成初始向量****************************************/
    public static String generateVI(){
        Random r = new Random();
        String VI = Integer.toBinaryString(r.nextInt(65536));
        while(VI.length()<16){
            VI="0"+VI;
        }
        System.out.println(VI);
        return VI;
    }

/*********************************CBC加密*******************************************/
    //CBC加密
    public static String CBC_Encrypt(String plainText, String key, String IV){
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

/*********************************CBC解密*******************************************/
    public static String CBC_Decode(String cipherText, String key, String IV){
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
````

#### 2.3.6 GUI页面

```` java
import test.SAES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;




public class mainui extends JFrame{
    JFrame window1=new JFrame("S—AES普通加解密") ;
    //ui1 SAES
    JLabel lb1=new JLabel();
    JLabel lb2=new JLabel();
    JLabel lb3=new JLabel();
    JLabel lb4=new JLabel();
    JLabel message=new JLabel();
    JTextField input=new JTextField();
    JTextField keyfield=new JTextField();
    JTextField encry_output=new JTextField();
    JTextField decry_output=new JTextField();
    JButton encry_btn=new JButton("加密");
    JButton decry_btn=new JButton("解密");
    JButton randomkey=new JButton("点击生成随机密钥");
    JSeparator line1 =new JSeparator(JSeparator.HORIZONTAL);
    JSeparator line2 =new JSeparator(JSeparator.HORIZONTAL);
    //ui2 dual SAES
    JLabel lb12=new JLabel();
    JLabel lb22=new JLabel();
    JLabel lb32=new JLabel();
    JLabel lb42=new JLabel();
    JLabel lb52=new JLabel("密钥2:");
    JLabel message2=new JLabel();
    JTextField input2=new JTextField();
    JTextField keyfield2=new JTextField();
    JTextField keyfiedld22=new JTextField();
    JTextField encry_output2=new JTextField();
    JTextField decry_output2=new JTextField();
    JButton encry_btn2=new JButton("加密");
    JButton decry_btn2=new JButton("解密");
    JButton randomkey2=new JButton("点击生成随机密钥1");
    JButton randomkey22=new JButton("点击生成随机密钥2");
    JSeparator line12 =new JSeparator(JSeparator.HORIZONTAL);
    JSeparator line22 =new JSeparator(JSeparator.HORIZONTAL);

    //ui3 triple SAES
    JLabel lb13=new JLabel();
    JLabel lb23=new JLabel();
    JLabel lb33=new JLabel();
    JLabel lb43=new JLabel();
    JLabel lb53=new JLabel("密钥2");
    JLabel lb533=new JLabel("密钥3");
    JLabel message3=new JLabel();
    JTextField input3=new JTextField();
    JTextField keyfield3=new JTextField();
    JTextField keyfield33=new JTextField();
    JTextField keyfield333=new JTextField();

    JTextField encry_output3=new JTextField();
    JTextField decry_output3=new JTextField();
    JButton encry_btn3=new JButton("加密");
    JButton decry_btn3=new JButton("解密");
    JButton randomkey3=new JButton("点击生成随机密钥1");
    JButton randomkey33=new JButton("点击生成随机密钥2");
    JButton randomkey333=new JButton("点击生成随机密钥3");
    JSeparator line13 =new JSeparator(JSeparator.HORIZONTAL);
    JSeparator line23 =new JSeparator(JSeparator.HORIZONTAL);

    //ui4 CRC SAES
    JLabel lb14=new JLabel();
    JLabel lb24=new JLabel();
    JLabel lb34=new JLabel();
    JLabel lb44=new JLabel();
    JLabel lb54=new JLabel();

    JLabel message4=new JLabel();
    JTextField input4=new JTextField();
    JTextField keyfield4=new JTextField();
    JTextField keyfield44=new JTextField();
    JTextField encry_output4=new JTextField();
    JTextField decry_output4=new JTextField();
    JButton encry_btn4=new JButton("加密");
    JButton decry_btn4=new JButton("解密");
    JButton randomkey4=new JButton("点击生成随机密钥");
    JButton random4=new JButton("生成随机的IV");
    JSeparator line14 =new JSeparator(JSeparator.HORIZONTAL);
    JSeparator line24 =new JSeparator(JSeparator.HORIZONTAL);

    //ui5
    JLabel plaintext =new JLabel("请输入明文：");
    JLabel ciphertext=new JLabel("请输入密文：");
    JLabel result=new JLabel("破解结果：");
    JLabel message5=new JLabel("1");
    JTextArea resultfield=new JTextArea();
    JTextField plainfield =new JTextField();
    JTextField cipherfield=new JTextField();
    JButton start=new JButton("开始破解");
    JSeparator line5=new JSeparator(JSeparator.HORIZONTAL);

    public  mainui(){
        setVisible(true);
        maininit();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void maininit(){
        this.setTitle("S-AES");
        this.setSize(800,600);
        //设置常驻屏幕中央
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth=(int)screen.getWidth();
        int screenHeight=(int)screen.getHeight();
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        this.setLocation(x,y);

        //多panel切换
        JTabbedPane tabbedPane=new JTabbedPane();
        JPanel jp =new JPanel(null);
        JPanel jp2 =new JPanel(null);
        JPanel jp3 =new JPanel(null);
        JPanel jp4 =new JPanel(null);
        JPanel jp5 =new JPanel(null);
        this.add(tabbedPane);
        tabbedPane.add(jp);
        tabbedPane.add(jp2);
        tabbedPane.add(jp3);
        tabbedPane.add(jp4);
        tabbedPane.add(jp5);

        tabbedPane.addTab("SAES",null,jp,"此为最原始的S-AES");
        tabbedPane.addTab("dual-SAES ",null,jp2,"此为二重加密的S-AES");
        tabbedPane.addTab("triple-SAES",null,jp3,"此为三重加密的S-AES");
        tabbedPane.addTab("CRC-SAES",null,jp4,"此为按照CRC加密的S-AES");
        tabbedPane.addTab("middle-meet-attack",null,jp5,"此为S-AES的破解");
        //this.add(jp);
        lb1.setText("请输入你要加密的明文或要解密的密文：");
        lb2.setText("请输入二进制密钥:");
        lb3.setText("加密结果：");
        lb4.setText("解密结果：");
        message.setText("1");
        lb12.setText("请输入你要加密的明文或要解密的密文：");
        lb22.setText("请输入二进制密钥1:");
        lb52.setText("请输入二进制密钥2:");
        lb32.setText("加密结果：");
        lb42.setText("解密结果：");
        message2.setText("1");
        lb13.setText("请输入你要加密的明文或要解密的密文：");
        lb23.setText("请输入二进制密钥1:");
        lb53.setText("请输入二进制密钥2:");
        lb533.setText("请输入二进制密钥3:");
        lb33.setText("加密结果：");
        lb43.setText("解密结果：");
        message3.setText("1");
        lb14.setText("请输入你要加密的明文或要解密的密文：");
        lb24.setText("请输入二进制密钥:");
        lb54.setText("随机数IV:");
        lb34.setText("加密结果：");
        lb44.setText("解密结果：");
        message4.setText("1");



        //设置布局
        //A-AES
        lb1.setBounds(50,40,250,50);
        lb2.setBounds(50,100,200,50);
        lb3.setBounds(50,250,100,50);
        lb4.setBounds(50,300,100,50);
        message.setBounds(50,400,100,50);
        input.setBounds(300,40,250,40);
        keyfield.setBounds(300,100,250,40);
        encry_output.setBounds(300,250,250,40);
        decry_output.setBounds(300,300,250,40);
        randomkey.setBounds(300,170,130,30);
        encry_btn.setBounds(650,40,70,30);
        decry_btn.setBounds(650,100,70,30);
        line1.setBounds(0,210,800,2);
        line2.setBounds(0,450,800,2);

        //dual-SAES组件分布
        lb12.setBounds(50,40,250,50);
        lb22.setBounds(50,100,200,50);
        lb52.setBounds(50,150,200,50);
        lb32.setBounds(50,300,100,50);
        lb42.setBounds(50,350,100,50);
        message2.setBounds(50,400,100,50);
        input2.setBounds(300,40,250,40);
        keyfield2.setBounds(300,100,250,40);
        keyfiedld22.setBounds(300,150,250,40);
        encry_output2.setBounds(300,300,250,40);
        decry_output2.setBounds(300,350,250,40);
        randomkey2.setBounds(150,230,140,30);
        randomkey22.setBounds(300,230,140,30);
        encry_btn2.setBounds(650,40,70,30);
        decry_btn2.setBounds(650,100,70,30);
        line12.setBounds(0,270,800,2);
        line22.setBounds(0,450,800,2);

        //triple-AES组件分布
        lb13.setBounds(50,40,250,50);
        lb23.setBounds(50,100,200,50);
        lb53.setBounds(50,150,200,50);
        lb533.setBounds(50,200,200,50);
        lb33.setBounds(50,350,100,50);
        lb43.setBounds(50,400,100,50);
        message3.setBounds(50,480,100,50);
        input3.setBounds(300,40,250,40);
        keyfield3.setBounds(300,100,250,40);
        keyfield33.setBounds(300,150,250,40);
        keyfield333.setBounds(300,200,250,40);
        encry_output3.setBounds(300,350,250,40);
        decry_output3.setBounds(300,400,250,40);
        randomkey3.setBounds(150,260,140,30);
        randomkey33.setBounds(300,260,140,30);
        randomkey333.setBounds(450,260,140,30);
        encry_btn3.setBounds(650,40,70,30);
        decry_btn3.setBounds(650,100,70,30);
        line13.setBounds(0,310,800,2);
        line23.setBounds(0,450,800,2);
        //CRC S-AES

        lb14.setBounds(50,40,250,50);
        lb24.setBounds(50,100,200,50);
        lb54.setBounds(50,150,200,50);
        lb34.setBounds(50,300,100,50);
        lb44.setBounds(50,350,100,50);
        message4.setBounds(50,400,100,50);
        input4.setBounds(300,40,250,40);
        keyfield4.setBounds(300,100,250,40);
        keyfield44.setBounds(300,150,250,40);
        encry_output4.setBounds(300,300,250,40);
        decry_output4.setBounds(300,350,250,40);
        randomkey4.setBounds(150,230,140,30);
        random4.setBounds(300,230,140,30);
        encry_btn4.setBounds(650,40,70,30);
        decry_btn4.setBounds(650,100,70,30);
        line14.setBounds(0,270,800,2);
        line24.setBounds(0,450,800,2);

        //5.attack
        plaintext.setBounds(50,40,250,50);
        ciphertext.setBounds(50,110,250,50);
        plainfield.setBounds(300,42,250,40);
        cipherfield.setBounds(300,112,250,40);
        result.setBounds(50,300,200,40);
        resultfield.setBounds(250,200,400,300);
        line5.setBounds(0,185,800,2);
        start.setBounds(650,100,85,30);
        message5.setBounds(50,400,200,40);


        //添加组件
        //S-AES
        jp.add(lb1);
        jp.add(lb2);
        jp.add(lb3);
        jp.add(lb4);
        jp.add(message);
        jp.add(input);
        jp.add(keyfield);
        jp.add(encry_output);
        jp.add(decry_output);
        jp.add(decry_btn);
        jp.add(encry_btn);
        jp.add(randomkey);
        jp.add(line1);
        jp.add(line2);

        //dual-SAES
        jp2.add(lb12);
        jp2.add(lb22);
        jp2.add(lb32);
        jp2.add(lb42);
        jp2.add(lb52);
        jp2.add(message2);
        jp2.add(input2);
        jp2.add(keyfield2);
        jp2.add(keyfiedld22);
        jp2.add(encry_output2);
        jp2.add(decry_output2);
        jp2.add(decry_btn2);
        jp2.add(encry_btn2);
        jp2.add(randomkey2);
        jp2.add(randomkey22);
        jp2.add(line12);
        jp2.add(line22);

        //triple SAES
        jp3.add(lb13);
        jp3.add(lb23);
        jp3.add(lb33);
        jp3.add(lb43);
        jp3.add(lb53);
        jp3.add(lb533);
        jp3.add(message3);
        jp3.add(input3);
        jp3.add(keyfield3);
        jp3.add(keyfield33);
        jp3.add(keyfield333);
        jp3.add(encry_output3);
        jp3.add(decry_output3);
        jp3.add(decry_btn3);
        jp3.add(encry_btn3);
        jp3.add(randomkey3);
        jp3.add(randomkey33);
        jp3.add(randomkey333);
        jp3.add(line13);
        jp3.add(line23);

        //CRC SAES
        jp4.add(lb14);
        jp4.add(lb24);
        jp4.add(lb34);
        jp4.add(lb44);
        jp4.add(lb54);
        jp4.add(message4);
        jp4.add(input4);
        jp4.add(keyfield4);
        jp4.add(keyfield44);
        jp4.add(encry_output4);
        jp4.add(decry_output4);
        jp4.add(decry_btn4);
        jp4.add(encry_btn4);
        jp4.add(randomkey4);
        jp4.add(random4);
        jp4.add(line14);
        jp4.add(line24);

        //mid-meet attack
        jp5.add(plaintext);
        jp5.add(ciphertext);
        jp5.add(plainfield);
        jp5.add(cipherfield);
        jp5.add(result);
        jp5.add(resultfield);
        jp5.add(start);
        jp5.add(line5);
        jp5.add(message5);

        //字体部分
        Font font = new Font("微软雅黑", Font.PLAIN, 12);
        randomkey.setFont(font);
        encry_btn.setFont(font);
        decry_btn.setFont(font);
        start.setFont(font);






        //1.S-ASE
        randomkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfield.setText(key);
            }
        });
        encry_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现A-DES加密的代码
                if (input.getText().trim().equals("")){
                    message.setText("<html><font color='red'>请输入明文!</font> </html>");

                } else if (keyfield.getText().trim().equals("")) {
                    message.setText("<html><font color='red'>请输入密钥!</font> </html>");

                } else {
                    String plaintext = input.getText();
                    String key = keyfield.getText();
                    String ciphertext = SAES.encryptString(plaintext, key);
                    // resultLabel.setText("<html><font color='green'>加密结果:</font> " + ciphertext + "</html>");
                    encry_output.setText("加密结果:" + ciphertext);
                }
            }
        });

        decry_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现A-DES解密的代码
                String ciphertext = input.getText();
                String key = keyfield.getText();
                String plaintext = SAES.decodeString(ciphertext, key);

                decry_output.setText("解密结果:" + plaintext );
            }
        });
        //2.dual S-AES
        randomkey2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfield2.setText(key);
            }
        });
        randomkey22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfiedld22.setText(key);
            }
        });
        encry_btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现A-DES加密的代码
                if (input2.getText().trim().equals("")){
                    message2.setText("<html><font color='red'>请输入明文!</font> </html>");

                } else if (keyfield2.getText().trim().equals("")) {
                    message2.setText("<html><font color='red'>请输入密钥1!</font> </html>");}
                else if (keyfiedld22.getText().trim().equals("")) {
                    message2.setText("<html><font color='red'>请输入密钥2!</font> </html>");}

                else {
                    String plaintext = input2.getText();
                    String key1 = keyfield2.getText();
                    String key2=keyfiedld22.getText();
                    String ciphertext = SAES.doubleEncrypt(plaintext,key1,key2);
                    // resultLabel.setText("<html><font color='green'>加密结果:</font> " + ciphertext + "</html>");
                    encry_output2.setText("加密结果:" + ciphertext);
                }
            }
        });
        decry_btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现dual-A-DES解密的代码
                String ciphertext = input2.getText();
                String key1 = keyfield2.getText();
                String key2=keyfiedld22.getText();
                String plaintext = SAES.doubleDecode(ciphertext,key1,key2);

                decry_output2.setText("解密结果:" + plaintext );
            }
        });




        //3.triple S-AES
        randomkey3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfield3.setText(key);
            }
        });
        randomkey33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfield33.setText(key);
            }
        });
        randomkey333.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfield333.setText(key);
            }
        });
        encry_btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现A-DES加密的代码
                if (input3.getText().trim().equals("")){
                    message3.setText("<html><font color='red'>请输入明文!</font> </html>");

                } else if (keyfield3.getText().trim().equals("")) {
                    message3.setText("<html><font color='red'>请输入密钥1!</font> </html>");}
                else if (keyfield33.getText().trim().equals("")) {
                    message3.setText("<html><font color='red'>请输入密钥2!</font> </html>");}

                else {
                    String plaintext = input3.getText();
                    String key1 = keyfield3.getText();
                    String key2=keyfield33.getText();
                    String key3=keyfield333.getText();
                    if(keyfield333.getText().trim().equals("")) {
                        String ciphertext = SAES.tripleEncrypt(plaintext, key1, key2);
                        // resultLabel.setText("<html><font color='green'>加密结果:</font> " + ciphertext + "</html>");
                        encry_output3.setText("加密结果:" + ciphertext);
                    } else if (keyfield333.getText().length()==16) {
                        String ciphertext=SAES.tripleEncrypt(plaintext,key1,key2,key3);
                        encry_output3.setText("加密结果："+ ciphertext);
                    }
                    else {
                        message3.setText("<html><font color='red'>请输入正确的密钥3!</font> </html>");
                    }
                }
            }
        });
        decry_btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //三重加密的SAES分为两种
                String ciphertext = input3.getText();
                String key1 = keyfield3.getText();
                String key2=keyfield33.getText();
                String key3=keyfield333.getText();
                if(key3.trim().equals("")) {
                    String plaintext = SAES.tripleDecode(ciphertext, key1, key2);
                    decry_output3.setText("解密结果:" + plaintext );
                }
                else {
                    String plaintext = SAES.tripleDecode(ciphertext, key1, key2,key3);
                    decry_output3.setText("解密结果:" + plaintext );
                }

            }
        });
        //4.CBC AES
        randomkey4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(65536);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<16){
                    key="0"+key;
                }
                keyfield4.setText(key);
            }
        });
        random4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String four =SAES.generateVI();
                keyfield44.setText(four);
            }
        });
        encry_btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现CBC A-DES加密的代码
                if (input4.getText().trim().equals("")){
                    message4.setText("<html><font color='red'>请输入明文!</font> </html>");

                } else if (keyfield4.getText().trim().equals("")) {
                    message4.setText("<html><font color='red'>请输入密钥1!</font> </html>");}
                else if (keyfield44.getText().trim().equals("")) {
                    message4.setText("<html><font color='red'>请输入IV!</font> </html>");}

                else {
                    String plaintext = input4.getText();
                    String key1 = keyfield4.getText();
                    String four= keyfield44.getText();
                    String ciphertext = SAES.CBC_Encrypt(plaintext,key1,four);
                    // resultLabel.setText("<html><font color='green'>加密结果:</font> " + ciphertext + "</html>");
                    encry_output4.setText("加密结果:" + ciphertext);
                }
            }
        });
        decry_btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现CBC-A-DES解密的代码
                String ciphertext = input4.getText();
                String key1 = keyfield4.getText();
                String four=keyfield44.getText();
                String plaintext = SAES.CBC_Decode(ciphertext,key1,four);

                decry_output4.setText("解密结果:" + plaintext );
            }
        });

        //5.中间相遇攻击
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num=0;
                String cipher=cipherfield.getText();
                String plain=plainfield.getText();
                if(plain.trim().equals("")){
                    message5.setText("<html><font color='red'>请输入待破解的明文!</font> </html>");
                } else if (cipher.trim().equals("")) {
                    message5.setText("<html><font color='red'>请输入待破解的密文!</font> </html>");
                }
                else {
                    message5.setText("破解中，请稍后....");

                    while (resultfield.getText().trim().equals("")){

                        ArrayList keylist=SAES.Meet_in_the_middle_attack(plain,cipher);

                        for(int i=0;i<keylist.size();i++){

                            resultfield.setText((String)keylist.get(i)+"\n");
                            num++;
                        }
                        message5.setText("破解成功！");
                        if(num==0){
                            resultfield.setText("未找到结果！");
                        }                     
                    }
                }
            }
        });

    }
    public static void main(String[] args) {
        mainui ui=new mainui();

    }
}
````

## 用户指南
#### 开始之前

1.1 引言

欢迎欢迎使用S-AES Java程序用户手册。本手册旨在为您提供关于S-AES（Simplified Advanced Encryption Standard）程序的详细信息，以及如何使用它来进行数据加密和解密操作。S-AES是一种简化版的高级加密标准（AES），旨在提供更易于理解和实施的加密算法。虽然S-AES相对于标准的AES算法来说更简单，但它仍提供了一定级别的数据保护，适用于教育、学术和特定嵌入式系统的应用。

1.2 关于S-AES算法

S-AES程序的目标是为用户提供一种简化的数据加密工具，使其能够以可靠的方式保护敏感信息。通过本程序，您可以轻松地对数据进行加密，以防止未经授权的访问者或恶意攻击者访问您的敏感信息。S-AES支持16位密钥长度，提供了基本的数据保护，并可用于多种应用场景。

1.3 关于本手册

本用户手册将为您提供使用S-AES程序所需的所有信息。以下是本手册的主要内容：

- 安装和环境要求：了解如何准备您的环境以使用S-AES程序。
- 快速入门：快速开始使用程序的简单步骤，以便您迅速上手。
- 功能和选项：详细介绍程序支持的功能和选项，帮助您了解其潜力。
- 示例用法：演示如何使用程序来执行常见任务，以便您更好地理解其用途。
- 加密和解密指南：详细说明如何使用程序进行加密和解密操作，包括输入数据格式和密钥管理。
- 错误处理：帮助您解决可能出现的问题和错误的建议。
- 安全性注意事项：提供保护您的数据和密钥的最佳实践建议。
- 技术支持：获取程序的技术支持和报告问题的途径。
- 我们鼓励您仔细阅读本手册，以充分了解S-AES程序的功能和用法。如果您有任何疑问或需要进一步协助，请随时联系我们的技术支持团队。

感谢您选择S-AES程序，我们希望它能满足您的数据加密需求并提供可靠的数据保密，您将会了解如何安装程序、运行简单的加密和解密操作，以及利用不同选项和功能进行更高级的操作。我们将提供示例代码、命令行参数说明和错误处理指南，以帮助您充分利用该程序。

#### 2.安装与配置

本S-AES分为三个Java文件，其中，程序的主要算法功能的实现在SAES.java文件里实现，剩下的mainui.java 为java swing的java文件，还有Main.java为运行的主函数。要运行本程序，只需把三个java文件放在同一个java project里，运行 Main.java 即可

2.2 本程序运行在java jdk 1.8以上，使用前请确保java版本不要过于老旧

#### 3.快速入门

这个快速入门指南将引导您在最短的时间内开始使用S-AES Java程序。S-AES是一个用于数据加密和解密的简化版高级加密标准（AES）实现。您可以使用这个程序来保护敏感数据的机密性。

- 步骤 1：环境准备

在开始之前，确保您已满足以下环境要求：

安装Java jdk 1.8 (JDK)。
下载将S-AES 三个Java程序放在同一个packet。 

首先，确保您已经成功安装并配置了S-DES Java程序，按照用户手册中的指南进行设置。如果您还没有完成这一步，请返回至安装与配置部分。

- 步骤2  运行程序
   运行程序 Main.java ,如果你要在mainui.java运行程序也可以，只需编写一个 public static void main（String[] args）{}里new一个mainui即可

  ![image](https://github.com/revovle2/S-AES/assets/93172576/31997039-ddee-47ab-b019-66f59d80873f)

- 步骤3 加密操作
  现在，假设你有一个明文需要加密，在GUI的第一个输入框输入你要加密的密文
  
  ![image](https://github.com/revovle2/S-AES/assets/93172576/b012bb6f-b2a2-4bd3-a8e7-bb48fd98b191)

  随后输入16bits 密钥，你可以手动输入，也可以随机生成，本程序设计了随机生成密钥的按钮，点击即可
  ![image](https://github.com/revovle2/S-AES/assets/93172576/5c6825a0-6e3a-4978-9e5c-7a2d4d3bf2ca)

  点击加密按钮即可
  ![image](https://github.com/revovle2/S-AES/assets/93172576/c23af724-ece4-4a50-bc16-d6a49f87653f)

  要解密的话，同样也是在第一个输入框输入密文，解密即可

  ![image](https://github.com/revovle2/S-AES/assets/93172576/5db0a813-9513-4e43-a525-6b134ba38f4a)

  未输入明文或密文时，ui会有提示：
  ![image](https://github.com/revovle2/S-AES/assets/93172576/d0108e2a-6b82-4577-9fd5-ae6687405227)

  
  未输入明文：

  ![image](https://github.com/revovle2/S-AES/assets/93172576/05fa3b78-4403-4d38-8264-206a9cccd681)

  随后，本程序还提供了双重加密以及三级加密，CBC加密，以及对双重加密的破解功能
  
  - 双重加密
    使用方法类似于S-AES ，输入两个密钥即可

    ![image](https://github.com/revovle2/S-AES/assets/93172576/0a051bc2-ab40-4740-9f3d-4d1845578ca1)

    加密成功：

    ![image](https://github.com/revovle2/S-AES/assets/93172576/e6808bc8-20ef-474f-a205-d6583eed170b)
    
    解密同理


 
  - 三次加密
 
    当只输入两个密钥时，采用32bits加密方法，当三个密钥均输入时，采用48bits加密
 
    两个密钥

    ![image](https://github.com/revovle2/S-AES/assets/93172576/14468019-f8b0-41e4-97ea-1650c81fdf79)

    三个密钥：

    ![image](https://github.com/revovle2/S-AES/assets/93172576/497844ad-e37d-4d3a-afe8-3aadc485c5fd)


    

 
  - 基于S-AES的cbc加密
 
    使用方法同二重加密
 
  - 对双重加密的中间相遇攻击
    
    输入已知的明文密文，点击开始破解，等待一会即可

    ![image](https://github.com/revovle2/S-AES/assets/93172576/531e398a-b495-4ab8-b9c5-35f41d1f3df7)

    - 完成！
   
    - 您已经成功执行了S-AES加密和解密操作。这是一个简单的示例，用于演示程序的基本功能。请记住，S-AES算法是用于教育和学习的，而不是用于高度安全的加密任务。在实际应用中，您可能需要更强大的加密算法。

对于更高级的用法和更多选项，请查看用户手册中的其他部分。如果您遇到任何问题或需要进一步的帮助，请参考错误处理与故障排除部分或联系我们的支持团队。

感谢您选择使用S-AES Java程序！

#### 4. S-AES算法解释



4.1 基本原理图


![image](https://github.com/revovle2/S-AES/assets/93172576/98174586-59fd-4e40-8076-fa66318c27f8)

4.2 基本原理

S-AES 的加密算法使用16位明文和16位密文作为输入，生成16位密文进行输出，解密同理。加密算法使用4个不同的函数或变换:密钥加(Ak)、半字节代替(NS)、行移位（SR)和列混淆（MC )。加密算法被组织成三轮。第0轮是简单的密钥加轮;第1轮是包含4个函数的完整轮;第2轮仅包含3个函数。每轮都使用16位密钥的密钥加函数。初始的16位密钥被扩展到48位，以便每轮都可使用一个不同的轮密钥。

下面介绍这些操作。


4.2.2.1 轮密钥加

密钥加函数将16位状态矩阵与16位轮密钥逐位异或。图D.4将其描述为逐列操作，但它也可视为逐半字节操作或逐位操作。下面是一个例子。

![image](https://github.com/revovle2/S-AES/assets/93172576/bfe00f1f-34e4-4967-a504-dfe265358a47)

4.2.2.2 半字节代替

半字节代替函数是简单的查表操作（见图D.4 )。AES定义一个4×4的半字节值矩阵，称为S盒,其中包含所有4位值的排列。状态中的每个半字节都按以下方式映射到一个新的半字节:半字节最左侧的2位用作行值，最右侧的2位用作列值。这些行和列的值用作S盒中选择唯一的4位输出值的索引。例如，十六进制值A代表S盒中第2行、第2列的值0。因此值A被映射为值0。

![image](https://github.com/revovle2/S-AES/assets/93172576/f3f6b229-850a-4c65-9e29-fbf1d12146d2)

4.2.2.3 行移位

![image](https://github.com/revovle2/S-AES/assets/93172576/9c95b875-8a73-46e4-9072-c5d68686dc38)


4.2.2.4 列混淆
![image](https://github.com/revovle2/S-AES/assets/93172576/deab51d9-2a95-4253-8593-33be6dc2a857)

4.2.2.5 拓展密钥

![image](https://github.com/revovle2/S-AES/assets/93172576/f195a20f-480f-4ef5-b39b-689b4a96e56b)

而函数中的S盒构建方法如下：

![image](https://github.com/revovle2/S-AES/assets/93172576/81b9a5c9-a57b-49f1-9ca7-c1d317609fdd)

S-AES算法的这些步骤共同构成了加密和解密的过程。它是一种轻量级的加密算法，用于保护数据的机密性。请注意，虽然S-AES算法对于教育和学习非常有用，但在实际应用中，可能需要更强大的加密算法以满足更高的安全要求。

4.3 其他基本原理

4.3.1 双重加密

双重加密原理：进行两轮的S-AES加密，两次使用不同的密钥

![image](https://github.com/revovle2/S-AES/assets/93172576/51a4e9e0-4926-40cb-a114-5139a30e0b05)

4.3.2 三重加密

进行三轮的S-AES加密 ，有两种模式：

![image](https://github.com/revovle2/S-AES/assets/93172576/3c5fadb6-08f3-4c2f-8e13-2adc025823c4)

![image](https://github.com/revovle2/S-AES/assets/93172576/eae72f6c-a222-4dee-aa1a-9e0e281295b2)

4.3.3 CBC加密 

 一般用于加密较长的明文

 原理如图

 ![image](https://github.com/revovle2/S-AES/assets/93172576/99d1794c-6bfd-4287-ae39-a661e320fed9)

 即每一个block加密所需的密钥由上一个block参与构成

 4.3.4 中间相遇攻击

 ![image](https://github.com/revovle2/S-AES/assets/93172576/1595588e-6260-4499-a548-dd998c9b5e66)







#### 5.错误处理与故障排除

5.1 错误消息
在程序出现错误时，可能会生成错误消息，以指示问题所在。请注意并记录错误消息的内容，以便更轻松地解决问题。

5.2 常见问题解决方法

问题 1：程序无法启动或闪退
解决方法：
确保已经正确安装了Java运行时环境（JRE）。您可以在命令行中运行java -version来检查是否安装了JRE。
检查程序的命令行参数是否正确。确保文件路径和选项的拼写正确。 

问题2. 无效的密钥文件：
如果密钥文件损坏或包含无效数据，加密或解密操作可能会失败。
解决方案：验证密钥文件的完整性。确保密钥文件包含有效的密钥数据。

问题3. 密钥长度错误：

如果密钥长度与S-AES所需的16位不匹配，操作可能无法执行。
解决方案：使用128位的密钥，因为S-AES仅支持这种密钥长度。

问题4. 内存不足：

如果系统内存不足，程序可能无法正常运行。
解决方案：关闭其他占用大量内存的应用程序，或者考虑在更强大的计算机上运行程序。

问题5. 加密和解密失败：

加密或解密操作失败，导致生成的密文或明文不正确。

解决方案：确保输入数据、密钥和其他参数正确。检查是否遵循正确的加密和解密步骤。

问题6. 未捕获的异常：

问题：程序可能会抛出未捕获的异常，导致崩溃。
解决方案：实现适当的异常处理，以捕获并记录异常信息，而不是崩溃。这可以帮助您更容易识别问题。

问题7. 密钥安全性问题：密钥的丢失或泄露可能导致数据的安全性问题。

解决方案：妥善保管密钥文件，确保只有授权的人可以访问它。定期更改密钥以提高安全性。

问题8. 编译错误：如果您需要手动编译程序，编译错误可能会发生。

解决方案：仔细检查编译错误消息，查找并修复代码中的问题。

5.3 联系支持
如果您遇到无法解决的问题或需要进一步的帮助，请不要犹豫，联系我们的支持团队。您可以通过以下方式联系我们：

电子邮件：20214511@cqu.edu.cn 

QQ:1635031764  2161949425


我们的支持团队将尽力协助您解决问题，并提供所需的帮助和支持。

5.4 总结
在使用S-AES Java程序时，可能会出现各种问题，但大多数问题都可以通过仔细检查和一些简单的步骤来解决。本节提供了一些常见问题的解决方法，以及联系支持团队的方式。我们希望您能够顺利使用S-AES Java程序，同时也感谢您的支持。

#### 6.测试用例

##### 6.1 加密二进制明文

场景：您希望使用S-AES Java程序加密一条简短的二进制消息。

准备明文消息，例如：1101001111010011。
再选择一个16位的S-AES的二进制密钥。
在GUI中对应位置输入即可

##### 6.2 加密ASCII码

场景：您希望使用S-DES Java程序加密一条简短的英文句子消息。

准备明文消息，例如：hello world 。
选择一个16位的S-AES密钥。
在GUI中对应位置输入即可

##### 6.3 加密中文

场景：您希望使用S-DES Java程序加密一条简短的中文句子消息。

准备明文消息，例如：重庆大学 。
选择一个16位的S-AES密钥。
在GUI中对应位置输入即可

##### 6.4 使用其他加密功能
 如果你想使用CBC算法或者二重、三重S-AES，按照GUI的提示输入相应的明文密钥即可，输入无限制，如有疑问，请查看3. 快速入门 以及 5.错误处理与故障排除

#### 7.性能和安全性注意事项

使用S-AES算法的Java程序时，性能和安全性都是非常重要的考虑因素。以下是性能和安全性方面的一些注意事项：

##### 7.1性能注意事项：

- 优化算法： S-AES是一个相对简单的加密算法，通常在性能方面表现良好。然而，您可以进一步优化算法以提高性能，例如通过更高效的数据结构和算法选择。

- 并行处理： 考虑在多核处理器上使用并行处理，以提高加密和解密操作的速度。这可以通过多线程或并行计算来实现。

- 数据块大小： 在处理大型数据集时，考虑将数据分成适当大小的块，以减少内存和处理要求。这可以提高性能。

- 硬件加速： 如果您有访问硬件加速的机会（如AES-NI指令集），考虑使用硬件加速来加快加密和解密过程。

- 输入/输出缓冲： 使用合理大小的输入和输出缓冲区，以减少I/O操作的频率，从而提高性能。

##### 7.2安全性注意事项：

- 密钥管理： 妥善管理加密密钥是安全性的核心。确保密钥存储和传输是安全的，只有授权用户可以访问它。

- 随机性： 在加密中使用足够的随机性是关键。确保使用强密码生成随机密钥，以抵抗各种攻击。

- 数据完整性： 确保数据在传输过程中不被篡改，可以使用消息认证码（MAC）或数据完整性检查来验证数据完整性。

- 保护加密上下文： 不仅要保护密钥，还要确保保护整个加密上下文，包括初始化向量（IV）和其他参数。

- 安全协议： 考虑使用安全通信协议（如TLS/SSL）来加密数据的传输，以保护数据在传输中的安全性。

- 密钥轮换： 定期更改加密密钥，以降低潜在攻击的风险。

- 安全审计： 定期对加密操作和密钥管理进行审计，以确保系统的安全性。

- 不安全性警告： 在程序中实现足够的错误处理和日志记录，以检测潜在的不安全操作或攻击。


##### 7.3 总结
综合来说，性能和安全性是权衡关系，您需要根据您的应用需求来确定如何平衡二者。确保在程序设计和部署中考虑到这些注意事项，以实现既高性能又安全的数据加密和解密操作。

#### 8. Q&A

本节包含了一些常见的问题和解答，以帮助您更好地理解和使用S-DES Java程序。

##### 8.1 一般问题

Q1： 什么是S-AES？

A；S-AES（Simplified Advanced Encryption Standard） 是一种轻量级的数据加密算法，用于保护数据的机密性。它是一种用于教育和学习的算法，不适用于高度安全性要求的任务。

Q2：我可以在哪里找到S-AES的更多信息？

A ：您可以查阅相关的加密学教材或网络资源，以深入了解S-DES算法的工作原理。

8.2 安装和配置

Q3：如何安装S-AES Java程序？

A3：请参考用户手册的安装与配置部分，其中包含了安装程序的详细步骤。

Q4：我需要安装特定的Java版本吗？

A4：是的，S-AES Java程序需要特定的Java运行时环境（JRE）。请确保您安装了兼容的Java版本。

8.3 加密和解密操作

Q5：如何选择一个合适的S-AES密钥？

A5：S-AES密钥应该是16位的二进制数字（0和1的组合）。选择一个足够复杂和随机的密钥以提高安全性。

Q6：S-AES支持哪些密钥长度？

A6： S-AES仅支持16-48位密钥长度。不支持AES中的192位和256位密钥长度。

Q7：我如何生成16-48位的安全密钥？

A7： 生成强密码是生成密钥的关键。您可以使用密码管理工具或随机密码生成器来创建具有足够熵的密钥。确保不使用弱密码，以提高安全性。同时本UI提供随机生成，使用后请确保你已经记住了密钥

Q8：S-AES适用于哪些加密任务？

A8：S-AES是一个用于教育和学习的算法，适用于基本的加密任务。对于高度安全性要求的任务，请使用更强大的加密算法，如AES。


Q9：我忘记了加密操作使用的密钥。我该怎么办？

A9： 如果您忘记了密钥，不可能恢复加密数据。密钥管理是极其重要的。建议定期备份密钥，并存储备份的密钥在安全的地方。

Q10：如何知道S-AES是否足够安全？

A10： S-AES是一个相对较简单的加密算法，适用于一些教育和研究目的。但对于高度敏感的数据，建议使用更复杂的加密算法，如标准AES，以获得更高级别的安全性。

Q11：我可以在S-AES中使用不同的加密模式吗？

A11： S-AES通常使用ECB（电子密码本）模式，但可以根据需要实现其他加密模式，如CBC（密码分组链接）或CTR（计数器）模式。

Q12：我遇到了加密/解密速度很慢的问题。有什么方法可以改进性能？

A12： 您可以尝试使用并行处理、硬件加速、更高效的数据结构或优化算法来提高性能。确保输入/输出缓冲适当大小，以减少I/O开销。

Q13：S-AES是否支持文件夹加密？

A13： S-AES通常用于文件级别的加密，但您可以实现文件夹级别的加密，将多个文件分别加密，然后组织它们在一个文件夹中。

Q14：我遇到了未捕获的异常。如何排除错误？

A14： 未捕获的异常通常是编程错误或运行时问题的迹象。确保实现了适当的异常处理来捕获异常并记录相关信息，以帮助识别和解决问题。

8.4 故障排除

Q15：程序无法启动，如何解决？

A15：请确保已正确安装Java运行时环境（JRE）并检查程序的命令行参数是否正确。

Q16：如何处理加密或解密操作失败？

A16：请检查密钥、输入文件和选项是否正确，并确保文件存在和包含有效数据。

Q17:代码出现乱码怎么办？

A17：将编码从UTF-8 改为GBK

8.5 安全性

Q18：S-AES算法安全吗？

A18：S-AES算法是用于教育和学习的算法，不适用于高度安全性要求的任务。对于高度安全性要求的任务，请使用更强大的加密算法。

Q19：如何确保密文的安全性？

A19：加密后的数据应妥善存储，只有授权的用户才能访问密文。此外，密钥的安全性也是保障密文安全的关键。

8.6 联系支持

Q20：如何联系支持团队获取帮助？

A20：您可以通过电子邮件或访问我们的支持页面联系支持团队，详细信息请参阅用户手册的联系信息部分。

8.7 总结

本节提供了一些常见问题和解答，希望能帮助您更好地使用S-AES Java程序。如果您遇到其他问题或需要进一步的帮助，请不要犹豫，联系我们的支持团队。



#### 9.附录
9.1 参考文献

\[1\]\ 密码编码学与网络安全——原理与实践（第八版）ISBN 97871214065098 William Stalling著 陈晶等人译

#### 10.致谢

我们要衷心感谢以下个人和组织，因为他们的支持和贡献使S-AES Java程序得以成功开发和维护：

- 胡海波老师：感谢老师在课堂上授予我们密码编码学相关知识，帮助我们改进程序的质量。

- 开发人员： 刘星 赵铨

无论是提供反馈、技术支持、贡献代码还是其他方式，他们的帮助都是非常宝贵的。没有他们的支持，这个项目将不会如此成功。


#### 11.历史版本
版本v1.0 初始版本 2023.10.22

v1.1  最新版本 修复了加密中文时的部分BUG 2023.10.23
 


















    





  

  

- 























































