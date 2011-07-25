dataSource {
    pooled = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}

environments {
    development {
        dataSource {
		    driverClassName = "org.postgresql.Driver"
			dialect = org.hibernate.dialect.PostgreSQLDialect
		    username = "simon"
		    password = "password"
            dbCreate = "create-drop"
            url = "jdbc:postgresql://localhost:5444/metaapp"
/*			logSql = true*/
        }
    }
    test {
        dataSource {
		    driverClassName = "org.hsqldb.jdbcDriver"
            dbCreate = "update"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:hsqldb:file:prodDb;shutdown=true"
        }
    }
}
