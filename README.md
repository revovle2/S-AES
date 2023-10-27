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

















