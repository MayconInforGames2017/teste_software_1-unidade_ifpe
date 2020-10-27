package teste_software_avaliacao1_ifpe;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContaTest {

	@Test
	void testSetNumeroValido() {
		final Conta instance = new Conta();
		final String esperado = "12345-6";
		instance.setNumero(esperado);
		final String sucesso = instance.getNumero();
		assertEquals(esperado, sucesso);
	}

	@Test
	void testSetNumeroInvalidoNaoSalva() {
		final Conta instance = new Conta();
		final String invalido = "123";
		assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
		final String obtido = instance.getNumero();
		assertNotEquals(invalido, obtido);
	}
	
	@Test
	void testSaldoInicial() {
		final Conta instance = new Conta();
		final double inicio = 0;
		final double saldo = instance.getSaldo();
		assertEquals(inicio, saldo);
	}

	@Test
	void testContaCriadaComSaldo() {
	
		try {
			Conta conta = new Conta("123456", 10);
			conta.getNumero();
			conta.getSaldo();
			assertEquals(10, conta.getSaldo());
			throw new Exception("Conta criada com sucesso!");
		} catch (Exception e) {
			System.out.println("erro:" + e);
		}
	}
	
	@Test
	void testDepositoPositivo() {
		final Conta c = new Conta();
		
		try {
			int valorDeposito = 20;
			c.debitar(valorDeposito);
			assertEquals(20, c.getSaldo());
		} catch (Exception e) {
			System.out.println("erro:" + e);
		}
		
	}
	
	@Test
	void testNaoPodeSacarValorAcimaMil() {
		final Conta c = new Conta();
		
		try {
			double valorSaque = 1001;
			c.creditar(valorSaque);
			assertEquals(1001, c.getSaldo());
		} catch (Exception e) {
			System.out.println("erro:" + e);
		}
		
	}
	
	@Test
	void testSacarValorAbaixoMil() {
		final Conta c = new Conta();
		
		try {
			double valorSaque = 10;
			c.creditar(valorSaque);
			assertEquals(10, c.getSaldo());
		} catch (Exception e) {
			System.out.println("erro:" + e);
		}
		
	}
	
}
