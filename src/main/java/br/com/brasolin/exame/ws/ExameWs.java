package br.com.brasolin.exame.ws;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.brasolin.exame.dao.DaoAgenda;
import br.com.brasolin.exame.entity.Agenda;

@WebService(serviceName="ExameWsService")
@SOAPBinding(style=Style.RPC)
public class ExameWs {

	@WebMethod
	public @WebResult(name="agendaResponse") List<Agenda> listarAgendaCliente(@WebParam Agenda pesquisaRequest) 
            throws Exception{
	
		DaoAgenda daoAgenda = new DaoAgenda();
		List<Agenda> lista = new ArrayList<Agenda>();
		ResultSet rs;
		try {
			rs = daoAgenda.listarAgendaCliente(pesquisaRequest.getCodigoCliente());
			
			if (rs != null) {
				while (rs.next()) {
					Agenda agenda = new Agenda();
					agenda.setId(rs.getInt("ID"));
					agenda.setData(rs.getDate("DATA"));
					agenda.setCodigoCliente(rs.getString("CODIGOCLIENTE"));
					agenda.setNomeCliente(rs.getString("NOMECLIENTE"));
					agenda.setCodigoExame(rs.getString("CODIGOEXAME"));
					agenda.setNomeExame(rs.getString("NOMEEXAME"));
					lista.add(agenda);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	@WebMethod
	public @WebResult(name="agendaResponse") List<Agenda> listarAgendaToda() 
            throws Exception{
	
		DaoAgenda daoAgenda = new DaoAgenda();
		List<Agenda> lista = new ArrayList<Agenda>();
		ResultSet rs;
		try {
			rs = daoAgenda.listarAgendaCliente("");
			if (rs != null) {
				while (rs.next()) {
					Agenda agenda = new Agenda();
					agenda.setId(rs.getInt("ID"));
					agenda.setCodigoCliente(rs.getString("CODIGOCLIENTE"));
					agenda.setNomeCliente(rs.getString("NOMECLIENTE"));
					agenda.setCodigoExame(rs.getString("CODIGOEXAME"));
					agenda.setNomeExame(rs.getString("NOMEEXAME"));
					agenda.setData(rs.getDate("DATA"));
					lista.add(agenda);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}
	
	
	
}
