package com.common

class ObjFavor {
	
	Long objectId
	String objectType
	static belongsTo=[user:User]
	
    static constraints = {
    }
}
