package br.com.brasolin.exame;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

import br.com.brasolin.exame.dao.DaoAgenda;
import br.com.brasolin.exame.entity.Agenda;

@Conversion()
public class AlterarAction extends ActionSupport {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id = 0;
	Agenda agenda = null;
	DaoAgenda daoAgenda = null;
	String submitType;
	private String codigoCliente = "", codigoExame = "", nomeCliente = "", nomeExame = "";
	private Date dataExame = new Date();
	
	
	public String execute() throws Exception {
		
		daoAgenda = new DaoAgenda();
		if (submitType != null && submitType.equals("obter")) {
		    agenda = daoAgenda.obterAgenda(id);
		    codigoExame = agenda.getCodigoExame();
		    nomeExame = agenda.getNomeExame();
		    codigoCliente = agenda.getCodigoCliente();
		    nomeCliente = agenda.getNomeCliente();
		    dataExame = agenda.getData();
		    return SUCCESS;
		} else {
			Agenda agenda = new Agenda();
			agenda.setId(id);
			agenda.setCodigoCliente(codigoCliente);
			agenda.setCodigoExame(codigoExame);
			agenda.setData(dataExame);
			agenda.setNomeCliente(nomeCliente);
			agenda.setNomeExame(nomeExame);
			daoAgenda.alterarAgenda(agenda);
			return "EXCLUIDO";
		}
		
        
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getCodigoExame() {
		return codigoExame;
	}

	public void setCodigoExame(String codigoExame) {
		this.codigoExame = codigoExame;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}


	
}

	