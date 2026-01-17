public class Main {
    public static void main(String[] args){

        System.out.println("Задание 1. Задача 2");
        Human human1 = new Human("Клеопатра", 152);

        Human human2 = new Human("Пушкин", 167);

        Human human3 = new Human("Владимир", 189);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);

        System.out.println("\nЗадание 1. Задача 3");
        Name name1 = new Name("Клеопатра");

        Name name2 = new Name("Пушкин", " Александр ", "Сергеевич");

        Name name3 = new Name("Маяковский", " Владимир ");

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);

        System.out.println("\nЗадание 2. Задача 2");

        Humanwithname humanwithname1 = new Humanwithname(name1, 152);

        Humanwithname humanwithname2 = new Humanwithname(name2, 167);

        Humanwithname humanwithname3 = new Humanwithname(name3, 189);

        System.out.println(humanwithname1);
        System.out.println(humanwithname2);
        System.out.println(humanwithname3);

        System.out.println("\nЗадание 3. Задача 3");

        City A = new City("A", 3);
        City B = new City("B", 2);
        City C = new City("C", 2);
        City D = new City("D", 3);
        City E = new City("E", 1);
        City F = new City("F", 2);

        A.add(B, 5);
        A.add(F, 1);
        A.add(D, 6);

        B.add(A, 5);
        B.add(C, 3);

        C.add(B, 3);
        C.add(D, 4);

        D.add(A, 6);
        D.add(C, 4);
        D.add(E, 2);

        E.add(F, 2);

        F.add(B, 1);
        F.add(E, 2);

        City[] cities = {A, B, C, D, E, F};

        for (City city : cities) {
            System.out.println(city);
        }

        System.out.println("\nЗадание 4. Задача 8");

        CreatingCity A2 = new CreatingCity("A");
        CreatingCity C2 = new CreatingCity("C");
        CreatingCity F2 = new CreatingCity("F");

        CreatingCity[] neighborsE = {F2};
        int[] costsE = {2};
        CreatingCity E2 = new CreatingCity("E", neighborsE, costsE);

        CreatingCity[] neighborsB = {A2, C2};
        int[] costsB = {5, 3};
        CreatingCity B2 = new CreatingCity("B", neighborsB, costsB);

        F2.add(E2, 2);
        F2.add(B2, 1);

        CreatingCity[] neighborsD = {A2, E2, C2};
        int[] costsD = {6, 2, 4};
        CreatingCity D2 = new CreatingCity("D", neighborsD, costsD);

        A2.add(B2, 5);
        A2.add(F2, 1);
        A2.add(D2, 6);

        C2.add(B2, 3);
        C2.add(D2, 4);

        CreatingCity[] cities2 = {A2, B2, C2, D2, E2, F2};

        for (CreatingCity city : cities2) {
            System.out.println(city);
        }

        System.out.println("\nЗадание 5. Задача 5");
        Fraction f1 = new Fraction(5, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(1, 4);

        Fraction res1 = f1.multiply(f2);
        System.out.println(f1 + " * " + f2 + " = " + res1);

        Fraction res2 = f2.sum(f3);
        System.out.println(f2 + " + " + f3 + " = " + res2);

        Fraction res3 = f3.minus(f1);
        System.out.println(f3 + " - " + f1 + " = " + res3);

        Fraction res4 = f3.div(f2);
        System.out.println(f3 + " / " + f2 + " = " + res4);

        Fraction res5 = f1.sum(f2).div(f3).minus(5);
        System.out.println("f1.sum(f2).div(f3).minus(5) = " + res5);



    }
}