public class City {
    private String name;
    private City[] nearbycities;
    private int[] cost;
    private int countpath; //

    public City(String name, int maxpaths) {
        this.name = name;
        this.nearbycities = new City[maxpaths];
        this.cost = new int[maxpaths];
        this.countpath = 0;
    }

    public void add(City city, int costs) { //добавление пути
        if (countpath < nearbycities.length) {
            nearbycities[countpath] = city;
            cost[countpath] = costs;
            countpath++;
        }
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append(name).append(": ");
        for (int i = 0; i < countpath; i++) {
            line.append(nearbycities[i].getName()).append(":").append(cost[i]);
            if (i < countpath - 1) {
                line.append(", ");
            }
        }
        return line.toString();
    }
}