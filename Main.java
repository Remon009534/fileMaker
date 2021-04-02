package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Make[] file = new Make[1];

        for (int i = 0; i < file.length; i++) {

            Scanner input = new Scanner(System.in);

            System.out.print("File Name: ");
            String fileName = input.nextLine().trim();

            System.out.print("File Type: ");
            String fileType = input.nextLine().trim();

            System.out.println("Enter the Content: \n");
            String fileContent = input.nextLine().trim();

            file[i] = new Make(fileName, fileType, fileContent);
            System.out.println("\n");
        }

        for(int i = 0; i < file.length; i++)
        {
            file[i].ShowInfo();
        }
    }
}