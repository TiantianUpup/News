package com.cqupt.myproject.entity;

import java.io.Serializable;

/**
 * 新闻实体类
 * @author hetiantian
 * @version  2017/11/9.
 */
public class News implements Serializable {
    private static final long serialVersionUID = 528026439035909738L;
    //新闻id
    private Integer newsId;
    //新闻标题
    private String newsTitle;
    //新闻内容
    private String newsContent;

    public News() {
    }

    public News(Integer newsId, String newsTitle, String newsContent) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    //get and set
    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }
}
