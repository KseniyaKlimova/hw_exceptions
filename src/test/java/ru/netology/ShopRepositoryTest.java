package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ShopRepository;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(101, "Яблоко", 55);
    Product product2 = new Product(111, "Груша", 79);
    Product product3 = new Product(117, "Слива", 83);
    Product product4 = new Product(129, "Абрикос", 32);
    Product product5 = new Product(134, "Апельсин", 150);

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(111);

        Product[] expected = {product1, product3, product4, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(7));
    }
}

