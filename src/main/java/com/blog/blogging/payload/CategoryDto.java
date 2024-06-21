package com.blog.blogging.payload;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    @NotEmpty(message = "Title cannot be empty")
    private String categoryTitle;
    @NotEmpty
    @Size(min = 10, message = "Minimum 10 characters required")
    private String categoryDescription;
}
