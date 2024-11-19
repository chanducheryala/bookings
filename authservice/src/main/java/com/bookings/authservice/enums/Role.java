package com.bookings.authservice.enums;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER"),
    LOCATION_MANAGER("LOCATION_MANAGER");

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
