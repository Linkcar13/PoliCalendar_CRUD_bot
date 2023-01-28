/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PoliCalendar.Controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TreeTableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.util.Callback;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;

/**
 *
 * @author carlos
 */
public class VentanaController implements Initializable {

    //Secciones de la Aplicación
    @FXML
    private AnchorPane SeccionHome;
    @FXML
    private AnchorPane Seccion1;
    @FXML
    private AnchorPane Seccion2;
    @FXML
    private AnchorPane Seccion3;
    @FXML
    private AnchorPane Seccion4;
    @FXML
    private AnchorPane Seccion5;
    @FXML
    private AnchorPane SeccionVistas;
    @FXML
    private AnchorPane SeccionTE;
    @FXML
    private AnchorPane SeccionTF;
    @FXML
    private AnchorPane SeccionTM;
    @FXML
    private AnchorPane SeccionTA;
    @FXML
    private AnchorPane SeccionM1;
    @FXML
    private AnchorPane SeccionM2;
    @FXML
    private AnchorPane SeccionM3;
    @FXML
    private AnchorPane SeccionM4;
    @FXML
    private AnchorPane SeccionM5;
    @FXML
    private AnchorPane SeccionE1;
    @FXML
    private AnchorPane SeccionE2;
    @FXML
    private AnchorPane SeccionE3;
    @FXML
    private AnchorPane SeccionE4;
    @FXML
    private AnchorPane SeccionE5;

    //Botones con imagenes
    @FXML
    private ImageView RegistrarE1;
    @FXML
    private ImageView RegistrarF;
    @FXML
    private ImageView RegistrarM;
    @FXML
    private ImageView Registrar4;
    @FXML
    private ImageView ModificarE;
    @FXML
    private ImageView ModificarC;
    @FXML
    private ImageView ModificarR;
    @FXML
    private ImageView ModificarA;

    @FXML
    private ImageView EliminarE;
    @FXML
    private ImageView EliminarC;
    @FXML
    private ImageView EliminarR;
    @FXML
    private ImageView EliminarA;

    //Botones panel lateral
    @FXML
    private JFXButton BtnRegistro;
    @FXML
    private JFXButton BtnEliminar;
    @FXML
    private JFXButton BtnVisualizar;
    @FXML
    private JFXButton BtnModificar;
    @FXML
    private JFXButton BtnLogOut;
    @FXML
    private ImageView VisualizarE;
    @FXML
    private ImageView VisualizarF;
    @FXML
    private ImageView VisualizarM;
    @FXML
    private ImageView VisualizarA;

    //Botones y Textos Panel de login
    @FXML
    private AnchorPane SeccionLogin;
    @FXML
    private JFXButton BtnExit;
    @FXML
    private JFXButton BtnLogin;
    @FXML
    private TextField TxtUser;
    @FXML
    private TextField TxtPassword;
    @FXML
    private ImageView Deny;
    @FXML
    private ImageView BtnHome;

    //Declaracion de tablas
    @FXML
    private JFXTreeTableView<Estudiante> tablaEstudiante;
    @FXML
    private JFXTreeTableView<Carrera> TablaCarrera;
    @FXML
    private JFXTreeTableView<Recordatorio> TablaRecordatorio;
    @FXML
    private JFXTreeTableView<Actividad> TablaActividad;

    int index = -1;
    java.sql.Connection con = null;
    ResultSet RC = null;
    PreparedStatement SC = null;

    ObservableList<Carrera> CarreraData;
    //
    ObservableList<Estudiante> EstudianteData;
    ObservableList<Recordatorio> RecordatorioData;
    ObservableList<Actividad> ActividadData;
    //    

    //Registro Estudiante
    @FXML
    private TextField TxtEstudiante;
    @FXML
    private TextField TxtSemestre;
    @FXML
    private TextField TxtCodUnico;
    @FXML
    private TextField TxtCarrera;
    @FXML
    private TextField TxtEdad;
    @FXML
    private JFXComboBox<String> ComboFacultad;
    @FXML
    private JFXButton BtnSaveEstudiante;

    //Registro Carrera
    @FXML
    private TextField TxtSCarrera;
    @FXML
    private JFXComboBox<String> ComboSCFacultad;
    @FXML
    private JFXComboBox<String> ComboModalidad;
    @FXML
    private JFXButton BtnSaveCarrera;

