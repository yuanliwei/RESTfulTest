package com.ylw.restfultest.view;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ylw.restfultest.MainApp;
import com.ylw.restfultest.controller.BaseController;
import com.ylw.restfultest.model.ListItemData;
import com.ylw.restfultest.utils.PropUtils;
import com.ylw.restfultest.utils.script.Invoke;
import com.ylw.restfultest.utils.script.JavascriptUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainAppController extends BaseController {
	private static Log log = LogFactory.getLog(MainAppController.class);

	@FXML
	MenuBar menuBar;
	@FXML
	ListView<ListItemData> listView;

	ProgressBar progressBar;
	ProgressIndicator progressIndicator;

	ObservableList<ListItemData> data = FXCollections.observableArrayList();

	private MainApp mainApp;

	@FXML
	public StackPane stackPane;

	private BorderPane center;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	protected void initialize() {

	}

	@FXML
	public void onClose(ActionEvent event) {
		System.out.println(((MenuItem) event.getSource()).getUserData());
	}

	@FXML
	public void onOpenUrl(ActionEvent event) {
		mainApp.mainViewController.webEngine.load((String) ((MenuItem) event.getSource()).getUserData());
	}

	@FXML
	public void onRefresh() {
		mainApp.mainViewController.webEngine.reload();
	}

	@FXML
	public void onAlert() {
		mainApp.mainViewController.webEngine.executeScript("alert('heeeeeello')");
	}

	@FXML
	public void onOpenFile() {
		log.debug("click open file");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("打开一个word文档");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Word Files", "*.doc", "*.docx"),
				new ExtensionFilter("All Files", "*.*"));

		String lastPath = PropUtils.get("last_open_doc_path");
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(lastPath)) {
			fileChooser.setInitialDirectory(new File(lastPath));
		}

		File selectedFile = fileChooser.showOpenDialog(mainApp.primaryStage);
		if (selectedFile != null) {
			log.debug("selectFile : " + selectedFile);
		}
	}

	public void setCenter(BorderPane center2) {
		// TODO Auto-generated method stub

	}

}
