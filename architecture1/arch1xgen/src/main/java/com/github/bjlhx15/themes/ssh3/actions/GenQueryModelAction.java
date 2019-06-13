


// Source File Name:   GenQueryModelAction.java

package com.github.bjlhx15.themes.ssh3.actions;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.BaseGenAction;
import com.github.bjlhx15.xgen.geninvocation.decorator.GenComponent;

public class GenQueryModelAction extends BaseGenAction
{

    public GenQueryModelAction()
    {
    }

    public Object executeDecorators(ModuleConfModel moduleConf, Object obj, GenComponent gc)
    {
        return gc.operation(moduleConf, "GenQueryModel", obj);
    }

    public Object initObject()
    {
        return "";
    }

    public Object execute(ModuleConfModel moduleConf, Object obj)
    {
        return obj;
    }

    public GenComponent beforeAction(ModuleConfModel moduleConf)
    {
        return super.defaultBeforeAction(moduleConf);
    }
}
