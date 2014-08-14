package com.common

class PreferrelCity {
	String type
	Integer sort=1
	
	static belongsTo=[city:City]

    static constraints = {
    }
}
