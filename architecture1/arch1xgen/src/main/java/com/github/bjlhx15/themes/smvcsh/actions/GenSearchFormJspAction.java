// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2014-1-28 15:51:13
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!

// Source File Name:   GenSearchFormJspAction.java

package com.github.bjlhx15.themes.smvcsh.actions;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.BaseGenAction;
import com.github.bjlhx15.xgen.geninvocation.decorator.GenComponent;

public class GenSearchFormJspAction extends BaseGenAction
{

    public GenSearchFormJspAction()
    {
    }

    public Object initObject()
    {
        return "";
    }

    public Object execute(ModuleConfModel moduleConf, Object obj)
    {
        return obj;
    }

    public Object executeDecorators(ModuleConfModel moduleConf, Object obj, GenComponent gc)
    {
        return gc.operation(moduleConf, "GenSearchFormJsp", obj);
    }

    public GenComponent beforeAction(ModuleConfModel moduleConf)
    {
        return super.defaultBeforeAction(moduleConf);
    }
}