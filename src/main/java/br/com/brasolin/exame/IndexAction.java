package br.com.brasolin.exame;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

import br.com.brasolin.exame.dao.DaoAgenda;
import br.com.brasolin.exame.entity.Agenda;

/**
 * 
 */
@Conversion()
public class IndexAction extends ActionSupport {
    
    
	private static final long serialVersionUID = 6329394260276112660L;
	ResultSet rs = null;
	Agenda agenda = null;
	List<Agenda> agendaLista = null;
	private boolean noData = false;
	DaoAgenda daoAgenda = new DaoAgenda();
    
    
    public String execute() throws Exception {
        
        try {
			agendaLista = new ArrayList<Agenda>();
			rs = daoAgenda.listarAgenda();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					agenda = new Agenda();
					agenda.setId(rs.getInt("ID"));
					agenda.setData(rs.getDate("DATA"));
					agenda.setCodigoCliente(rs.getString("CODIGOCLIENTE"));
					agenda.setNomeCliente(rs.getString("NOMECLIENTE"));
					agenda.setCodigoExame(rs.getString("CODIGOEXAME"));
					agenda.setNomeExame(rs.getString("NOMEEXAME"));
					agendaLista.add(agenda);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        return SUCCESS;
    }



	public List<Agenda> getAgendaLista() {
		return agendaLista;
	}



	public void setAgendaLista(List<Agenda> agendaLista) {
		this.agendaLista = agendaLista;
	}



	public boolean isNoData() {
		return noData;
	}



	public void setNoData(boolean noData) {
		this.noData = noData;
	}
    
    
    
    
}
