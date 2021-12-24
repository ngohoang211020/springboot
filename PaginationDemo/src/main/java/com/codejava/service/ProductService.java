package com.codejava.service;

import com.codejava.entity.Product;
import com.codejava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public void save100Product() {
        repo.saveAll(IntStream.range(0, 100).mapToObj(i -> Product.builder().name("Ngo Hoang "+i)
                .email("giacbavanh"+i).phone("0935581209").build()).collect(Collectors.toList()));
    }

    public Page<Product> getProductWithPage(Integer page, Integer size,String sortBy) {
        Sort sort= Sort.by(sortBy).descending();
        return repo.findAll(PageRequest.of(page,size,sort));
    }
}
