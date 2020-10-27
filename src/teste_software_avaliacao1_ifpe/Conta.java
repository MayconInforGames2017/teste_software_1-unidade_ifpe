package teste_software_avaliacao1_ifpe;

public class Conta {

	private String numero;
	private double saldo;

	public Conta() {
	}

	public Conta(String numero, double saldo) throws Exception {

		for (int i = 0; i < numero.length() - 1; i++) {
			if (!Character.isDigit(numero.charAt(i)))
				throw new Exception("Conta deve possuir apenas dígitos. Conta inválida!");
		}

		if (saldo <= 0)
			throw new Exception("Saldo nulo ou negativo. Conta inválida!");
		this.numero = numero;
		this.saldo = saldo;
	}

	public Conta(String numero) throws Exception {

		this(numero, 0);

	}

	public void creditar(double valor) throws Exception {

		if (valor <= 0 || valor > 1000)
			throw new Exception("Credito impossivel!");
		saldo += valor;

	}

	public void debitar(double valor) throws Exception {

		if (valor <= 0)
			throw new Exception("Debito impossível!");
		saldo -= valor;
		
		if (valor > 0)
			throw new Exception("Debito realizado com sucesso!");
		
		if (saldo < -300)
			throw new Exception("Debito não realizado! Saldo insuficiente em conta!");
	}

	public double getSaldo() {

		
		return saldo;

	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {

		return numero;

	}

	public void setNumero(String numero) {
		if(!numero.matches("\\d{5}-\\d")) {
			throw new IllegalArgumentException("Número inválido. Deve estar no formato 99999-9");
		}
		
		this.numero = numero;
	}

}
