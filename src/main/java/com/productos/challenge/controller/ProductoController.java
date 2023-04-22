package com.productos.challenge.controller;

import com.productos.challenge.Exception.ProductNotFoundException;
import com.productos.challenge.entity.Producto;
import com.productos.challenge.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;


    @GetMapping
    public ResponseEntity<List<Producto>> verProductosOrdenados(){
        List<Producto>listaProductos = productoService.verProductos();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto>buscarProductoPorId(@PathVariable("id") Long id){
        Producto producto = productoService.buscarProductoPorId(id)
                .orElseThrow(()-> new ProductNotFoundException("no se encontro el Producto"));
     return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto>crearProducto(@RequestBody Producto producto){

        Producto product =  productoService.crearProducto(producto);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PutMapping("/editar")
    public ResponseEntity<Producto>editarProducto(@RequestBody Producto producto){
        Producto product =  productoService.crearProducto(producto);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminarProducto(@PathVariable("id")Long id){
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
