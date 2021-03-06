package com.jf.common.base;

public class Page {
	Integer page;
	Integer pagesize;
	Integer defaultPage=1;
	Integer defaultPagesize=10;
	
	public Integer getPage() {
		if(page==null){
			page=defaultPage;
		}
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPagesize() {
		if(pagesize==null){
			pagesize=defaultPagesize;
		}
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getLimitStart() {
		if(page==null){
			page=defaultPage;
		}
		if(pagesize==null){
			pagesize=defaultPagesize;
		}
		return (page-1)*pagesize;
	}
	public Integer getLimitSize() {
		if(pagesize==null){
			pagesize=defaultPagesize;
		}
		return pagesize;
	}

}
