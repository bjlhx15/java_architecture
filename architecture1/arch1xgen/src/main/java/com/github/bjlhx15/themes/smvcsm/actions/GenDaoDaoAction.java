package com.github.bjlhx15.themes.smvcsm.actions;

import com.github.bjlhx15.xgen.genconf.vo.ModuleConfModel;
import com.github.bjlhx15.xgen.geninvocation.BaseGenAction;
import com.github.bjlhx15.xgen.geninvocation.decorator.GenComponent;

public class GenDaoDaoAction extends BaseGenAction {

	public Object initObject() {
		return "";
	}

	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}

	public Object executeDecorators(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		return gc.operation(moduleConf, "GenDaoDao", obj);
	}

	public GenComponent beforeAction(ModuleConfModel moduleConf) {
		return super.defaultBeforeAction(moduleConf);
	}
}
