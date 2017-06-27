package cn.baisee.vo;

import java.util.List;
import java.util.Map;

import cn.baisee.entity.Paper;

public class PageVo {

	private Integer currentPage = 1;// ��ǰҳ
	private Integer pageSize = 4;// ÿҳ������

	private Integer totalCount;// һ��������

	private List<Paper> result;
	
	private List result3;
	
	

	public List getResult3() {
		return result3;
	}

	public void setResult3(List result3) {
		this.result3 = result3;
	}

	private Map<String, Object> params;

	// ��ҳ��
	public Integer getTotalPage() {
		Integer totalPage = (totalCount / pageSize)
				+ (totalCount % pageSize == 0 ? 0 : 1);
		return totalPage;
	}

	
	// ���ط�ҳ��ѯ�ĵ�һ��ֵ
	public Integer getStartIndex() {
		Integer startIndex = (currentPage - 1) * pageSize;
		return startIndex;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<Paper> getResult() {
		return result;
	}

	public void setResult(List<Paper> result) {
		this.result = result;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}


	

	
}
