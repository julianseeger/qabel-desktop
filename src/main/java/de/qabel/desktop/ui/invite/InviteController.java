package de.qabel.desktop.ui.invite;

import de.qabel.desktop.ui.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class InviteController extends AbstractController implements Initializable {


	@FXML
	private TextArea textarea;

	private ResourceBundle bundle;
	public void initialize(URL location, ResourceBundle resources) {

		this.bundle = resources;
		textarea.setText(bundle.getString("inviteText"));
		textarea.setEditable(false);
	}

	@FXML
	protected void handleInviteButtonAction(ActionEvent event) throws IOException {
		new Thread(() -> {
			Desktop desktop;
			if (Desktop.isDesktopSupported()
					&& (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {

				String mailTo = "";
				String subject = createEMailSubject();
				String body = createEMailBody();
				String cc = "";

				String mailURIStr = String.format("mailto:%s?subject=%s&cc=%s&body=%s",
						mailTo, subject, cc, body);

				try {
					desktop.mail( new URI(mailURIStr));
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		).start();

	}

	private String createEMailBody() {
		String body =  bundle.getString("inviteText");
		body = body.replace("\n", "%0D%0A");
		body = body.replace(" ", "%20");
		return body;
	}

	private String createEMailSubject() {
		String subject = bundle.getString("emailSubjectText");
		subject = subject.replace(" ", "%20");
		return subject;
	}

}


