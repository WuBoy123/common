package com.common

class User {

	transient springSecurityService

	String username
	String password
	String email 
	int userType = 0 
	
	boolean emailVerified 
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	String qqOpenId 
	String qqAccessToken
	String sinaOpenId
	String sinaAccessToken
	Date dateCreated
	Date lastUpdated
//	DateTime lastVisit
	String loginBind = "0"
	
	Boolean flag = true
    String userPhotoUrl=""


	String checkOutStatus="0"//用作摄影师用户审�?

	static mapping = {
		password column: '`password`'
	}

	static constraints = {
		username blank: false, unique: true
		password blank: false
		email(email: true, unique: true,nullable:true)
		//lastVisit(nullable:true)
		qqOpenId(nullable:true, unique:false)
		qqAccessToken(nullable:true, unique:false)
		sinaOpenId(nullable:true, unique:false)
		sinaAccessToken(nullable:true, unique:false)
	}
	
	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
	
	public String encodePassword(String pass){
		return springSecurityService.encodePassword(pass)
	}

}
