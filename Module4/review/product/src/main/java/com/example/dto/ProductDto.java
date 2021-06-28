package com.example.dto;

import com.example.model.entity.TypeProduct;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto implements Validator {
    private Long id;
    @NotBlank(message = "please input product name (null)")
    @Size(min = 3, max = 45)
    private String name;
    private Double price;
    private String description;
    private String producer;

    @ManyToOne
    @JoinColumn(name = "type_product_id")
    private TypeProduct typeProduct;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, Double price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        String description = productDto.getDescription();
        ValidationUtils.rejectIfEmpty(errors,"description","description.empty");
        if(description.length()>11||description.length()<0){
            errors.rejectValue("description","description.length");
        }
        if(!description.startsWith("0")){
            errors.rejectValue("description","description.startsWith");
        }
        if (!description.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("description", "description.matches");
        }
    }
}
