public class Product implements IProduct {
    private final String[] names;   // single-dimensional array
    private final int[][] sales;    // two-dimensional array [product][month]

    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] row : sales) total += rowTotal(row);
        return total;
    }

    public double GetAverageProductSold() {
        return (double) GetTotalProductsSold() / (sales.length * sales[0].length);
    }

    public String GetMostPopularProduct() {
        int best = 0;
        for (int i = 1; i < sales.length; i++)
            if (rowTotal(sales[i]) > rowTotal(sales[best])) best = i;
        return names[best];
    }

    private int rowTotal(int[] row) {
        int total = 0;
        for (int s : row) total += s;
        return total;
    }
}
