package com.example.service_adherent.mapper.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pageable <T>{

    private List<T> data;
    private int size;
    private int nombrePages;
    private boolean isEmpty;


}
