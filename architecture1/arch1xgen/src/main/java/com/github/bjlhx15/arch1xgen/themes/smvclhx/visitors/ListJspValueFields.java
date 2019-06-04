package com.github.bjlhx15.arch1xgen.themes.smvclhx.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class ListJspValueFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"voFields")).getValues();
		String moduleName = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"moduleName")).getValue();
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < voFields.length; i++)
			buffer.append((new StringBuilder("<td>${m.")).append(voFields[i])
					.append("}</td>\n\t").toString());

		buffer.append("<td>\n\t");
		buffer.append((new StringBuilder(
				"<a href=\"${pageContext.request.contextPath}/"))
				.append(moduleName)
				.append("/toUpdate/${m.uuid}\">修改 </a> |\n\t")
				.toString());
		buffer.append((new StringBuilder(
				"<a href=\"${pageContext.request.contextPath}/"))
				.append(moduleName)
				.append("/toDelete/${m.uuid}\">删除</a>\n")
				.toString());
		buffer.append("</td>\n");
		return buffer.toString();
	}
}