    //Modificar Carrera
    @FXML
    private TextField TxtModEstudiante;
    @FXML
    private TextField TxtModSemestre;
    @FXML
    private TextField TxtModCodUnico;
    @FXML
    private TextField TxtModCarrera;
    @FXML
    private TextField TxtModEdad;
    @FXML
    private JFXComboBox<String> ComboFacultad1;
    @FXML
    private JFXButton BtnModEstudiante;

    //Modificar Carrera
    @FXML
    private TextField TxtMCarrera;
    @FXML
    private JFXComboBox<String> ComboMFacultad;
    @FXML
    private JFXComboBox<String> ComboMModalidad;
    @FXML
    private JFXButton BtnModCarrera;

    //Modificar Recordatorio
    @FXML
    private TextField TxtSCRecordatorio;
    @FXML
    private TextField TxtNuevoPed;
    @FXML
    private JFXButton BtnModRecor;

    //Modificar Actividad
    @FXML
    private TextField TxtModActividad;
    @FXML
    private TextField TxtNuevoFechaEnt;
    @FXML
    private JFXButton BtnModActividad;

    //Eliminar Estudiante
    @FXML
    private TextField TxtEliminarE;
    @FXML
    private JFXButton BtnEliminarEst;

    //Eliminar Carrera
    @FXML
    private TextField TxtEliminarCarrera;
    @FXML
    private JFXButton BtnEliminarCarrera;

    //Eliminar Recordatorio
    @FXML
    private TextField TxtEliminarRecordatorio;
    @FXML
    private JFXButton BtnEliminarRec;

    //Eliminar Actividad
    @FXML
    private TextField TxtEliminarActividad;
    @FXML
    private JFXButton BtnEliminarAct;

    ObservableList<String> Facultades
            = FXCollections.observableArrayList("ING Sistemas", "ING Civil");

    ObservableList<String> Modalidades
            = FXCollections.observableArrayList("Presencial", "Virtual");

    private ColorAdjust colorAdjust = new ColorAdjust();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//ComboBoxes
        ComboFacultad.setItems(Facultades);
        ComboSCFacultad.setItems(Facultades);
        ComboModalidad.setItems(Modalidades);
        ComboFacultad1.setItems(Facultades);
        ComboMFacultad.setItems(Facultades);
        ComboMModalidad.setItems(Modalidades);

//Tabla Estudiante 
        JFXTreeTableColumn<Estudiante, String> CodigoUnico = new JFXTreeTableColumn<>("Codigo Unico");
        CodigoUnico.setPrefWidth(100);
        CodigoUnico.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Estudiante, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Estudiante, String> param) {
                return param.getValue().getValue().CodigoUnico;
            }
        });

        JFXTreeTableColumn<Estudiante, String> idFacultad = new JFXTreeTableColumn<>("Id Facultad");
        idFacultad.setPrefWidth(100);
        idFacultad.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Estudiante, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Estudiante, String> param) {
                return param.getValue().getValue().idFacultad;
            }
        });
        JFXTreeTableColumn<Estudiante, String> NombreCarrera = new JFXTreeTableColumn<>("Nombre Carrera");
        NombreCarrera.setPrefWidth(100);
        NombreCarrera.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Estudiante, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Estudiante, String> param) {
                return param.getValue().getValue().NombreCarrera;
            }
        });
        JFXTreeTableColumn<Estudiante, String> NombreEstudiante = new JFXTreeTableColumn<>("Nombre Estudiante");
        NombreEstudiante.setPrefWidth(130);
        NombreEstudiante.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Estudiante, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Estudiante, String> param) {
                return param.getValue().getValue().NombreEstudiante;
            }
        });
        JFXTreeTableColumn<Estudiante, String> edad = new JFXTreeTableColumn<>("Edad");
        edad.setPrefWidth(50);
        edad.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Estudiante, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Estudiante, String> param) {
                return param.getValue().getValue().edad;
            }
        });
        JFXTreeTableColumn<Estudiante, String> semestre = new JFXTreeTableColumn<>("Semestre");
        semestre.setPrefWidth(80);
        semestre.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Estudiante, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Estudiante, String> param) {
                return param.getValue().getValue().semestre;
            }
        });

        /*ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("Computer Department", "23", "CD 1"));
        users.add(new User("Sales Department", "22", "Employee 1"));
        users.add(new User("Sales Department", "22", "Employee 2"));
        users.add(new User("Sales Department", "25", "Employee 4"));
        users.add(new User("Sales Department", "25", "Employee 5"));
        users.add(new User("IT Department", "42", "ID 2"));
        users.add(new User("HR Department", "22", "HR 1"));
        users.add(new User("HR Department", "22", "HR 2"));*/
        EstudianteData = Conection.getEstudiantes();
        final TreeItem<Estudiante> root = new RecursiveTreeItem<Estudiante>(EstudianteData, RecursiveTreeObject::getChildren);
        tablaEstudiante.getColumns().setAll(CodigoUnico, idFacultad, NombreCarrera, NombreEstudiante, edad, semestre);
        tablaEstudiante.setRoot(root);
        tablaEstudiante.setShowRoot(false);

