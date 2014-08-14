package com.common

class Country {
	String searchIndex
	String value
	
	static hasMany=[state:State]

	static mapping = {
		version false
	}

	static constraints = {
		searchIndex nullable: true
		value unique: true
	}

}
