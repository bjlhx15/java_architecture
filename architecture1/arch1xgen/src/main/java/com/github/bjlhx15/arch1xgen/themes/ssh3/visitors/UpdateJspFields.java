


// Source File Name:   UpdateJspFields.java

package com.github.bjlhx15.arch1xgen.themes.ssh3.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class UpdateJspFields
    implements Visitor
{

    public UpdateJspFields()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFields")).getValues();
        String voFieldsNames[] = ((ExtendConfModel)moduleConf.getMapExtends().get("colunName_CN")).getValues();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i += 2)
        {
            buffer.append("<tr>\n\t");
            buffer.append((new StringBuilder("<td>")).append(voFieldsNames[i]).append("</td>\n\t").toString());
            buffer.append((new StringBuilder("<td><input type=\"text\" name=\"m.")).append(voFields[i]).append("\" value=\"${m.").append(voFields[i]).append("}\"></td>\n\t").toString());
            if(i < voFields.length - 1)
            {
                buffer.append((new StringBuilder("<td>")).append(voFieldsNames[i + 1]).append("</td>\n\t").toString());
                buffer.append((new StringBuilder("<td><input type=\"text\" name=\"m.")).append(voFields[i + 1]).append("\"  value=\"${m.").append(voFields[i + 1]).append("}\"></td>\n").toString());
            }
            buffer.append("</tr>\n");
        }

        return buffer.toString();
    }
}
