package ba.unsa.etf.rpr.tutorijal10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import net.sf.jasperreports.engine.JRException;

import java.util.ResourceBundle;


public class GradoviController {
    private GeografijaDAO model;
    @FXML
    public MenuItem printBtn;
    public MenuItem english;
    public MenuItem french;
    public MenuItem bosnian;
    public MenuItem german;
    public MenuItem about;
    public Menu file;
    public Menu help;
    public Menu view;
    public Menu edit;
    public Menu jezik;

    public GradoviController(GeografijaDAO model) {
        this.model = model;
    }

    @FXML
    public void stampajGradove(ActionEvent actionEvent) {
        try {
            new GradoviReport().showReport(model.getConn());
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }

    public void promijeni(ActionEvent actionEvent) {
        String property = "property";
        MenuItem menuItem = (MenuItem) actionEvent.getSource();
        String id = menuItem.getId();
        switch (id) {
            case "english":
                property = "Translate_en_GB";
                break;
            case "french":
                property = "Translate_fr";
                break;
            case "german":
                property = "Translate_de";
                break;
            case "bosnian":
                property = "Translate_bs_BA";
                break;
        }
        edit.setText(ResourceBundle.getBundle(property).getString("edit"));
        file.setText(ResourceBundle.getBundle(property).getString("file"));
        help.setText(ResourceBundle.getBundle(property).getString("help"));
        view.setText(ResourceBundle.getBundle(property).getString("view"));
        about.setText(ResourceBundle.getBundle(property).getString("about"));
        jezik.setText(ResourceBundle.getBundle(property).getString("language"));
        printBtn.setText(ResourceBundle.getBundle(property).getString("print"));
        bosnian.setText(ResourceBundle.getBundle(property).getString("bosanski"));
        english.setText(ResourceBundle.getBundle(property).getString("engleski"));
        french.setText(ResourceBundle.getBundle(property).getString("francuski"));
        german.setText(ResourceBundle.getBundle(property).getString("njemacki"));
    }
}
