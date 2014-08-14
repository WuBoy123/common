package com.common

class City {
	String searchIndex
	String value
	static belongsTo=[state:State]

	static mapping = {
		version false
	}

	static constraints = {
		searchIndex nullable: true
		value unique: true
	}
}
