package com.intern.olp

import grails.transaction.Transactional

@Transactional
class AppInitializationService {

    static initialize() {
        initMember()

    }
    private static initMember() {
        def role = new Role(
                authority : "ROLE_ADMIN"
        )

        role.validate()
        if (!role.hasErrors()) {
            role.save()
        }
        def user = new User(
                fullname: "System Administrator",
                email: "ocb@domain.com",
                password: "123456"
        )
        user.validate()
        if (!user.hasErrors()) {
            user.save()
            UserRole.create(user, role)
        }
    }
}
