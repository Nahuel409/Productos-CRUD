package com.productos.challenge.controller;

import com.productos.challenge.entity.Producto;
import com.productos.challenge.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

@PostMapping
    public ResponseEntity<Producto>crearProducto(@RequestBody Producto producto){

      Producto product =  productoService.crearProducto(producto);
      return new ResponseEntity<>(product,HttpStatus.CREATED);
}


}
