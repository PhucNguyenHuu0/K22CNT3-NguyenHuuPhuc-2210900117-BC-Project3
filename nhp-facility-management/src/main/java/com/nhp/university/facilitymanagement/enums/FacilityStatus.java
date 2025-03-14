package com.nhp.university.facilitymanagement.enums;

public enum FacilityStatus {
    AVAILABLE("Available"),       // Còn trống
    OCCUPIED("Occupied"),         // Đang sử dụng
    UNDER_MAINTENANCE("Under Maintenance"); // Đang bảo trì

    private final String displayName;

    // Constructor
    FacilityStatus(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }
}
