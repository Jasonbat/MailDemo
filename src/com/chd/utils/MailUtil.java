package com.chd.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件发送的工具类
 */
public class MailUtil {
    /**
     * 发送邮件
     *
     * @param to   收件人
     * @param code 激活码
     */
    public static void sendMail(String to, String code) throws Exception {
        //创建连接对象
        Properties pros = new Properties();
        Session session = Session.getInstance(pros, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //需要用户名和密码
                return new PasswordAuthentication("service@store.com", "111");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置邮件信息
        message.setFrom(new InternetAddress("service@store.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //设置邮件主题
        message.setSubject("来自XX网站的激活邮件");
        //设置邮件的正文
        String hs = "localhost:8080/MailDemo/ActiveServlet?code=" + code;
        message.setContent("<h1></h1><h3><a href=" + hs + " >激活链接</a></h3>",
                "text/html;charset=utf-8");
        //发送邮件
        Transport.send(message);
    }
}
