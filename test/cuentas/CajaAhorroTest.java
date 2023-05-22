package cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CajaAhorroTest {

	@Test
	public void queAlCrearLaCajaEstaTengaSaldoCero() {
		
		Double valorEsperado = 0.00D;
		CajaAhorro cAhorro = new CajaAhorro();
		Double valorActual = cAhorro.getSaldo();
		assertEquals(valorEsperado,valorActual,0.01);
	}
	
	@Test
	public void queSePuedaDepositar() {
		CajaAhorro cAhorro = new CajaAhorro();
		Boolean valorEsperado = cAhorro.depositar(2_341.50);
		assertTrue(valorEsperado);
	}
	
	@Test
	public void queSePuedaConsultarSaldo() {
		Double valorEsperado = 4_000.00;
		Double valorActual;
		CajaAhorro cAhorro = new CajaAhorro();
		cAhorro.depositar(valorEsperado);
		valorActual = cAhorro.getSaldo();
		assertEquals(valorEsperado,valorActual,0.01);
	}
	
	@Test
	public void queSePuedanSumarLosDepositosEnLaCajaDeAhorro() {
		
		CajaAhorro cAhorro = new CajaAhorro();
		
		Double[] montos = {4_000.00D, 3_000D, 2_000.00D};
		
		Double valorEsperado = 0.00D;
		
		for(int i = 0 ; i < montos.length ; i++) {
			cAhorro.depositar(montos[i]);
			valorEsperado += montos[i];
		}
		
		Double valorActual = cAhorro.getSaldo();
		assertEquals(valorEsperado, valorActual, 0.01);
	}
	
	@Test
	public void queNoSeDepositenMontosNegativos() {
		
		CajaAhorro cAhorro = new CajaAhorro();
		
		Boolean valor = cAhorro.depositar(-3_000);
		
		assertFalse(valor);
	}
	
	@Test
	public void queSePuedaExtraerDineroDeLaCajaAhorroConSaldoSuficiente() {
		
		CajaAhorro cAhorro = new CajaAhorro();
		Double depositado = 5_000D;
		Double extraido = 4_000D;
		
		cAhorro.depositar(depositado);
		Boolean valorEsperado = cAhorro.extraer(extraido);
		
		assertTrue(valorEsperado);
	}
	
	@Test
	public void queNoSePuedaExtraerDineroDeLaCajaAhorroConSaldoInsuficiente() {
		
		CajaAhorro cAhorro = new CajaAhorro();
		Double depositado = 4_000D;
		Double extraido = 5_000D;
		
		cAhorro.depositar(depositado);
		Boolean valorEsperado = cAhorro.extraer(extraido);
		
		assertFalse(valorEsperado);
	}
	
	@Test
	public void queLaExtraccionSeVeaReflejadaEnElSaldo() {
		
		CajaAhorro cAhorro = new CajaAhorro();
		Double depositado = 5_000D;
		Double extraido = 4_000D;
		
		cAhorro.depositar(depositado);
		cAhorro.extraer(extraido);
		
		Double valorEsperado = depositado - extraido;
		Double valorActual = cAhorro.getSaldo();
		
		assertEquals(valorEsperado, valorActual,0.01);
	}
	
	@Test
	public void queSeCobreComisionDespuesDeLaQuintaExtraccionConsecutiva() {
		CajaAhorro cAhorro = new CajaAhorro();
		Double deposito = 4_000.00D;
		Double extraccion = 1.00;
		Double comision = 6.00;
		Double valorEsperado = deposito - extraccion*6 - comision;
		cAhorro.depositar(deposito);
		
		for(int i  = 0 ; i < 5 ; i++) {
			cAhorro.extraer(extraccion);
		}
		
		cAhorro.extraer(extraccion);
		
		Double valorActual = cAhorro.getSaldo();
		assertEquals(valorEsperado, valorActual, 0.01);
	}
	
	@Test
	public void queNoSeCobreComisionConDepositoEnMedio() {
		CajaAhorro cAhorro = new CajaAhorro();
		Double deposito = 4_000.00D;
		Double extraccion = 1.00;
		Double valorEsperado = deposito*2 - extraccion*6;
		
		cAhorro.depositar(deposito);
		
		for(int i  = 0 ; i < 5 ; i++) {
			cAhorro.extraer(extraccion);
		}
		
		cAhorro.depositar(deposito);
		
		cAhorro.extraer(extraccion);
		
		Double valorActual = cAhorro.getSaldo();
		assertEquals(valorEsperado, valorActual, 0.01);
	}
	
	@Test
	public void queNoSeExtraigaDespuesDeLaQuintaSiNoTengoSaldo() {
		CajaAhorro cAhorro = new CajaAhorro();
		Double deposito = 6.00D;
		Double extraccion = 1.00;

		cAhorro.depositar(deposito);
		
		for(int i  = 0 ; i < 5 ; i++) {
			cAhorro.extraer(extraccion);
		}
		
		assertFalse(cAhorro.extraer(extraccion));
	}

}
