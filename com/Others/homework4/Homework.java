package Algorithm.com.Others.homework4;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args){
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        String address = "";
        double charge = 0;
        String voltage, voltageOption;
        String season = "";
        int codeNum = 0; // 가정용인지 산업용인지 확인
        int amount = 0;
        int option = 0;

        System.out.print("주소를 입력하세요 : ");
        address = strScanner.nextLine();

        while(true){
            if(address.equals("q") || address.equals("Q")) break;
            
            System.out.print("식별코드를 선택하세요(주택용 : 1, 산업용 : 2) : ");
            codeNum = intScanner.nextInt();
            System.out.print("사용량을 선택하세요 : ");
            amount = intScanner.nextInt();
            System.out.print("계절을 선택하세요 : ");
            season = strScanner.nextLine();

            if(codeNum == 1){                    // 가정용 저전압일때
                if(season.equals("Summer")){
                    if(amount <= 300){
                        charge = 910 + (amount * 93.3);
                    }
                    else if(amount > 300 && amount <= 450){
                        charge = 1600 + (300 * 93.3) + ((amount - 300) * 187.9);
                    }
                    else{
                        charge = 7300 + (300 * 93.3) + (150 * 187.9) + ((amount - 450) * 280.6);
                    }
                }
                else{   // 여름이 아닐때
                    if(amount <= 200){
                        charge = 910 + (amount * 93.3);
                    }
                    else if(amount > 200 && amount <= 400){
                        charge = 1600 + (200 * 93.3) + ((amount - 200) * 187.9);
                    }
                    else{
                        charge = 7300 + (200 * 93.3) + (200 * 187.9) + ((amount - 400) * 280.6);
                    }
                }

                System.out.println("");
                System.out.println("주소    식별코드    계절    사용량       요금");
                System.out.println(address+"    "+codeNum+"       "+season+"     "+amount+"       "+charge);
                System.out.println("==============================================================================");
            }
            else{       // 산업용일때
                System.out.print("전압을 선택하세요 : ");
                voltage = strScanner.nextLine();

                if(voltage.equals("high")){
                    System.out.print("전압옵션을 선택하세요 : ");
                    voltageOption = strScanner.nextLine();

                    if(voltageOption.equals("A")){
                        System.out.print("요금옵션을 선택하세요 : ");
                        option = intScanner.nextInt();

                        if(option == 1){
                            if(season.equals("Summer")){
                                charge = 6490 + (amount * 89.6);
                            }
                            else if(season.equals("Winter")){
                                charge = 6490 + (amount * 89.5);
                            }
                            else{
                                charge = 6490 + (amount * 65.9);
                            }
                        }
                        else{
                            if(season.equals("Summer")){
                                charge = 7470 + (amount * 84.8);
                            }
                            else if(season.equals("Winter")){
                                charge = 7470 + (amount * 83.0);
                            }
                            else{
                                charge = 7470 + (amount * 61.3);
                            }
                        }
                    }
                    else{
                        System.out.print("요금옵션을 선택하세요 : ");
                        option = intScanner.nextInt();

                        if(option == 1){
                            if(season.equals("Summer")){
                                charge = 6000 + (amount * 88.4);
                            }
                            else if(season.equals("Winter")){
                                charge = 6000 + (amount * 88.0);
                            }
                            else{
                                charge = 6000 + (amount * 64.8);
                            }
                        }
                        else{
                            if(season.equals("Summer")){
                                charge = 6900 + (amount * 83.7);
                            }
                            else if(season.equals("Winter")){
                                charge = 6900 + (amount * 81.9);
                            }
                            else{
                                charge = 6900 + (amount * 60.2);
                            }
                        }
                    }

                    System.out.println("");
                    System.out.println("주소    식별코드   계절   사용량   전압/전압옵션   요금옵션      요금");
                    System.out.println(address+"    "+codeNum+"      "+season+"   "+amount+"        "+voltage+voltageOption+"            "+option+"       "+charge);
                    System.out.println("==============================================================================");
                }
                else{
                    if(season.equals("Summer")){
                        charge = 5550 + (amount * 81.0);
                    }
                    else if(season.equals("Winter")){
                        charge = 5550 + (amount * 79.3);
                    }
                    else{
                        charge = 5550 + (amount * 59.2);
                    }

                    System.out.println("");
                    System.out.println("주소    식별코드    계절    사용량      전압    요금");
                    System.out.println(address+"    "+codeNum+"       "+season+"     "+amount+"       "+voltage+"    "+charge);
                    System.out.println("==============================================================================");
                }
            }

            System.out.print("주소를 입력하세요 : ");
            address = strScanner.nextLine();
        }

        intScanner.close();
        strScanner.close();
    }
}