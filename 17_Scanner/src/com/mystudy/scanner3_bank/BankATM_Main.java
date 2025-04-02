package com.mystudy.scanner3_bank;

public class BankATM_Main {

	public static void main(String[] args) {
		BankATM bank = new BankATM();
		//bank = new BankATM(10000);
		bank.startBank();
		
		bank.showMoney();
		
		bank.inputMoney(1000000);

	}

}
