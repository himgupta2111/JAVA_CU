// WITHOUT SYNCHRONIZATION

class Bank {

    // Initial custom balance
    int total = 100;

    // Money withdrawal method. Withdraw only if total money
    // greater than or equal to the money requested for
    // withdrawal
    void withdraw(String name, int withdrawal) {
        if (total >= withdrawal) {
            System.out.println(name + " withdrawn " + withdrawal);
            total = total - withdrawal;

            System.out.println(total);
            // Making the thread sleep for 1 second after
            // each withdrawal
            // Try block to check for exceptions
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Else if the money requested for withdrawal is
        // greater than the balance then deny transaction
        else {
            System.out.println(name + " you can not withdraw " + withdrawal);
            System.out.println("your balance is: " + total);
            // Making the thread sleep for 1 second after
            // each transaction failure
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method - To deposit money
    // Accepting money whenever deposited
    void deposit(String name, int deposit) {
        System.out.println(name + " deposited " + deposit);
        total = total + deposit;
        System.out.println("Balance after deposit: " + total);
        // Making the thread sleep for 1 second after
        // each deposit
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Method - Withdraw method
// Called from ThreadWithdrawal class
// using the object of Bank class passed
// from the main() method
class ThreadWithdrawal extends Thread {
    Bank bank;
    String name;
    int dollar;

    // Constructor of this method
    ThreadWithdrawal(Bank ob, String name, int money) {
        this.bank = ob;
        this.name = name;
        this.dollar = money;
    }

    // run() method for thread
    public void run() {
        bank.withdraw(name, dollar);
    }
}

// Deposit method is called from ThreadDeposit class
// using the object of Bank class passed
// from the main method
class ThreadDeposit extends Thread {

    Bank bank;
    String name;
    int dollar;

    ThreadDeposit(Bank bank, String name, int money) {
        // This keyword refers t ocurrent instance itself
        this.bank = bank;
        this.name = name;
        this.dollar = money;
    }

    public void run() {
        bank.deposit(name, dollar);
    }
}

// Class 2
// Main class
public class WithoutSyncBank {
    // Main driver method
    public static void main(String[] args) {
        // Declaring an object of Bank class and passing the
        // object along with other parameters to the
        // ThreadWithdrawal and ThreadDeposit class. This
        // will be required to call withdraw and deposit
        // methods from those class
        // Creating an object of class1
        Bank bank = new Bank();
        ThreadWithdrawal t1 = new ThreadWithdrawal(bank, "A", 20);
        ThreadWithdrawal t2 = new ThreadWithdrawal(bank, "B", 40);
        ThreadDeposit t3 = new ThreadDeposit(bank, "C", 35);
        ThreadWithdrawal t4 = new ThreadWithdrawal(bank, "D", 80);
        ThreadWithdrawal t5 = new ThreadWithdrawal(bank, "E", 40);

        // When a program calls the start() method, a new
        // thread is created and then the run() method is
        // executed.

        // Starting threads created above
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
