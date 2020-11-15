package Practical_Algorigthms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        DS2 lab1 = new DS2();
        String fileName = "E:\\postgraduate\\Practical Algorithm\\lab\\lab1\\Lab1test.DAT";
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tempString = null;
            //初始化
            lab1.init();
            //获取一行并插入
            while ((tempString = reader.readLine()) != null) {
                lab1.insert(lab1.length() + "," + tempString);
            }
            Scanner in = new Scanner(System.in);
            String input;
            while (true){
                input = in.next();
                if ("Q".equals(input)){
                    break;
                }else if (input.charAt(0) == 'F'){
                    lab1.find(Integer.parseInt(input.substring(1)));
                }else if(input.charAt(0) == 'I'){
                    lab1.insert(input.substring(1));
                }else if(input.charAt(0) == 'D'){
                    lab1.delete(Integer.parseInt(input.substring(1)));
                }else {
                    lab1.printAll();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
