import exceprions.WrongAccountException;
import exceprions.WrongCurrencyException;
import exceprions.WrongOperationException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        List<Account> accounts = new ArrayList<>(){
            {
                add(new Account("accountId000", 50, "USD"));
                add(new Account("accountId003", 250, "HRV"));
                add(new Account("accountId001", 50, "EUR"));
                add(new Account("accountId001", 50, "USD"));
                add(new Account("accountId001", 50, "USD"));
            }
        };

        for (Account account : accounts) {
            try {
                bankApplication.process(account.getId(), account.getBalance(), account.getCurrency());
            } catch (WrongAccountException wrongAccountException) {
                System.out.println(String.format("No such account '%s' exists", account.getId()));
            } catch (WrongCurrencyException wrongCurrencyException) {
                System.out.println(String.format("The account '%s' has an account in another currency", account.getId()));
            } catch (WrongOperationException wrongOperationException) {
                System.out.println(String.format("The account '%s' does not have enough funds, now on the account '%s'", account.getId(), account.getBalance()));
            } catch (Exception exception) {
                System.out.println("A processing error occurred, please try again");
            } finally {
                System.out.println("Thank you for using our service");
            }
        }
    }
}