package de.qabel.desktop.config;

import de.qabel.core.config.Account;
import de.qabel.core.config.Identity;

import java.util.Date;

public interface ClientConfig {
    boolean hasAccount();

    Account getAccount();

    /**
     * @param account BoxAccount to use
     * @throws IllegalStateException when an account already exists
     */
    void setAccount(Account account) throws IllegalStateException;

    Identity getSelectedIdentity();

    void selectIdentity(Identity identity);

    boolean hasDeviceId();

    void setDeviceId(String deviceId);

    String getDeviceId();

    /**
     * @deprecated to be replaced because an identity can have multiple drops and the state mustn't be a date
     */
    @Deprecated
    Date getLastDropPoll(Identity identity);

    /**
     * @deprecated to be replaced because an identity can have multiple drops and the state mustn't be a date
     */
    @Deprecated
    void setLastDropPoll(Identity identity, Date lastDropPoll);

    ShareNotifications getShareNotification(Identity identity);
}
