package br.com.brasolin.exame;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

import br.com.brasolin.exame.dao.DaoAgenda;
import br.com.brasolin.exame.entity.Agenda;

@Conversion()
public class NovoAction extends ActionSupport {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String codigoCliente = "", codigoExame = "", nomeCliente = "", nomeExame = "";
	private Date dataExame = new Date();
	Agenda agenda = null;
	DaoAgenda daoAgenda = null;
	
	public String execute() throws Exception {
		
			return SUCCESS;
		
        
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

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
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
	
	
	
	
}
