package org.academy2024.lab4;

import org.academy2024.*;

import javax.lang.model.element.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void lab4_1_namesOfAccountHolders() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        List<AccountHolder> accountHolders = DataHelper.loadAccountHolders();

        //TODO: Map ids in transactions to account holders and create statement lines

        HashMap<String, String> names = new HashMap<>();
        accountHolders.forEach(a -> names.put(a.accountId(), a.name()));
        transactions.stream().map(t -> new StatementLine(names.get(t.accountId()), t.accountId(), t.date(), t.amount()))
                .forEach(t -> LinePrinter.print(t.toString()));

        LinePrinter.resetColor();

    }

    void intoMap(Map<String, AccountHolder> m, AccountHolder a) {
        m.put(a.accountId(), a);
    }

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.lab4_1_namesOfAccountHolders();

    }
}
