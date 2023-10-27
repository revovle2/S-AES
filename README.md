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
























































