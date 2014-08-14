dataSource {
    pooled = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
	driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "pml309309"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
	naming_strategy = com.common.CustomNamingStrategy
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
    development {
        dataSource {
			username = "dev"
			password = "123"
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			url = "jdbc:mysql://192.168.1.134:3306/pml_back_dev?useUnicode=true&characterEncoding=utf-8"
        }
    }
    test {
        dataSource {
            dbCreate = "validate"
//            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			url = "jdbc:mysql://192.168.1.125:3306/pml_dev?useUnicode=true&characterEncoding=utf-8"
        }
    }
    production {
        dataSource {
            dbCreate = "validate"
//            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			//url = "jdbc:mysql://localhost:3306/reveng"
			url = "jdbc:mysql://10.66.106.228:3306/pml_prod?useUnicode=true&characterEncoding=utf-8"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
