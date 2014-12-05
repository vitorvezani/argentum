package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {

		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		// digite foreach e de um ctrl + espaço para ajudar a criar o bloco	abaixo!
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		
		minimo = negociacoes.size() == 1 ? negociacoes.get(0).getPreco() : minimo;
		minimo = negociacoes.size() == 0 ? 0 : minimo;
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
	}
	
}
