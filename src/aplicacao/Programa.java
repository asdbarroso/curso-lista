package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import identidades.Funcionarios;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantos funionários serão cadastrados: ");
		int n = sc.nextInt();

		List<Funcionarios> listaFunc = new ArrayList<>();

		Funcionarios funcionario;

		for (int i = 1; i <= n; i++) {
			System.out.println("Funcionario #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salario : ");
			double salario = sc.nextDouble();
			funcionario = new Funcionarios(id, nome, salario);
			listaFunc.add(funcionario);
			System.out.println();
		}

		System.out.println("Informe a Id do funcionario para atualização: ");
		int idAlt = sc.nextInt();

		List<Funcionarios> result = listaFunc.stream().filter(x -> x.getId() == idAlt).collect(Collectors.toList());

		if (result.size() != 0) {
			System.out.print("Informe o percentual: ");
			double porcentagem = sc.nextDouble();
			for (Funcionarios x : result) {
				x.atualizaSalario(porcentagem);
			}
		} else {
			System.out.println("Funcionario não existe!");
		}
		System.out.println();
		System.out.println("Lista de Funcionarios");

		for (Funcionarios f : listaFunc) {
			System.out.println(f);
		}

		sc.close();
	}
}