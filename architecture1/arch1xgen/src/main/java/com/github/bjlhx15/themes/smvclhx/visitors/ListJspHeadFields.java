package com.github.bjlhx15.themes.smvclhx.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class ListJspHeadFields implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFieldsNames[] = ((ExtendConfModel) moduleConf.getMapExtends()
				.get("voFieldsNames")).getValues();
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < voFieldsNames.length; i++)
			buffer.append((new StringBuilder("<td>")).append(voFieldsNames[i])
					.append("</td>\n\t").toString());

		return buffer.toString();
	}
}