//Tabla Carrera
        JFXTreeTableColumn<Carrera, String> nombreCarrera = new JFXTreeTableColumn<>("Nombre Carrera");
        nombreCarrera.setPrefWidth(100);
        nombreCarrera.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Carrera, String> param1) {
                return param1.getValue().getValue().nombreCarrera;
            }
        });

        JFXTreeTableColumn<Carrera, String> idFacultadpk = new JFXTreeTableColumn<>("Id Facultad");
        idFacultadpk.setPrefWidth(100);
        idFacultadpk.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Carrera, String> param1) {
                return param1.getValue().getValue().idFacultadpk;
            }
        });
        JFXTreeTableColumn<Carrera, String> Modalidad = new JFXTreeTableColumn<>("Modalidad");
        Modalidad.setPrefWidth(100);
        Modalidad.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Carrera, String> param1) {
                return param1.getValue().getValue().Modalidad;
            }
        });

        CarreraData = Conection.getCarreras();
        final TreeItem<Carrera> root1 = new RecursiveTreeItem<Carrera>(CarreraData, RecursiveTreeObject::getChildren);
        TablaCarrera.getColumns().setAll(nombreCarrera, idFacultadpk, Modalidad);
        TablaCarrera.setRoot(root1);
        TablaCarrera.setShowRoot(false);
//Tabla Recordatorio
        JFXTreeTableColumn<Recordatorio, String> idRecordatorio = new JFXTreeTableColumn<>("Id Recordatorio");
        idRecordatorio.setPrefWidth(100);
        idRecordatorio.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Recordatorio, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Recordatorio, String> param1) {
                return param1.getValue().getValue().idRecordatorio;
            }
        });
        JFXTreeTableColumn<Recordatorio, String> idFacultadfkR = new JFXTreeTableColumn<>("Codigo Unico");
        idFacultadfkR.setPrefWidth(100);
        idFacultadfkR.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Recordatorio, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Recordatorio, String> param1) {
                return param1.getValue().getValue().idFacultadfkR;
            }
        });
        JFXTreeTableColumn<Recordatorio, String> codigoUnicofk = new JFXTreeTableColumn<>("id Facultad");
        codigoUnicofk.setPrefWidth(100);
        codigoUnicofk.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Recordatorio, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Recordatorio, String> param1) {
                return param1.getValue().getValue().codigoUnicofk;
            }
        });
        JFXTreeTableColumn<Recordatorio, String> uidfk = new JFXTreeTableColumn<>("Id Actividad");
        uidfk.setPrefWidth(100);
        uidfk.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Recordatorio, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Recordatorio, String> param1) {
                return param1.getValue().getValue().uidfk;
            }
        });
        JFXTreeTableColumn<Recordatorio, String> periodo = new JFXTreeTableColumn<>("periodo");
        periodo.setPrefWidth(100);
        periodo.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Recordatorio, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Recordatorio, String> param1) {
                return param1.getValue().getValue().periodo;
            }
        });
        JFXTreeTableColumn<Recordatorio, String> entregado = new JFXTreeTableColumn<>("Entregado");
        entregado.setPrefWidth(100);
        entregado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Recordatorio, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Recordatorio, String> param1) {
                return param1.getValue().getValue().entregado;
            }
        });


        RecordatorioData = Conection.getRecordatorios();
        final TreeItem<Recordatorio> root2 = new RecursiveTreeItem<Recordatorio>(RecordatorioData, RecursiveTreeObject::getChildren);
        TablaRecordatorio.getColumns().setAll(idRecordatorio, idFacultadfkR, codigoUnicofk, uidfk, periodo, entregado);
        TablaRecordatorio.setRoot(root2);
        TablaRecordatorio.setShowRoot(false);

