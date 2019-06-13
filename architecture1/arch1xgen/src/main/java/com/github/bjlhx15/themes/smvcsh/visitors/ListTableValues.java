


// Source File Name:   ListTableValues.java

package com.github.bjlhx15.themes.smvcsh.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class ListTableValues
    implements Visitor
{

    public ListTableValues()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        return genProperties(moduleConf, "voFields");
    }

    private static String genProperties(ModuleConfModel moduleConf, String fieldsName)
    {
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get(fieldsName)).getValues();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i++)
        {
            buffer.append((new StringBuilder("<td>${m.")).append(voFields[i]).append("}</td> ").toString());
            buffer.append("\n\t");
        }

        return buffer.toString();
    }
}
