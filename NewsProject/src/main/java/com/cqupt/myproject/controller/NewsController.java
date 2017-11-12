package com.cqupt.myproject.controller;

import com.cqupt.myproject.entity.News;
import com.cqupt.myproject.service.NewsService;
import com.cqupt.myproject.util.PageUtil;
import com.cqupt.myproject.util.Result;
import com.cqupt.myproject.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 新闻控制器
 * @author hetiantian
 * @version  2017/11/9.
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/queryNewsByPage")
    @ResponseBody
//    @Cacheable( cacheNames="news", key="#result.data.")
    public Result queryNewsByPage() {
        PageUtil<News> pageUtil = newsService.queryNewsByPage(1);
        return ResultUtil.successResult(pageUtil);
    }


}
