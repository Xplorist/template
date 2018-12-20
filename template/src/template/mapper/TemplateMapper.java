package template.mapper;

import java.util.List;

import template.model.TemplateBean;

/**
 *	送檢取料mapper
 * @author C3005579
 * @date 2018年9月8日 下午3:16:24 
 */
public interface TemplateMapper {
	// 查詢template list
	List<TemplateBean> queryTemplatList();
	
	// 新增template
	void addTemplate();
}


