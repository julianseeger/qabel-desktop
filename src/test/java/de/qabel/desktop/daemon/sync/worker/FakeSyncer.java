package de.qabel.desktop.daemon.sync.worker;

import de.qabel.desktop.config.BoxSyncConfig;
import de.qabel.desktop.daemon.management.Transaction;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class FakeSyncer implements Syncer {
	public BoxSyncConfig config;
	public boolean started;
	public boolean stopped;

	public FakeSyncer(BoxSyncConfig config) {
		this.config = config;
	}

	@Override
	public void run() {
		started = true;
	}

	@Override
	public List<Transaction> getHistory() {
		return null;
	}

	@Override
	public void shutdown() {

	}

	@Override
	public void setPollInterval(int amount, TimeUnit unit) {

	}

	@Override
	public void stop() throws InterruptedException {
		stopped = true;
	}

	public boolean isStopped() {
		return stopped;
	}

	@Override
	public Syncer onProgress(Consumer<Transaction> consumer) {
		return null;
	}

	@Override
	public long totalElements() {
		return 0;
	}

	@Override
	public long finishedElements() {
		return 0;
	}

	@Override
	public double getProgress() {
		return 0;
	}

	@Override
	public Syncer onProgress(Runnable runnable) {
		return null;
	}

	@Override
	public long totalSize() {
		return 0;
	}

	@Override
	public long currentSize() {
		return 0;
	}
}
