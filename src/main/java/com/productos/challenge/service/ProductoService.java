package com.productos.challenge.service;

import com.productos.challenge.Exception.ProductNotFoundException;
import com.productos.challenge.entity.Producto;
import com.productos.challenge.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
   @Autowired
   ProductoRepository productoRepository;
    public Producto crearProducto(Producto producto){
       return productoRepository.save(producto);
    }

    public List<Producto> verProductos(){
        return productoRepository.findAll(Sort.by(Sort.Direction.ASC, "precio"));
    }
  public Optional<Producto> buscarProductoPorId(Long id){
      try{
          return productoRepository.findById(id);
      }catch(EmptyResultDataAccessException ex){
          throw new ProductNotFoundException("No se encontro el id");}
  }

    public void eliminarProducto(Long id){
        try{
        productoRepository.deleteById(id);
    }catch(EmptyResultDataAccessException ex){
   throw new ProductNotFoundException("No se encontro el id");}
    }


}
