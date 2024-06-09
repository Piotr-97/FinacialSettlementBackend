package s18746.financialsettlementbackend.employeemanager;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class EmployeeRepositoryTestImpl implements EmployeeRepository {

    Map<Long, Employee> database = new ConcurrentHashMap<>();

    @Override
    public void delete(Employee employee) {
      database.remove(employee.getId());
    }




    @Override
    public Optional<Employee> findByFirstnameAndLastname(String firstname, String lastname) {
       return database.values()
                .stream()
                .filter(e -> e.getFirstname().equals(firstname))
                .filter(e -> e.getLastname().equals(lastname))
                .findFirst();
    }


    @Override
    public List<Employee> findAll() {
        return database.values().stream()
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }





    @Override
    public Employee getById(Long id) {

        return database.get(id);
    }


    @Override
    public Employee save(Employee employee) {
      return  database.put(employee.getId(), employee);

    }

    @Override
    public Optional<Employee> findById(Long id) {
      return   database.values().stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }




    @Override
    public void flush() {

    }

    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Employee> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employee getOne(Long aLong) {
        return null;
    }


    @Override
    public Employee getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }


    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }



    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }



    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return null;
    }



    @Override
    public boolean existsById(Long aLong) {
        return false;
    }


    @Override
    public List<Employee> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }





    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }
}
