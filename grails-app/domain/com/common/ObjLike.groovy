package com.common

class ObjLike {
	
	Long objectId
	String objectType
	static belongsTo=[user:User]

    static constraints = {
    }
}
