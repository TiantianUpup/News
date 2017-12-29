# News
###
自己随便搭的项目，主要是想模仿腾讯新闻做一个简陋的查看新闻的网页。使用intercept拦截登陆验证，以及使用一下redis缓存新闻
###
###
遇到的问题记录一下  

1.一不小心拦截了所有请求，导致无法启动  

2.静态资源的访问  

3.Cannot get Jedis connection; nested exception is redis无法获得连接使用缓存的时候出错  

4.对结果进行封装到一个result，但没有对其进行序列化，报SerializationException异常

5.java.lang.Integer cannot be cast to java.lang.String   redis键是一个对象类型

6.HTTP Status 405 - Request method 'GET' not supported
###
