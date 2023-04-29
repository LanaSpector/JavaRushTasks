package com.javarush.task.pro.task06.task0622;

import java.util.Scanner;

/* 
Диабло (1)
*/

public class Solution {
    public static String getFirstPositionPhrase = "Помоги Амиго определить, где спрятался Диабло? Введи номер позиции (1, 2, 3 или 4):";
    public static String getPositionPhrase = "Диабло не обнаружен. Давай попробуем снова. Введи номер позиции (1, 2, 3 или 4):";
    public static String findDiabloPhrase = "Амиго обнаружил Диабло.";
    public static String diabloDefendPhrase = "Амиго атакует. Диабло отбил атаку Амиго и нанес ответный удар.";
    public static String amigoAttackPhrase = "Удар Амиго достиг цели. Диабло потерял 3 жизни.";
    public static String winPhrase = "Амиго одержал победу над Диабло и выбил из его головы загадочный кристалл.";
    public static String loosePhrase = "Диабло победил Амиго.";
    public static int diabloPosition;
    public static int amigoLives = 9;
    public static int diabloLives = 9;

    public static void main(String[] args) {
        diabloPosition = getRandomNumber(4);
        findDiablo();
        battle();
        isAmigoWin();
        if(isAmigoWin()==true) {
            System.out.print(winPhrase);
        } else {
            System.out.print(loosePhrase);
        }
    }

    public static int getRandomNumber(int range) {
        return (int) (Math.random() * range) + 1;
    }
    
    public static void findDiablo() {
        System.out.print(getFirstPositionPhrase);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(sc.hasNextInt()) {
            num = sc.nextInt();
            if(num==diabloPosition) {
                System.out.print(findDiabloPhrase);
                break;
            }
            else {
                System.out.print(getPositionPhrase);
            }
        }
    }
    
    public static void amigoLostLife() {
        -- amigoLives;
    }
    
    public static void diabloLostLife() {
        diabloLives -= 3;
    }
    
    public static int amigoAttacks() {
        return getRandomNumber(3);
    }
        
    public static int diabloDefends() {
        return getRandomNumber(3);
    }
    
    public static void battle() {
        while(amigoLives>0 || diabloLives>0) {
            if(amigoLives<=0 || diabloLives<=0) {
                break;
            }
            amigoAttacks();
            if(amigoAttacks()!=diabloDefends()) {
                System.out.print(amigoAttackPhrase);
                diabloLostLife();
            }
            else {
                System.out.print(diabloDefendPhrase);
                amigoLostLife();
            }
        } 
    }
    
    public static boolean isAmigoWin() {
        if(diabloLives<=0) {
            return true;
        } else {
            return false;
        }
    }
}
