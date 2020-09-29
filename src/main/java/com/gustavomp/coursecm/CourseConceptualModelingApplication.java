package com.gustavomp.coursecm;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavomp.coursecm.domain.Categoria;
import com.gustavomp.coursecm.domain.Cidade;
import com.gustavomp.coursecm.domain.Cliente;
import com.gustavomp.coursecm.domain.Endereco;
import com.gustavomp.coursecm.domain.Estado;
import com.gustavomp.coursecm.domain.Pagamento;
import com.gustavomp.coursecm.domain.PagamentoComBoleto;
import com.gustavomp.coursecm.domain.PagamentoComCartao;
import com.gustavomp.coursecm.domain.Pedido;
import com.gustavomp.coursecm.domain.Produto;
import com.gustavomp.coursecm.domain.enums.EstadoPagamento;
import com.gustavomp.coursecm.domain.enums.TipoCliente;
import com.gustavomp.coursecm.repositories.CategoriaRepository;
import com.gustavomp.coursecm.repositories.CidadeRepository;
import com.gustavomp.coursecm.repositories.ClienteRepository;
import com.gustavomp.coursecm.repositories.EnderecoRepository;
import com.gustavomp.coursecm.repositories.EstadoRepository;
import com.gustavomp.coursecm.repositories.PagamentoRepository;
import com.gustavomp.coursecm.repositories.PedidoRepository;
import com.gustavomp.coursecm.repositories.ProdutoRepository;

@SpringBootApplication
public class CourseConceptualModelingApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CourseConceptualModelingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Categoria and Produto instantiation
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//Estado and Cidade isntantiation
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Cliente and Endereco instantiation
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "53425347", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("2734658854", "94736522"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Jardim", "38574677", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "47895847", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		//Pedido and Pagamento instantiation
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}

}
