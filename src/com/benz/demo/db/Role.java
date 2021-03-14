package com.benz.demo.db;

public enum Role {

    ROLE_USER(101, "ROLE_USER"),
    ROLE_ADMIN(102, "ROLE_ADMIN"),
    ROLE_MODERATOR(103, "ROLE_MODERATOR");

    private final int roleId;
    private final String roleName;

    Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
