package com.fernandopaniagua.formateo;

import java.text.DecimalFormat;
import java.text.NumberFormat;//Permite construir 'formateadores' de números
import java.text.ParseException;
import java.util.Locale;

public class AppNumber {

	public static void main(String[] args) {
		NumberFormat.getInstance();//Un NumberFormat genérico
		NumberFormat.getInstance(Locale.getDefault());//Un NumberFormat genérico para un Locale concreto
		
		NumberFormat.getNumberInstance();//Específico para números
		NumberFormat.getNumberInstance(Locale.getDefault());//Específico para números para un locale concreto
		
		System.out.println(1000000.23);//SALIDA 1000000.23
		NumberFormat nfES = NumberFormat.getNumberInstance(Locale.getDefault());
		System.out.println(nfES.format(1000000.23));//SALIDA 1.000.000,23
		NumberFormat nf2 = NumberFormat.getNumberInstance(Locale.US);
		System.out.println(nf2.format(1000000.23));//1,000,000.23
		
		NumberFormat.getCurrencyInstance();//Específico para moneda
		NumberFormat.getCurrencyInstance(Locale.getDefault());
		
		System.out.println(1_000_000 + "€");//Hecho a mano. SALIDA 1000000€
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();
		System.out.println(nf3.format(1_000_000));//SALIDA 1.000.000,00 €
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf4.format(1_000_000));//SALIDA $1,000,000.00
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		System.out.println(nf5.format(1_000_000));//SALIDA ￥1,000,000
		
		NumberFormat.getPercentInstance();//Específico para %
		NumberFormat.getPercentInstance(Locale.getDefault());
		
		float importe = 0.5260f;//Expresado en fracción de 1
		NumberFormat nf6 = NumberFormat.getPercentInstance();
		System.out.println(nf6.format(importe));//SALIDA 53 %
		NumberFormat nf7 = NumberFormat.getPercentInstance(Locale.CHINA);
		System.out.println(nf7.format(importe));//SALID 53%
		
		NumberFormat.getIntegerInstance();//Específico para enteros
		NumberFormat.getIntegerInstance(Locale.getDefault());
		
		//El método parse de NumberFormat convierte del número expresado en un Locale concreto a número 'normal'
		try {
			float numero = nfES.parse("100.000,23").floatValue();
			System.out.println(numero);//SALIDA 100000.23
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//DecimalFormat como clase específica para dar formato a números decimales
		DecimalFormat df1 = new DecimalFormat("000000.0000");
		System.out.println(df1.format(23.18));//SALIDA 000023,1800
		
		float PI = 3.14159265359f;
		DecimalFormat df2 = new DecimalFormat("#.####");//Sólo hay que indicar una # en la parte entera
		System.out.println(df2.format(3.14));//SALIDA 3,14
		System.out.println(df2.format(PI));//SALIDA 3,1416
		System.out.println(df2.format(12345.238891));//SALIDA 12345,2389
		
		//Clase DecimalFormat
		DecimalFormat df3 = new DecimalFormat("#.000");
		System.out.println(df3.format(3.14));//SALIDA 3,140
		System.out.println(df3.format(PI));//SALIDA 3,142
		System.out.println(df3.format(12345.238891));//SALIDA 12345,239
				
		//Método estático format de String
		System.out.println(String.format("%d", 10));//SALIDA 10
		System.out.println(String.format("%f", 10.5f));//10,500000
		System.out.println(String.format(Locale.US, "%,f", 1000000.28f));//1,000,000.250000
		System.out.println(String.format(Locale.getDefault(), "%,f", 1000000.28f));//1.000.000,250000
		
		System.out.println(String.format("%2.2f", PI));//SALIDA 3,14
		System.out.println(String.format("%1.5f", PI));//SALIDA 3,14159
		System.out.println(String.format("%15.2f", PI));//           3,14
		System.out.println(String.format("%015.2f", PI));//000000000003,14
		System.out.println(String.format("%025.20f", PI));//0003,14159274101257320000
	}
}
