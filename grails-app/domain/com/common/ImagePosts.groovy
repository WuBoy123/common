package com.common

import java.util.Date;

class ImagePosts {
	String title
	String context
	String checkOutStatus="0"
	Date lastUpdated
	static belongsTo=[user:User]
	static mapping = {
	}
	static constraints = {
	}
}
