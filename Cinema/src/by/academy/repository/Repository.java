package by.academy.repository;

public interface Repository<T> {

    T update(T newUpdate);

    T delete(T t);

}
