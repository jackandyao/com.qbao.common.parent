package com.qbao.recommend.util.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sjzhangjun
 * 通用分页工具类，该工具类分页指定泛型的List对集合
 * @param <E> 指定的泛型
 */
public class PageUtil<E> {
	/**
	 * 每页显示的记录数
	 */
	private int pageSize = 6;

	/**
	 * 总记录数
	 */
	private int totalRecord;

	/**
	 * 分页切割的启始点
	 */
	private int startIndex;

	/**
	 * 分页切割的结束点
	 */
	private int endIndex;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 当前页数
	 */
	private int currentPage;

	/**
	 * 总记录集合
	 */
	private List<E> totalList;

	public PageUtil(List<E> totalList) {
		super();
		this.totalList = totalList;
		init();
	}

	/**
	 * 初始化该分页对象
	 */
	private void init() {
		if (null != totalList) {
			totalRecord = totalList.size();
			if (totalRecord % this.pageSize == 0) {
				this.totalPage = totalRecord / this.pageSize;
			} else {
				this.totalPage = totalRecord / this.pageSize + 1;
			}
		}
	}

	/**
	 * 得到分页后的数据
	 * @return 分页数据
	 */
	public List<E> getPage(int currentPage) {
		this.currentPage = currentPage;
		if (currentPage <= 0) {
			this.currentPage = 1;
		}
//		if (currentPage >= this.totalPage) {
//			this.currentPage = this.totalPage;
//		}
		List<E> subList = new ArrayList<E>();
		if (null != this.totalList) {
			subList.addAll(this.totalList.subList(getStartIndex(), getEndIndex()));
		}
		return subList;
	}

	/**
	 * 设置每页显示的记录条数,如果不设置则默认每页显示6条记录
	 * @param pageSize 每页显示的记录条数(值必需介于2~100之间)
	 */
	public void setPageSize(int pageSize) {
		if (pageSize >= 2 && pageSize <= 100) {
			this.pageSize = pageSize;
			init();
		}
	}

	public int getStartIndex() {
		if (null == this.totalList) {
			return 0;
		}
		this.startIndex = (getCurrentPage() - 1) * this.pageSize;
		if (startIndex > totalRecord) {
			startIndex = totalRecord;
		}
		if (startIndex < 0) {
			startIndex = 0;
		}
		return startIndex;
	}

	public int getEndIndex() {
		if (null == this.totalList) {
			return 0;
		}
		endIndex = getStartIndex() + this.pageSize;
		if (endIndex < 0) {
			endIndex = 0;
		}
		if (endIndex < getStartIndex()) {
			endIndex = getStartIndex();
		}
		if (endIndex > this.totalRecord) {
			endIndex = this.totalRecord;
		}
		return endIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public boolean isEndPage() {
		return this.currentPage == this.totalPage;
	}

	/**
	 * 获取下一页的页数
	 * @return 下一页的页数
	 */
	public int getNextPage() {
		int nextPage = this.currentPage + 1;
//		if (nextPage > this.totalPage) {
//			nextPage = this.totalPage;
//		}
		if (nextPage <= 0) {
			nextPage = 1;
		}
		return nextPage;
	}

	/**
	 * 获取上一页的页数
	 * @return 上一页的页数
	 */
	public int getLastPage() {
		int lastPage = this.currentPage - 1;
		if (lastPage > this.totalPage) {
			lastPage = this.totalPage;
		}
		if (lastPage <= 0) {
			lastPage = 1;
		}
		return lastPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	
	/**
	 * demo
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1,2,3,4,5,6,7,8,8,9,0,11,1,2,3,4,3,1,45,6,5,7".split("\\D"));
		
		PageUtil<String> util = new PageUtil<String>(list);
		//util.setPageRecords(6);//如果不设置则默认每页显示6条记录
		System.out.println(util.getPage(util.getNextPage()));
		System.out.println(util.getPage(util.getNextPage()));
		System.out.println(util.getPage(util.getNextPage()));
		System.out.println(util.getPage(util.getNextPage()));
		System.out.println(util.getPage(util.getNextPage()));
		System.out.println(util.getPage(util.getLastPage()));
		System.out.println(util.getPage(util.getLastPage()));
		System.out.println(util.getPage(util.getLastPage()));
		System.out.println(util.getPage(util.getLastPage()));
		
	}
}