//Tabla Actividad
        JFXTreeTableColumn<Actividad, String> uid = new JFXTreeTableColumn<>("Id Actividad");
        uid.setPrefWidth(100);
        uid.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().uid;
            }
        });

        JFXTreeTableColumn<Actividad, String> summary = new JFXTreeTableColumn<>("Summary");
        summary.setPrefWidth(90);
        summary.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().summary;
            }
        });
        JFXTreeTableColumn<Actividad, String> description = new JFXTreeTableColumn<>("Descripcion");
        description.setPrefWidth(90);
        description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().description;
            }
        });
        JFXTreeTableColumn<Actividad, String> dateStramp = new JFXTreeTableColumn<>("Date Stramp");
        dateStramp.setPrefWidth(90);
        dateStramp.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().dateStramp;
            }
        });
        JFXTreeTableColumn<Actividad, String> dateStart = new JFXTreeTableColumn<>("Date Start");
        dateStart.setPrefWidth(70);
        dateStart.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().dateStart;
            }
        });
        JFXTreeTableColumn<Actividad, String> dateEnd = new JFXTreeTableColumn<>("Date End");
        dateEnd.setPrefWidth(70);
        dateEnd.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().dateEnd;
            }
        });
        JFXTreeTableColumn<Actividad, String> categories = new JFXTreeTableColumn<>("categories");
        categories.setPrefWidth(90);
        categories.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().categories;
            }
        });
        JFXTreeTableColumn<Actividad, String> idFacultafkA = new JFXTreeTableColumn<>("id Facultad");
        idFacultafkA.setPrefWidth(90);
        idFacultafkA.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Actividad, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Actividad, String> param1) {
                return param1.getValue().getValue().idFacultafkA;
            }
        });


        ActividadData = Conection.getActividades();
        final TreeItem<Actividad> root3 = new RecursiveTreeItem<Actividad>(ActividadData, RecursiveTreeObject::getChildren);
        TablaActividad.getColumns().setAll(uid, idFacultafkA, summary, description, dateStramp, dateStart, dateEnd, categories);
        TablaActividad.setRoot(root3);
        TablaActividad.setShowRoot(false);
    }

    public void exit(MouseEvent evt) {
        System.exit(0);
    }

    public void Seccion1(MouseEvent evt) {
        if (Seccion1.isVisible()) {
            Seccion1.setVisible(false);
            return;
        }

        Seccion1.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionVistas.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void Seccion2(MouseEvent evt) {
        if (Seccion2.isVisible()) {
            Seccion2.setVisible(false);
            return;
        }

        Seccion2.setVisible(true);
        Seccion1.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionVistas.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void Seccion3(MouseEvent evt) {
        if (Seccion3.isVisible()) {
            Seccion3.setVisible(false);
            return;
        }

        Seccion3.setVisible(true);
        Seccion1.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion2.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionVistas.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void Seccion4(MouseEvent evt) {
        if (Seccion4.isVisible()) {
            Seccion4.setVisible(false);
            return;
        }

        Seccion4.setVisible(true);
        Seccion1.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionVistas.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void Seccion5(MouseEvent evt) {
        if (Seccion5.isVisible()) {
            Seccion5.setVisible(false);
            return;
        }

        Seccion5.setVisible(true);
        Seccion1.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionVistas.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void Home(MouseEvent evt) {

        SeccionHome.setVisible(true);
        Seccion1.setVisible(false);

        //false conditions
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionVistas.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
        //
    }

    public void VistasHome(MouseEvent evt) {
        if (SeccionVistas.isVisible()) {
            SeccionTE.setVisible(false);
            return;
        }

        SeccionVistas.setVisible(true);
        SeccionTE.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void VistasD(MouseEvent evt) {
        if (SeccionTE.isVisible()) {
            SeccionTE.setVisible(false);
            return;
        }

        SeccionVistas.setVisible(true);
        SeccionTE.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void VistasF(MouseEvent evt) {
        if (SeccionTF.isVisible()) {
            SeccionTF.setVisible(false);
            return;
        }

        SeccionVistas.setVisible(true);
        SeccionTF.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void VistasM(MouseEvent evt) {
        if (SeccionTM.isVisible()) {
            SeccionTM.setVisible(false);
            return;
        }

        Seccion5.setVisible(true);
        SeccionTM.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void VistasA(MouseEvent evt) {
        if (SeccionTA.isVisible()) {
            SeccionTA.setVisible(false);
            return;
        }

        Seccion5.setVisible(true);
        SeccionTA.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void ModInit(MouseEvent evt) {
        if (SeccionM1.isVisible()) {
            SeccionM1.setVisible(false);
            return;
        }

        SeccionM1.setVisible(true);
        SeccionTA.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void ModE(MouseEvent evt) {
        if (SeccionM2.isVisible()) {
            SeccionM2.setVisible(false);
            return;
        }

        SeccionM1.setVisible(true);
        SeccionM2.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void ModC(MouseEvent evt) {
        if (SeccionM3.isVisible()) {
            SeccionM3.setVisible(false);
            return;
        }

        SeccionM1.setVisible(true);
        SeccionM3.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);

    }

    public void ModA(MouseEvent evt) {
        if (SeccionM4.isVisible()) {
            SeccionM4.setVisible(false);
            return;
        }

        SeccionM1.setVisible(true);
        SeccionM4.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void ModR(MouseEvent evt) {
        if (SeccionM5.isVisible()) {
            SeccionM5.setVisible(false);
            return;
        }

        SeccionM1.setVisible(true);
        SeccionM5.setVisible(true);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionTA.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionE1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void DelInit(MouseEvent evt) {
        if (SeccionE1.isVisible()) {
            SeccionE1.setVisible(false);
            return;
        }

        SeccionE1.setVisible(true);
        SeccionTA.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void DelE(MouseEvent evt) {
        if (SeccionE2.isVisible()) {
            SeccionE2.setVisible(false);
            return;
        }

        SeccionE1.setVisible(true);
        SeccionE2.setVisible(true);
        SeccionTA.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void DelC(MouseEvent evt) {
        if (SeccionE3.isVisible()) {
            SeccionE3.setVisible(false);
            return;
        }

        SeccionE1.setVisible(true);
        SeccionE3.setVisible(true);
        SeccionTA.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void DelA(MouseEvent evt) {
        if (SeccionE4.isVisible()) {
            SeccionE4.setVisible(false);
            return;
        }

        SeccionE1.setVisible(true);
        SeccionE4.setVisible(true);
        SeccionTA.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE2.setVisible(false);
        SeccionE5.setVisible(false);
    }

    public void DelR(MouseEvent evt) {
        if (SeccionE5.isVisible()) {
            SeccionE5.setVisible(false);
            return;
        }

        SeccionE1.setVisible(true);
        SeccionE5.setVisible(true);
        SeccionTA.setVisible(false);

        //false conditions
        SeccionHome.setVisible(false);
        Seccion1.setVisible(false);
        Seccion2.setVisible(false);
        Seccion3.setVisible(false);
        Seccion4.setVisible(false);
        Seccion5.setVisible(false);
        SeccionTE.setVisible(false);
        SeccionTF.setVisible(false);
        SeccionTM.setVisible(false);
        SeccionM2.setVisible(false);
        SeccionM3.setVisible(false);
        SeccionM4.setVisible(false);
        SeccionM5.setVisible(false);
        SeccionM1.setVisible(false);
        SeccionE3.setVisible(false);
        SeccionE4.setVisible(false);
        SeccionE2.setVisible(false);
    }

    //Focus Buttons
    public void FocusButtons1(MouseEvent evt) {
        BtnRegistro.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons2(MouseEvent evt) {
        BtnEliminar.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons3(MouseEvent evt) {
        BtnVisualizar.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons4(MouseEvent evt) {
        BtnModificar.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons5(MouseEvent evt) {
        BtnLogOut.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons6(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        RegistrarE1.setEffect(colorAdjust);
        RegistrarE1.setPreserveRatio(true);
        RegistrarE1.setCache(true);
    }

    public void FocusButtons7(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        RegistrarF.setEffect(colorAdjust);
        RegistrarF.setPreserveRatio(true);
        RegistrarF.setCache(true);
    }

    public void FocusButtons8(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        RegistrarM.setEffect(colorAdjust);
        RegistrarM.setPreserveRatio(true);
        RegistrarM.setCache(true);
    }

    public void FocusButtons9(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        Registrar4.setEffect(colorAdjust);
        Registrar4.setPreserveRatio(true);
        Registrar4.setCache(true);
    }

    public void FocusButtons12(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        VisualizarE.setEffect(colorAdjust);
        VisualizarE.setPreserveRatio(true);
        VisualizarE.setCache(true);
    }

    public void FocusButtons13(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        VisualizarF.setEffect(colorAdjust);
        VisualizarF.setPreserveRatio(true);
        VisualizarF.setCache(true);
    }

    public void FocusButtons14(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        VisualizarM.setEffect(colorAdjust);
        VisualizarM.setPreserveRatio(true);
        VisualizarM.setCache(true);
    }

    public void FocusButtons15(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        VisualizarA.setEffect(colorAdjust);
        VisualizarA.setPreserveRatio(true);
        VisualizarA.setCache(true);
    }

    public void FocusButtons10(MouseEvent evt) {
        BtnExit.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons11(MouseEvent evt) {
        BtnLogin.setStyle("-fx-background-color: #267099;");
    }

    public void FocusButtons16(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        ModificarE.setEffect(colorAdjust);
        ModificarE.setPreserveRatio(true);
        ModificarE.setCache(true);
    }

    public void FocusButtons17(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        ModificarC.setEffect(colorAdjust);
        ModificarC.setPreserveRatio(true);
        ModificarC.setCache(true);
    }

    public void FocusButtons18(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        ModificarR.setEffect(colorAdjust);
        ModificarR.setPreserveRatio(true);
        ModificarR.setCache(true);
    }

    public void FocusButtons19(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        ModificarA.setEffect(colorAdjust);
        ModificarA.setPreserveRatio(true);
        ModificarA.setCache(true);
    }

    public void FocusButtons20(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        EliminarE.setEffect(colorAdjust);
        EliminarE.setPreserveRatio(true);
        EliminarE.setCache(true);
    }

    public void FocusButtons21(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        EliminarC.setEffect(colorAdjust);
        EliminarC.setPreserveRatio(true);
        EliminarC.setCache(true);
    }

    public void FocusButtons22(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        EliminarR.setEffect(colorAdjust);
        EliminarR.setPreserveRatio(true);
        EliminarR.setCache(true);
    }

    public void FocusButtons23(MouseEvent evt) {
        //Effect lighting = new Lighting();
        //RegistrarE1.setEffect(lighting);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.9);
        colorAdjust.setBrightness(0.5);
        colorAdjust.setSaturation(1.0);
        EliminarA.setEffect(colorAdjust);
        EliminarA.setPreserveRatio(true);
        EliminarA.setCache(true);
    }

    //UnfocusButtons
    public void UnFocusButtons1(MouseEvent evt) {
        BtnRegistro.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons2(MouseEvent evt) {
        BtnEliminar.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons3(MouseEvent evt) {
        BtnVisualizar.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons4(MouseEvent evt) {
        BtnModificar.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons5(MouseEvent evt) {
        BtnLogOut.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons6(MouseEvent evt) {
        RegistrarE1.setEffect(null);
    }

    public void UnFocusButtons7(MouseEvent evt) {
        RegistrarF.setEffect(null);
    }

    public void UnFocusButtons8(MouseEvent evt) {
        RegistrarM.setEffect(null);
    }

    public void UnFocusButtons9(MouseEvent evt) {
        Registrar4.setEffect(null);
    }

    public void UnFocusButtons10(MouseEvent evt) {
        BtnExit.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons11(MouseEvent evt) {
        BtnLogin.setStyle("-fx-background-color: #42456b;");
    }

    public void UnFocusButtons12(MouseEvent evt) {
        VisualizarE.setEffect(null);
    }

    public void UnFocusButtons13(MouseEvent evt) {
        VisualizarF.setEffect(null);
    }

    public void UnFocusButtons14(MouseEvent evt) {
        VisualizarM.setEffect(null);
    }

    public void UnFocusButtons15(MouseEvent evt) {
        VisualizarA.setEffect(null);
    }

    public void UnFocusButtons16(MouseEvent evt) {
        ModificarE.setEffect(null);
    }

    public void UnFocusButtons17(MouseEvent evt) {
        ModificarC.setEffect(null);
    }

    public void UnFocusButtons18(MouseEvent evt) {
        ModificarR.setEffect(null);
    }

    public void UnFocusButtons19(MouseEvent evt) {
        ModificarA.setEffect(null);
    }

    public void UnFocusButtons20(MouseEvent evt) {
        EliminarE.setEffect(null);
    }

    public void UnFocusButtons21(MouseEvent evt) {
        EliminarC.setEffect(null);
    }

    public void UnFocusButtons22(MouseEvent evt) {
        EliminarR.setEffect(null);
    }

    public void UnFocusButtons23(MouseEvent evt) {
        EliminarA.setEffect(null);
    }

//Cerrar Cesión
    public void Logout(MouseEvent evt) {
        SeccionLogin.setVisible(true);
    }

    //CRUD Buttons
    public void SaveStudent(MouseEvent evt) throws SQLException {
        String Estudiante;
        int Facultad=0;
        int Semestre=0;
        int codigoUnico=0;
        String Carrera;
        int edad=0;

        Estudiante = TxtEstudiante.getText();
        if (ComboFacultad.getValue().equals("ING Sistemas")){
            
        Facultad = 20;
        }
        else if (ComboFacultad.getValue().equals("ING Civil")){
        Facultad = 6;    
        }
        Semestre = Integer.parseInt(TxtSemestre.getText());
        codigoUnico = Integer.parseInt(TxtCodUnico.getText());
        Carrera = TxtCarrera.getText();
        edad = Integer.parseInt(TxtEdad.getText());

        TxtEstudiante.setText(null);
        //ComboFacultad.getAccessibleText()
        TxtSemestre.setText(null);
        TxtCodUnico.setText(null);
        TxtCarrera.setText(null);
        TxtEdad.setText(null);

        //envia a la base de datos
        Conection.InsertEst(codigoUnico, Facultad, Carrera, Estudiante, edad, Semestre);
    }

    public void SaveModStudent(MouseEvent evt) {
        String Estudiante;
        int Facultad=0;
        int Semestre;
        String codigoUnico;
        String Carrera;
        int edad;

        Estudiante = TxtModEstudiante.getText();
        if (ComboFacultad1.getValue().equals("ING Sistemas")){
            
        Facultad = 20;
        }
        else if (ComboFacultad1.getValue().equals("ING Civil")){
        Facultad = 6;    
        }
        System.out.println(ComboFacultad1.getValue());
        Semestre = Integer.parseInt(TxtModSemestre.getText());
        codigoUnico = TxtModCodUnico.getText();
        Carrera = TxtModCarrera.getText();
        edad = Integer.parseInt(TxtModEdad.getText());

        TxtEstudiante.setText(null);
        //ComboFacultad.getAccessibleText()
        TxtSemestre.setText(null);
        TxtCodUnico.setText(null);
        TxtCarrera.setText(null);
        TxtEdad.setText(null);

        //envia a la base de datos
        Conection.updateEst(codigoUnico, Facultad, Carrera, Estudiante, edad, Semestre);
    }

    public void SaveCarrera(MouseEvent evt) {
        String Modalidad="";
        int Facultad=0;
        String Carrera;

        if (ComboSCFacultad.getValue().equals("ING Sistemas")){
            
        Facultad = 20;
        }
        else if (ComboSCFacultad.getValue().equals("ING Civil")){
        Facultad = 6;    
        }
        if(ComboModalidad.getValue().equals("Presencial")){
        Modalidad ="Presencial" ;
        }
        else if (ComboModalidad.getValue().equals("Virtual")){
        Modalidad ="Virtual" ;
        }
        
        Carrera = TxtSCarrera.getText();

        TxtSCarrera.setText(null);

        //envia a la base de datos
        Conection.saveCarrera(Carrera, Facultad, Modalidad);
    }

    public void SaveModCarrera(MouseEvent evt) {
        String Modalidad;
        int Facultad;
        String Carrera;

        Facultad = Integer.parseInt(ComboMFacultad.getValue());
        Modalidad = ComboMModalidad.getValue();
        Carrera = TxtMCarrera.getText();

        TxtMCarrera.setText(null);

        //envia a la base de datos
        Conection.saveModCarrera(Carrera, Facultad, Modalidad);
    }

    public void SaveModRecordatorio(MouseEvent evt) {
        String NuevoPed;
        String Recordatorio;

        
        NuevoPed = TxtNuevoPed.getText();
        Recordatorio = TxtSCRecordatorio.getText();

        TxtNuevoPed.setText(null);
        TxtSCRecordatorio.setText(null);        

        //envia a la base de datos
        Conection.saveModRecordatorio(Recordatorio,NuevoPed);
    }
    
        public void SaveModActividad(MouseEvent evt) {
        String fechaEnt;
        int Actividad;

        
        fechaEnt = TxtNuevoPed.getText();
        Actividad = Integer.parseInt(TxtSCRecordatorio.getText());

        TxtNuevoFechaEnt.setText(null);
        TxtSCRecordatorio.setText(null);

        //envia a la base de datos
        Conection.saveModActividad(Actividad,fechaEnt);
    }
        
        public void DeleteEstudiante(MouseEvent evt) {
        int codigoUnico=0;


        
        codigoUnico = Integer.parseInt(TxtEliminarE.getText());

        TxtEliminarE.setText(null);

        //envia a la base de datos
        Conection.DeleteEstudiante(codigoUnico);
    }

        public void DeleteCarrera(MouseEvent evt) {
        String nombreCarrera;

        
        nombreCarrera = TxtEliminarCarrera.getText();

        TxtEliminarE.setText(null);

        //envia a la base de datos
        Conection.DeleteCarrera(nombreCarrera);
    }

        public void DeleteRecordatorio(MouseEvent evt) {
        int Recordatorio=0;

        
        Recordatorio = Integer.parseInt(TxtEliminarRecordatorio.getText());

        TxtSCRecordatorio.setText(null);

        //envia a la base de datos
        Conection.DeleteRecor(Recordatorio);
    }

        public void DeleteActividad(MouseEvent evt) {
        int Actividad;

        
        Actividad = Integer.parseInt(TxtEliminarActividad.getText());

        TxtEliminarActividad.setText(null);

        //envia a la base de datos
        Conection.saveModActividad(Actividad);
    }        

        

    //Manejo De Login
    public void Control(MouseEvent evt) {
        String User, Password;
        User = TxtUser.getText();
        Password = TxtPassword.getText();
        System.out.println(User);
        System.out.println(Password);
        if (User.equals("LAPTOP-AV5A5DAQ") && Password.equals("4545755")) {
            SeccionLogin.setVisible(false);
            TxtUser.setText(null);
            TxtPassword.setText(null);
            Conection.getConnectionSQL2();
        } else if (User.equals("CARLOS-WIN11") && Password.equals("241199")) {
            SeccionLogin.setVisible(false);
            TxtUser.setText(null);
            TxtPassword.setText(null);
            Conection.getConnectionSQL();
        } else {
            TxtUser.setText(null);
            TxtPassword.setText(null);
            Deny.setVisible(true);
        }
    }

    public static class Recordatorio extends RecursiveTreeObject<Recordatorio> {

        StringProperty idRecordatorio;
        StringProperty codigoUnicofk;
        StringProperty uidfk;
        StringProperty periodo;
        StringProperty entregado;
        StringProperty idFacultadfkR;

        public Recordatorio(String idRecordatorio, String codigoUnicofk, String idFacultadfkR, String uidfk, String periodo, String entregado) {
            this.idRecordatorio = new SimpleStringProperty(idRecordatorio);
            this.codigoUnicofk = new SimpleStringProperty(codigoUnicofk);
            this.uidfk = new SimpleStringProperty(uidfk);
            this.periodo = new SimpleStringProperty(periodo);
            this.entregado = new SimpleStringProperty(entregado);
            this.idFacultadfkR = new SimpleStringProperty(idFacultadfkR);
        }
    }

    public static class Actividad extends RecursiveTreeObject<Actividad> {

        StringProperty uid;
        StringProperty idFacultafkA;
        StringProperty summary;
        StringProperty description;
        StringProperty dateStramp;
        StringProperty dateStart;
        StringProperty dateEnd;
        StringProperty categories;

        public Actividad(String uid, String idFacultafkA, String summary, String description, String dateStramp, String dateStart, String dateEnd, String categories) {
            this.uid = new SimpleStringProperty(uid);
            this.summary = new SimpleStringProperty(summary);
            this.description = new SimpleStringProperty(description);
            this.dateStramp = new SimpleStringProperty(dateStramp);
            this.dateStart = new SimpleStringProperty(dateStart);
            this.dateEnd = new SimpleStringProperty(dateEnd);
            this.categories = new SimpleStringProperty(categories);
            this.idFacultafkA = new SimpleStringProperty(idFacultafkA);

        }
    }

    public static class Carrera extends RecursiveTreeObject<Carrera> {

        StringProperty nombreCarrera;
        StringProperty idFacultadpk;
        StringProperty Modalidad;

        public Carrera(String nombreCarrera, String idFacultadpk, String Modalidad) {
            this.nombreCarrera = new SimpleStringProperty(nombreCarrera);
            this.idFacultadpk = new SimpleStringProperty(idFacultadpk);
            this.Modalidad = new SimpleStringProperty(Modalidad);
        }
    }

    public static class Estudiante extends RecursiveTreeObject<Estudiante> {

        StringProperty CodigoUnico;
        StringProperty idFacultad;
        StringProperty NombreCarrera;
        StringProperty NombreEstudiante;
        StringProperty edad;
        StringProperty semestre;

        public Estudiante(String CodigoUnico, String idFacultad, String NombreCarrera, String NombreEstudiante, String edad, String semestre) {
            this.CodigoUnico = new SimpleStringProperty(CodigoUnico);
            this.idFacultad = new SimpleStringProperty(idFacultad);
            this.NombreCarrera = new SimpleStringProperty(NombreCarrera);
            this.NombreEstudiante = new SimpleStringProperty(NombreEstudiante);
            this.edad = new SimpleStringProperty(edad);
            this.semestre = new SimpleStringProperty(semestre);
        }
    }

}
