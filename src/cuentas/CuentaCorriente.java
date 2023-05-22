package cuentas;

public class CuentaCorriente extends CuentaBancaria{

	private Double comisionPorDescubierto;
	private Double montoDescubierto;
	
	public CuentaCorriente(Double descubierto) {
		super();
		this.comisionPorDescubierto = 0.05D;
		this.montoDescubierto = descubierto;
	}
	
	public Boolean extraer(Double montoExtraer) {
		
		if(super.saldo + this.montoDescubierto <= montoExtraer )
			return false;
			
		if(super.saldo < montoExtraer) {		
				
			if((-(super.saldo - montoExtraer) * this.comisionPorDescubierto) > this.montoDescubierto)
				return false;
		
			super.saldo = -(super.saldo - montoExtraer) * this.comisionPorDescubierto;
			return true;
		}
		
		super.saldo -= montoExtraer;	
		return true;
	}

	public Double getDescubiertoTotal() {
			return this.montoDescubierto;
	}
	
	public Double getDeuda() {
		return super.saldo >= 0 ? 0.0 : super.saldo ;
}
	
	public Double getDescubiertoRestante() {
		return this.montoDescubierto - getDeuda();
}
}
