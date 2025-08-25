public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.pagesPrinted = 0;
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public int addToner(int tonerAmount) {
        int newTonerLevel = tonerLevel + tonerAmount;
        if (newTonerLevel < 0 || newTonerLevel > 100) {
            return -1;
        } else {
            tonerLevel += tonerAmount;
            return tonerLevel;
        }


    }

    public int printPages(int pages) {


        if (duplex) {
            System.out.println("It's a duplex printer!");
            int sheet = Math.round(((float) pages / 2));
            pagesPrinted += sheet;
            return sheet;
        } else {
            pagesPrinted += pages;
            return pages;
        }

    }

}
