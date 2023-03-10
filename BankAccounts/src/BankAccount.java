class BankAccount {
    private String name;
    private double balance;
    private long accountNo;
    private long idNumber;
    private String phoneNumber;
    private String address;

    public BankAccount(String name, long accountNo, double balance, long idNumber) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
        this.idNumber = idNumber;
        phoneNumber = "0";
        address = "";
    }

    public String getName() {

        return name;
    }

    public double getBalance() {

        return balance;
    }

    public long getAccountNo() {

        return accountNo;
    }

    public long getIdNumber() {

        return idNumber;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getAddress() {

        return address;
    }

    public void setName(String newName) {

        this.name = newName;
    }

    public void setPhoneNumber(String newPhoneNumber) {

        this.phoneNumber = newPhoneNumber;
    }

    public void setAddress(String newAddress) {

        this.address = newAddress;
    }

    public String toString() {

        return name + " " + accountNo + " " + balance + " TL";
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: " + amount + " TL is an invalid value. The value that you deposited must be greater than zero (0).");
            return 0;
        }
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: " + amount + " TL is an invalid value. The value that you withdraw must be greater than zero (0).");
            return 0;
        }
        if (balance < amount) {
            System.out.println("ERROR: " + amount + " TL is an invalid value. The value that you withdraw must be less than your balance.");
            return 0;
        }
        balance -= amount;
        return balance;
    }

    public double transfer(BankAccount target, double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: " + amount + " TL is an invalid value. The value that you transferred must be greater than zero (0).");
            return 0;
        }
        if (balance < amount) {
            System.out.println("ERROR: " + amount +  " TL is an invalid value. The value that you transferred must be less than your balance.");
            return 0;
        }
        else {
            balance = balance - amount;
            target.deposit(amount);
        }
        return amount;
    }

}
class Main {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount("Erayk", 23423, 100.00, 123456789);
        BankAccount bank2 = new BankAccount("Jason", 46372, 500.00,987654321);
        System.out.println(bank1);

        bank1.getIdNumber();
        bank1.getPhoneNumber();
        bank1.getAddress();
        System.out.println("\n" + bank1.getIdNumber() + " " + bank1.getPhoneNumber() + " " + bank1.getAddress() + "\n");

        bank1.setPhoneNumber("053XXXXXXXX");
        bank1.setAddress("XXX Kartal/Istanbul");
        bank1.setName("Eray");

        System.out.println(bank1);
        System.out.println("\n" + bank1.getIdNumber() + " " + bank1.getPhoneNumber() + " " + bank1.getAddress() + "\n");
        System.out.println(bank2.getName() + " " + bank2.getBalance() + " TL\n");

        bank1.deposit(-200);
        bank1.deposit(150);
        System.out.println("Eray's new balance : " + bank1.getBalance() + " TL\n");

        bank2.withdraw(-200);
        bank2.withdraw(1000);
        bank2.withdraw(150);
        System.out.println("Jason's new balance : " + bank2.getBalance() + " TL\n");

        bank1.transfer(bank2, -200);
        bank1.transfer(bank2, 1000);
        bank1.transfer(bank2, 100);
        System.out.println("\nEray's new balance : " + bank1.getBalance() + " TL");
        System.out.println("Jason's new balance : " + bank2.getBalance() + " TL");
    }
}
