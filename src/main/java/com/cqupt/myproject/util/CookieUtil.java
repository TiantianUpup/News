package com.cqupt.myproject.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * cookie工具类
 *
 * @author hetiantian
 * @version 2017/12/28.
 */
public class CookieUtil {
    /**
     * 服务器向客户端颁发cookie，在颁发给客户端时先对cookie进行压缩
     * @param response
     * @param name cookie名字
     * @param value cookie值
     * @throws IOException
     * */
    public static void addCookie(HttpServletResponse response, String name, String value) throws IOException {
        System.out.println("进入了方法体...");


        //进行cookie进行压缩
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DeflaterOutputStream dos = new DeflaterOutputStream(bos);

        dos.write(name.getBytes());
        dos.close();
        System.out.println("name: " + name);
        System.out.println("name before compress length: " + name.length());
        String compressName = URLEncoder.encode(new String(bos.toByteArray()), "UTF-8");
//        String compressName = new BASE64Encoder().encode(bos.toByteArray());
        System.out.println("name after compress length: " + compressName.length());
        System.out.println("compressName: " + compressName);

        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        DeflaterOutputStream dos1 = new DeflaterOutputStream(bos1);

        dos1.write(value.getBytes());
        dos1.close();
        System.out.println("value: " + value);
        System.out.println("value before compress length: " + value.length());
        //压缩以后进行编码
        String compressValue = URLEncoder.encode(new String(bos.toByteArray()), "UTF-8");
        System.out.println("value after compress length: " + compressValue.length());
        System.out.println("compressValue: " + compressValue);

        //压缩以后需要使用使用base64进行编码,因为压缩以后存在控制字符，不符合cookie标准
    //        String lastName = URLEncoder.encode(compressName, "UTF-8");
    //        String lastValue = URLEncoder.encode(compressValue, "UTF-8");
    //        System.out.println("lastName: " + lastName);
    //        System.out.println("lastValue: " + lastValue);

        Cookie cookie = new Cookie(compressName, compressValue);
        cookie.setPath("/");  //本域名下contextPath都可以访问该Cookie

        cookie.setMaxAge(Integer.MAX_VALUE);  //失永远保存在浏览器，除非人为进行清理
        System.out.println("发送结束...");
        unCompressCookie(cookie);
        response.addCookie(cookie);  //向客户端发送cookie
    }

    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);  //获得客户端保存的cookie
        //获得指定的cookie
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            //存在则返回这个cookie
            return cookie;
        }else{
            //不存在返回null
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }


   /**
    * 对cookie进行解压和解码
    * */
   public static void unCompressCookie(Cookie c) {
       try {
           ByteArrayOutputStream out = new ByteArrayOutputStream();
           byte[] compress = URLDecoder.decode(c.getName(), "UTF-8").getBytes();
           System.out.println(1);
           ByteArrayInputStream bis = new ByteArrayInputStream(compress);
           System.out.println(2);
           InflaterInputStream inflater = new InflaterInputStream(bis);

           byte[] b = new byte[1024];
           int count;
           System.out.println(3);
           while ((count = inflater.read(b)) >= 0) {
               out.write(b, 0, count);
           }

           inflater.close();
           System.out.println(4);
           String name = new String(out.toByteArray());
           System.out.println("name: " + name);

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
