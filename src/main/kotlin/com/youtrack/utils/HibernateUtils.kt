package com.youtrack.utils

import com.youtrack.issue.IssuePriority
import com.youtrack.issue.IssueState
import com.youtrack.issue.impl.IssueImpl
import com.youtrack.user.User
import com.youtrack.user.UserCredentials
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration

class HibernateUtils private constructor() {

    companion object {
        private var SESSION_FACTORY: SessionFactory? = null

        init {
            val configuration = Configuration()
            configuration.configure()
            configuration.addAnnotatedClass(IssueImpl::class.java)
            configuration.addAnnotatedClass(User::class.java)
            configuration.addAnnotatedClass(UserCredentials::class.java)
            configuration.addAnnotatedClass(IssueState::class.java)
            configuration.addAnnotatedClass(IssuePriority::class.java)


            val serviceRegistry = StandardServiceRegistryBuilder().applySettings(configuration.properties).build()
            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry)
        }

        fun getSessionFactory(): SessionFactory = SESSION_FACTORY!!

        fun shutdown() {
            SESSION_FACTORY?.close()
        }
    }
}