package com.common

class Image {

	String path
	String name
	static belongsTo = [imagePosts:ImagePosts]
    static constraints = {
    }
}
