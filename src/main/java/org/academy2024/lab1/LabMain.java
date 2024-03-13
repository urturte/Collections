package org.academy2024.lab1;

import org.academy2024.Color;
import org.academy2024.DataHelper;
import org.academy2024.LinePrinter;
import org.academy2024.Transaction;

import java.util.List;


public class LabMain {

    private List<Transaction> transactions = DataHelper.loadTransactions();

    private void exercise_1_1_simplyPrintTransactions() {

        transactions.forEach(t -> LinePrinter.print(Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }

    private void exercise_1_2_printTransactionsSorted() {

        //TODO: Sort transactions here
//        transactions.sort((t, a)-> a.amount().compareTo(t.amount()));
//        transactions.sort((t,a) -> a.accountId().compareTo(t.accountId()));
        transactions.sort((t,a) -> a.date().compareTo(t.date()));

        transactions.forEach(t -> LinePrinter.print(Color.GREEN, t.toString()));
        LinePrinter.resetColor();
    }


    public static void main(String[] args) {

        LabMain lab = new LabMain();

        lab.exercise_1_1_simplyPrintTransactions();
        lab.exercise_1_2_printTransactionsSorted();
    }
}
