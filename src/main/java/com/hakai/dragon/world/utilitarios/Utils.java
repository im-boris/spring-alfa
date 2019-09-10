package com.hakai.dragon.world.utilitarios;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

public class Utils<T> {
	
	
    @SuppressWarnings("unchecked")
    public T setResponse(String stringFormatoJson, Class<?> classeDestino) {
        Gson gson = new Gson();
        return (T) gson.fromJson(stringFormatoJson, classeDestino);
    }

    
	public void gravar(String basePath, String nomeArq, String infoLog) {

		try {
			PrintWriter output = new PrintWriter(new FileWriter(basePath + nomeArq, true));
			output.printf("%s\r\n", infoLog);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public LocalDateTime obtemDataHoraAtual() {
		return LocalDateTime.now();
	}

	public DateTimeFormatter obtemTipoDataHoraFormatado(String mascara) {
		return DateTimeFormatter.ofPattern(mascara);
	}

	public String[] obtemArrayComDataHora(LocalDateTime dataHoraConsulta, DateTimeFormatter formataDataHora) {

		String horaDataLocal = dataHoraConsulta.format(formataDataHora);

		String[] campos = horaDataLocal.split(" ");

		return campos;
	}
	
}
