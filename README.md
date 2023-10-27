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






