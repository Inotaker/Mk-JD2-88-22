package by.it.academy.Mk_JD2_88_22.classwork.dto.airports;

public class Pageable {
    private int page;
    private int size;

    public Pageable(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public static Pageable of(int page, int size) {
        Pageable pageable = new Pageable(page, size);
        pageable.setPage(page);
        pageable.setSize(size);
        return pageable;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
