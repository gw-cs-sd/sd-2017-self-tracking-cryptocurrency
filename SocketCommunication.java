import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.*;
 
public class SocketCommunication {

    public static void main(String[] args) throws InterruptedException {
        
        final PC producerconsumer = new PC();

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerconsumer.consumer();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerconsumer.producer();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
       //Initalize the threads
        producerThread.start();
        consumerThread.start();
 
        producerThread.join();
        consumerThread.join();
    }
 
    // This class has a list of transactions, producer that queues and initializes transactions
    // and a consumer that recieves and consumes the transactions 
    public static class PC {
        // Create a transactions queue shared by producer and consumer
        LinkedList<Currency> transactions = new LinkedList<>();
        int transactionQueueCapacity = 1;
 
        public void producer() throws InterruptedException {

            while (true) {
                synchronized (this) {
                    // wait while transactions queue is full
                    while (transactions.size()==transactionQueueCapacity)
                        wait();

                    Currency testCurrency1 = new Currency(
                        "sender2", 
                        "testReciever1", 
                        new ArrayList<String> (),
                        100.00,
                        0.00,
                        new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines")),
                        "currency1"
                    );
 
                    System.out.println("Sent\t Currency: \t" + testCurrency1);
 
                    // to insert the jobs in the transactions
                    transactions.add(testCurrency1);
 
                    // notifies the consumer thread that the queue is full and to start consuming
                    notify();
                    Thread.sleep(500);
                }
            }
        }
 
        public void consumer() throws InterruptedException{
            while (true) {
                synchronized (this) {
                    
                    //If there is nothing to be recieved from the producer wait 
                    while (transactions.size()==0)
                        wait();
 
                    //Get the first transaction from the LinkedList
                    Currency temp = transactions.removeFirst();
 
                    System.out.println("Recieved Currency: \t" + temp);
 
                    // Let the producer know the queue is not full
                    notify();
                    Thread.sleep(500);
                }
            }
        }
    }
}