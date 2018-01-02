package com.cqupt.myproject.service;

import com.cqupt.myproject.entity.News;
import com.cqupt.myproject.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 新闻业务层
 * @author hetiantian
 * @version 2017/11/9.
 */
public interface NewsService {
    int queryCount();
    PageUtil<News> queryNewsByPage(Integer currentPage);
    List<News> queryNewsByPageOptimization(Integer lastPageRecord);
}
