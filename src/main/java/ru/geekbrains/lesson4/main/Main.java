package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.data.ProductDataRepository;
import ru.geekbrains.lesson4.data.ProductsRepository;
import ru.geekbrains.lesson4.entity.Product;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        //ArticleDAO articleDAO = applicationContext.getBean("articleDAO", ArticleDAO.class);
        ProductDataRepository productDataRepository = applicationContext.getBean("productDataRepository", ProductDataRepository.class);
        //ProductsPaginationRepository productsPaginationRepository = applicationContext.getBean("productsPaginationRepository", ProductsPaginationRepository.class);


        ProductsRepository productsRepository = applicationContext.getBean("productsRepository", ProductsRepository.class);



//        List<Article> articles = articlesRepository.findByTitle("New Title");
//        System.out.println("articles = " + articles);
//
//        Article article2 = articlesRepository.findById(2l).get();
//        System.out.println("article2 = " + article2);

//        Optional<ArticleData> optional = articleDataRepository.findOneById(8L);
//        System.out.println("id = " + optional.get().getId() + ", " + optional.get().getTitle());

        Pageable pageable = PageRequest.of(1, 4);

//        Page<Product> articlePage = productsPaginationRepository.findAll(pageable);
//        System.out.println(articlePage.getContent());
    }

}
