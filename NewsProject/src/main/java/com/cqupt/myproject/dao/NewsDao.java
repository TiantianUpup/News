package com.cqupt.myproject.dao;

import com.cqupt.myproject.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 新闻的持久化层
 * @author hetiantian
 * @version  2017/11/9.
 */
@Repository
public interface NewsDao {
    List<News> queryNewsByPage(@Param("start") Integer currentPage, @Param("size") Integer size);
    int queryCount();
}
