package com.coder.hotel.util;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/1
 */
public class Page {
    private Long pages;
    private Long page;
    private Long size;
    private Long total;

    public Page(Long pages, Long page, Long size, Long total) {
        this.pages = pages;
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
