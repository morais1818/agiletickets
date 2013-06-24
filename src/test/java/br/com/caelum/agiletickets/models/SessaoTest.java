package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

private Sessao sessao;

@Before
public void inicializa(){
	this.sessao = new Sessao();
	//System.out.println("Antes");
}

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void podeReservarTodosIngressos () throws Exception{
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		Assert.assertEquals(true, sessao.podeReservar(10));
		
	}
}
