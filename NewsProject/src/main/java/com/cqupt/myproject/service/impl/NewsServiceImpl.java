package com.cqupt.myproject.service.impl;

import com.cqupt.myproject.dao.NewsDao;
import com.cqupt.myproject.entity.News;
import com.cqupt.myproject.service.NewsService;
import com.cqupt.myproject.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新闻业务层的实现类
 * @author hetiantian
 * @version 2017/11/9.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

   /**
    * 查询news表中的数据条数
    * @return
    * */
    public int queryCount() {
        return newsDao.queryCount();
    }

    /**
     * 分页查询
     * @param currentPage 当前页数
     * @return
     * */
    public PageUtil<News> queryNewsByPage(Integer currentPage) {
        PageUtil<News> pageUtil = new PageUtil<News>();

        //封装当前页数
        pageUtil.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize = 2;
        pageUtil.setPageSize(pageSize);

        //封装总记录数
        int totalCount = newsDao.queryCount();
        pageUtil.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        int totalPage = (int)Math.ceil(tc / pageSize);//向上取整
        pageUtil.setTotalPage(totalPage);

        //计算开始取数据的位置
        int start = (currentPage - 1) * pageSize;
        int size = pageUtil.getPageSize();

        //封装每页显示的页数
        List<News> newsList = newsDao.queryNewsByPage(start, size);

        pageUtil.setLists(newsList);
        return pageUtil;
    }
}
