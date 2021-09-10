package product.controller;

public interface General<T> {
    void show();
    void add(T t);
    void update(String id,T t);
    void delete(String id);
}
