package com.company;

public class Main {

    public static void main(String[] args) {
        Main context = new Main();
        int[] price = {5, 100, 20, 66, 16};//заполняем массив
        context.decryptData(price, 20, 1, 3);//заполняем метод
    }

    public int[] decryptData(int[] price, int discount, int offset, int readLength) {
        boolean paramPrice = true;//если цены больше нуля, то true
        boolean paramDiscount = true;//если скидка от 1 до 99 %, то true
        boolean paramOffset = true;//если номер позиции больше или равно нулю, то true
        boolean paramReadLength = true;//если количество позиций больше нуля, то true
        int[] newPrice = new int[readLength];//массив для данных с учетом скидки с округлением до нижних целых чисел

        paramDiscount = discount >= 1 && discount <= 99; //проверка скидки
        paramOffset = offset >= 0 && offset <= price.length;// проверка номера позиции
        paramReadLength = (readLength > 0 && (readLength + offset) <= price.length);//проверка количества позиций

        //в программе можно выбрать 2 вида проверки массива на начилие цены ниже нуля
        //в задании не уточнено, цена должна быть ниже нуля каждая, или только та, что попадает в диапозон, по этому
        //сделал оба варианта. Для проверки нужно закомментировать один и раскомментировать другой

        for (int priceOfOneItem : price) {//проверка массива на наличие цены ниже нуля
            if (priceOfOneItem <= 0) {
                paramPrice = false;
                break;
            }
        }

//        //проверка значений массива на наличие цены ниже нуля, которые попадают в диапозон
//        int position = offset;//счетчик
//        int count=0;//счетчик
//        while (position < price.length&&count<readLength){
//            if (price[position] <= 0) {
//                paramPrice = false;
//                break;
//            }
//            count++;
//            position++;
//        }

        if (paramPrice && paramDiscount && paramOffset && paramReadLength) { //если все условия совпадают
            int count2 = 0;//счетчик
            do {
                float priceItem = (float) price[offset]; //переменная правильных значений после деления
                priceItem= (float) Math.floor(priceItem-priceItem*discount / 100); //считаем и округляем
                newPrice[count2] = (int) priceItem;//записываем значение с учетом скидки
                System.out.println(newPrice[count2]);//вывести значение
                offset++;
                count2++;
            } while (count2 < readLength);
        } else {
            System.out.println("Ошибка условий. Исправте вводные значения");
        }
        return newPrice;//возвращаем массив
    }
}
