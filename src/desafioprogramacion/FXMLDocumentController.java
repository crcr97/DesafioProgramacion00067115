/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafioprogramacion;
import java.io.File;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author carlo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TreeView  menuDePasos;
    
    @FXML
    private ImageView imagenActual;
    
    @FXML
    private void ClickBotonSiguiente(ActionEvent event) {
        //ENCONTRANDO ARCHIVO DE IMAGEN
        File file = new File("src/imagenes/Victoria.png");
        //ENVIANDO IMAGEN A IMAGEVIEW
        imagenActual.setImage(new Image(file.toURI().toString()));
        //ANIMACION
        FadeTransition ft = new FadeTransition();
        ft.setNode(imagenActual);
        ft.setDuration(new Duration(2000.0));
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
    
    @FXML
    private void ClickBotonAnterior(ActionEvent event) {
        File file = new File("src/imagenes/California.png");
        imagenActual.setImage(new Image(file.toURI().toString()));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        creandoTreeView();
    }
    

    void creandoTreeView(){
        TreeItem todosLosPasos = new TreeItem("Pasos M.E.F. 3D");
        TreeItem paso1 = new TreeItem("Paso 1");
        TreeItem paso2 = new TreeItem("Paso 2");
        TreeItem paso3 = new TreeItem("Paso 3");
        TreeItem paso4 = new TreeItem("Paso 4");
        TreeItem paso5 = new TreeItem("Paso 5");
        TreeItem paso6 = new TreeItem("Paso 6");
        menuDePasos.setRoot(todosLosPasos);        
        todosLosPasos.getChildren().addAll(paso1,paso2,paso3,paso4,paso5,paso6);
        
        //HIJOS PASO 1
        TreeItem paso1parte1 = new TreeItem("Parte 1");
        TreeItem paso1parte2 = new TreeItem("Parte 2");
        paso1.getChildren().addAll(paso1parte1,paso1parte2);

        menuDePasos.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<TreeItem<String>>() {

                @Override
                public void changed(
                        ObservableValue<? extends TreeItem<String>> observable,
                        TreeItem<String> old_val, TreeItem<String> new_val) {
                    TreeItem<String> selectedItem = new_val;
                    System.out.println("Selected Text : " + selectedItem.getValue());
                            File file = new File("src/imagenes/California.png");
        imagenActual.setImage(new Image(file.toURI().toString()));
                    // do what ever you want
                    //Subiendo a git
                }

            });
    
    }
    
}
