/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafioprogramacion.controladores;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
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
public class FXMLDocumentController implements Initializable{
    
    private int contador=1;
    private ArrayList  listadoDeImagenes;
    
    @FXML
    private TreeView  menuDePasos;
    
    @FXML
    private ImageView imagenActual;
    
    @FXML
    private void ClickBotonSiguiente(ActionEvent event){
        File file = new File("src/imagenes/Victoria.png");
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
    
    @FXML
    private void ClickBotonAnterior(ActionEvent event){
        File file = new File("src/imagenes/California.png");
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){ 
        creandoListadoDeImagenes();
        creandoTreeView();
        detectarClickEnTreeView();
    }
    

    void creandoListadoDeImagenes(){
    }
    
    void creandoTreeView(){
        TreeItem todosLosPasos = new TreeItem("Pasos M.E.F. 3D");
        
        menuDePasos.setRoot(todosLosPasos);
        
        //ELEMENTOS DEL MENU
        TreeItem pasoPreliminar= new TreeItem("Pasos preliminares");
        TreeItem paso1 = new TreeItem("Paso 1-Localizacion");
        TreeItem paso2 = new TreeItem("Paso 2-Interpolacion");
        TreeItem paso3 = new TreeItem("Paso 3-Aproximacion del modelo");
        TreeItem paso4 = new TreeItem("Paso 4-Metodo de los residuos ponderados");
        TreeItem paso5 = new TreeItem("Paso 5-Metodo de Galerkin");
        TreeItem paso6 = new TreeItem("Paso 6");
        TreeItem componentesDeMatrices = new TreeItem("Definiendo Componentes de Matrices");        
        TreeItem paso7 = new TreeItem("Paso 7");        
        todosLosPasos.getChildren().addAll(pasoPreliminar,paso1,paso2,paso3,paso4,paso5,paso6,componentesDeMatrices,paso7);
        
        //PASO PRELIMINAR
        TreeItem pasoPreliminarParte1 = new TreeItem("Definicion de Dominio");
        TreeItem pasoPreliminarParte2 = new TreeItem("Definicion de Condiciones de Contorno");
        TreeItem pasoPreliminarParte3 = new TreeItem("Definicion de Condiciones de Contorno");
        TreeItem pasoPreliminarParte4 = new TreeItem("Definicion de Malla");
        TreeItem pasoPreliminarParte5 = new TreeItem("Definicion de Malla-Numeracion de Nodos");
        TreeItem pasoPreliminarParte6 = new TreeItem("Definicion de Malla-Numeracion elemento 1");
        TreeItem pasoPreliminarParte7 = new TreeItem("Definicion de Malla-Numeracion elemento 2");
        TreeItem pasoPreliminarParte8 = new TreeItem("Definicion de Malla-Numeracion elemento 3");
        TreeItem pasoPreliminarParte9 = new TreeItem("Definicion de Malla-Numeracion elemento 4");
        TreeItem pasoPreliminarParte10 = new TreeItem("Definicion de Malla-Numeracion elemento 5");
        TreeItem pasoPreliminarParte11 = new TreeItem("Definicion de Malla-Numeracion elemento 6");
        TreeItem pasoPreliminarParte12 = new TreeItem("Tabla de Conectividades");
        pasoPreliminar.getChildren().addAll(pasoPreliminarParte1,pasoPreliminarParte2,pasoPreliminarParte3,
                                            pasoPreliminarParte4,pasoPreliminarParte5,pasoPreliminarParte6,
                                            pasoPreliminarParte7,pasoPreliminarParte8,pasoPreliminarParte9,
                                            pasoPreliminarParte10,pasoPreliminarParte11,pasoPreliminarParte12);
        
        //PASO 1
        TreeItem paso1Parte1 = new TreeItem("Localizacion-Ecuaciones a Usar");
        TreeItem paso1Parte2 = new TreeItem("Localizacion-Isoparametrizacion");
        TreeItem paso1Parte3 = new TreeItem("Localizacion-Funciones de Forma");
        TreeItem paso1Parte4 = new TreeItem("Localizacion-Parte Faltante");
        paso1.getChildren().addAll(paso1Parte1,paso1Parte2,paso1Parte3,paso1Parte4);

        //PASO 2
        TreeItem paso2Parte1 = new TreeItem("Interpolacion");
        paso2.getChildren().addAll(paso2Parte1);
        
        //PASO 3
        TreeItem paso3Parte1 = new TreeItem("Residuales");        
        paso3.getChildren().addAll(paso3Parte1);

        //PASO 4
        TreeItem paso4Parte1 = new TreeItem("Residuos Ponderados");
        TreeItem paso4Parte2 = new TreeItem("Residuos Ponderados-Uniendo integrales");        
        paso4.getChildren().addAll(paso4Parte1,paso4Parte2);
        
        //PASO 5
        TreeItem paso5Parte1 = new TreeItem("Metodo de Galerkin-Planteando Integrales");
        TreeItem paso5Parte2 = new TreeItem("Metodo de Galerkin-Nombrando Integrales");        
        TreeItem paso5Parte3 = new TreeItem("Metodo de Galerkin-Forma Fuerte");
        paso5.getChildren().addAll(paso5Parte1,paso5Parte2,paso5Parte3);
        
        //PASO 6
        TreeItem paso6Parte1 = new TreeItem("Integracion por partes-Integrando para Matriz L");
        TreeItem paso6Parte2 = new TreeItem("Integracion por partes-Integrando para Matriz P");        
        TreeItem paso6Parte3 = new TreeItem("Integracion por partes-Forma Debil");
        paso6.getChildren().addAll(paso6Parte1,paso6Parte2,paso6Parte3);
        
        
        //DEFINIENDO COMPONENTES DE MATRICES
        
        TreeItem componentesConsideraciones = new TreeItem("Consideraciones:");

            //MATRIZ K
        TreeItem componentesMatrizK = new TreeItem("Componentes de K");
        TreeItem MatrizKIntegral = new TreeItem("Componentes de K-Planteando integral");
        TreeItem MatrizKIntegralModificada = new TreeItem("Componentes de K-Integral Modificada");
        TreeItem MatrizKDistribuyendoIntegral = new TreeItem("Componentes de K-Distribuyendo Integral");        
        TreeItem MatrizKResolviendoIntegral = new TreeItem("Componentes de K-Resolviendo Integral");        
        TreeItem MatrizKRespuestaIntegral = new TreeItem("Componentes de K-Respuesta Integral"); 
        componentesMatrizK.getChildren().addAll(MatrizKIntegral,MatrizKIntegralModificada,MatrizKDistribuyendoIntegral,
                                                MatrizKResolviendoIntegral,MatrizKRespuestaIntegral);
        
            //MATRIZ C        
        TreeItem componentesMatrizC = new TreeItem("Componentes de C");
        TreeItem MatrizCIntegral = new TreeItem("Componentes de C-Planteando integral");
        TreeItem MatrizCResolviendoIntegral = new TreeItem("Componentes de C-Resolviendo Integral");        
        componentesMatrizC.getChildren().addAll(MatrizCIntegral,MatrizCResolviendoIntegral);
        
            //MATRIZ D
        TreeItem componentesMatrizD = new TreeItem("Componentes de D");
        TreeItem MatrizDIntegral = new TreeItem("Componentes de D-Planteando integral");
        TreeItem MatrizDResolviendoIntegral = new TreeItem("Componentes de D-Resolviendo Integral");        
        componentesMatrizD.getChildren().addAll(MatrizDIntegral,MatrizDResolviendoIntegral);        
            
            //MATRIZ Q        
        TreeItem componentesMatrizQ = new TreeItem("Componentes de Q");
        TreeItem MatrizQIntegral = new TreeItem("Componentes de Q-Planteando integral");
        TreeItem MatrizQIntegralModificada = new TreeItem("Componentes de Q-Integral Modificada");
        TreeItem MatrizQDistribuyendoIntegral = new TreeItem("Componentes de Q-Distribuyendo Integral");        
        TreeItem MatrizQResolviendoIntegral = new TreeItem("Componentes de Q-Resolviendo Integral");        
        TreeItem MatrizQRespuestaIntegral = new TreeItem("Componentes de Q-Respuesta Integral"); 
        componentesMatrizQ.getChildren().addAll(MatrizQIntegral,MatrizQIntegralModificada,MatrizQDistribuyendoIntegral,
                                                MatrizQResolviendoIntegral,MatrizQRespuestaIntegral);            
            //MATRIZ F
        TreeItem componentesMatrizF = new TreeItem("Componentes de F");
        TreeItem MatrizFIntegral = new TreeItem("Componentes de F-Planteando integral");
        TreeItem MatrizFIntegralModificada = new TreeItem("Componentes de F-Integral Modificada");
        TreeItem MatrizFDistribuyendoIntegral = new TreeItem("Componentes de F-Distribuyendo Integral");        
        TreeItem MatrizFResolviendoIntegral = new TreeItem("Componentes de F-Resolviendo Integral");        
        TreeItem MatrizFRespuestaIntegral = new TreeItem("Componentes de F-Respuesta Integral"); 
        componentesMatrizF.getChildren().addAll(MatrizFIntegral,MatrizFIntegralModificada,MatrizFDistribuyendoIntegral,
                                                MatrizFResolviendoIntegral,MatrizFRespuestaIntegral);  

            //MATRIZ M
        TreeItem componentesMatrizM = new TreeItem("Componentes de M");
        TreeItem MatrizMIntegral = new TreeItem("Componentes de M-Planteando integral");
        TreeItem MatrizMIntegralModificada = new TreeItem("Componentes de M-Integral Modificada");
        TreeItem MatrizMDistribuyendoIntegral = new TreeItem("Componentes de M-Distribuyendo Integral");        
        TreeItem MatrizMResolviendoIntegral = new TreeItem("Componentes de M-Resolviendo Integral");        
        TreeItem MatrizMRespuestaIntegral = new TreeItem("Componentes de M-Respuesta Integral"); 
        componentesMatrizM.getChildren().addAll(MatrizMIntegral,MatrizMIntegralModificada,MatrizMDistribuyendoIntegral,
                                                MatrizMResolviendoIntegral,MatrizMRespuestaIntegral);          
        
        componentesDeMatrices.getChildren().addAll(componentesConsideraciones,componentesMatrizK,componentesMatrizC,componentesMatrizD,
                                                   componentesMatrizQ,componentesMatrizF,componentesMatrizM);
        
    }
    

    void detectarClickEnTreeView(){
        menuDePasos.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<TreeItem<String>>(){

                @Override
                public void changed(
                    ObservableValue<? extends TreeItem<String>> observable,
                    TreeItem<String> old_val, TreeItem<String> new_val){
                    
                        TreeItem<String> selectedItem = new_val;
                        
                        System.out.println("Selected Text : " + selectedItem.getValue());
                        
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
    
}