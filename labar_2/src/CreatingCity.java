//Создаем Города.
//Измените сущность Город из задачи 3.3. Новые требования включают:
// Город можно создать указав только название
// Город можно создать указав название и набор связанных с ним городов и стоимостей
//путей к ним


public class CreatingCity {
    private String name;              // Название города
    private CreatingCity[] nearbyCities;  // Массив соседних городов
    private int[] cost;               // Стоимость проезда до соседних городов
    private int countPath;            // Количество существующих путей

    // город без соседей
    public CreatingCity(String name) {
        this.name = name;
        this.nearbyCities = new CreatingCity[0];
        this.cost = new int[0];
        this.countPath = 0;
    }

    public CreatingCity(String name, CreatingCity[] nearbyCities, int[] cost) {
        this.name = name;
        // Создаем новые массивы того же размера
        this.nearbyCities = new CreatingCity[nearbyCities.length];
        this.cost = new int[cost.length];
        this.countPath = nearbyCities.length;  // количество путей равно размеру массивов
        for (int i = 0; i < nearbyCities.length; i++) {
            this.nearbyCities[i] = nearbyCities[i];
            this.cost[i] = cost[i];
        }
    }

    // Метод для добавления нового пути к соседнему городу
    public void add(CreatingCity city, int costs) {
        if (countPath == nearbyCities.length) {
            int newSize;
            if (countPath == 0) {
                newSize = 1;
            } else {
                newSize = countPath * 2;
            }
            CreatingCity[] newNearby = new CreatingCity[newSize];
            int[] newCost = new int[newSize];
            // Копируем старые данные в новые массивы
            for (int i = 0; i < countPath; i++) {
                newNearby[i] = nearbyCities[i];
                newCost[i] = cost[i];
            }

            nearbyCities = newNearby;
            cost = newCost;
        }

        nearbyCities[countPath] = city;
        cost[countPath] = costs;
        countPath++;
    }

    public String getName() {
        return name;
    }

    // Метод для строкового представления города и его путей
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append(name).append(": ");


        for (int i = 0; i < countPath; i++) {
            line.append(nearbyCities[i].getName())
                    .append(":")
                    .append(cost[i]);

            if (i < countPath - 1) {
                line.append(", ");
            }
        }
        return line.toString();
    }
}