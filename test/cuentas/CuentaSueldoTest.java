package cuentas;

import static org.junit.Assert.*;
import org.junit.Test;

public class CuentaSueldoTest {

	@Test
	public void queAlCrearLaCuentaEstaTengaSaldoCero() {
		
		Double valorEsperado = 0.00D;
		CuentaSueldo cSueldo = new CuentaSueldo();
		Double valorActual = cSueldo.getSaldo();
		assertEquals(valorEsperado,valorActual,0.01);
	}
	
	@Test
	public void queSePuedaDepositar() {
		CuentaSueldo cSueldo = new CuentaSueldo();
		Boolean valorEsperado = cSueldo.depositar(2_341.50);
		assertTrue(valorEsperado);
	}
	
	@Test
	public void queSePuedaConsultarSaldo() {
		Double valorEsperado = 4_000.00;
		Double valorActual;
		CuentaSueldo cSueldo = new CuentaSueldo();
		cSueldo.depositar(valorEsperado);
		valorActual = cSueldo.getSaldo();
		assertEquals(valorEsperado,valorActual,0.01);
	}
	
	@Test
	public void queSePuedanSumarLosDepositosEnLaCuentaSaldo() {
		
		CuentaSueldo cSueldo = new CuentaSueldo();
		
		Double[] montos = {4_000.00D, 3_000D, 2_000.00D};
		
		Double valorEsperado = 0.00D;
		
		for(int i = 0 ; i < montos.length ; i++) {
			cSueldo.depositar(montos[i]);
			valorEsperado += montos[i];
		}
		
		Double valorActual = cSueldo.getSaldo();
		assertEquals(valorEsperado, valorActual, 0.01);
	}
	
	@Test
	public void queNoSeDepositenMontosNegativos() {
		
		CuentaSueldo cSueldo = new CuentaSueldo();
		
		Boolean valor = cSueldo.depositar(-3_000);
		
		assertFalse(valor);
	}
	
	@Test
	public void queSePuedaExtraerDineroDeLaCuentaSaldoConSaldoSuficiente() {
		
		CuentaSueldo cSueldo = new CuentaSueldo();
		Double depositado = 5_000D;
		Double extraido = 4_000D;
		
		cSueldo.depositar(depositado);
		Boolean valorEsperado = cSueldo.extraer(extraido);
		
		assertTrue(valorEsperado);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroDeLaCuentaSaldoConSaldoInsuficiente() {
		
		CuentaSueldo cSueldo = new CuentaSueldo();
		Double depositado = 4_000D;
		Double extraido = 5_000D;
		
		cSueldo.depositar(depositado);
		Boolean valorEsperado = cSueldo.extraer(extraido);
		
		assertFalse(valorEsperado);
	}
	
	@Test
	public void queLaExtraccionSeVeaReflejadaEnElSaldo() {
		
		CuentaSueldo cSueldo = new CuentaSueldo();
		Double depositado = 5_000D;
		Double extraido = 4_000D;
		
		cSueldo.depositar(depositado);
		cSueldo.extraer(extraido);
		
		Double valorEsperado = depositado - extraido;
		Double valorActual = cSueldo.getSaldo();
		
		assertEquals(valorEsperado, valorActual,0.01);
	}

}
