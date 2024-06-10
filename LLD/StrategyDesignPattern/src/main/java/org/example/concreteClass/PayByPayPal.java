package org.example.concreteClass;

import org.example.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private Boolean signedIn = false;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    @Override
    public boolean pay(int payAmount) {
        if(signedIn){
            System.out.println("Paying "+ payAmount + " using PayPal.");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try{
            while(!signedIn) {
                System.out.println("Enter the user's email: ");
                email = READER.readLine();
                System.out.print("Enter the password: ");
                password = READER.readLine();
                if(verify())
                    System.out.println("Data verification has been successful.");
                else
                    System.out.println("Wrong email or password");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verify() {
        this.signedIn = email.equals(DATA_BASE.get(password));
        return signedIn;
    }
}
