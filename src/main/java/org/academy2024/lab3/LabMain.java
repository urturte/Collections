package org.academy2024.lab3;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;
import org.academy2024.lab2.StatementLine;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void exercise_3_1_printTopTransactions() {

        List<Transaction> transactions = DataHelper.loadTransactions();
        int howManyBiggestAmounts = 3;

        //TODO: Find the biggest transactions
        transactions.sort((t, a) -> t.amount().compareTo(a.amount()));
        Set<Transaction> biggestTransactions = (Set<Transaction>) transactions.stream()
                .sorted((t, a)-> a.amount().compareTo(t.amount()))
                .limit(howManyBiggestAmounts)
                .collect(Collectors.toSet());
        transactions.sort((t, a) -> t.date().compareTo(a.date()));
        transactions.stream()
                .map(t -> new StatementLine(biggestTransactions.contains(t)?Color.RED:Color.GREEN, t.accountId(),t.date(), t.amount()))
                        .forEach(t -> LinePrinter.print(t.color(), t.toString()));

        LinePrinter.resetColor();
    }

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_3_1_printTopTransactions();

    }
}
