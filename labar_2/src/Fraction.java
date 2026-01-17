//Создайте сущность Дробь со следующими особенностями:
// Имеет числитель: целое число
// Имеет знаменатель: целое число
// Дробь может быть создана с указанием числителя и знаменателя
// Может вернуть строковое представление вида “числитель/знаменатель”
// Может выполнять операции сложения, вычитания, умножения и деления с другой Дробью
//или целым числом. Результатом операции должна быть новая Дробь (таким образом,обе
//исходные дроби не изменяются)

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        // Если знаменатель отрицательный, делаем оба числа с противоположными знаками
        if (denominator < 0) {
            numerator = -1 * numerator;
            denominator = -1 * denominator;
        }

        // Находим НОД
        int a;
        if (numerator < 0) {
            a = -1 * numerator;  // берем модуль числителя
        } else {
            a = numerator;
        }
        int b = denominator;

        // Алгоритм Евклида для нахождения НОД
        while (b != 0) {
            int x = b;
            b = a % b;
            a = x;
        }
        int nod = a;  // найденный НОД

        // Сокращаем дробь на НОД
        this.numerator = numerator / nod;
        this.denominator = denominator / nod;
    }

    // Преобразование дроби в строку
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);  // если знаменатель 1, выводим просто число
        }
        return numerator + "/" + denominator;  // иначе выводим дробь
    }

    public Fraction sum(Fraction other) {
        int newnumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newdenominator = this.denominator * other.denominator;
        return new Fraction(newnumerator, newdenominator);
    }

    public Fraction minus(Fraction other) {
        int newnumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newdenominator = this.denominator * other.denominator;
        return new Fraction(newnumerator, newdenominator);
    }

    public Fraction multiply(Fraction other) {
        int newnumerator = this.numerator * other.numerator;
        int newdenominator = this.denominator * other.denominator;
        return new Fraction(newnumerator, newdenominator);
    }

    public Fraction div(Fraction other) {
        int newnumerator = this.numerator * other.denominator;
        int newdenominator = this.denominator * other.numerator;
        return new Fraction(newnumerator, newdenominator);
    }

    // Сложение дроби с целым числом
    public Fraction sum(int number) {
        return this.sum(new Fraction(number, 1));
    }

    // Вычитание целого числа из дроби
    public Fraction minus(int number) {
        return this.minus(new Fraction(number, 1));
    }

    // Умножение дроби на целое число
    public Fraction multiply(int number) {
        return this.multiply(new Fraction(number, 1));
    }

    // Деление дроби на целое число
    public Fraction div(int number) {
        return this.div(new Fraction(number, 1));
    }
}