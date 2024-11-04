package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class GetraenkemarktView {

	private GetraenkemarktControl getrCont;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblArtikelnummer = new Label("Artikel:");
	private Label lblEinkaufspreis = new Label("Einkaufspreis:");
	private Label lblVerkaufspreis = new Label("Verkaufspreis:");
	private Label lblMitAlkohol = new Label("mit Alkohol ?:");
	private Label lblBehältnis = new Label("Behältnis:");
	private TextField txtArtikelnummer = new TextField();
	private TextField txtEinkaufspreis = new TextField();
	private TextField txtVerkaufspreis = new TextField();
	private TextField txtMitAlkohol = new TextField();
	private TextField txtBehältnis = new TextField();
	private TextArea txtAnzeige = new TextArea();
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public GetraenkemarktView(GetraenkemarktControl getrCont, Stage primaryStage) {

		this.getrCont = getrCont;

		Scene scene = new Scene(this.pane, 700, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Getränken für einen Getränkemarkt");
		primaryStage.show();
		this.initKomponenten();
		this.initListener();

	}

	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblArtikelnummer.setLayoutX(20);
		lblArtikelnummer.setLayoutY(90);
		lblEinkaufspreis.setLayoutX(20);
		lblEinkaufspreis.setLayoutY(130);
		lblVerkaufspreis.setLayoutX(20);
		lblVerkaufspreis.setLayoutY(170);
		lblMitAlkohol.setLayoutX(20);
		lblMitAlkohol.setLayoutY(210);
		lblBehältnis.setLayoutX(20);
		lblBehältnis.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblArtikelnummer, lblEinkaufspreis, lblVerkaufspreis,
				lblMitAlkohol, lblBehältnis);

		// Textfelder
		txtArtikelnummer.setLayoutX(170);
		txtArtikelnummer.setLayoutY(90);
		txtArtikelnummer.setPrefWidth(200);
		txtEinkaufspreis.setLayoutX(170);
		txtEinkaufspreis.setLayoutY(130);
		txtEinkaufspreis.setPrefWidth(200);
		txtVerkaufspreis.setLayoutX(170);
		txtVerkaufspreis.setLayoutY(170);
		txtVerkaufspreis.setPrefWidth(200);
		txtMitAlkohol.setLayoutX(170);
		txtMitAlkohol.setLayoutY(210);
		txtMitAlkohol.setPrefWidth(200);
		txtBehältnis.setLayoutX(170);
		txtBehältnis.setLayoutY(250);
		txtBehältnis.setPrefWidth(200);
		pane.getChildren().addAll(getTxtArtikelnummer(), txtEinkaufspreis, txtVerkaufspreis, txtMitAlkohol, txtBehältnis);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menue
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImport);
		this.mnDatei.getItems().add(mnItmTxtImport);
		this.mnDatei.getItems().add(new SeparatorMenuItem());
		this.mnDatei.getItems().add(mnItmCsvExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrCont.nehmeGetraenkemarktAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrCont.zeigeGetraenkeMarktAn();
			}
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrCont.leseAusDatei("csv");
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrCont.leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrCont.schreibeGetraenkemarktInCsvDatei();
			}
		});
	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	public TextField getTxtArtikelnummer() {
		return txtArtikelnummer;
	}

	public TextField getTxtEinkaufspreis() {
	    return txtEinkaufspreis;
	}

	public TextField getTxtVerkaufspreis() {
	    return txtVerkaufspreis;
	}

	public TextField getTxtMitAlkohol() {
	    return txtMitAlkohol;
	}

	public TextField getTxtBehältnis() {
	    return txtBehältnis;
	}
	
	public TextArea getTxtAnzeige() {
		return txtAnzeige;
	}

}