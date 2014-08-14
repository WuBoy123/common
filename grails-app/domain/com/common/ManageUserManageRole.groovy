package com.common

import org.apache.commons.lang.builder.HashCodeBuilder

class ManageUserManageRole implements Serializable {

	private static final long serialVersionUID = 1

	ManageUser manageUser
	ManageRole manageRole

	boolean equals(other) {
		if (!(other instanceof ManageUserManageRole)) {
			return false
		}

		other.manageUser?.id == manageUser?.id &&
		other.manageRole?.id == manageRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (manageUser) builder.append(manageUser.id)
		if (manageRole) builder.append(manageRole.id)
		builder.toHashCode()
	}

	static ManageUserManageRole get(long manageUserId, long manageRoleId) {
		ManageUserManageRole.where {
			manageUser == ManageUser.load(manageUserId) &&
			manageRole == ManageRole.load(manageRoleId)
		}.get()
	}

	static boolean exists(long manageUserId, long manageRoleId) {
		ManageUserManageRole.where {
			manageUser == ManageUser.load(manageUserId) &&
			manageRole == ManageRole.load(manageRoleId)
		}.count() > 0
	}

	static ManageUserManageRole create(ManageUser manageUser, ManageRole manageRole, boolean flush = false) {
		def instance = new ManageUserManageRole(manageUser: manageUser, manageRole: manageRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(ManageUser u, ManageRole r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = ManageUserManageRole.where {
			manageUser == ManageUser.load(u.id) &&
			manageRole == ManageRole.load(r.id)
		}.deleteAll()

		if (flush) { ManageUserManageRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(ManageUser u, boolean flush = false) {
		if (u == null) return

		ManageUserManageRole.where {
			manageUser == ManageUser.load(u.id)
		}.deleteAll()

		if (flush) { ManageUserManageRole.withSession { it.flush() } }
	}

	static void removeAll(ManageRole r, boolean flush = false) {
		if (r == null) return

		ManageUserManageRole.where {
			manageRole == ManageRole.load(r.id)
		}.deleteAll()

		if (flush) { ManageUserManageRole.withSession { it.flush() } }
	}

	static constraints = {
		manageRole validator: { ManageRole r, ManageUserManageRole ur ->
			if (ur.manageUser == null) return
			boolean existing = false
			ManageUserManageRole.withNewSession {
				existing = ManageUserManageRole.exists(ur.manageUser.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['manageRole', 'manageUser']
		version false
	}
}
