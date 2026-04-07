package com.quicklypark.back.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.quicklypark.back.acceso.entity.PlazaEntity;

public class FicheroParkingUtil {

	public static final char SIMBOLO_PLAZA = 'X';

	public static List<PlazaEntity> leerPlazas(MultipartFile fichero, long idParking) throws IOException {
		List<PlazaEntity> plazas = new ArrayList<PlazaEntity>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(fichero.getInputStream()));

		String linea;
		int fila = 0;
		do {
			linea = reader.readLine();
			if (linea != null) {
				plazas.addAll(leerFila(linea, fila, idParking));
				fila++;
			}
		} while (linea != null);

		return plazas;
	}
	
	public static List<PlazaEntity> leerPlazas(MultipartFile fichero) throws IOException {
		return leerPlazas(fichero, -1);
	}

	private static List<PlazaEntity> leerFila(String linea, int numFila, long idParking) {
		List<PlazaEntity> plazas = new ArrayList<PlazaEntity>();

		for (int numColumna = 0; numColumna < linea.length(); numColumna++) {
			if (SIMBOLO_PLAZA == linea.charAt(numColumna)) {
				PlazaEntity plaza = new PlazaEntity(0, numFila, numColumna, idParking, true);
				plazas.add(plaza);
			}
		}

		return plazas;
	}

}
