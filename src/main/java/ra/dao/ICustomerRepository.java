package ra.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ra.model.Customer;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    @Query("select c from Customer as c where c.name like concat('%',:name,'%') ")
    Iterable<Customer> searchByName(@Param("name") String name);
    @Query("select c from Customer as c where c.age > :age")
    Iterable<Customer> searchByAge(@Param("age") int age);
}
