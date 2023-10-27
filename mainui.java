package org.example;

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
       JLabel copyright=new JLabel("design by @B5 513");
    JLabel copyright2=new JLabel("design by @B5 513");

    JLabel copyright3=new JLabel("design by @B5 513");
    JLabel copyright4=new JLabel("design by @B5 513");
    JLabel copyright5=new JLabel("design by @B5 513");
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
    JLabel message5=new JLabel("5");
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
           message2.setText("2");
           lb13.setText("请输入你要加密的明文或要解密的密文：");
           lb23.setText("请输入二进制密钥1:");
           lb53.setText("请输入二进制密钥2:");
           lb533.setText("请输入二进制密钥3:");
           lb33.setText("加密结果：");
           lb43.setText("解密结果：");
           message3.setText("3");
           lb14.setText("请输入你要加密的明文或要解密的密文：");
           lb24.setText("请输入二进制密钥:");
           lb54.setText("随机数IV:");
           lb34.setText("加密结果：");
           lb44.setText("解密结果：");
           message4.setText("4");



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
           copyright.setBounds(400,400,200,40);

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
           copyright2.setBounds(400,400,200,40);

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
           copyright3.setBounds(400,480,200,40);
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
           copyright4.setBounds(400,400,200,40);

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
           copyright5.setBounds(50,480,200,40);


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
           jp.add(copyright);
           jp2.add(copyright2);
           jp3.add(copyright3);
           jp4.add(copyright4);
           jp5.add(copyright5);

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

           Font fontcopy=new Font("宋体" ,Font.ITALIC,10);
           copyright.setFont(fontcopy);
           copyright2.setFont(fontcopy);
           copyright3.setFont(fontcopy);
           copyright4.setFont(fontcopy);
           copyright5.setFont(fontcopy);






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
                           //resultfield.setText(SAES.Meet_in_the_middle_attack(plain,cipher));

                       }

                   }
               }
           });

       }




    public static void main(String[] args) {
       mainui ui=new mainui();

    }
}
