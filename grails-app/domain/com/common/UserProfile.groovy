package com.common


/**
 * UserProfile
 * 用户资料
 */
class UserProfile {
	
	String fullName //全名
	Date dateOfBirth //生日
	String gender = "M" //性别
	String email  
	String mobile
	String constellatory//星座
	String location//常驻�?
	String note//个人说明（个性签名）
	
	/* Automatic timestamping of GORM */
	Date dateCreated
	Date lastUpdated

	static belongsTo = [user : User]
	
    static constraints = {
		fullName(nullable: true)
		email(email: true, unique: true)
		dateOfBirth(nullable: true)
		gender(inList: ["M", "F"])
		mobile(nullable: true)
    }
}
