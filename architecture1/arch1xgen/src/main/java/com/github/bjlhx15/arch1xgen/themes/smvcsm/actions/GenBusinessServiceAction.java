package com.github.bjlhx15.arch1xgen.themes.smvcsm.actions;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.BaseGenAction;
import com.github.bjlhx15.xgen.geninvocation.decorator.GenComponent;

public class GenBusinessServiceAction extends BaseGenAction {

	public Object initObject() {
		return "";
	}

	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}

	public Object executeDecorators(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		return gc.operation(moduleConf, "GenBusinessService", obj);
	}

	public GenComponent beforeAction(ModuleConfModel moduleConf) {
		return super.defaultBeforeAction(moduleConf);
	}
}
