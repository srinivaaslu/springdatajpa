package com.nivas.example.springdatajpa;

import com.nivas.example.springdatajpa.entity.*;
import com.nivas.example.springdatajpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ProductRepository  productRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartApplication...");

        bookRepository.save(new Book("Java","Backend Programming"));
        bookRepository.save(new Book("Node","Full Stack Programming"));
        bookRepository.save(new Book("JavaReactive Program","Backend Programming"));
        bookRepository.save(new Book("Python","Backend Programming"));
        bookRepository.save(new Book("Springboot","Backend Programming"));
        bookRepository.save(new Book("JavaScript","Frontend Programming"));



        System.out.println("\nfindAll()");
        bookRepository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindAll()");
        bookRepository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        bookRepository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        bookRepository.findByName("Node").forEach(x -> System.out.println(x));

        System.out.println("\nfindByNameContaining('Java')");
        bookRepository.findByNameContaining("Java").forEach(x -> System.out.println(x));

        System.out.println("\nfindBackend Programming books('Backend Programming')");
        bookRepository.findBackendProgrammingBooks("Backend Programming").forEach(x -> System.out.println(x));


        System.out.println("\nfind List of  Programming books('Java and Node')");
        List<String> allBooks = new ArrayList<>();
        allBooks.add("Java");
        allBooks.add("Node");
        bookRepository.findListOfBooks(allBooks).forEach(x -> System.out.println(x));

        //Product Repo example
        Product product= new Product("TV",400);
        Product product1= new Product("WASHING MACHINE",300);
        Product product2= new Product("ROBOTIC MACHINE",200);
        List<Product> allProduct = new ArrayList<>();
        allProduct.add(product);
        allProduct.add(product1);
        allProduct.add(product2);
        productRepository.saveAll(allProduct);

        System.out.println("\nfindAllProductByPriceBetween(200,400)");
        productRepository.findAllByPriceBetween(200,400).forEach(x -> System.out.println(x));

        System.out.println("\nfindAll With Sort method");
        productRepository.findAll(PageRequest.of(0,5, Sort.by(Sort.Direction.ASC,"name"))).forEach(x-> System.out.println(x));

        //One to One Mapping in SpringDataJPA
        List<Student> studentList = new ArrayList<>();
        Student student = new Student( "Anup", 98884, new Address("Pune"));
        Student student1 = new Student( "Archu", 4384, new Address("UK"));
        Student student2 = new Student( "Ram", 3484, new Address("Chennai"));
        Student student3 = new Student( "Yuvraj", 9854, new Address("Baramati"));

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentRepository.saveAll(studentList);

        System.out.println("\nfindAll Students ");
        studentRepository.findAll().forEach(x-> System.out.println(x));
        //One to One Mapping in SpringDataJPA Ends here

        //One to Many Mapping in SpringDataJPA using hibernate

        Person person = new Person("Srinivas","Brussels");
        person.addPhone(new Phone("3G","OnePLus"));
        person.addPhone(new Phone("4G","SamSung"));
        person.addPhone(new Phone("5G","IPhone"));
        personRepository.save(person);

        Person person2 = new Person("Nivas","Brussels");
        person2.addPhone(new Phone("3G","OnePLus2T"));
        personRepository.save(person2);

        personRepository.findAll().forEach(x-> System.out.println(x));

        //One to Many Mapping in SpringDataJPA using hibernate ends here

    }
}
