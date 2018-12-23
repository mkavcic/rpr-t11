package ba.unsa.etf.rpr.tutorijal10;

import net.sf.jasperreports.engine.JRException;

public class GradoviController {
    private  GeografijaDAO model;

    public void stampajKnjige() {
        try {
            new GradoviReport().showReport(model.getConn());
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }
}
