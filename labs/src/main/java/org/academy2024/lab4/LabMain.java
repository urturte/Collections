package org.academy2024.lab4;

import org.academy2024.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void lab4_1_namesOfAccountHolders() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        List<AccountHolder> accountHolders = DataHelper.loadAccountHolders();

        Map<String, AccountHolder> accountHoldersMap = accountHolders
                .stream()
                .collect(HashMap::new, (m, a) -> intoMap(m, a), HashMap::putAll);

        transactions
                .stream()
                .map(t -> new StatementLine(accountHoldersMap.get(t.accountId()).name(), t.accountId(), t.date(), t.amount()))
                .forEach(statementLine -> LinePrinter.print(Color.GREEN, statementLine.toString()));
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
