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

public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void exercise_3_1_printTopTransactions() {

        List<Transaction> transactions = DataHelper.loadTransactions();

        int howManyBiggestAmounts = 4;
        Set<Transaction> biggestTransactions = transactions.stream()
                .sorted((t1, t2) -> t2.amount().compareTo(t1.amount()))
                .limit(howManyBiggestAmounts)
                .collect(Collectors.toSet());

        transactions.stream()
                .sorted((t1, t2) -> t2.date().compareTo(t1.date()))
                .forEach( t -> LinePrinter.print(getColor(t, biggestTransactions), t.toString()) );
        LinePrinter.resetColor();
    }

    private Color getColor(Transaction transaction, Set<Transaction> biggestTransactions) {
        return biggestTransactions.contains(transaction) ? Color.RED : Color.GREEN;
    }

    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_3_1_printTopTransactions();

    }
}
