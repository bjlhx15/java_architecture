package com.github.bjlhx15.themes.smvcsm.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class QueryJspJson implements Visitor {

	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		String voFields[] = ((ExtendConfModel) moduleConf.getMapExtends().get(
				"voFields")).getValues();
		StringBuffer buffer = new StringBuffer("var json ='{");

		for (int i = 0; i < voFields.length; i++){
			if(i==0){
				buffer.append("\""+voFields[i]+"\":\"'+$(\"#"+voFields[i]+"\").val()+'\"");
			}else{
				buffer.append(",\""+voFields[i]+"\":\"'+$(\"#"+voFields[i]+"\").val()+'\"");
			}
		}
		buffer.append("}';");
		return buffer.toString();
	}
}
