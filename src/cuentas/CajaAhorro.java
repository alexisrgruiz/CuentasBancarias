package cuentas;

public class CajaAhorro extends CuentaBancaria{


protected Integer cantExtracciones;
private Double comision;
	
	public CajaAhorro() {
		super();
		this.cantExtracciones = 0;
		this.comision = 6.00;
	}

public Boolean depositar(double monto) {
		
		if(monto <= 0)
			return false;
		
		super.saldo += monto;
		this.cantExtracciones = 0;
		return true;
	}

	public Boolean extraer(Double montoExtraer) {
		
		if(super.saldo < montoExtraer )
			return false;
		
		if(this.cantExtracciones >= 5) {
			if(super.saldo < montoExtraer + this.comision )
				return false;
			
			super.saldo -= (montoExtraer + this.comision);
			this.cantExtracciones++;
			return true;
		}
		
		super.saldo -= montoExtraer;
		this.cantExtracciones++;
		
		return true;
	}

}
