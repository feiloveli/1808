package com.jk.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092900627305";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCNrQx1/iFQkWpPu8mXgDezSEtLHGre66lYp5Ys9+aLI5tYRVEaZpFqvdrDqdwZhBDDC8yKD8/YqBSGYbu0BHiVQyskgVMt5WTFNHvQPPeS7ahuHdiK77HNzQaUx2b8H/f1VA9CHC2z7dFfqraP2WGt34VD70OOd+briiigQG/d98ZdXggcDGU443jHl1Wlz5s935GANJjr1j3pJ3louXoiFGvDPPT/QCY8gmd77dvl2u4tLWqgncxmBgnhWonIsF4UYYmcd0qRW2j2/sAoHSjW05k8eI3vWg79rQOG/+EKXVQ72qQI7DLHoOBEh/DRpgXc7w/ldLlZfpn2PloxUtbfAgMBAAECggEASwP+3hcicrOcc/19v29PjulPnMS+PazQbTXHSaY1dyTyYynIyM7YXomKZSHyfbw01+HOeqfmqNROkdz781SOuJHpLRog/eNBmT2x9U/i0vRtw2igOOiz38GYo3x1pjgTJd5NefbLqELbIumUYtR6aQM6X/83aR9JsRvlaPzVftSdpvzJveRS6d2d+O0eWEXWHKi8GihIgtIcxMdT63B1y3oPqyJ/Uc+7ItZtburB18dpr55pONCCkYzqolZxWqN9Iw+uwhdR1STYA3gkM8YZpEjBaNIxHXGxJeDvgho93XrYqyIudYCAIoWInagAQEd4O0QditN7WtMcuCrTet2lOQKBgQDtYjnrDXi6MB8dLgMiEsmnyocAN90JolLujy9TrGN1LQ0uAl1vZefKseObDEplVJD1H1bat4O1eefIJqf/ByetdM8IkDns53P9Kqb3kiIzHvA8y+k1UBaBT4cp93n2YWB0hBHSXHZShKQXrFH+YVJFvDs08+0vGnQs02BoRlRfawKBgQCYyV7YpGMp6kmV+PlmwVRLj74LTde4hKb3sAwL1e62kt3reu9db0WggfwVKLgTvpk3a+14SWhDmU/LRRwkoZ0NjwERtClUZPVCf2smwgGAHSGinaNkC32MqlVKXAJbedlSUTJavTFG8FtM9teg+fmcW2xion8ElPfahl47S4DHXQKBgQDhfvCDz21CeJnlzyKcyHoU0PeDBo4LK85Z3VxYwKZN1fjyHr8BJi2Ux3zteTRmo3l70ERiSfdseZvq7oWhZfuT8yUD/nV4DLmK4WxwOroQE7CkIBOtWCG4voIoJHUPzZqhtB910+12H5f9AO12lp5frhoUCC7kEt4PAtBO3ZgidwKBgCR5vrj91ebF1jeFrxUHBrbbZEWSmfOlR69OSjHxKwJPYce8G7U0wWymW6Y5iGi+UhnXHGRhMhEhYtlmcGeWZcY848Z0OoG5cIwlm1Evc+hADC2kcMOLsreIWsBb4vwvxOBQHjNng4IqE8H2FFiMFTls4h1SKfzQC7QR7CE/z0jJAoGBAOuHqz980kYMCKgXJv7BhxY0LPBxz6lamTZ5fJOastpM91rSMjHooYaUg6wnAzBQ0KMhxkPqPlqNRzQLjvz6I7epg6J24QxFC646w+Ai0UQj1XsZJFhCW64QJskMPGJueyD8kc/r8XTwMAu6GpQPXy6ZClmjoHHEodxfm7v54uJy";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAja0Mdf4hUJFqT7vJl4A3s0hLSxxq3uupWKeWLPfmiyObWEVRGmaRar3aw6ncGYQQwwvMig/P2KgUhmG7tAR4lUMrJIFTLeVkxTR70Dz3ku2obh3Yiu+xzc0GlMdm/B/39VQPQhwts+3RX6q2j9lhrd+FQ+9Djnfm64oooEBv3ffGXV4IHAxlOON4x5dVpc+bPd+RgDSY69Y96Sd5aLl6IhRrwzz0/0AmPIJne+3b5druLS1qoJ3MZgYJ4VqJyLBeFGGJnHdKkVto9v7AKB0o1tOZPHiN71oO/a0Dhv/hCl1UO9qkCOwyx6DgRIfw0aYF3O8P5XS5WX6Z9j5aMVLW3wIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://kyd.free.idcfengye.com/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
