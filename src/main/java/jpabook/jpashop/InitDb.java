package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor

    static class InitService {

        private final EntityManager em;
        public void dbInit1() {
            final Member member = createMember("userA", "서울", "1", "1111");
            em.persist(member);

            final Book book1 = createBook("JPA1 BOOK", 10000, 100);
            em.persist(book1);

            final Book book2 = createBook("JPA2 BOOK", 20000, 100);
            em.persist(book2);

            final OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            final OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 1);

            final Delivery delivery = createDelivery(member);
            final Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Book createBook(String name, int price, int stockQuantity) {
            final Book book1 = new Book();
            book1.setName(name);
            book1.setPrice(price);
            book1.setStockQuantity(stockQuantity);
            return book1;
        }

        private Member createMember(String name, String city, String street, String zipcode) {
            final Member member = new Member();
            member.setName(name);
            member.setAddress(new Address(city, street, zipcode));
            return member;
        }

        public void dbInit2() {
            final Member member = createMember("userB", "부산", "2", "2222");
            em.persist(member);

            final Book book1 = createBook("SPRING1 BOOK", 10000, 200);
            em.persist(book1);

            final Book book2 = createBook("SPRING2 BOOK", 20000, 300);
            em.persist(book2);

            final OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 3);
            final OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);

            final Delivery delivery = createDelivery(member);
            final Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Delivery createDelivery(Member member) {
            final Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            return delivery;
        }
    }
}
