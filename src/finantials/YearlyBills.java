package finantials;

public interface YearlyBills {

	public abstract MonthBill getMonthBill(int month);

	public abstract void setMonthBill(int month, MonthBill monthBill);

	public abstract void freezeBills();

	public abstract boolean isFreezeBills();

	public abstract YearlyBills clone();

}
