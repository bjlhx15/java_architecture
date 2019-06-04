package com.github.bjlhx15.arch1xgen.themes.smvclhx.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class QueryModelProperty implements Visitor {
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"qmVoFields")).getValues();
		String voFieldsTypes[] = ((ExtendConfModel) moduleConf.getMapExtends()
				.get("qmVoFieldsTypes")).getValues();
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < voFields.length; i++)
			if (voFields[i] != null && voFields[i].trim().length() != 0)
				buffer.append((new StringBuilder("private "))
						.append(voFieldsTypes[i]).append(" ")
						.append(voFields[i]).append(";\n\t").toString());

		return buffer.toString();
	}
}
