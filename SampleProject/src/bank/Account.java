package bank;

public class Account {
	// field
	private String username;
	private String accountNum;
	private int money;
	
	// constructor
	public Account() {
		// default
	}
	
	public Account(String username, String accountNum, int money) {
		this.username = username;
		this.accountNum = accountNum;
		this.money = money;
		System.out.println(this.getAccountNum() + this.getUsername());
		printMoney();
	}
	
	// method
	public void deposit(int inputMoney) {
		System.out.println(inputMoney + " 원 입금합니다.");
		this.money += inputMoney;
		printMoney();
	}
	
	public void withdraw(int outputMoney) {
		System.out.println(outputMoney + " 원 출금합니다.");
		this.money -= outputMoney;
		printMoney();
	}

	public void printMoney() {
		System.out.println("잔액 : " + this.money);
	}
	
	public String getUsername() {
		return "( 예금주 : " + username + " )";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountNum() {
		return "계좌 " + accountNum + " ";
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public static void main(String[] args) {
		Account account = new Account("홍길동", "123-456789", 10000);
		account.deposit(20000);
		account.withdraw(45000);
	}
}
