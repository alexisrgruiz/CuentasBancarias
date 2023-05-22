package cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	@Test
	public void queAlCrearLaCuentaEstaTengaMontoDescubierto() {
		Double valorEsperado = 150.00;
		
		CuentaCorriente cCorriente = new CuentaCorriente(valorEsperado);
		Double valorActual = cCorriente.getDescubiertoTotal();
		
		assertEquals(valorEsperado, valorActual, 0.01);
	}
	
	@Test
	public void queAlQuererExtraerMasQueMontoDescubiertoPosibleNoExtraiga() {
		
		Double descubierto = 150.00;
		Double deposito = 200.00;
		Double extraccion = deposito + descubierto + 3;
		CuentaCorriente cCorriente = new CuentaCorriente(descubierto);
		cCorriente.depositar(deposito);
		
		Boolean resultado = cCorriente.extraer(extraccion);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queAlQuererExtraerYTengaSaldoNegativoMaximoNoExtraiga() {
		
		Double descubierto = 150.00;
		Double deposito = 200.00;
		Double extraccion = deposito + descubierto;
		CuentaCorriente cCorriente = new CuentaCorriente(descubierto);
		cCorriente.depositar(deposito);
		
		Boolean resultado = cCorriente.extraer(extraccion);
		
		assertFalse(resultado);
	}

}
