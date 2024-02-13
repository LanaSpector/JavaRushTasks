package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/* 
Наследование от внутреннего класса
*/

public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }
    public class BigHall extends Building.Hall {
        public BigHall(BigDecimal square, Building b){

            b.super(square);
        }
    }

    public class Apt3Bedroom extends Building.Apartments {
        public Apt3Bedroom(Building b) {
            b.super();
        }
    }

    public static void main(String[] args) {

    }
}
