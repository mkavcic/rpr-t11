package ba.unsa.etf.rpr.tutorijal10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import net.sf.jasperreports.engine.JRException;




public class GradoviController {
    private  GeografijaDAO model;
    @FXML
    public MenuItem printBtn;

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
}
