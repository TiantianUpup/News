   package com.cqupt.myproject.controller;

import com.cqupt.myproject.entity.News;
import com.cqupt.myproject.exception.ErrorException;
import com.cqupt.myproject.service.NewsService;
import com.cqupt.myproject.util.PageUtil;
import com.cqupt.myproject.util.Result;
import com.cqupt.myproject.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 新闻控制器
 * @author hetiantian
 * @version  2017/11/9.
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/queryNewsByPage", method = RequestMethod.POST)
    @ResponseBody
    @Cacheable( cacheNames="news", key = "#p0")
    public Result queryNewsByPage(@RequestParam("currentPage") String currentPage) {
        Integer currentPage1 = Integer.valueOf(currentPage);
        PageUtil<News> pageUtil = newsService.queryNewsByPage(currentPage1);
        return ResultUtil.successResult(pageUtil);
    }

    @RequestMapping(value = "/queryNewsByPageOptimization", method = RequestMethod.POST)
    @ResponseBody
    public Result queryNewsByPageOptimization(@RequestParam("lastPageRecord") Integer lastPageRecord) {
        List<News> newsList = newsService.queryNewsByPageOptimization(lastPageRecord);
        return ResultUtil.successResult(newsList);
    }

}
