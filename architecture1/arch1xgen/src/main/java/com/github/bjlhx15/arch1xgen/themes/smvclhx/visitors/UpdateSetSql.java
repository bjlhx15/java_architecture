package com.github.bjlhx15.arch1xgen.themes.smvclhx.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;

public class UpdateSetSql implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"voFields")).getValues();

		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < voFields.length; i++) {
			buffer.append(voFields[i]+"=#{"+voFields[i]+"}");
			if(i<voFields.length-1){
				buffer.append(",");
			}
		}
		return buffer.toString();
	}
}
