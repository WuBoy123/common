package com.common;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

public class CustomNamingStrategy extends ImprovedNamingStrategy {

	private static final long serialVersionUID = -4180278415622444773L;

	public String classToTableName(String className) {
		return StringHelper.unqualify(className.toLowerCase());
	}

	public String propertyToColumnName(String propertyName) {
		return propertyName;
	}
}