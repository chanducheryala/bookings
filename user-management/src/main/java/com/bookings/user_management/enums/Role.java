package com.bookings.user_management.enums;

public enum Role {
    SUPER_ADMIN("Super Administrator"),
    ADMIN("Administrator"),
    SUB_ADMIN("Sub Administrator"),
    USER("User"),
    LOCATION_MANAGER("Location Manager"),
    LOCATION_SUBMANAGER("Location Sub-Manager"),
    CUSTOMER("Customer");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Role fromString(String roleName) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No role found with name: " + roleName);
    }

    @Override
    public String toString() {
        return displayName;
    }
}
