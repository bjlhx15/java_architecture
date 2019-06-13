


// Source File Name:   VoProperty.java

package com.github.bjlhx15.themes.ssh3.visitors;

import com.github.bjlhx15.xgen.genconf.vo.ExtendConfModel;
import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.template.visitors.TemplateElement;
import com.github.bjlhx15.xgen.template.visitors.Visitor;
import java.util.Map;

public class VoProperty
    implements Visitor
{

    public VoProperty()
    {
    }

    public Object visitTemplateElement(TemplateElement element)
    {
        ModuleConfModel moduleConf = element.getModuleConf();
        String voFields[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFields")).getValues();
        String voFieldsTypes[] = ((ExtendConfModel)moduleConf.getMapExtends().get("voFieldsTypes")).getValues();
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < voFields.length; i++)
            buffer.append((new StringBuilder("private ")).append(voFieldsTypes[i]).append(" ").append(voFields[i]).append(";\n\t").toString());

        return buffer.toString();
    }
}
