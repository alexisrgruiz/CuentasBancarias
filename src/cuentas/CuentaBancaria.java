package cuentas;

public abstract class CuentaBancaria {
	protected Double saldo;
	
	public CuentaBancaria() {
		this.saldo = 0.00D;
	}
	
	public Boolean depositar(double monto) {
		
		if(monto <= 0)
			return false;
		
		this.saldo += monto;
		return true;
	}
	

	public Double getSaldo() {
		return this.saldo;
	}
	
	public abstract Boolean extraer(Double monto);
}
