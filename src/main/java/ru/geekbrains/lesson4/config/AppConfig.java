package ru.geekbrains.lesson4.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.geekbrains.lesson4.dao.impl.ProductDAO;
import ru.geekbrains.lesson4.data.ProductData;
import ru.geekbrains.lesson4.data.ProductDataRepository;
import ru.geekbrains.lesson4.data.ProductsRepository;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.entity.User;
import ru.geekbrains.lesson4.services.impl.ProductServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("ru.geekbrains.lesson4.repositories")
@EnableTransactionManagement
@ComponentScan("ru.geekbrains.lesson4")
public class AppConfig {

    @Bean(name="dataSource")
    public DataSource getDataSource() {
        // Создаем источник данных
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Задаем параметры подключения к базе данных
        dataSource.setUrl("jdbc:h2:file:C:\\Users\\Professional\\Searches\\Desktop\\java\\GeekBrains\\Spring\\teacher.lesson4-Spring\\db\\demo;MV_STORE=false");
        dataSource.setUsername("sa");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        // Создаем класса фабрики, реализующей интерфейс
        // FactoryBean<EntityManagerFactory>
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        // Задаем источник подключения
        factory.setDataSource(getDataSource());
        // Задаем адаптер для конкретной реализации JPA,
        // указывает, какая именно библиотека будет использоваться в качестве
        // поставщика постоянства
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // Указание пакета, в котором будут находиться классы-сущности
        factory.setPackagesToScan("ru.geekbrains.lesson4.entity");
        // Создание свойств для настройки Hibernate
        Properties jpaProperties = new Properties();
        // Указание диалекта конкретной базы данных
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        // Максимальное количество строк, возвращаемых за один запрос из БД
        jpaProperties.put("hibernate.jdbc.fetch_size", 50);
        // Максимальное количество запросов при использовании пакетных операций
        jpaProperties.put("hibernate.jdbc.batch_size", 10);
        // Включает логирование
        jpaProperties.put("hibernate.show_sql", true);
        //jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.hbm2ddl.auto", "create");

        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        // Создание менеджера транзакций
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory);
        return tm;
    }

    @Bean(name="productDataRepository")
    public ProductDataRepository getProductDataRepository() {
        ProductDataRepository dr = new ProductDataRepository() {
            @Override
            public List<Product> findAll() {
                return null;
            }
            @Override
            public List<Product> findAll(Sort sort) {
                return null;
            }
            @Override
            public Page<Product> findAll(Pageable pageable) {
                return null;
            }
            @Override
            public List<Product> findAllById(Iterable<Long> iterable) {
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
            public void delete(Product product) {

            }

            @Override
            public void deleteAll(Iterable<? extends Product> iterable) {

            }
            @Override
            public void deleteAll() {

            }
            @Override
            public <S extends Product> S save(S s) {
                return null;
            }
            @Override
            public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }
            @Override
            public Optional<Product> findById(Long aLong) {
                return Optional.empty();
            }
            @Override
            public boolean existsById(Long aLong) {
                return false;
            }
            @Override
            public void flush() {

            }
            @Override
            public <S extends Product> S saveAndFlush(S s) {
                return null;
            }
            @Override
            public void deleteInBatch(Iterable<Product> iterable) {

            }
            @Override
            public void deleteAllInBatch() {

            }
            @Override
            public Product getOne(Long aLong) {
                return null;
            }
            @Override
            public <S extends Product> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }
            @Override
            public <S extends Product> List<S> findAll(Example<S> example) {
                return null;
            }
            @Override
            public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }
            @Override
            public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }
            @Override
            public <S extends Product> long count(Example<S> example) {
                return 0;
            }
            @Override
            public <S extends Product> boolean exists(Example<S> example) {
                return false;
            }
            @Override
            public Optional<ProductData> findOneById(Long id) {
                return Optional.empty();
            }
        };
        return dr;
    }

    @Bean(name="productsRepository")
    public ProductsRepository getProductsRepository() {
        ProductsRepository pr = new ProductsRepository() {
            @Override
            public List<Product> findAll() {
                return null;
            }

            @Override
            public List<Product> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Product> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<Product> findAllById(Iterable<Long> iterable) {
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
            public void delete(Product product) {

            }

            @Override
            public void deleteAll(Iterable<? extends Product> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Product> S save(S s) {
                return null;
            }

            @Override
            public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Product> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Product> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Product> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Product getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Product> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Product> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Product> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Product> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public List<Product> findByTitle(String title) {
                return null;
            }

            @Override
            public Product findOneByTitle(String title) {
                return null;
            }

            @Override
            public List<Product> findProductByUser(User user) {
                return null;
            }
        };
        return pr;
    }

    @Bean(name="productDAO")
    public ProductDAO getProductDAO() {
        ProductDAO pd = new ProductDAO(){
            @PersistenceContext
            private EntityManager entityManager;
            @Override
            public List < Product > findAll () {
                return entityManager . createQuery ( "from Product" ,
                        Product . class ). getResultList ();
            }
            @Override
            public void save ( Product product ) {
                entityManager . persist ( product );
            }
            @Override
            public Product findById ( Long id ) {
                return entityManager . find ( Product . class , id );
            }
            @Override
            public void update ( Product product ) {
                entityManager . merge ( product );
            }
            @Override
            public void delete ( Product product ) {
                entityManager . remove ( product );
            }
            @Override
            public Double findMinPrice ( ) {
                return (Double) entityManager . createQuery ( "SELECT MIN(PRICE) FROM PRODUCTS"). getSingleResult();
            }
        };
        return pd;
    }
}
