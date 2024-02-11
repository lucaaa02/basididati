package it.uniroma2.dicii.bd;


import Controller.MainController;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        MainController applicationController = new ApplicationController();
        applicationController.start();
    }
}
