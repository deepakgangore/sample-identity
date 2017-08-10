package com.deepak.identity.usermanagement.dto;

/**
 * Created by dgangore on 8/10/2017.
 */
public class UserStatus {

    private boolean identityStatus;

    private boolean lockedStatus;

    public boolean isIdentityStatus() {
        return identityStatus;
    }

    public void setIdentityStatus(boolean identityStatus) {
        this.identityStatus = identityStatus;
    }

    public boolean isLockedStatus() {
        return lockedStatus;
    }

    public void setLockedStatus(boolean lockedStatus) {
        this.lockedStatus = lockedStatus;
    }
}
