package com.common

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder

class UserGeneralStyle  implements Serializable{
	
	GeneralStyle style
	User user

	boolean equals(other) {
		if (!(other instanceof UserGeneralStyle)) {
			return false
		}

		other.style?.id == style?.id &&
			other.user?.id == user?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (style) builder.append(style.id)
		builder.toHashCode()
	}

	static UserGeneralStyle get(long userId, long styleId) {
		find 'from UserGeneralStyle where user.id=:userId and style.id=:styleId',
			[userId: userId, styleId: styleId]
	}

	static UserGeneralStyle create(User user, GeneralStyle style, boolean flush = false) {
		new UserGeneralStyle(user: user, style: style).save(flush: flush, insert: true)
	}

	static boolean remove(User user, GeneralStyle style, boolean flush = false) {
		UserGeneralStyle instance = UserGeneralStyle.findByUserAndStyle(user, style)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(User user) {
		executeUpdate 'DELETE FROM UserGeneralStyle WHERE user=:user', [user: user]
	}

	static void removeAll(GeneralStyle style) {
		executeUpdate 'DELETE FROM UserGeneralStyle WHERE style=:style', [style: style]
	}

	static mapping = {
		id composite: ['user', 'style']
		version false
	}
}
