package s18746.financialsettlementbackend.workermanager;

import org.hibernate.jdbc.Work;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import s18746.financialsettlementbackend.workerManager.Worker;
import s18746.financialsettlementbackend.workerManager.WorkerRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class WorkerRepositoryTestImpl implements WorkerRepository {

    Map<Long,Worker> database = new ConcurrentHashMap<>();




    @Override
    public Optional<Worker> findByFirstnameAndLastname(String firstname, String lastname) {
       return database.values()
                .stream()
                .filter(e -> e.getFirstname().equals(firstname))
                .filter(e -> e.getLastname().equals(lastname))
                .findFirst();
    }


    @Override
    public List<Worker> findAll() {
        return database.values().stream()
                .toList();
    }





    @Override
    public Worker getById(Long id) {

        return database.get(id);
    }


    @Override
    public Worker save(Worker worker) {
      return  database.put(worker.getId(),worker);

    }

    @Override
    public Optional<Worker> findById(Long id) {
      return   database.values().stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }




    @Override
    public void flush() {

    }

    @Override
    public <S extends Worker> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Worker> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Worker> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Worker getOne(Long aLong) {
        return null;
    }


    @Override
    public Worker getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Worker> List<S> findAll(Example<S> example) {
        return null;
    }


    @Override
    public <S extends Worker> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }



    @Override
    public <S extends Worker> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Worker> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Worker> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Worker> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Worker, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }



    @Override
    public <S extends Worker> List<S> saveAll(Iterable<S> entities) {
        return null;
    }



    @Override
    public boolean existsById(Long aLong) {
        return false;
    }


    @Override
    public List<Worker> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Worker entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Worker> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Worker> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Worker> findAll(Pageable pageable) {
        return null;
    }
}
