package com.common

class State {
	
	String searchIndex
	String value
	
	static hasMany=[city:City]
	static belongsTo=[country:Country]

	static mapping = {
		version false
	}

	static constraints = {
		searchIndex nullable: true
		value unique: true
	}
}
