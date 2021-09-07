package product.controller;

public interface General<T> {
    void show();
    void add(T t);
    void update(String id,T t);
    void delete(String id);
    void softPrice();
    int findPriceMax();
    void output();
    void input();

}
