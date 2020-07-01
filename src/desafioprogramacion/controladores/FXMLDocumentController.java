/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafioprogramacion.controladores;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author carlo
 */
public class FXMLDocumentController implements Initializable{
    
    @FXML
    private VBox contenedorImagen;
    
    @FXML
    private BorderPane panelPrincipal;
    
    @FXML
    private Text pasoSeleccionado;
    
    @FXML
    private TreeView  menuDePasos;
    
    @FXML
    private ImageView imagenActual;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){        
        creandoTreeView();
        detectarClickEnTreeView();
        cambiarTamanoImagen();
    }
    
    void creandoTreeView(){
        TreeItem todosLosPasos = new TreeItem("Pasos M.E.F. 3D");
        
        menuDePasos.setRoot(todosLosPasos);
        
        TreeItem pasoPreliminar= new TreeItem("Pasos preliminares");
        TreeItem paso1 = new TreeItem("Paso 1-Localizacion");
        TreeItem paso2 = new TreeItem("Paso 2-Interpolacion");
        TreeItem paso3 = new TreeItem("Paso 3-Aproximacion del modelo");
        TreeItem paso4 = new TreeItem("Paso 4-Metodo de los residuos ponderados");
        TreeItem paso5 = new TreeItem("Paso 5-Metodo de Galerkin");
        TreeItem paso6 = new TreeItem("Paso 6-Integracion por partes");
        TreeItem componentesDeMatrices = new TreeItem("Definiendo Componentes de Matrices");        
        TreeItem paso7 = new TreeItem("Paso 7-Ensamblaje");        
        todosLosPasos.getChildren().addAll(pasoPreliminar,paso1,paso2,paso3,paso4,paso5,paso6,
                                           componentesDeMatrices,paso7);
        
        TreeItem pasoPreliminarParte1 = new TreeItem("Definicion de Dominio");
        TreeItem pasoPreliminarParte2 = new TreeItem("Definicion de Malla");
        TreeItem pasoPreliminarParte3 = new TreeItem("Definicion de Condiciones de Contorno");
        TreeItem pasoPreliminarParte4 = new TreeItem("Numeracion de Nodos");
        TreeItem pasoPreliminarParte5 = new TreeItem("Numeracion elemento 1");
        TreeItem pasoPreliminarParte6 = new TreeItem("Numeracion elemento 2");
        TreeItem pasoPreliminarParte7 = new TreeItem("Numeracion elemento 3");
        TreeItem pasoPreliminarParte8 = new TreeItem("Numeracion elemento 4");
        TreeItem pasoPreliminarParte9 = new TreeItem("Numeracion elemento 5");
        TreeItem pasoPreliminarParte10 = new TreeItem("Numeracion elemento 6");
        TreeItem pasoPreliminarParte11 = new TreeItem("Tabla de Conectividades");
        pasoPreliminar.getChildren().addAll(pasoPreliminarParte1,pasoPreliminarParte2,pasoPreliminarParte3,
                                            pasoPreliminarParte4,pasoPreliminarParte5,pasoPreliminarParte6,
                                            pasoPreliminarParte7,pasoPreliminarParte8,pasoPreliminarParte9,
                                            pasoPreliminarParte10,pasoPreliminarParte11);
        
        TreeItem paso1Parte1 = new TreeItem("Localizacion-Ecuaciones a Usar");
        TreeItem paso1Parte2 = new TreeItem("Localizacion-Isoparametrizacion");
        TreeItem paso1Parte3 = new TreeItem("Localizacion-Funciones de Forma");
        paso1.getChildren().addAll(paso1Parte1,paso1Parte2,paso1Parte3);

        TreeItem paso2Parte1 = new TreeItem("Interpolacion");
        paso2.getChildren().addAll(paso2Parte1);
        
        TreeItem paso3Parte1 = new TreeItem("Residuales");        
        paso3.getChildren().addAll(paso3Parte1);

        TreeItem paso4Parte1 = new TreeItem("Residuos Ponderados-Planteando Integrales");
        TreeItem paso4Parte2 = new TreeItem("Residuos Ponderados-Uniendo integrales");        
        paso4.getChildren().addAll(paso4Parte1,paso4Parte2);
        
        TreeItem paso5Parte1 = new TreeItem("Metodo de Galerkin-Planteando Integrales");
        TreeItem paso5Parte2 = new TreeItem("Metodo de Galerkin-Nombrando Integrales");        
        TreeItem paso5Parte3 = new TreeItem("Metodo de Galerkin-Forma Fuerte");
        paso5.getChildren().addAll(paso5Parte1,paso5Parte2,paso5Parte3);
        
        TreeItem paso6Parte1 = new TreeItem("Integracion por partes-Integrando para Matriz L");
        TreeItem paso6Parte2 = new TreeItem("Integracion por partes-Integrando para Matriz P");        
        TreeItem paso6Parte3 = new TreeItem("Integracion por partes-Forma Debil");
        paso6.getChildren().addAll(paso6Parte1,paso6Parte2,paso6Parte3);
                
        TreeItem componentesConsideraciones = new TreeItem("Consideraciones");

        TreeItem componentesMatrizK = new TreeItem("Componentes de K");
        TreeItem MatrizKIntegral = new TreeItem("Componentes de K-Planteando integral");
        TreeItem MatrizKIntegralModificada = new TreeItem("Componentes de K-Integral Modificada");
        TreeItem MatrizKDistribuyendoIntegral = new TreeItem("Componentes de K-Distribuyendo Integral");        
        TreeItem MatrizKResolviendoIntegral = new TreeItem("Componentes de K-Resolviendo Integral");        
        TreeItem MatrizKRespuestaIntegral = new TreeItem("Componentes de K-Respuesta Integral"); 
        componentesMatrizK.getChildren().addAll(MatrizKIntegral,MatrizKIntegralModificada,
                                                MatrizKDistribuyendoIntegral,MatrizKResolviendoIntegral,
                                                MatrizKRespuestaIntegral);
        
        TreeItem componentesMatrizC = new TreeItem("Componentes de C");
        TreeItem MatrizCIntegral = new TreeItem("Componentes de C-Planteando integral");
        TreeItem MatrizCResolviendoIntegral = new TreeItem("Componentes de C-Resolviendo Integral");        
        componentesMatrizC.getChildren().addAll(MatrizCIntegral,MatrizCResolviendoIntegral);
        
        TreeItem componentesMatrizD = new TreeItem("Componentes de D");
        TreeItem MatrizDIntegral = new TreeItem("Componentes de D-Planteando integral");
        TreeItem MatrizDResolviendoIntegral = new TreeItem("Componentes de D-Resolviendo Integral");        
        componentesMatrizD.getChildren().addAll(MatrizDIntegral,MatrizDResolviendoIntegral);        
            
        TreeItem componentesMatrizQ = new TreeItem("Componentes de Q");
        TreeItem MatrizQIntegral = new TreeItem("Componentes de Q-Planteando integral");
        TreeItem MatrizQIntegralModificada = new TreeItem("Componentes de Q-Integral Modificada");
        TreeItem MatrizQDistribuyendoIntegral = new TreeItem("Componentes de Q-Distribuyendo Integral");        
        TreeItem MatrizQResolviendoIntegral = new TreeItem("Componentes de Q-Resolviendo Integral");        
        TreeItem MatrizQRespuestaIntegral = new TreeItem("Componentes de Q-Respuesta Integral"); 
        componentesMatrizQ.getChildren().addAll(MatrizQIntegral,MatrizQIntegralModificada,
                                                MatrizQDistribuyendoIntegral,
                                                MatrizQResolviendoIntegral,MatrizQRespuestaIntegral);            
        
        TreeItem componentesMatrizF = new TreeItem("Componentes de F");
        TreeItem MatrizFIntegral = new TreeItem("Componentes de F-Planteando integral");
        TreeItem MatrizFIntegralModificada = new TreeItem("Componentes de F-Integral Modificada");
        TreeItem MatrizFDistribuyendoIntegral = new TreeItem("Componentes de F-Distribuyendo Integral");        
        TreeItem MatrizFResolviendoIntegral = new TreeItem("Componentes de F-Resolviendo Integral");        
        TreeItem MatrizFRespuestaIntegral = new TreeItem("Componentes de F-Respuesta Integral"); 
        componentesMatrizF.getChildren().addAll(MatrizFIntegral,MatrizFIntegralModificada,
                                                MatrizFDistribuyendoIntegral,MatrizFResolviendoIntegral,
                                                MatrizFRespuestaIntegral);  

        TreeItem componentesMatrizM = new TreeItem("Componentes de M");
        TreeItem MatrizMIntegral = new TreeItem("Componentes de M-Planteando integral");
        TreeItem MatrizMIntegralModificada = new TreeItem("Componentes de M-Integral Modificada");
        TreeItem MatrizMDistribuyendoIntegral = new TreeItem("Componentes de M-Distribuyendo Integral");        
        TreeItem MatrizMResolviendoIntegral = new TreeItem("Componentes de M-Resolviendo Integral");        
        TreeItem MatrizMRespuestaIntegral = new TreeItem("Componentes de M-Respuesta Integral"); 
        componentesMatrizM.getChildren().addAll(MatrizMIntegral,MatrizMIntegralModificada,
                                                MatrizMDistribuyendoIntegral,MatrizMResolviendoIntegral,
                                                MatrizMRespuestaIntegral);          
        
        componentesDeMatrices.getChildren().addAll(componentesConsideraciones,componentesMatrizK,
                                                   componentesMatrizC,componentesMatrizD,componentesMatrizQ,
                                                   componentesMatrizF,componentesMatrizM);
    }
    
    void detectarClickEnTreeView(){
        menuDePasos.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<TreeItem<String>>(){

                @Override
                public void changed(
                    ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val){
                    
                        TreeItem<String> selectedItem = new_val;                        
                        pasoSeleccionado.setText(selectedItem.getValue());

                        File file = new File("src/imagenes/"+selectedItem.getValue()+".PNG");
                        imagenActual.setImage(new Image(file.toURI().toString()));
                    
                        FadeTransition ft = new FadeTransition();
                        ft.setNode(imagenActual);
                        ft.setDuration(new Duration(2000.0));
                        ft.setFromValue(0.0);
                        ft.setToValue(1.0);
                        ft.setCycleCount(1);
                        ft.setAutoReverse(true);
                        ft.play();  
                }
            });        
    }
    
    void cambiarTamanoImagen(){
        contenedorImagen.heightProperty().addListener((observable, oldValue, newValue) -> {
                imagenActual.fitHeightProperty().bind(contenedorImagen.heightProperty());
                imagenActual.fitWidthProperty().bind(contenedorImagen.widthProperty()); 
            });
    }

    @FXML
    public void captureAndSaveDisplay(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        
        File file = fileChooser.showSaveDialog(null);


        if(file != null){
            try {
                WritableImage writableImage = new WritableImage((int)panelPrincipal.getWidth(),
                        (int)panelPrincipal.getHeight());
                WritableImage snapshot = panelPrincipal.snapshot(new SnapshotParameters(), writableImage);
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png",file);
                alert();
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
    
    public void alert(){
        Alert alert = new Alert(AlertType.NONE,"", ButtonType.FINISH);
        alert.setTitle("Aviso!");
        alert.setContentText("Captura Guardada Con Exito!");
        alert.getDialogPane().setPrefSize(200,50);
        Optional<ButtonType> result = alert.showAndWait();

    }
    
}
