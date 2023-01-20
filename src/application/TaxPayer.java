package application;

public class TaxPayer {

	private Double salaryIncome;
	private Double serviccesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double serviccesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviccesIncome = serviccesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServiccesIncome() {
		return serviccesIncome;
	}

	public void setServiccesIncome(Double serviccesIncome) {
		this.serviccesIncome = serviccesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double monthlySalary = salaryIncome / 12.0;
		double tax = 0.0;
		if (monthlySalary >= 3000.00 && monthlySalary <= 5000.00) {
			tax = salaryIncome * 0.10;
		}else {
			if (monthlySalary > 5000.00) {
				tax = salaryIncome * 0.20;
			}
		}
		return tax;
	}
	
	public double servicesTax() {
		double tax = serviccesIncome * 0.15;
		return tax;
	}
	
	public double capitalTax() {
		double tax = capitalIncome * 0.20;
		return tax;
	}
	
	public double grossTax() {
		double total = salaryTax() + servicesTax() + capitalTax();
		return total;
	}
	
	public double taxRebate() {
		double rebate = healthSpending + educationSpending;
		double tax = 0.0;
		if (rebate > grossTax() * 0.30) {
			tax = grossTax() * 0.30;
		}else {
			tax = rebate;
		}
		return tax;
	}
	
	public double netTax() {
		double tax = grossTax() - taxRebate();
		return tax;
	}
}
