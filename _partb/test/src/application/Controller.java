package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

//import javafx.event.MouseEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable  {
	DirectoryChooser filechooser=new DirectoryChooser();
	File folder;
	ImageView ggv= new ImageView (new Image("folder_icon0.png"));
	
	@FXML
	private TreeView<File> treeview;
	@FXML
	private TextArea overview;
	
	TreeItem<File> rootItem;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		filechooser.setInitialDirectory(new File("D:\\"));
		
		
	}

	public void selectItem(MouseEvent event) throws Exception  {
		Node t =  event.getPickResult().getIntersectedNode();
		System.out.println(event.getPickResult().getIntersectedNode());
		
		TreeItem<File> rootIt = treeview.getSelectionModel().getSelectedItem();
		StringBuilder field = new StringBuilder("");
		field.append(rootIt.getValue().getName()+"("+Files.size(rootIt.getValue().toPath())/1000+"KB)\n");
		PrintItem(rootIt,field);
		
		
				
		
		
		
    }
	public void PrintItem(TreeItem<File> r,StringBuilder fielde) throws Exception {
		
		List<TreeItem<File>> trees = r.getChildren();
		
		for(int i=0;i<trees.size();i++) {
			if(trees.get(i).getValue().isDirectory()) {
				fielde.append("   "+trees.get(i).getValue().getName()+" ("+Files.size(trees.get(i).getValue().toPath())/1000+"KB)\n");
//				fielde.append("");
				PrintItem(trees.get(i),fielde);
				}
			else {
//				textarea.app
				fielde.append("      "+trees.get(i).getValue().getName()+" ("+Files.size(trees.get(i).getValue().toPath())/1000+"KB)\n");
			}
			
			}
//		 writer(textarea,fielde);
		overview.setText(fielde.toString());
		System.out.println(fielde.toString());
		
	}
//	private void writer(TextArea te,StringBuilder fie) {
//		te.setText(fie.toString());
//	}
//	
	public void selectfold(ActionEvent event) {
		folder=filechooser.showDialog(new Stage());
//				showOpenDialog(new Stage());
		System.out.print(folder.getAbsolutePath());
		ggv.setFitHeight(15);
		ggv.setFitWidth(15);
		rootItem= new TreeItem<>(folder,ggv);
//		System.out.println(rootItem.toString());
		treeview.setRoot(rootItem);
		rootItem.setExpanded(true);
		File a[]=folder.listFiles();
		ssvb(a,rootItem);
	
    }
	 void ssvb (File q[],TreeItem<File> ro) {
		for(int i=0;i<q.length;i++) {
			TreeItem<File> ro1=new TreeItem<>(q[i],ggv);
//			ro1.setExpanded(true);
			ro.getChildren().add(ro1);
			if(q[i].isDirectory()) { 
				ssvb(q[i].listFiles(),ro1);
			}
			
		
//		
	}
		
	
}
}