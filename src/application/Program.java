package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int contribuintes = sc.nextInt();
		
		System.out.println();
		for (int i=0; i<contribuintes; i++) {
			System.out.println("Digite os dados do " + (i+1) + "o contribuinte:");
			System.out.print("Renda anual com salario: ");
			double salario = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servico = sc.nextDouble();
			System.out.print("Renda anual com ganho capital: ");
			double capital = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double gastosMedicos = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double gastosEducacionais = sc.nextDouble();
			list.add(new TaxPayer(salario, servico, capital, gastosMedicos, gastosEducacionais));
			System.out.println();
		}
		
		for (int i=0; i<list.size(); i++) {
			System.out.println("Resumo do " + (i+1) + "o contribuinte:");
			double impostoBruto = list.get(i).grossTax();
			System.out.println("Imposto bruto total: " + String.format("%.2f", impostoBruto));
			double abatimento = list.get(i).taxRebate();
			System.out.println("Abatimento: " + String.format("%.2f", abatimento));
			double impostoDevido = list.get(i).netTax();
			System.out.println("Imposto devido: " + String.format("%.2f", impostoDevido));
			System.out.println();
		}
		sc.close();
	}
}
