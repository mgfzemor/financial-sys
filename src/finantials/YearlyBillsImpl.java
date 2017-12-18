package finantials;

public class YearlyBillsImpl implements YearlyBills {

	static private int kMaxBills = 12;
	
	private boolean isFreeze;

	private MonthBill[] bills;

	public YearlyBillsImpl() {
		bills = new MonthBill[kMaxBills];
	}
	
	public MonthBill getMonthBill(int month) {
		return bills[month];
	}

	public void setMonthBill(int month, MonthBill monthBill) {
		if (!isFreezeBills())
			bills[month] = monthBill;
	}

	public void freezeBills() {
		isFreeze = true;
	}

	public boolean isFreezeBills() {
		return isFreeze;
	}

	public YearlyBills clone() {
		
		YearlyBillsImpl yearBills = new YearlyBillsImpl();
		
		for (int i = 0; i < kMaxBills; i++) {
			yearBills.bills[i] = bills[i].clone();
			yearBills.isFreeze = isFreeze;
		}
		
		return yearBills;
	}

	
}
