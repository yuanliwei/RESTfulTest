package com.ylw.restfultest;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ylw.restfultest.utils.PropUtils;
import com.ylw.restfultest.utils.Res;
import com.ylw.restfultest.view.MainAppController;
import com.ylw.restfultest.view.MainViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private static Log log = LogFactory.getLog(MainApp.class);

	private BorderPane root;
	public MainViewController mainViewController;
	public MainAppController mainAppController;
	public Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("RESTfulTest");

		primaryStage.getIcons().add(Res.getImageFromRes("icon.jpg"));
		PropUtils.load();
		FXMLLoader loader = Res.getFXMLLoader("MainApp.fxml");
		try {
			root = loader.load();
			mainAppController = loader.getController();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		Scene scene = new Scene(root, 1000, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		initCenter();

		initController();
	}

	private void initCenter() {
		FXMLLoader loader = Res.getFXMLLoader("MainView.fxml");
		try {
			BorderPane center = loader.load();
			mainViewController = loader.getController();
			mainAppController.setCenter(center);
			mainAppController.stackPane.getChildren().add(center);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	private void initController() {
		mainAppController.setMainApp(this);
		mainViewController.setMainApp(this);
		mainViewController.load(PropUtils.get("sel_html_path"));
	}
	
	@Override
	public void stop() throws Exception {
		PropUtils.store();
		super.stop();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
