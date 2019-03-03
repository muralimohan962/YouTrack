package com;

public class Solution {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Murali", "muralimohan962@gmail.com", 22);
        Customer customer2 = new Customer("Vamshi", "vamshikrishna@gmail.com", 23);

        System.out.println(checkMail(customer1, customer2, "@gmail.com"));

        customer2.setEmail("vamshiballa@hotmail.com");
        System.out.println(checkMail(customer1, customer2, "@gmail.com"));
    }

    static boolean checkMail(Customer customer1, Customer customer2, String domain) {
        return customer1.getEmail().endsWith(domain) && customer2.getEmail().endsWith(domain);
    }
}
