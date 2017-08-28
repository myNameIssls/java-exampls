package cn.tyrone.javase.multithreading;

public class Account {

	private int balance = 10000; // 账户余额
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * 账户余额结算方法
	 * @param operationType 操作类型
	 * @param operationMoney 操作金额
	 * @return
	 */
	public synchronized int calc(String operationType, int operationMoney) {

		switch (operationType) {
		case "add": // 添加操作
			this.balance += operationMoney;
			break;
		case "reduce": // 减少操作
			this.balance -= operationMoney;
			break;
		default:
			break;
		}

		return this.balance;
	}

}
