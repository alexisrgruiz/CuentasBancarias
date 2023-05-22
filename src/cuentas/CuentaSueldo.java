package cuentas;

public class CuentaSueldo extends CuentaBancaria{

	public CuentaSueldo() {
		super();
	}
	
	public Boolean extraer(Double montoExtraer) {
		
		if(this.saldo < montoExtraer )
			return false;
		
		this.saldo -= montoExtraer;
		return true;
	}

}
