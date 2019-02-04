public class Bank {
    public double calculateYearlyInterest(Account account) throws InvalidBalanceException{

        double bal = account.getBalance();

        if (bal < 0) {
            throw new InvalidBalanceException("Balance of savings account can't be negative");
        }

        if (bal >= 0 && bal < 100) { //intentional error? answer is no
            return bal * .03;
        } else if (bal >= 100 && bal < 1000) {
            return bal * .05;
        } else {
            return bal * .07;
        }
    }
}