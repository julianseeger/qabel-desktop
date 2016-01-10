package de.qabel.desktop.config;

import de.qabel.core.config.Account;
import de.qabel.core.config.Identity;
import javafx.collections.ObservableList;

import java.util.Observer;

public interface ClientConfiguration {
	boolean hasAccount();
	Account getAccount();

	/**
	 * @param account BoxAccount to use
	 * @throws IllegalStateException when an account already exists
	 */
	void setAccount(Account account) throws IllegalStateException;

	Identity getSelectedIdentity();
	void selectIdentity(Identity identity);

	ObservableList<BoxSyncConfig> getBoxSyncConfigs();

	/**
	 * @see java.util.Observable#addObserver(Observer)
	 * @param o
	 */
	void addObserver(Observer o);

	/**
	 * @see java.util.Observable#deleteObserver(Observer)
	 * @param o
	 */
	void deleteObserver(Observer o);
}
