package projeto_bo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import javax.swing.JOptionPane;

import projeto_dao.BateriaDao;
import projeto_entity.Bateria;
import projeto_entity.Kartodromo;

public class BateriaBo {
	
	public String salvarAlterar(Bateria bateria, String parametroData, String parametroHora, List<Bateria> bateriaLista,
			String horaAbertura, String horaFechamento) throws Exception {
		
		verificarHora(bateriaLista, parametroHora, horaAbertura, horaFechamento);
		verificarDados(bateria, parametroData);
		
		try {
			
			return new BateriaDao().salvarAlterar(bateria);
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	public void verificarDados(Bateria bateria, String parametroData) throws Exception {
		
		if(bateria.getData().isBefore(LocalDate.parse(parametroData))) {
			throw new Exception("Erro, Data invalida");
		}
		
	
		if(bateria.getData().isBefore(LocalDate.now()) || bateria.getData().isEqual(LocalDate.now())) {
			throw new Exception("Erro, Data invalida");
		}
		
	}
	
	public void verificarHora(List<Bateria> bateria, String parametroHora, String horaAbertura, String horaFechamento) throws Exception {
		
		String[] parametro2 = horaAbertura.split(":");
		String[] parametro3 = horaFechamento.split(":");
		String[] hora = parametroHora.split(":");
				
		
		if(Integer.parseInt(hora[0]) < Integer.parseInt(parametro2[0]) || Integer.parseInt(hora[0]) > Integer.parseInt(parametro3[0])){
					
			throw new Exception("Erro, Horario não disponivel");
					
		}
		
		if(bateria.size() > 0) {  
			
			for(Bateria lista: bateria) {
				
				String[] horaLista = lista.getHora().toString().split(":");
				String[] horaParametro = parametroHora.split(":");
				
				if(horaLista[0].equals(horaParametro[0])) {
					
					throw new Exception("Erro, horario já ocupado");
				}
				
			}
			
		}
	
	
	}
	
	public void atualizar(Bateria bateria) throws Exception {
		
		try {
			new BateriaDao().atualizar(bateria);
		}catch(Exception e) {
			throw new Exception("ERRO AO ATUALIZAR STATUS DA BATERIA");
		}
	}
	
	public List<Bateria> listar(String parametro, String nome, LocalDate data, String hora, int id, Bateria bateria) throws Exception{
		
		data = formatarDataHora(parametro, hora);
	
		try {
			return new BateriaDao().listar(parametro, nome, data, hora, id, bateria);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean verificarBateriasAtivas(List<Bateria> bateria) {
		
		if(bateria.size() == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public LocalDate formatarDataHora(String parametro, String dataHora) {
		
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		if(parametro.equals("listaCampeonato")) {
			if(dataHora.equals("") == false) {
				return LocalDate.parse(dataHora.replaceAll("/","-"), formatar);
			}
			else {
				return null;
			}
			
		}else {
			return null;
		}
		
	}
	
	public void verificarQuantidadeBateria(List<Bateria> bateria, int maximoBateriaCampeonato) throws Exception {
		
		if(bateria.size() == maximoBateriaCampeonato) {
			throw new Exception("Maximo de baterias já cadastradas");
		}
		
	}
	
	public LocalDate converterData(String data) {
		
		if(data.equals("  /  /    ")) {
			return null;
		}
		else {
			DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return LocalDate.parse(data.replaceAll("/", "-"),formatar);
		}		
	}	
}