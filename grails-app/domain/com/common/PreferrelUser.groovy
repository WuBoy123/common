package com.common

class PreferrelUser {
	
	String type
	Integer sort=1
	
	static belongsTo=[user:User]

    static constraints = {
    }
}
