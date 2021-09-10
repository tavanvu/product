package product.controller;

public interface ReadAndWrite<T> extends General<T>{
    void output();
    void input();
}
