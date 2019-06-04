


// Source File Name:   VoToString.java

package com.github.bjlhx15.arch1xgen.themes.ssh3.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class VoToString
    implements Visitor
{

    public VoToString()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFields")).getValues();
        StringBuffer buffer = new StringBuffer("\"Model\"+this.getClass().getName()+\"[");
        for(int i = 0; i < voFields.length; i++)
        {
            String fName = voFields[i];
            buffer.append((new StringBuilder()).append(fName).append("=\" + this.get").append(fName.substring(0, 1).toUpperCase()).append(fName.substring(1)).append("() + \",").toString());
        }

        buffer.append("]\"");
        return buffer.toString();
    }
}
