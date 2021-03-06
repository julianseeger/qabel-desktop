package de.qabel.desktop.crashReports;

import java.io.IOException;
import java.net.URISyntaxException;

public interface CrashReportHandler {

	int sendFeedback(String feedbackFieldText, String text, String feedback) throws URISyntaxException, IOException;
	int sendStacktrace(String feedback, String stacktrace) throws URISyntaxException, IOException;

}
