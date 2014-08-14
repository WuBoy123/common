import com.common.ManageRole
import com.common.ManageUser
import com.common.ManageUserManageRole

class BootStrap {

    def init = { servletContext ->
		def adminUser = ManageUser.findByUsername("admin")
		def adminRole = ManageRole.findByAuthority("ROLE_ADMIN") ?: new ManageRole(authority: 'ROLE_ADMIN').save()
		def userRole = ManageRole.findByAuthority("ROLE_USER") ?: new ManageRole(authority: 'ROLE_USER').save()
		def advanceUserRole = ManageRole.findByAuthority("ROLE_ADVANCE_USER") ?: new ManageRole(authority: 'ROLE_ADVANCE_USER').save()
		def switchUserRole = ManageRole.findByAuthority("ROLE_SWITCH_USER") ?: new ManageRole(authority: 'ROLE_SWITCH_USER').save()
		def configRole = ManageRole.findByAuthority("ROLE_CONFIG_ADMIN") ?: new ManageRole(authority: 'ROLE_CONFIG_ADMIN').save()
		def photoRole = ManageRole.findByAuthority("ROLE_PHOTOER_ADMIN") ?: new ManageRole(authority: 'ROLE_PHOTOER_ADMIN').save()
		if (!adminUser) {
			adminUser = new ManageUser(
					username: 'admin',
					password: "password",
					email:"admin@xmmoyi.com",
					enabled: true,
					lastVisit: new Date())
			adminUser.save(flush:true)
			ManageUserManageRole.create(adminUser, configRole)
		}
    }
    def destroy = {
    }
}
