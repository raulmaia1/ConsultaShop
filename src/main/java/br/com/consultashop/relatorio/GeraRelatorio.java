package br.com.consultashop.relatorio;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import br.com.consultashop.bean.VendaBean;
import javafx.application.Platform;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

class GeraRelatorio {

	public void gera(VendaBean venda) {
		Platform.runLater(() -> {
			try {
				Map<String, Object> param = new HashMap<String, Object>();

//				param.put("logoacide", "relatorios/logoacide.png");
//				param.put("logo", "relatorios/logo.png");

				JasperReport report = (JasperReport) JRLoader.loadObject(new File("relatorios/cupom.jasper"));
				JasperPrint print = JasperFillManager.fillReport(report, param, new JRBeanCollectionDataSource(venda.getCarrinho()));

				JasperViewer jv = new JasperViewer(print, false);
				jv.setTitle("Cupom");
				jv.setVisible(true);

			} catch (JRException e) {
				e.printStackTrace();
			}
		});
	}

}
