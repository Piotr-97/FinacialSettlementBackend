package s18746.financialsettlementbackend.accountantmenagerfacadetest;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlement;
import s18746.financialsettlementbackend.accountantmenager.AnswerForSettlementRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AccountantManagerRepositoryTestImpl implements AnswerForSettlementRepository {


    @Override
    public void flush() {

    }

    @Override
    public <S extends AnswerForSettlement> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AnswerForSettlement> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AnswerForSettlement getOne(Long aLong) {
        return null;
    }

    @Override
    public AnswerForSettlement getById(Long aLong) {
        return null;
    }

    @Override
    public AnswerForSettlement getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AnswerForSettlement> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AnswerForSettlement> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AnswerForSettlement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AnswerForSettlement> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AnswerForSettlement> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AnswerForSettlement> findAll() {
        return null;
    }

    @Override
    public List<AnswerForSettlement> findAllById(Iterable<Long> longs) {
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
    public void delete(AnswerForSettlement entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AnswerForSettlement> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AnswerForSettlement> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AnswerForSettlement> findAll(Pageable pageable) {
        return null;
    }
}
